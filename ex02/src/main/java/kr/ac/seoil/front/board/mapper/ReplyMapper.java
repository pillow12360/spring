package kr.ac.seoil.front.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ac.seoil.front.board.vo.Criteria;
import kr.ac.seoil.front.board.vo.ReplyVO;

/**
 * 댓글 Mapper Interface
 * @author Software
 *
 */
public interface ReplyMapper {

	/**
	 * 댓글등록
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int insert(ReplyVO vo) throws Exception;

	/**
	 * 특정 댓글 읽기
	 * @param rno
	 * @return
	 * @throws Exception
	 */
	public ReplyVO select(Long rno) throws Exception;
	
	/**
	 * 댓글 삭제
	 * @param rno
	 * @return
	 * @throws Exception
	 */
	public int delete(Long rno) throws Exception;
	
	/**
	 * 댓글 수정
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int update(ReplyVO vo) throws Exception;
	
	
	public List<ReplyVO> selectList(
			@Param("cri") Criteria cri
			, @Param("bno") Long bno) throws Exception;
}











