package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.StudentsDAO;
import com.entity.Students;

@WebServlet("/list-students")
public class ReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StudentsDAO dao = new StudentsDAO();
        List<Students> studentsList = dao.getAllStudents();
        
        HttpSession session = req.getSession();
        session.setAttribute("studentsList", studentsList);
        
        resp.sendRedirect("list.jsp");
    }
}
