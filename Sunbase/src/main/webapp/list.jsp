<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBconnect"%>
<%@page import="com.entity.*"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.*"%>
<%@page import="com.DB.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students List</title>
    <%@include file="AllComponent/allCss.jsp" %>
</head>
<body>
    <%@include file="AllComponent/navbar.jsp" %>
    
    <% Connection con = DBconnect.getConnetion(); %>

    <h1 class="text-center text-success">Students List</h1>

    <% 
    String successMsg = (String)session.getAttribute("successMsg");

    if(successMsg != null) {
    %>
    <div class="alert alert-success" role="alert">
        <%= successMsg %>
    </div>
    <% 
    session.removeAttribute("successMsg");
    }
    %>

    <% 
    String failedMsg = (String)session.getAttribute("failedMsg");

    if(failedMsg != null) {
    %>
    <div class="alert alert-danger" role="alert">
        <%= failedMsg %>
    </div>
    <% 
    session.removeAttribute("failedMsg");
    }
    %>

    <div class="container">
        <form method="get" action="search">
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Search by ID or Name" name="keyword">
                <div class="input-group-append">
                    <button class="btn btn-success" type="submit">Search</button>
                </div>
            </div>
        </form>
        
        <table class="table table-striped" border="1px">
            <thead class="bg-success text-white">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Age</th>
                    <th scope="col">Action</th>
                   
                </tr>
            </thead>
            <tbody>
                <%
                StudentsDAO dao = new StudentsDAO();
                List<Students> studentsList = dao.getAllStudents();
                for(Students s : studentsList) {
                %>
                <tr>
                    <th scope="row"><%= s.getId() %></th>
                    <td><%= s.getName() %></td>
                    <td><%= s.getEmail() %></td>
                    <td><%= s.getAge() %></td>
                    <td>
                        <a href="edit.jsp?id=<%=s.getId() %>" class="btn btn-sm btn-success">Edit</a>
                        <a href="delete?id=<%=s.getId() %>" class="btn btn-sm btn-danger">Delete</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
        
        

        
    </div>

</body>
</html>
