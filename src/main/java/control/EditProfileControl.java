package control;

import dao.DAO;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditProfileControl", urlPatterns = {"/editProfile"})
public class EditProfileControl extends HttpServlet {

    /**
     * Hiển thị form chỉnh sửa thông tin
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển hướng đến trang editProfile.jsp để hiển thị form
        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
    }

    /**
     * Xử lý cập nhật thông tin người dùng
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");

        // Kiểm tra nếu tài khoản không tồn tại trong session
        if (a == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int id = a.getId();

        // Lấy các giá trị nhập vào từ người dùng
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        DAO dao = new DAO();
        dao.editProfile(username, password, email, id);

        // Cập nhật lại thông tin trong session
        a.setUser(username);
        a.setPass(password);
        a.setEmail(email);
        session.setAttribute("acc", a);

        // Gửi thông báo thành công và chuyển hướng lại trang editProfile.jsp
        request.setAttribute("mess", "Cập nhật tài khoản thành công!");
        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet xử lý việc chỉnh sửa thông tin tài khoản người dùng";
    }
}