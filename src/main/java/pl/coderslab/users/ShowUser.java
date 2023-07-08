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

@WebServlet("/users/show")
public class ShowUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<User> userList = new ArrayList<>();
        try {
            userList = UserDao.createListOfUsers();
            User userToShow = DbUtil.userFromId(userList, userId);
            request.setAttribute("userToShow", userToShow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/users/showUser.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
