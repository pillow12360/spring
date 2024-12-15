package kr.ac.seoil.front.board.service;

import java.util.List;

import kr.ac.seoil.front.board.vo.BoardVO;
import kr.ac.seoil.front.board.vo.Criteria;

public interface BoardService {
	/**
	 * 게시물 목록
	 * @return
	 */
	public List<BoardVO> getList() throws Exception;
	
	/**
	 * 게시물 목록 (Paging)
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> getList(Criteria cri) throws Exception; 

	/**
	 * 전체 게시물 갯수 조회
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int getTotalCount(Criteria cri) throws Exception;
	
	/**
	 * 게시물 등록 (PK not setting VO)
	 * @param vo
	 * @throws Exception
	 */
	public void create(BoardVO vo) throws Exception;

	/**
	 * 게시물 등록 (PK setting VO)
	 * @param vo
	 * @throws Exception
	 */
	public void createGetKey(BoardVO vo) throws Exception;
	
	/**
	 * 게시물 상세
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public BoardVO getInfo(BoardVO vo) throws Exception;
	
	/**
	 * 게시물 삭제
	 * @param bno
	 * @return
	 * @throws Exception
	 */
	public int remove(Long bno) throws Exception;
	
	/**
	 * 게시물 수정
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int modify(BoardVO vo) throws Exception;
	
	
	
	
	
	
}
