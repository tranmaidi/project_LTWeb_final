package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

import entity.Account;
import entity.Email;
import entity.EmailUtils;
import entity.Cart;
import entity.Product;

/**
 * Servlet implementation class ForgotPasswordControl
 */
@WebServlet(name = "OrderControl", urlPatterns = {"/order"})
public class OrderControl extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");

        // Kiểm tra nếu người dùng chưa đăng nhập
        if (a == null) {
            response.sendRedirect("login");
            return;
        }

        int accountID = a.getId();
        DAO dao = new DAO();

        // Lấy danh sách giỏ hàng và sản phẩm
        List<Cart> list = dao.getCartByAccountID(accountID);
        List<Product> list2 = dao.getAllProduct();

        double totalMoney = 0;
        for (Cart c : list) {
            for (Product p : list2) {
                if (c.getProductID() == p.getId()) {
                    totalMoney += p.getPrice() * c.getAmount();

                    // Thêm sản phẩm vào bảng History
                    dao.insertHistory(accountID, p.getId(), c.getAmount(), c.getSize());
                }
            }
        }

        double totalMoneyVAT = totalMoney + totalMoney * 0.1;

        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String emailAddress = request.getParameter("email");
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String deliveryAddress = request.getParameter("deliveryAddress");
            
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login");
                return;
            }
            int accountID = a.getId();
            DAO dao = new DAO();
            List<Cart> list = dao.getCartByAccountID(accountID);
            List<Product> list2 = dao.getAllProduct();

            double totalMoney = 0;
            for (Cart c : list) {
                for (Product p : list2) {
                    if (c.getProductID() == p.getId()) {
                        totalMoney += p.getPrice() * c.getAmount();
                    }
                }
            }
            double totalPayment = totalMoney + 25000;
            // Gửi email xác nhận đơn hàng
            Email email = new Email();
            email.setFrom("ditran.120804@gmail.com");
            email.setFromPassword("pguk ltzo biuh swqk");
            email.setTo(emailAddress);
            email.setSubject("Đặt hàng thành công từ DINNO SHOP");

            StringBuilder sb = new StringBuilder();
            sb.append("Xin chào ").append(name).append("<br>");
            sb.append("Bạn vừa đặt hàng từ DINNO SHOP.<br>");
            sb.append("Địa chỉ nhận hàng: <b>").append(deliveryAddress).append("</b><br>");
            sb.append("Số điện thoại: <b>").append(phoneNumber).append("</b><br>");
            sb.append("Các sản phẩm đã đặt:<br>");
            for (Cart c : list) {
                for (Product p : list2) {
                    if (c.getProductID() == p.getId()) {
                        sb.append(" <img src='").append(p.getImage()).append("' alt='").append("<br>")                                
                                .append("' style='width:70px; height:70px;'><br>")
                                .append(p.getName())
                                .append(" | Price: ").append(String.format("%.00f", p.getPrice())).append(" VND")
                                .append(" | Amount: ").append(c.getAmount())
                                .append(" | Size: ").append(c.getSize())
                                .append("<br>");
                    }
                }
            }
            sb.append("Phí vận chuyển: 250000 VND.<br>");
            sb.append("Tổng tiền: ").append(String.format("%.00f", totalPayment)).append(" VND<br>");
            sb.append("Cảm ơn bạn đã đặt hàng tại DINNO SHOP.<br>");
            sb.append("<br><img src='https://img.meta.com.vn/data/image/2022/09/14/stt-cam-on-khach-hang-1.jpg' alt='Thank You' style='width:500px; height:auto;'/><br>");
            sb.append("Chủ cửa hàng<3");

            email.setContent(sb.toString());
            EmailUtils.send(email);
            request.setAttribute("mess", "Đặt hàng thành công!");

            // Xóa giỏ hàng
            dao.deleteCartByAccountID(accountID);

            String phuongThuc = request.getParameter("phuongThuc");
            if ("chuyenKhoan".equals(phuongThuc)) {
                phuongThuc = "Chuyển khoản qua ngân hàng";
            } else {
                phuongThuc = "Thanh toán khi nhận hàng";
            }
            String voucherCode = request.getParameter("voucherCode");
            if(voucherCode != "" ||voucherCode != null && !voucherCode.isEmpty()){
                Double discountAmount = dao.getDiscountAmount(voucherCode);
                totalPayment -= discountAmount;
                dao.insertVoucherAcc(accountID, voucherCode);
            }
            dao.insertInvoice(accountID, totalPayment, phuongThuc);
        } catch (Exception e) {
            request.setAttribute("error", "Đặt hàng thất bại!");
            e.printStackTrace();
        }
        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
    }
}
