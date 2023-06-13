package com.lcomputerspring3.example.service;

import java.util.List;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.Pagination;

public interface BoardService {
	public List<Board> selectBoardList();
	
	public List<Board> selectBoardListWithPage(Pagination pagination);
	
	public int boardCountAll();
	
	public void writePost(Board board);
	
	public Board getBoard(int bId);
	
	public int editBoard(int bId);
	
	public int deleteBoard(int bId);
}
