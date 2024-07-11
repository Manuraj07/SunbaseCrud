package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.StudentsDAO;
import com.entity.Students;

@WebServlet("/add-student")

public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));

        Students student = new Students();
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);

        StudentsDAO dao = new StudentsDAO();
        boolean isAdded = dao.addStudent(student);
        HttpSession session = req.getSession();

        if (isAdded) {
            session.setAttribute("successMsg", "Student added successfully.");
            resp.sendRedirect("list.jsp");
        } else {
            session.setAttribute("failedMsg", "Something went wrong");
            resp.sendRedirect("list.jsp");
        }
    }
}