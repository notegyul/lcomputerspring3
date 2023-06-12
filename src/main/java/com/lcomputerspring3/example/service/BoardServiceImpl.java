package com.lcomputerspring3.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService{

	@Autowired BoardMapper boardmapper;
	
	@Override
	public List<Board> selectBoardList(){
		return boardmapper.selectBoardList();
	}
	
	@Override
	public void writePost(Board board) {
		boardmapper.writePost(board);
	}
	
	
	@Override
	public Board getBoard(int bId) {
		return boardmapper.getBoard(bId);
	}
	
	
	@Override
	public int editBoard(int bId) {
		return 0;
	}
	
	@Override 
	public int deleteBoard(int bId) {
		return 0;
	}
	
	
	
	
	
	
}
