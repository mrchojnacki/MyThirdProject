package pl.coderslab.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.DAO.UserDao;
import pl.coderslab.entity.User;

import java.io.IOException;

@WebServlet("/users/update")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        String oldUserName = request.getParameter("oldUserName");
        String oldEmail = request.getParameter("oldEmail");
        String oldPassword = request.getParameter("oldPassword");

        String newUserName = request.getParameter("username");
        String newEmail = request.getParameter("email");
        String newPassword = request.getParameter("password");

        if (newUserName.equals("")) {
            newUserName=oldUserName;
        }
        if (newEmail.equals("")) {
            newEmail = oldEmail;
        }
        if (newPassword.equals("")) {
            newPassword=oldPassword;
        }

        User updatedUser = new User(userId, newEmail, newUserName, newPassword);
        UserDao.updateUserInDatabase(updatedUser);
        response.sendRedirect("/user/list");
    }
}
