package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import com.example.esap_vm.model.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "UpdateBikeServlet", value = "/UpdateBikeServlet", urlPatterns = "/update-bike")
public class UpdateBikeServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long bikeId = Long.parseLong(req.getParameter("bikeId"));
        Bike bike = appBean.getBikeById(bikeId);
        req.setAttribute("bike", bike);
        req.getRequestDispatcher("view/UpdateBike.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long bikeId = Long.parseLong(req.getParameter("bikeId"));
        String bikeName = req.getParameter("bikeName");
        Integer price = Integer.parseInt(req.getParameter("price"));
        appBean.updateBike(bikeId,new Bike(bikeName,price));
        resp.sendRedirect(req.getContextPath() + "/bikes");
    }
}