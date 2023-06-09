package com.lcomputerspring3.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.Pagination;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
	
	public List<Board> selectBoardListWithPage(Pagination pagination);
	
	public int boardCountAll();
	
	public void writePost(Board board);
	
	public Board getBoard(int bId);
	
	public int edit(int bId);
	
	public int delete(int bId);
	
}
