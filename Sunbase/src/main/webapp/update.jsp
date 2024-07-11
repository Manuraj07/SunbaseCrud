<%@page import="com.DB.DBconnect"%>
<%@page import="com.DAO.StudentsDAO"%>
<%@page import="com.entity.Students"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <%@ include file="AllComponent/allCss.jsp" %>
</head>
<body>
    <%@ include file="AllComponent/navbar.jsp" %>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h3 class="text-center">Update Student</h3>
                
                <% 
                String idParam = request.getParameter("id");
                if (idParam != null && !idParam.isEmpty()) {
                    int id = Integer.parseInt(idParam);
                    StudentsDAO dao = new StudentsDAO(DBconnect.getConnetion());
                    Students student = dao.getStudentById(id);
                    if (student != null) {
                %>
                <form action="update-student?id=<%= id %>" method="post">
                    <input type="hidden" name="id" value="<%= student.getId() %>">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" value="<%= student.getName() %>">
                    </div>
                    
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" id="email" name="email" value="<%= student.getEmail() %>">
                    </div>
                    
                    <div class="form-group">
                        <label for="age">Age</label>
                        <input type="text" class="form-control" id="age" name="age" value="<%= student.getAge() %>">
                    </div>
                    
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </div>
                </form>
                <% 
                    } else { 
                %>
                <p class="text-center">Student not found.</p>
                <% 
                    }
                } else { 
                %>
                <p class="text-center">Invalid student ID.</p>
                <% } %>
            </div>
        </div>
    </div>
</body>
</html>
