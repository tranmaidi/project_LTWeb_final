package control;

import dao.DAO;
import entity.Account;
import entity.Invoice;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StatisticControl", urlPatterns = {"/admin"})
public class StatisticControl extends HttpServlet {

    /**
     * Kiểm tra nếu người dùng là admin
     */
    private boolean isAdmin(HttpSession session, DAO dao) {
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            return false;
        }
        int uID = a.getId();
        return dao.checkAccountAdmin(uID) == 1;  // Nếu là admin, trả về true
    }

    /**
     * Xử lý các yêu cầu GET và POST
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        DAO dao = new DAO();

        // Kiểm tra quyền admin
        if (!isAdmin(session, dao)) {
            response.sendRedirect("login"); // Nếu không phải admin, chuyển hướng về login
            return;
        }

        // Lấy dữ liệu thống kê từ DAO
        double totalMoney1 = dao.totalMoneyDay(1);
        double totalMoney2 = dao.totalMoneyDay(2);
        double totalMoney3 = dao.totalMoneyDay(3);
        double totalMoney4 = dao.totalMoneyDay(4);
        double totalMoney5 = dao.totalMoneyDay(5);
        double totalMoney6 = dao.totalMoneyDay(6);
        double totalMoney7 = dao.totalMoneyDay(7);

        double totalMoneyMonth1 = dao.totalMoneyMonth(1);
        double totalMoneyMonth2 = dao.totalMoneyMonth(2);
        double totalMoneyMonth3 = dao.totalMoneyMonth(3);
        double totalMoneyMonth4 = dao.totalMoneyMonth(4);
        double totalMoneyMonth5 = dao.totalMoneyMonth(5);
        double totalMoneyMonth6 = dao.totalMoneyMonth(6);
        double totalMoneyMonth7 = dao.totalMoneyMonth(7);
        double totalMoneyMonth8 = dao.totalMoneyMonth(8);
        double totalMoneyMonth9 = dao.totalMoneyMonth(9);
        double totalMoneyMonth10 = dao.totalMoneyMonth(10);
        double totalMoneyMonth11 = dao.totalMoneyMonth(11);
        double totalMoneyMonth12 = dao.totalMoneyMonth(12);

        // Thống kê thêm
        int allReview = dao.countAllReview();
        int allProduct = dao.countAllProduct();
        double sumAllInvoice = dao.sumAllInvoice();

        List<Invoice> listAllInvoice = dao.getAllInvoice();
        List<Account> listAllAccount = dao.getAllAccount();

        // Đưa dữ liệu vào request để hiển thị trên trang Statistic.jsp
        request.setAttribute("listAllInvoice", listAllInvoice);
        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("sumAllInvoice", sumAllInvoice);
        request.setAttribute("allReview", allReview);
        request.setAttribute("allProduct", allProduct);

        // Tổng tiền theo ngày
        request.setAttribute("totalMoney1", totalMoney1);
        request.setAttribute("totalMoney2", totalMoney2);
        request.setAttribute("totalMoney3", totalMoney3);
        request.setAttribute("totalMoney4", totalMoney4);
        request.setAttribute("totalMoney5", totalMoney5);
        request.setAttribute("totalMoney6", totalMoney6);
        request.setAttribute("totalMoney7", totalMoney7);

        // Tổng tiền theo tháng
        request.setAttribute("totalMoneyMonth1", totalMoneyMonth1);
        request.setAttribute("totalMoneyMonth2", totalMoneyMonth2);
        request.setAttribute("totalMoneyMonth3", totalMoneyMonth3);
        request.setAttribute("totalMoneyMonth4", totalMoneyMonth4);
        request.setAttribute("totalMoneyMonth5", totalMoneyMonth5);
        request.setAttribute("totalMoneyMonth6", totalMoneyMonth6);
        request.setAttribute("totalMoneyMonth7", totalMoneyMonth7);
        request.setAttribute("totalMoneyMonth8", totalMoneyMonth8);
        request.setAttribute("totalMoneyMonth9", totalMoneyMonth9);
        request.setAttribute("totalMoneyMonth10", totalMoneyMonth10);
        request.setAttribute("totalMoneyMonth11", totalMoneyMonth11);
        request.setAttribute("totalMoneyMonth12", totalMoneyMonth12);

        // Forward dữ liệu sang trang Statistic.jsp
        request.getRequestDispatcher("Statistic.jsp").forward(request, response);
    }

    // Phương thức xử lý HTTP GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Phương thức xử lý HTTP POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
