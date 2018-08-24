package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConn;

import pojo.Student;

public class StudentImpl {
	
	public String joinString(String[] slikes) {
		String joinlikes = "";
		for (String temp : slikes) {
			joinlikes += temp + "-";
		}
		return joinlikes.substring(0, joinlikes.length() - 1);
	}
	
	public void deleteStudent(String sno) {
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre = con.prepareStatement("DELETE FROM Student WHERE Sno=?");
			pre.setString(1, sno);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateStudent(Student student) {
		Connection con =null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre = con.prepareStatement("UPDATE Student SET Sname=? ,Sage=?, Saddress=? WHERE Sno=?");
			pre.setString(1, student.getSname());
			pre.setInt(2, student.getSage());
			pre.setString(3, student.getSaddress());
			pre.setString(4, student.getSno());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void saveStudent(Student student) {
		// 连接数据库 完成数据的录入操作
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre = con
					.prepareStatement("INSERT INTO Student(Sno,Sname,Ssex,Sage,Saddress) VALUES (?,?,?,?,?)");
			pre.setString(1, student.getSno());
			pre.setString(2, student.getSname());
			pre.setString(3, student.getSsex());
			pre.setInt(4, student.getSage());
			pre.setString(5, student.getSaddress());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	public ArrayList<Student> queryStudent(String sname) {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		ArrayList<Student> students = new ArrayList<Student>();
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre = con.prepareStatement("SELECT * FROM Student WHERE Sname LIKE ?");
			pre.setString(1, "%"+sname+"%");
			res = pre.executeQuery();
			while(res.next()) {
				Student student = new Student();
				//student.setSid(res.getInt("sid"));
				student.setSno(res.getString("Sno"));
				student.setSname(res.getString("Sname"));
				student.setSsex(res.getString("Ssex"));
				student.setSage(res.getInt("Sage"));
				student.setSaddress(res.getString("Saddress"));
				students.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
}
