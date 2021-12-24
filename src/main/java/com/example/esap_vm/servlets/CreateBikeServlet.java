package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import com.example.esap_vm.model.Bike;
import com.example.esap_vm.model.Drive;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name="CreateBikeServlet", value = "/CreateBikeServlet",urlPatterns = "create-bike") // пустой url был
public class CreateBikeServlet extends HttpServlet {
    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // List<Long> drivesId = appBean.getAllDrives().stream().map(Drive::getId).collect(Collectors.toList());
        // req.setAttribute("drivesIds",drivesId);
        req.getRequestDispatcher("view/CreateBike.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        String bikeName = req.getParameter("bikeName");
        Integer price = Integer.parseInt(req.getParameter("price"));
        appBean.createBike(new Bike(bikeName,price));
        resp.sendRedirect(req.getContextPath());
    }
}
