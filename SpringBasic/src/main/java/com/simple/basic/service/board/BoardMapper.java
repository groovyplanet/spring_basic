package com.simple.basic.service.board;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.BoardVO;

@Mapper
public interface BoardMapper {
    public void insertBoard(BoardVO vo); // 게시글 등록
    public ArrayList<BoardVO> selectBoardList(); // 게시글 목록 조회
    public void delete (int num);
}