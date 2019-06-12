package com.bitcamp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.dto.BoardDTO;
import com.bitcamp.service.BoardService;

public class UpdateResultAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		Float sal = Float.parseFloat(request.getParameter("sal"));
		BoardDTO dto = new BoardDTO();
		dto.setEmpno(empno);
		dto.setEname(ename);
		dto.setJob(job);
		dto.setSal(sal);
		BoardService service = BoardService.getService();
		int result = service.updateService(dto);
		request.setAttribute("result", result);
		return "/updateresult.jsp";
	}

}
