package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import db.DBConn;
import pojo.User;
import pojo.Rel;

public class UserImpl {

	public void registerUser(User user) {
		Connection con = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre = con.prepareStatement("INSERT INTO Login(Lname,Lpassword) VALUES (?,?)");
			pre.setString(1, user.getLname());
			pre.setString(2, user.getLpassword());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pre.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Rel findUser(User user) {
		Rel result = new Rel();
		Connection con = null;
		ResultSet res = null;
		PreparedStatement pre = null;
		DBConn conns = new DBConn();
		con = conns.getConnection();
		try {
			pre = con.prepareStatement("SELECT * FROM Login WHERE Lname LIKE ? ");
			pre.setString(1, "%"+user.getLname()+"%");
			res = pre.executeQuery();
			if(!res.next()) 
				result.setId("1");	
			else 
				result.setId("0");
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
		return result;
	}
}
