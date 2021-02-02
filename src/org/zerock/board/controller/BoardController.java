package org.zerock.board.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.board.dao.BoardDAO;
import org.zerock.board.domain.Board;
import org.zerock.board.domain.PageInfo;
import org.zerock.common.controller.MultiController;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;

@WebServlet("/board/*")
@Log4j
public class BoardController extends MultiController{
	
	@Default
	private BoardDAO dao = new BoardDAO();
	
	public String listGET(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		log.info("list..............");
		
		PageInfo pageInfo = new PageInfo();
		
		pageInfo.setPage(getInt(req,"page", 1));
		pageInfo.setPerSheet(getInt(req, "perSheet", 10));
		
		List<Board> list = dao.getList(pageInfo);
		
		list.forEach(board -> log.info(board));
		
		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("list", list);
		
		return "board/list";
	}
}
