package com.simple.basic.service.score.impl;

import java.util.ArrayList;

import com.simple.basic.command.ScoreVO;

public interface ScoreDAO {
	public void regist(ScoreVO vo); //등록
	public ArrayList<ScoreVO> getScore();
	public void delete(int sno); //삭제
}
