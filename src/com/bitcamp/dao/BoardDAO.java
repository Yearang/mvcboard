package com.bitcamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitcamp.dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO dao = new BoardDAO();

	public static BoardDAO getDAO() {
		return dao;
	}

	private BoardDAO() {
	}

	/**
	 * empno, ename, job, sal의 자료를 읽어서 list에 저장함
	 * 
	 * @param conn
	 * @return List
	 * @throws SQLException
	 */

	public List<BoardDTO> boardList(Connection conn) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select empno, ename, job, sal ");
		sql.append("from tempemp				  ");
		ArrayList<BoardDTO> list = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setSal(rs.getInt("sal"));
				list.add(dto);
			}
		}
		return list;
	}

	public int insertBoard(Connection conn, BoardDTO dto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into tempemp ");
		sql.append("values(?, ?, ?, ?) ");
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, dto.getEmpno());
			pstmt.setString(2, dto.getEname());
			pstmt.setString(3, dto.getJob());
			pstmt.setDouble(4, dto.getSal());
			result = pstmt.executeUpdate();
		}
		return result;
	}

	public BoardDTO detailBoard(Connection conn, int empno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select empno, ename, job, sal 	");
		sql.append("from tempemp					");
		sql.append("where empno = ?					");
		PreparedStatement pstmt = null;
		BoardDTO dto = new BoardDTO();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setSal(rs.getFloat("sal"));
			}
		} finally {
			if(rs!=null) {
				rs.close();}			
		}
		return dto;
	}

	public int deleteBoard(Connection conn, int empno) throws SQLException {
		StringBuilder sql = new StringBuilder();
		int result = 0;
		sql.append("delete from tempemp where empno = ?");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, empno);
			result = pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)
			{
				pstmt.close();
			}
		}
		return result;
	}

	public int updateBoard(Connection conn, BoardDTO dto) throws SQLException{
		StringBuilder sql = new StringBuilder();
		int result = 0;
		sql.append("update tempemp	 ");
		sql.append("set ename = ?	 ");
		sql.append("	, job = ?	 ");
		sql.append("	, sal = ?	 ");
		sql.append("where empno = ?	 ");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getEname());
			pstmt.setString(2, dto.getJob());
			pstmt.setDouble(3, dto.getSal());
			pstmt.setInt(4, dto.getEmpno());
			result = pstmt.executeUpdate();
			System.out.println(result);
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}