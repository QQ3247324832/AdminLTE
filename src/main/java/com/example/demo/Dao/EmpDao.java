package com.example.demo.Dao;

import com.example.demo.Entity.Emp;
import com.example.demo.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class EmpDao {
	public int save(Emp emp){
		String sql="insert into t_emp (empno,ename,mgr,hiredate,deptno,salary,comm) values( null,?,?,?,?,?,?)";
		try(Connection conn= DBUtil.getConnection()){
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setInt(2, emp.getMgr());
			ps.setDate(3, emp.getHiredate());
			ps.setInt(4, emp.getDeptno());
			ps.setDouble(5, emp.getSalary());
			ps.setDouble(6, emp.getComm());
			int n=ps.executeUpdate();
			return n;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	public List<Emp> findAll(){
		String sql="select empno,ename,mgr,hiredate,deptno,salary,comm from t_emp";
		Connection conn=null;
		try{
			conn=DBUtil.getConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			List<Emp> list = new ArrayList<Emp>();
			while(rs.next()){
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				int mgr=rs.getInt("mgr");
				Date hiredate=rs.getDate("hiredate");
				int deptno=rs.getInt("deptno");
				double salary=rs.getDouble("salary");
				double comm=rs.getDouble("comm");
				Emp emp=new Emp(empno,ename,mgr,hiredate,deptno,salary,comm);
				list.add(emp);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			DBUtil.close(conn);
		}
	}
}
