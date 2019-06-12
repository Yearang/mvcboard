package com.bitcamp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doReq(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doReq(request, response);
	}

	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		Action act = null;
		if ("/list.do".equals(path)) {
			act = new ListAction();
		} else if ("/insert.do".equals(path)) {
			act = new InsertAction();
		} else if ("/insertresult.do".equals(path)) {
			act = new InsertResultAction();
		} else if ("/detail.do".equals(path)) {
			act = new DetailAction();
		} else if ("/del.do".equals(path)) {
			act = new DeleteAction();
		} else if ("/update.do".equals(path)) {
			act = new UpdateAction();
		} else if ("/updateresult.do".equals(path)) {
			act = new UpdateResultAction();
		}
		String urlpath = act.execute(request, response);
		RequestDispatcher disp = request.getRequestDispatcher(urlpath);
		disp.forward(request, response);
	}
}