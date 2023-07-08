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

@WebServlet("/users/findtoupdate")
public class FindUserToUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        int userIdToUpdate = Integer.parseInt(request.getParameter("userId"));
        try {
            userList = UserDao.createListOfUsers();
            User userToUpdate = DbUtil.userFromId(userList, userIdToUpdate);
            request.setAttribute("id", userIdToUpdate);
            request.setAttribute("userName", userToUpdate.getUsername());
            request.setAttribute("Email", userToUpdate.getEmail());
            request.setAttribute("userPassword", userToUpdate.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/users/updateUserForm.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
