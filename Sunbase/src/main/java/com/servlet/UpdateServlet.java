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

@WebServlet("/updateStudent")
public class UpdateServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        
        StudentsDAO dao = new StudentsDAO();
        Students student = new Students();
        
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);
        
        boolean isUpdated = dao.updateStudent(student);
        HttpSession session = req.getSession();
        if (isUpdated) {
            session.setAttribute("successMsg", "Student updated successfully");
            resp.sendRedirect("list.jsp");
        } else {
            session.setAttribute("failedMsg", "Something went wrong");
            resp.sendRedirect("list.jsp");
        }
    }
}
