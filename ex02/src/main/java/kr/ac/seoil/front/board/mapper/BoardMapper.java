package kr.ac.seoil.front.board.mapper;

import java.util.List;

import kr.ac.seoil.front.board.vo.BoardVO;
import kr.ac.seoil.front.board.vo.Criteria;

public interface BoardMapper {

	/**
	 * 게시물 목록
	 * @return
	 */
	public List<BoardVO> selectList();
	
	/**
	 * 게시물 목록 페이징처리
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public List<BoardVO> selectListWithPaging(Criteria cri) throws Exception;
	
	/**
	 * 게시물 전체 갯수 리턴
	 * @param cri
	 * @return
	 * @throws Exception
	 */
	public int selectTotalCount(Criteria cri) throws Exception;
	
	/**
	 * 게시물 등록 (PK not setting VO)
	 * @param vo
	 * @throws Exception
	 */
	public void insert(BoardVO vo) throws Exception;
	
	/**
	 * 게시물 등록 (PK setting VO)
	 * @param vo
	 * @throws Exception
	 */
	public void insertSelectKey(BoardVO vo) throws Exception;
	
	/**
	 * 게시물 상세
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public BoardVO selectInfo(BoardVO vo) throws Exception;
	
	/**
	 * 게시물 삭제
	 * @param bno
	 * @return
	 * @throws Exception
	 */
	public int delete(Long bno) throws Exception;
	
	/**
	 * 게시물 수정
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int update(BoardVO vo) throws Exception;
}













