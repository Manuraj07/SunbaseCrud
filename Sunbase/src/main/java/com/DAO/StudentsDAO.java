package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBconnect;
import com.entity.Students;

public class StudentsDAO {
	 private Connection con;

	    public StudentsDAO() {
	        con = DBconnect.getConnetion();
	    }
	    

	    public StudentsDAO(Connection conn) {
	        this.con = conn;
	    }

	    // Get all students
	    public List<Students> getAllStudents() {
	        List<Students> list = new ArrayList<>();
	        Students student = null;

	        try {
	            String sql = "SELECT * FROM students";
	            PreparedStatement statement = con.prepareStatement(sql);
	            ResultSet res = statement.executeQuery();

	            while (res.next()) {
	                student = new Students();
	                student.setId(res.getInt("id"));
	                student.setName(res.getString("name"));
	                student.setEmail(res.getString("email"));
	                student.setAge(res.getInt("age"));
	                list.add(student);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    // Add a new student
	    public boolean addStudent(Students student) {
	        boolean success = false;

	        try {
	            String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, student.getName());
	            statement.setString(2, student.getEmail());
	            statement.setInt(3, student.getAge());
	            int result = statement.executeUpdate();

	            if (result == 1) {
	                success = true;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return success;
	    }

	    // Get a student by ID
	    public Students getStudentById(int id) {
	        Students student = null;
	        String query = "SELECT * FROM students WHERE id = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(query)) {
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                student = new Students();
	                student.setId(rs.getInt("id"));
	                student.setName(rs.getString("name"));
	                student.setEmail(rs.getString("email")); // Retrieve the email from the result set
	                student.setAge(rs.getInt("age")); // Retrieve the age from the result set
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return student;
	    }


	    // Update a student
	    public boolean updateStudent(Students student) {
	        boolean success = false;

	        try {
	            String sql = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setString(1, student.getName());
	            statement.setString(2, student.getEmail());
	            statement.setInt(3, student.getAge());
	            statement.setInt(4, student.getId());
	            int result = statement.executeUpdate();

	            if (result == 1) {
	                success = true;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return success;
	    }

	    // Delete a student
	    public boolean deleteStudent(int id) {
	        boolean success = false;

	        try {
	            String sql = "DELETE FROM students WHERE id = ?";
	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setInt(1, id);
	            int result = statement.executeUpdate();

	            if (result == 1) {
	                success = true;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return success;
	    }

	    // Search students by keyword
	    public List<Students> searchStudents(String keyword) {
	        List<Students> studentsList = new ArrayList<>();
	        String query = "SELECT * FROM students WHERE id LIKE ? OR name LIKE ? OR email LIKE ?";
	        try (PreparedStatement pstmt = con.prepareStatement(query)) {
	            String keywordPattern = "%" + keyword + "%";
	            pstmt.setString(1, keywordPattern);
	            pstmt.setString(2, keywordPattern);
	            pstmt.setString(3, keywordPattern);
	            System.out.println("Executing query with keyword: " + keywordPattern);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                Students student = new Students();
	                student.setId(rs.getInt("id"));
	                student.setName(rs.getString("name"));
	                student.setEmail(rs.getString("email"));
	                student.setAge(rs.getInt("age"));
	                studentsList.add(student);
	                System.out.println("Found student: ID=" + student.getId() + ", Name=" + student.getName());
	            }
	            System.out.println("Number of students found: " + studentsList.size());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return studentsList;
	    }


	    
}
