package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteBikeServlet", value = "/DeleteBikeServlet", urlPatterns = "/delete-bike")
public class DeleteBikeServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long bikeId = Long.parseLong(req.getParameter("bikeId"));
        appBean.deleteBike(bikeId);
        resp.sendRedirect(req.getContextPath()+ "/bikes");
    }
}