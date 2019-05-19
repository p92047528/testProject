package com.xy.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.xy.dao.SqlBean;

public class Dao {
	
	static SqlBean db = new SqlBean();
	static Connection conn;
	static PreparedStatement stmt = null;
	
	static{ 
		try {			
			if (conn == null){
				conn = db.getConnection();
			}
		}catch (Exception ee){
			ee.printStackTrace();
		}
	}

	//检验登录信息
	public boolean isRight(String adminName,String pass){
		String sql = "select * from admin where adminName = '" + adminName + "' and adminPass = '" + pass + "'";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){			
				return true;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
