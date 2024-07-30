package com.heg.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heg.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_BY_DESG="SELECT EMPNO,NAME,EMAIL,CITY,COUNTRY,ZIP,DEPT,UNIT,DESIGNATION FROM EMP_DETAIL WHERE DESIGNATION IN ";
	
	@Autowired
	private DataSource ds;
	
	@Override
	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeBO> listBO=null;
		try(Connection con=ds.getConnection(); 
			Statement st=con.createStatement()	) {
			
			ResultSet rs=st.executeQuery(GET_EMP_BY_DESG +cond+ "ORDER BY EMPNO");
			
			//Convert rs object records to List of BO class Objexts
			listBO=new ArrayList<>();
			EmployeeBO bo=null;
			while(rs.next()) {
				bo=new EmployeeBO();
				bo.setEmpno(rs.getInt("EMPNO"));
				bo.setName(rs.getString("NAME"));
				bo.setEmail(rs.getString("EMAIL"));
				bo.setCity(rs.getString("CITY"));
				bo.setZip(rs.getInt("ZIP"));
				bo.setDept(rs.getString("DEPT"));
				bo.setUnit(rs.getString("UNIT"));
				bo.setDesignation(rs.getString("DESIGNATION"));
				listBO.add(bo);
				
			}//while
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listBO;
	}//method

}//class
