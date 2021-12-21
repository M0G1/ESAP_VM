package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import com.example.esap_vm.model.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowUsersServlet", value = "/ShowUsersServlet", urlPatterns = "/user")
public class ShowUsersServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = appBean.getAllUsers();
        request.setAttribute("Users", users);
        request.getRequestDispatcher("view/ShowUsers.jsp").forward(request, response);
    }
}