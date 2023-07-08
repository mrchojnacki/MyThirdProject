package pl.coderslab.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.DAO.UserDao;
import pl.coderslab.entity.User;

import java.io.IOException;

@WebServlet("/users/addUser")
public class addUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User userToAdd = new User(username, email, password);
        UserDao.addUserToDatabase(userToAdd);
        response.sendRedirect("/user/list");
    }
}
