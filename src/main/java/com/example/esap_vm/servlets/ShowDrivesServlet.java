package com.example.esap_vm.servlets;

import com.example.esap_vm.ejb.AppBean;
import com.example.esap_vm.model.Drive;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowDrivesServlet", value = "/ShowDrivesServlet", urlPatterns = "/drives")
public class ShowDrivesServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Drive> drives = appBean.getAllDrives();
        request.setAttribute("drives", drives);
        request.getRequestDispatcher("view/ShowDrives.jsp").forward(request, response);
    }
}