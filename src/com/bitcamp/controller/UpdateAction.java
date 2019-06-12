package com.bitcamp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.dto.BoardDTO;
import com.bitcamp.service.BoardService;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getService();
		int empno = Integer.parseInt(request.getParameter("empno"));
		BoardDTO dto = service.detailService(empno);
		request.setAttribute("dto", dto);
		return "/update.jsp";
	}

}
