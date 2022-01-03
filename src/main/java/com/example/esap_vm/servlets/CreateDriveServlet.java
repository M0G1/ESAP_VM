package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import com.example.esap_vm.model.Bike;
import com.example.esap_vm.model.Drive;
import com.example.esap_vm.model.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CreateDriveServlet", value = "/CreateDriveServlet", urlPatterns = "/create-drive")
public class CreateDriveServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Long> userIds = appBean.getAllUsers().stream().map(User::getId).collect(Collectors.toList());
        req.setAttribute("userIds", userIds);
        List<String> userNames = appBean.getAllUsers().stream().map(User::getName).collect(Collectors.toList());
        req.setAttribute("userNames", userNames);
        List<Long> bikeIds = appBean.getAllBikes().stream().map(Bike::getId).collect(Collectors.toList());
        req.setAttribute("bikeIds", bikeIds);
        List<String> bikeNames = appBean.getAllBikes().stream().map(Bike::getBikeName).collect(Collectors.toList());
        req.setAttribute("bikeNames", bikeNames);
        req.getRequestDispatcher("view/CreateDrive.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = Long.parseLong(req.getParameter("userId"));
        Long bikeId = Long.parseLong(req.getParameter("bikeId"));
        Integer hours = Integer.parseInt(req.getParameter("hours"));
        appBean.createDrive(new Drive(hours), userId, bikeId);
        resp.sendRedirect(req.getContextPath() + "/drives");
    }

}
