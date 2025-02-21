/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Account;
import entity.Category;
import entity.Product;
import entity.Review;
import entity.Reply;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetailControl", urlPatterns = {"/detail"})
public class DetailControl extends HttpServlet {

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
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Product p = dao.getProductByID(id);
        
        // Kiểm tra xem sản phẩm có trong chương trình khuyến mãi không
        double discountRate = dao.getDiscountRate(p.getId()); // Phương thức kiểm tra giảm giá
        double discountedPrice = p.getPrice();
        if (discountRate > 0) {
            // Nếu có giảm giá, tính lại giá sản phẩm
            discountedPrice = p.getPrice() * (1 - discountRate);
        }
        
        int cateIDProductDetail = dao.getCateIDByProductID(id);
        List<Product> listRelatedProduct = dao.getRelatedProduct(cateIDProductDetail);

        List<Review> listAllReview = dao.getAllReviewByProductID(id);
        int countAllReview = listAllReview.size();
        List<Reply> listAllReply = dao.getReplyAll();
        List<Account> listAllAcount = dao.getAllAccount();

        Product last = dao.getLast();
        
        request.setAttribute("discountedPrice", discountedPrice);
        request.setAttribute("detail", p);
        request.setAttribute("listRelatedProduct", listRelatedProduct);
        request.setAttribute("listAllReview", listAllReview);
        request.setAttribute("listAllAcount", listAllAcount);
        request.setAttribute("listAllReply", listAllReply); 
        request.setAttribute("countAllReview", countAllReview);
        request.setAttribute("p", last);
        request.getRequestDispatcher("DetailProduct.jsp").forward(request, response);
    }

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
