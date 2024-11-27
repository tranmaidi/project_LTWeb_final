/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ManagerCartControl", urlPatterns = {"/managerCart"})
public class ManagerCartControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        // Lấy thông tin tài khoản từ session
        HttpSession session = request.getSession();

        // Kiểm tra người dùng đã đăng nhập
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }

        int accountID = a.getId();
        DAO dao = new DAO();

        // Lấy danh sách giỏ hàng và sản phẩm
        List<Cart> listCart = dao.getCartByAccountID(accountID);
        List<Product> listProduct = dao.getAllProduct();

        // Tính tổng số lượng sản phẩm trong giỏ
        int totalAmount = 0;
        for (Cart cart : listCart) {
            totalAmount += cart.getAmount();
        }

        // Tính tổng tiền hàng và VAT
        double totalMoney = 0;
        for (Cart cart : listCart) {
            for (Product product : listProduct) {
                if (cart.getProductID() == product.getId()) {
                    totalMoney += product.getPrice() * cart.getAmount();
                }
            }
        }
        double totalMoneyVAT = totalMoney + totalMoney * 0.1;

        int totalAmountCart = 0;
        if (a != null) {
            List<Cart> list = dao.getCartByAccountID(accountID);
            totalAmountCart = list.size();
        }
        // Lưu tổng số lượng sản phẩm vào attribute
        session.setAttribute("cartQuantity", totalAmountCart);
        // Đặt dữ liệu vào request để chuyển tiếp đến JSP
        request.setAttribute("listCart", listCart);
        request.setAttribute("listProduct", listProduct);
        request.setAttribute("totalAmount", totalAmount);
        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("totalMoneyVAT", totalMoneyVAT);

        // Chuyển tiếp đến JSP
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }
//        HttpSession session = request.getSession();
//        Account a = (Account) session.getAttribute("acc");
//        if(a == null) {
//        	response.sendRedirect("login");
//        	return;
//        }
//        int accountID = a.getId();
//        DAO dao = new DAO();
//        List<Cart> list = dao.getCartByAccountID(accountID);
//        List<Product> list2 = dao.getAllProduct();
//      
//        request.setAttribute("listCart", list);
//        request.setAttribute("listProduct", list2);
//        request.getRequestDispatcher("Cart.jsp").forward(request, response);
//        double totalMoney=0;
//        for(Cart o : list) {
//        	for(Product p : list2) {
//        		if(o.getProductID()==p.getId()) {
//        			totalMoney=totalMoney+(p.getPrice()*o.getAmount());
//        		}
//        	}
//        }
//        
//        double totalMoneyVAT=totalMoney+totalMoney*0.1;
//       
//        
//       
//        
//       
//        PrintWriter out = response.getWriter();
//        		out.println(" <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng tiền hàng</strong><strong>"+totalMoney+"</strong></li>\r\n"
//        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Phí vận chuyển</strong><strong>Free ship</strong></li>\r\n"
//        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>10 %</strong></li>\r\n"
//        				+ "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng thanh toán</strong>\r\n"
//        				+ "                                            <h5 class=\"font-weight-bold\">"+totalMoneyVAT+"</h5>\r\n"
//        				+ "                                        </li>");
//        	
//       
//       
//        		
//        	
//         
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
