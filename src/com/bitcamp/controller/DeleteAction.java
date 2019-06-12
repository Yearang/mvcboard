package com.bitcamp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.service.BoardService;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getService();
		int empno = Integer.parseInt(request.getParameter("empno"));
		int result = service.deleteService(empno);
		request.setAttribute("result", result);
		return "/del.jsp";
	}

}
