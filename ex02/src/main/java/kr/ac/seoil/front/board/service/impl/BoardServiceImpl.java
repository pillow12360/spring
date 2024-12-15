package kr.ac.seoil.front.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.seoil.front.board.mapper.BoardMapper;
import kr.ac.seoil.front.board.service.BoardService;
import kr.ac.seoil.front.board.vo.BoardVO;
import kr.ac.seoil.front.board.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;
	
	/**
	 * 게시물 목록
	 */
	@Override
	public List<BoardVO> getList() {
		return boardMapper.selectList();
	}
	
	/**
	 * 게시물 목록 (Paging)
	 */
	@Override
	public List<BoardVO> getList(Criteria cri) throws Exception {
		return boardMapper.selectListWithPaging(cri);
	}
	
	/**
	 * 게시물 전체 갯수
	 */
	@Override
	public int getTotalCount(Criteria cri) throws Exception {
		return boardMapper.selectTotalCount(cri);
	}
	
	@Override
	public void create(BoardVO vo) throws Exception {
		boardMapper.insert(vo);
	}
	
	@Override
	public void createGetKey(BoardVO vo) throws Exception {
		boardMapper.insertSelectKey(vo);
	}
	
	@Override
	public BoardVO getInfo(BoardVO vo) throws Exception {
		return boardMapper.selectInfo(vo);
	}
	
	@Override
	public int remove(Long bno) throws Exception {
		return boardMapper.delete(bno);
	}
	
	@Override
	public int modify(BoardVO vo) throws Exception {
		return boardMapper.update(vo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
