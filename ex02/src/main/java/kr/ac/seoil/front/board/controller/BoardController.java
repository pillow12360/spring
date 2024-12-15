package kr.ac.seoil.front.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.seoil.front.board.service.BoardService;
import kr.ac.seoil.front.board.vo.BoardVO;
import kr.ac.seoil.front.board.vo.Criteria;
import kr.ac.seoil.front.board.vo.PageVO;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list1")
	public ModelAndView list(ModelAndView mv) throws Exception {
		List<BoardVO> list = boardService.getList();
		
		mv.addObject("list", list);
		mv.setViewName("board/list");
		
		return mv;
	}
	@GetMapping("/list")
	public void list(Model model, Criteria cri) throws Exception {
		List<BoardVO> list = boardService.getList(cri);
		
		int total = boardService.getTotalCount(cri);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageVO(cri, total));
	}
	
	@GetMapping("/write")
	public void reg() {
		
	}
	
	@PostMapping("/create")
	public String create(BoardVO vo, RedirectAttributes rttr) throws Exception {
		boardService.createGetKey(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/edit"})
	public void get(Model model, BoardVO vo, @ModelAttribute("cri") Criteria cri) throws Exception {
		BoardVO retVO = boardService.getInfo(vo);
		
		model.addAttribute("board", retVO);
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO vo, Criteria cri, RedirectAttributes rttr) throws Exception {
		int ret = boardService.modify(vo);
		
		if (ret > 0) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:list" + cri.getListLink();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) throws Exception {
		int ret = boardService.remove(bno);
		if (ret > 0) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";
	}
	
}












