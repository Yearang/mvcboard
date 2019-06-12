package com.bitcamp.controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.dto.BoardDTO;
import com.bitcamp.service.BoardService;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = BoardService.getService();
		List<BoardDTO> list = service.list();
		request.setAttribute("list", list);
		return "/list.jsp";
	}

}
