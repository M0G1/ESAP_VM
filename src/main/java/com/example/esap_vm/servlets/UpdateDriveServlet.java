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

@WebServlet(name = "UpdateDriveServlet", value = "/UpdateDriveServlet", urlPatterns = "/update-drive")
public class UpdateDriveServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Long> bikeIds = appBean.getAllBikes().stream().map(Bike::getId).collect(Collectors.toList());
        List<Long> userIds = appBean.getAllUsers().stream().map(User::getId).collect(Collectors.toList());
        Long driveId = Long.parseLong(req.getParameter("driveId"));
        Drive drive = appBean.getDriveById(driveId);
        req.setAttribute("bikeIds", bikeIds);
        req.setAttribute("userIds", userIds);
        req.setAttribute("drive", drive);
        resp.sendRedirect(req.getContextPath() + "/courses");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long driveId = Long.parseLong(req.getParameter("driveId"));
        Long userId = Long.parseLong(req.getParameter("userId"));
        Long bikeId = Long.parseLong(req.getParameter("bikeId"));
        Integer hours = Integer.parseInt(req.getParameter("hours"));
        appBean.updateDrive(driveId, new Drive(hours), userId, bikeId);
    }
}