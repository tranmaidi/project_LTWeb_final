/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import entity.Account;
import entity.Email;
import entity.EmailUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
@WebServlet(name = "InvoiceConfirm", urlPatterns = {"/confirm"})
public class InvoiceConfirmControl extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        
        if(a == null)
        {
            response.sendRedirect("login");
            return;         
        }
        
        String userEmail = (String) request.getParameter("userEmail");
        String userName = (String) request.getParameter("userName");
        
     
        try{
            Email email = new Email();
            email.setFrom("thanghuynh0706@gmail.com");
            email.setFromPassword("gazl nchi rrnx pgox");
            //email.setTo("thanghuynh0706@gmail.com");
            email.setTo(userEmail);
            email.setSubject("Transfer Confirm");

            String content = "<div style=\"font-family: sans-serif; max-width: 600px; margin: auto; \n" +
    "             background-color: #F4F4F4; text-align: center;\">\r\n"
                    + "<div style=\"margin: 15px\">\r\n"
                    + "<br><img src=\"https://websitebangiay-xran.onrender.com/WebsiteBanGiay-0.0.1-SNAPSHOT/images/logo3.png\" alt=\"logo\" width=\"200\" height=\"100\">\r\n"
                    + "</div>\r\n"
                    + "<div style=\"margin-top: -10px; padding: 5px\">\r\n"
                    + "<h1 style=\"color: #F964A6\">Xác nhận chuyển khoản</h1>\r\n"
                    + "<h3>Xin chào "+ userName +  "</h3>\r\n"
                    + "<h3>Vui lòng phản hồi email với hình ảnh minh chứng đã chuyển khoản</h3>\r\n"
                    + "<h3>Để tiếp tục mua sắm, vui lòng nhấn vào nút bên dưới</h3><br>\r\n"
                    + "<a href=\"https://websitebangiay-xran.onrender.com/WebsiteBanGiay-0.0.1-SNAPSHOT/home\" target=\"_blank\" style=\"text-decoration: none; \n" +
    "                 padding: 0.85em; color: #FFFFFF; background-color: #45BB89; border-radius: 5px\">Click here </a><br><br>\r\n"
                    + "</div>\r\n"
                    + "</div>\r\n";
            email.setContent(content);

            EmailUtils.send(email);
            request.setAttribute("mess", "Gửi mail xác nhận thành công");
        }catch (Exception e) {
                    e.printStackTrace();
		}
        
        request.getRequestDispatcher("hoaDon").forward(request, response);
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
