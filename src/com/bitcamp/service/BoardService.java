package com.bitcamp.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.bitcamp.common.util.DBConnection;
import com.bitcamp.dao.BoardDAO;
import com.bitcamp.dto.BoardDTO;

public class BoardService {

	private static BoardService service = new BoardService();
	public static BoardService getService()
	{
		return service;
	}
	private BoardService() {}
	
	public List<BoardDTO> list() {
		DBConnection db = DBConnection.getDB();
		Connection conn = null;
		List<BoardDTO> list = null; 
		try
		{
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDAO();
			list = dao.boardList(conn);
			conn.commit();
		} catch(SQLException e)
		{
			try {conn.rollback();} catch(SQLException e1) {}
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return list;
	}

	public int insertService(BoardDTO dto)
	{
		DBConnection db = DBConnection.getDB();
		Connection conn = null;
		int result = 0;
		try{
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDAO();
			result = dao.insertBoard(conn, dto);
			conn.commit();
			
		}catch(SQLException | NamingException e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
			System.out.println(e);
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}

	
	
	public BoardDTO detailService(int empno) {
		DBConnection db = DBConnection.getDB();
		Connection conn = null;
		BoardDAO dao = BoardDAO.getDAO();
		BoardDTO dto = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			dto = dao.detailBoard(conn, empno);			
			conn.commit();
		} catch(SQLException e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e);
		} catch (NamingException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return dto;
	}
	public int deleteService(int empno) {
		DBConnection db = DBConnection.getDB();
		Connection conn = null;
		int result = 0;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDAO();
			result = dao.deleteBoard(conn, empno);
			conn.commit();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	public int updateService(BoardDTO dto) {
		DBConnection db = DBConnection.getDB();
		Connection conn = null;
		int result = 0;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao = BoardDAO.getDAO();
			result = dao.updateBoard(conn, dto);
			conn.commit();
		} catch (SQLException | NamingException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
}
