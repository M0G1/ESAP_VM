package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet", urlPatterns = "/delete-user")
public class DeleteUserServlet extends HttpServlet {
    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = Long.parseLong(req.getParameter("userId"));
        appBean.deleteUser(userId);
        resp.sendRedirect(req.getContextPath() + "/users");
    }
}
