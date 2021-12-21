package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteDriveServlet", value = "/DeleteDriveServlet", urlPatterns = "/delete-drive")
public class DeleteDriveServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long driveId = Long.parseLong(req.getParameter("driveId"));
        appBean.deleteDrive(driveId);
    }

}