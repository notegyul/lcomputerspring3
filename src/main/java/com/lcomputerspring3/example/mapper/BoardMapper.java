package com.lcomputerspring3.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.Pagination;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList(Pagination pagination);
	
	public List<Board> selectBoardListWithPage(Pagination pagination);
	
	public int boardCountAll();
	
	public void writePost(Board board);
	
	public Board readBoard(int bId);
	
	public int editBoard(Board board);
	
	public int deleteBoard(Board board);
	
	public int writePostGroupUpdate(Board board);
	
	public void replyToBoardOrigin(Board board);

	public void replyTo(Board board);
	
	public void updateBOrder(Board board);
	
}
