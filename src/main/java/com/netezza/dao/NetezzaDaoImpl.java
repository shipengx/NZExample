package com.netezza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class NetezzaDaoImpl implements NetezzaDao {

	private BasicDataSource dataSource;
	private static final String GET_NUM_OF_SIGNALS_SQL = " select count(*) from mo_signals ";

	// DI setter
	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int getNumOfSignals() {
		int result = -1;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(GET_NUM_OF_SIGNALS_SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
				break;
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
