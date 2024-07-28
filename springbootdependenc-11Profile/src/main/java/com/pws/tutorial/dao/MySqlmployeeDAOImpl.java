package com.pws.tutorial.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.pws.tutorial.bo.EmployeeBO;

@Repository("empDAO")
@Profile({"dev","test"})
public class MySqlmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_BY_DESG = "select empno,ename,job,sal,deptno,mgr from emp where job in ";

	@Autowired
	private DataSource ds;

	@Override
	public List<EmployeeBO> getEmplByDesg(String cond) throws Exception {

		List<EmployeeBO> listBo = null;
		try (Connection con = ds.getConnection(); Statement st = con.createStatement();)// prepared statement object can
																						// not used here because no of
																						// designation
																						// is dynamic value)
		{
			// send and execute SQL Query in Db Software
			ResultSet rs = st.executeQuery(GET_EMP_BY_DESG + cond + " order by JOB");
			// Converts rs object records to listofbo classobject
			listBo = new ArrayList<>();
			EmployeeBO bo = null;
			while (rs.next()) {
				bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getDouble(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMngNo(rs.getInt(6));
				// add each object in list collection
				listBo.add(bo);

			} // while

		} // try
		catch (SQLException se) {
			se.printStackTrace();
			throw se; // for exception propagation
		} //
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBo;
	}//method

}//class
