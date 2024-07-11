<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Student</title>
    <%@ include file="AllComponent/allCss.jsp" %>
    <style>
        body {
            background-color: #f0f1f2;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        .card {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        .card-body {
            padding: 30px;
        }
        h3 {
            color: #28a745;
            margin-bottom: 30px;
        }
        form {
            margin-bottom: 0;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-control {
            border-radius: 5px;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <%@ include file="AllComponent/navbar.jsp" %>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h3 class="text-center">Add Student</h3>
                <form action="add-student" method="post">
                    <div class="form-group">
                        <label for="studentName">Name</label>
                        <input type="text" class="form-control" id="studentName" name="name">
                    </div>
                    
                    <div class="form-group">
                        <label for="studentEmail">Email</label>
                        <input type="email" class="form-control" id="studentEmail" name="email">
                    </div>
                    
                    <div class="form-group">
                        <label for="studentAge">Age</label>
                        <input type="number" class="form-control" id="studentAge" name="age">
                    </div>
                    
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Add Student</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
