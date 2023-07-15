package com.lcomputerspring3.example.service;

import java.util.List;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.Pagination;

public interface BoardService {
	public List<Board> selectBoardList(Pagination pagination);
	
	
	public int boardCountAll();
	
	public void writePost(Board board);
	
	public Board readBoard(int bId);
	
	public int editBoard(Board board);
	
	public int deleteBoard(Board board);
	
	public int writePostGroupUpdate(Board board);
	
	public void replyTo(Board board);
	
	public void updateBOrder(Board board);
	
}
