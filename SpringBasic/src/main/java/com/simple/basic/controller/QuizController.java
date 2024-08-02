package com.simple.basic.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.MemberVO;
import com.simple.basic.command.QuizVO;
@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/quiz01")
	public String quizview() { // vo로 맵핑하고 info로 넘긴다.

		System.out.println("퀴즈 이동");
		
		
		return "quiz/quiz01";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String quizresult(@ModelAttribute("info") QuizVO vo) {


		

		return "quiz/quiz01_ok";
	}
	
	@RequestMapping("/quiz02")
	public String quizbirth() { // vo로 맵핑하고 info로 넘긴다.

		System.out.println("퀴즈 이동");
		
		
		return "quiz/quiz02";
	}
	
	@RequestMapping(value = "/quiz02", method = RequestMethod.POST)
	public String quizresult1(MemberVO vo, RedirectAttributes ra) {
		
		   int year = vo.getYear();
		    int month = vo.getMonth();
		    int day = vo.getDay();
		    String msg = vo.getMsg();
		    
		    String all = year+"-"+month+"-"+day+"-"+msg;
		
		
		    ra.addFlashAttribute("all", all);
		  
		
		
		return "redirect:/quiz/quiz_result";
		
	}
	
	@RequestMapping("/quiz_result")
	public String quizResultPage() {
	    return "quiz/quiz_result";
	}
	
	
	
	}
	
	
	
	
	
	

