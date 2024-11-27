/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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

/**
 *
 * @author Admin
 */
@WebServlet(name = "totalQr", urlPatterns = {"/totalQr"})
public class TotalQrControl extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int accountID = a.getId();
        DAO dao = new DAO();
        List<Cart> list = dao.getCartByAccountID(accountID);
        List<Product> list2 = dao.getAllProduct();
        
        double totalMoney=0;
        for(Cart o : list) {
        	for(Product p : list2) {
        		if(o.getProductID()==p.getId()) {
        			totalMoney=totalMoney+p.getPrice()*o.getAmount();
        		}
        	}
        }
        
        double totalMoneyVAT=totalMoney*0.9;
        totalMoneyVAT = Math.round(totalMoneyVAT);
        
        String qrCodeUrl = "https://qr.sepay.vn/img?acc=1023751080&bank=VCB&amount=" + totalMoneyVAT;
        	
        PrintWriter out = response.getWriter();
                        out.println("<div class=\"flex justify-center mb-6\">\n"
                                + "    <img alt=\"Centered Image\"  src=\""+ qrCodeUrl + "\"  align=\"middle\"/>\n"
                                        + "<hr>"
                                + "   </div>\n"
                                + "    <div class=\"mb-4\">\n"
                                + "     <label class=\"block text-gray-700 font-medium mb-2\" for=\"cardHolder\">\n"
                                + "      Card Holder\n"
                                + "     </label>\n"
                                + "     <input class=\"w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500\" id=\"cardHolder\" type=\"text\" value=\"Trịnh Ngọc Hiếu\" readonly/>\n"
                                + "    </div>\n"
                                + "    <div class=\"mb-4\">\n"
                                + "     <label class=\"block text-gray-700 font-medium mb-2\" for=\"accountNumber\">\n"
                                + "      STK\n"
                                + "     </label>\n"
                                + "     <input class=\"w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500\" id=\"accountNumber\" type=\"text\" value=\"1023751080\" readonly/>\n"
                                + "    </div>\n"
                                + "    <div class=\"mb-4\">\n"
                                + "     <label class=\"block text-gray-700 font-medium mb-2\" for=\"bankName\">\n"
                                + "      Ngân Hàng\n"
                                + "     </label>\n"
                                + "     <input class=\"w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500\" id=\"bankName\" type=\"text\" value=\"Vietcombank\" readonly/>\n"
                                + "    </div>\n"
                                + "    <div class=\"mb-6\">\n"
                                + "     <label class=\"block text-gray-700 font-medium mb-2\" for=\"amount\">\n"
                                + "      Số tiền\n"
                                + "     </label>\n"
                                + "     <input class=\"w-full px-3 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500\" id=\"amount\" type=\"text\" value=\""+ totalMoneyVAT +"\" readonly/>\n"
                                + "    </div>\n"
                                + "  </div>");
        	
        
        		
        	
         
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
