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

        // Cập nhật thông tin doanh số bán hàng và lượng bán
//        for (Cart c : list) {
//            for (Product p : list2) {
//                if (c.getProductID() == p.getId()) {
//                    int sell_ID = dao.getSellIDByProductID(p.getId());
//                    double tongTienBanHangThem = p.getPrice() * c.getAmount();
//
//                    TongChiTieuBanHang t2 = dao.checkTongChiTieuBanHangExist(sell_ID);
//                    if (t2 == null) {
//                        dao.insertTongChiTieuBanHang(sell_ID, 0, tongTienBanHangThem);
//                    } else {
//                        dao.editTongBanHang(sell_ID, tongTienBanHangThem);
//                    }
//
//                    // Cập nhật số lượng đã bán
//                    SoLuongDaBan s = dao.checkSoLuongDaBanExist(p.getId());
//                    if (s == null) {
//                        dao.insertSoLuongDaBan(p.getId(), c.getAmount());
//                    } else {
//                        dao.editSoLuongDaBan(p.getId(), c.getAmount());
//                    }
//                }
//            }
//        }
        
        // Thêm hóa đơn mới
        
// Cập nhật tổng chi tiêu cho tài khoản hiện tại
//        TongChiTieuBanHang t = dao.checkTongChiTieuBanHangExist(accountID);
//        if (t == null) {
//            dao.insertTongChiTieuBanHang(accountID, totalMoneyVAT, 0);
//        } else {
//            dao.editTongChiTieu(accountID, totalMoneyVAT);
//        }

        // Chuyển tiếp đến trang xác nhận đặt hàng
        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Phương thức xử lý POST như cũ
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
            double totalMoneyVAT = totalMoney + totalMoney * 0.1;

            // Gửi email xác nhận đơn hàng
            Email email = new Email();
            email.setFrom("ditran.120804@gmail.com");
            email.setFromPassword("pguk ltzo biuh swqk");
            email.setTo(emailAddress);
            email.setSubject("Dat hang thanh cong tu Fashion Family");

            StringBuilder sb = new StringBuilder();
            sb.append("Dear ").append(name).append("<br>");
            sb.append("Ban vua dat hang tu Fashion Family.<br>");
            sb.append("Dia chi nhan hang: <b>").append(deliveryAddress).append("</b><br>");
            sb.append("So dien thoai: <b>").append(phoneNumber).append("</b><br>");
            sb.append("Cac san pham ban dat la:<br>");
            for (Cart c : list) {
                for (Product p : list2) {
                    if (c.getProductID() == p.getId()) {
                        sb.append(p.getName()).append(" | Price: ").append(p.getPrice()).append("$ | Amount: ").append(c.getAmount()).append(" | Size: ").append(c.getSize()).append("<br>");
                    }
                }
            }
            sb.append("Tong Tien: ").append(String.format("%.02f", totalMoneyVAT)).append("$<br>");
            sb.append("Cam on ban da dat hang tai DINNO SHOP<br>");
sb.append("Chu cua hang");

            email.setContent(sb.toString());
            EmailUtils.send(email);
            request.setAttribute("mess", "Dat hang thanh cong!");

            // Xóa giỏ hàng
            dao.deleteCartByAccountID(accountID);
            
            String phuongThuc = request.getParameter("phuongThuc");
            if ("chuyenKhoan".equals(phuongThuc)) {
                phuongThuc = "Chuyển khoản qua ngân hàng";
            } else {
                phuongThuc = "Thanh toán khi nhận hàng";
            }

            dao.insertInvoice(accountID, totalMoneyVAT, phuongThuc);
        } catch (Exception e) {
            request.setAttribute("error", "Dat hang that bai!");
            e.printStackTrace();
        }
        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
    }
}