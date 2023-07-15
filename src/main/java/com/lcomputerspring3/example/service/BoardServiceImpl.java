package com.lcomputerspring3.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.Pagination;
import com.lcomputerspring3.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService{

	@Autowired BoardMapper boardmapper;
	
	@Override
	public List<Board> selectBoardList(Pagination pagination){
		return boardmapper.selectBoardList(pagination);
	}
	
	
	
	@Override
	public int boardCountAll() {
		return boardmapper.boardCountAll();
	}
	
	@Override
	public void writePost(Board board) {
		boardmapper.writePost(board);
	}
	
	
	@Override
	public Board readBoard(int bId) {
		return boardmapper.readBoard(bId);
	}
	
	
	@Override
	public int editBoard(Board board) {
		return boardmapper.editBoard(board);
	}
	
	@Override 
	public int deleteBoard(Board board) {
		return boardmapper.deleteBoard(board);
	}
	
	@Override
	public int writePostGroupUpdate(Board board) {
		return boardmapper.writePostGroupUpdate(board);
	}
	
	@Override
	public void replyTo(Board board) {
		boardmapper.replyTo(board);
	}
	
	@Override
	public void updateBOrder(Board board) {
		boardmapper.updateBOrder(board);
	}
	
	
	
}
