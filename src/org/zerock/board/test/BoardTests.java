package org.zerock.board.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.zerock.board.dao.BoardDAO;
import org.zerock.board.domain.Board;
import org.zerock.board.domain.PageInfo;
import org.zerock.common.dao.MyBatisMaker;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardTests {

	private BoardDAO dao;
	
	@Before
	public void ready() {
		dao = new BoardDAO();
	}
	
	@Test
	public void testSqlSessioFactory() {
		//  			설정파링이 로딩이 끝난걸 확인
		System.out.println(MyBatisMaker.INSTANCE.getFactory());
		
	}
	
	@Test
	public void testGetList() throws Exception {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(1);
		pageInfo.setPerSheet(50);
		List<Board> list =dao.getList(pageInfo);
		
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void testGetOne() {
		
		Board board = dao.getOne(2L);
		log.info(board);
	}
	
	@Test
	public void testInsert() {
		
		Board board = Board.builder()
				.title("testTitle")
				.content("testContent")
				.writer("writer")
				.build();
		dao.insert(board);
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		Long sno = 68L;
		Board board = dao.getOne(sno);
		dao.delete(sno);
		log.info(board);		
	}
	
	@Test
	public void testUpdate() {
		Board board = dao.getOne(67L);
		board.setTitle("updateTitle");
		board.setContent("updateContent");
		board.setWriter("updateWriter");
		
		dao.update(board);
		log.info(board);
	}
}
