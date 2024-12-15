package kr.ac.seoil.front.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.seoil.front.board.mapper.ReplyMapper;
import kr.ac.seoil.front.board.service.ReplyService;
import kr.ac.seoil.front.board.vo.Criteria;
import kr.ac.seoil.front.board.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public int create(ReplyVO vo) throws Exception {
		return replyMapper.insert(vo);
	}
	
	@Override
	public ReplyVO get(Long rno) throws Exception {
		return replyMapper.select(rno);
	}
	
	@Override
	public int modify(ReplyVO vo) throws Exception {
		return replyMapper.update(vo);
	}
	
	@Override
	public int remove(Long rno) throws Exception {
		return replyMapper.delete(rno);
	}
	
	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) throws Exception {
		return replyMapper.selectList(cri, bno);
				
	}
}















