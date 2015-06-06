package com.erp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
	private static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "manager_user01";
	private static final String PWD = "a1234";
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * 获取连接的方法
	 * 
	 * @return
	 */
	public Connection getConnection() {
		try {
			Class.forName(DRIVER_CLASS);
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			Context context=new InitialContext();
//			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/news");
//			
//				conn=ds.getConnection();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return conn;
	}

	/**
	 * 使用JDBC实现增、删、改,不带占位符
	 * 
	 * @param sql
	 * @return
	 */

	public int executeUpdate(String sql) {
		return this.executeUpdate(sql, new Object[] {});
	}

	/**
	 * 使用JDBC实现增、删、改,不带占位符
	 * 
	 * @param sql
	 * @param params
	 *            传入占位符的数据
	 * @return
	 */
	public int executeUpdate(String sql, Object[] params) {
		int ret = 0;
		// 获得连接
		conn = this.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			ret = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * 一个占位符
	 */
	public int executeUpdate(String sql, List params) {
		int ret = 0;
		// 获得连接
		conn = this.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i + 1, params.get(i));
				}
			}
			ret = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * 一个占位符
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object params) {
		return this.executeUpdate(sql, new Object[] { params });
	}

	/**
	 * 实现查询,带占位符
	 * 
	 * @return
	 */
	public ResultSet executeQuery(String sql, Object[] params) {
		conn = this.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 不带占位符、查询
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet executeQuery(String sql) {
		return this.executeQuery(sql, new Object[] {});
	}

	/**
	 * 带一个占位符
	 * 
	 * @param sql
	 * @return
	 */

	public ResultSet executeQuery(String sql, Object params) {
		return this.executeQuery(sql, new Object[] { params });
	}

	/**
	 * List实现占位符查询
	 */
	public ResultSet executeQuery(String sql, List params) {
		return this.executeQuery(sql, params.toArray());
	}

	/**
	 * 关闭方法
	 */
	public void close() {

		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 计算表的记录数
	public int executeTotalCount(String sql) {

		rs = this.executeQuery(sql);
		int total = 0;
		try {
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}
		return total;
	}
	public ResultSet executeQueryForPage(String sql,int pageNo,int pageSize){
		String pageSql="select * from (select rownum r, x.* from ( ";
		pageSql+=sql+") x  where rownum<=?)t  where t.r>?";
		ResultSet rs=null;
		rs=this.executeQuery(pageSql,new Object[]{pageNo*pageSize,(pageNo-1)*pageSize});
		return rs;
	}
	public ResultSet executeQueryForPage(String sql,Object[] params){
		String pageSql="select * from (select rownum r, x.* from ( ";
		pageSql+=sql+") x  where rownum<=?)t  where t.r>?";
		ResultSet rs=null;
		rs=this.executeQuery(pageSql,params);
		return rs;
	}
	//返回新产生的id
	public int executeQueryForNewId(String sql){
		ResultSet rs=this.executeQuery(sql);
		int id=0;
		try {
			while(rs.next()){
			     id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}
}
