package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.StudentsDAO;

@WebServlet("/delete")
public class DeleteServlet  extends HttpServlet{
	
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        StudentsDAO dao = new StudentsDAO();
        boolean isDeleted = dao.deleteStudent(id);
        HttpSession session = req.getSession();
        if (isDeleted) {
            session.setAttribute("successMsg", "Student deleted successfully");
            resp.sendRedirect("list.jsp");
        } else {
            session.setAttribute("failedMsg", "Something went wrong");
            resp.sendRedirect("list.jsp");
        }
    }


}
