package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentsDAO;
import com.entity.Students;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        StudentsDAO dao = new StudentsDAO();
        List<Students> students = dao.searchStudents(keyword);

        request.setAttribute("students", students);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}