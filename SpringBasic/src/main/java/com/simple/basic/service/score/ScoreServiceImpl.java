package com.simple.basic.service.score;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.basic.command.ScoreVO;
import com.simple.basic.service.score.impl.ScoreDAO;
import com.simple.basic.util.aop.LogAdvice;

@Service("x") //반드시 component-scan에 의하여 읽혀야 함.
public class ScoreServiceImpl implements ScoreService {
//	@Autowired
//	@Qualifier("y")
//	ScoreDAO scoreDAO;
	
	//해당 클래스에서 로그를 사용함 (base패키지 밑에 존재해야 사용합니다.)
		public static final Logger log = LoggerFactory.getLogger(ScoreServiceImpl.class);
	
	@Autowired
	private ScoreMapper scoreMapper;
	
	
	
	
	@Override
	public void regist(ScoreVO vo) {
		//DAO 계층으로...
		System.out.println("regist 동작");
		scoreMapper.regist(vo);
	}
	
	@Override
		public ArrayList<ScoreVO> getScore() {
		System.out.println("getScore 동작");
			return scoreMapper.getScore();
		}
	@Override
	public void delete(int sno) {
		System.out.println("delete 동작");
		scoreMapper.delete(sno);
		
	}
	
	
	}
