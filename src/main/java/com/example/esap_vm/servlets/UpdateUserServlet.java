package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import com.example.esap_vm.model.Drive;
import com.example.esap_vm.model.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(name = "UpdateUserServlet", value = "/UpdateUserServlet", urlPatterns = "/update-user")
public class UpdateUserServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получаем пользователя и кладем в запрос
        Long userId = Long.parseLong(req.getParameter("userId"));
        User user = appBean.getUserById(userId);
        req.setAttribute("user", user);
        // кладем еще и id всех поездок
        List<Long> drivesIds = appBean.getAllDrives().stream().map(Drive::getId).collect(Collectors.toList());
        req.setAttribute("drivesIds", drivesIds);
        req.getRequestDispatcher("view/UpdateUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long userId = Long.parseLong(req.getParameter("userId"));
        String name = req.getParameter("userName");
        // user_name - snake
        // userName - camel
        Integer budget = Integer.parseInt(req.getParameter("budget"));
        appBean.updateUser(userId, new User(name,budget));
        /* МНОГОСТРОЧНЫЙ КОММЕНТ
        * */
        resp.sendRedirect(req.getContextPath() + "/students");
        // false, true, 1, 10232,12.2341,1e-2 -
    }
}
