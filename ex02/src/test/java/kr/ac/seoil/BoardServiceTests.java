package kr.ac.seoil;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.seoil.front.board.service.BoardService;
import kr.ac.seoil.front.board.vo.Criteria;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("File:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testGetList() throws Exception {
		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ " + boardService);
		assertNotNull(boardService);
		boardService.getList();
	}
	
	@Test
	public void testGetListByPaging() throws Exception {
		boardService.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}
}





















