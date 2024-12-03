package control;

import dao.DAO;
import entity.Voucher;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "QuanLyVoucherServlet", urlPatterns = {"/quanlyvoucher"})
public class QuanLyVoucherServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        List<Voucher> listAllVoucher;
        String filter = request.getParameter("filter");

        
        if (filter != null && !filter.isEmpty()) {
            // Lọc theo trạng thái của voucher
            switch (filter) {
                case "active":
                    listAllVoucher = dao.getActiveVouchers();
                    break;
                case "not_started":
                    listAllVoucher = dao.getNotStartedVouchers();
                    break;
                case "expired":
                    listAllVoucher = dao.getExpiredVouchers();
                    break;
                default:
                    listAllVoucher = dao.getAllVouchers();
            }
        } else {
            listAllVoucher = dao.getAllVouchers();  // Nếu không có lọc, lấy tất cả
        }
        
        request.setAttribute("listAllVoucher", listAllVoucher);
        request.getRequestDispatcher("quanlyVoucher.jsp").forward(request, response);
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
