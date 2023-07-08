package pl.coderslab.users;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pl.coderslab.DAO.UserDao;
import pl.coderslab.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/list")
public class UserList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        try {
            userList = UserDao.createListOfUsers();
            request.setAttribute("userList", userList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/users/list.jsp")
                .forward(request, response);
    }

}
