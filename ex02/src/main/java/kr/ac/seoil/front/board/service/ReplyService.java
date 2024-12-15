package kr.ac.seoil.front.board.service;

import java.util.List;

import kr.ac.seoil.front.board.vo.Criteria;
import kr.ac.seoil.front.board.vo.ReplyVO;

public interface ReplyService {
	/**
	 * 댓글등록
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int create(ReplyVO vo) throws Exception;
	
	/**
	 * 특정댓글 읽기
	 * @param rno
	 * @return
	 * @throws Exception
	 */
	public ReplyVO get(Long rno) throws Exception;

	/**
	 * 댓글 수정
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int modify(ReplyVO vo) throws Exception;
	
	/**
	 * 댓글 삭제
	 * @param rno
	 * @return
	 * @throws Exception
	 */
	public int remove(Long rno) throws Exception;
	
	/**
	 * 댓글 목록
	 * @param cri
	 * @param bno
	 * @return
	 * @throws Exception
	 */
	public List<ReplyVO> getList(Criteria cri, Long bno) throws Exception;
}












