package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import com.example.esap_vm.model.Bike;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowBikesServlet", value = "/ShowBikesServlet", urlPatterns = "/bikes")
public class ShowBikesServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get request to ShowBikesServlet");
        List<Bike> bikes = appBean.getAllBikes();
        req.setAttribute("bikes", bikes);
        req.getRequestDispatcher("view/ShowBikes.jsp").forward(req, resp);
    }
}