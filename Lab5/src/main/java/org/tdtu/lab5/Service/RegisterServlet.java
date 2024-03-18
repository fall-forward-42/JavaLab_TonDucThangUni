package org.tdtu.lab5.Service;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // Password should ideally be hashed
        user.setFullName(fullName);

        if (userService.register(user)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Username already exists!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
