package com.simple.basic.service.board;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.BoardVO;
import com.simple.basic.service.board.*;
import com.simple.basic.util.aop.LogAdvice;

@Service("z")
public class BoardServiceImpl implements BoardService {
	
	
	//해당 클래스에서 로그를 사용함 (base패키지 밑에 존재해야 사용합니다.)
		public static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void register(BoardVO vo) {
        boardMapper.insertBoard(vo);
    }

    @Override
    public ArrayList<BoardVO> getBoard() {
        return boardMapper.selectBoardList();
    }@Override
    public void delete(int num) {
    	boardMapper.delete(num);
    	
    }
    
    
    
}
