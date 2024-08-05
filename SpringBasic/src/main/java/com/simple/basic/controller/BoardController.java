package com.simple.basic.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.basic.command.BoardVO;
import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.board.BoardService;
import com.simple.basic.service.score.ScoreService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	@Qualifier("z") // 이름으로 연결 Autowired와 Qualifier는 한쌍.
	BoardService boardservice;
	
	
	//게시글등록
	@RequestMapping("/boardRegister")
	public String boardWrite() {
		
		return "board/boardRegister";
		
	}
	
	//폼요청
		@RequestMapping(value="/boardForm",method=RequestMethod.POST)
		public String boardForm(BoardVO vo) { //값 받기
			
			boardservice.register(vo);

			
			return "board/boardResult"; //결과화면
		}
		
		@RequestMapping("/boardList")
		public String boardList(Model model) {
	        ArrayList<BoardVO> list = boardservice.getBoard();
	        model.addAttribute("boardList", list);
	        return "board/boardList";
		}
		
		
		 @RequestMapping("/boardDelete")
		    public String boardDelete(int num) {
		        boardservice.delete(num);
		        return "redirect:/board/boardList"; // 삭제 후 목록으로 리다이렉트
		    }
	

}
