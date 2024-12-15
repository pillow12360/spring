package kr.ac.seoil;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.seoil.front.board.mapper.BoardMapper;
import kr.ac.seoil.front.board.vo.BoardVO;
import kr.ac.seoil.front.board.vo.Criteria;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("File:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		boardMapper.selectList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("Mapper Test Insert");
		vo.setContent("Mapper Test 등록");
		vo.setWriterNm("swchoi");
		boardMapper.insert(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testInsertSelectKey() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("Select Key Insert Test");
		vo.setContent("Select Key Insert Test");
		vo.setWriterNm("swchoi");
		
		boardMapper.insertSelectKey(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testSelectInfo() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(21L);
		
		BoardVO ret = boardMapper.selectInfo(vo);
		
		log.info(ret);
	}
	
	@Test
	public void testDelete() throws Exception {
		log.info("############# " + boardMapper.delete(25L));
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(3L);
		vo.setTitle("수정테스트_03");
		vo.setContent("수정 테스트 내용_03");
		log.info("############ " + boardMapper.update(vo));
	}
	
	@Test
	public void testPaging() throws Exception {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = boardMapper.selectListWithPaging(cri);
		list.forEach(board -> log.info(board.getBno()));
	}
}











