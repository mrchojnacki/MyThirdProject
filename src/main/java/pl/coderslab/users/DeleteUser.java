package pl.coderslab.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.DAO.UserDao;
import pl.coderslab.DbUtil;
import pl.coderslab.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users/delete")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> userList = UserDao.createListOfUsers();
            int idOfUserToDelete = Integer.parseInt(request.getParameter("userId"));
            User userToDelete = DbUtil.userFromId(userList, idOfUserToDelete);
            UserDao.deleteUserFromDatabase(userToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/user/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
