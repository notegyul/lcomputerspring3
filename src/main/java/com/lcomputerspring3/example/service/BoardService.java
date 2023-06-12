package com.lcomputerspring3.example.service;

import java.util.List;

import com.lcomputerspring3.example.domain.Board;

public interface BoardService {
	public List<Board> selectBoardList();
	
	public void writePost(Board board);
	
	public Board getBoard(int bId);
	
	public int editBoard(int bId);
	
	public int deleteBoard(int bId);
}
