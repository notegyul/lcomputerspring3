package com.lcomputerspring3.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerspring3.example.domain.Board;

@Mapper
public interface BoardMapper {
	public List<Board> selectBoardList();
}
