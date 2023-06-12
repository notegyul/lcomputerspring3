package com.lcomputerspring3.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.User;
import com.lcomputerspring3.example.service.BoardService;


@org.springframework.stereotype.Controller
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired User user;
	@Autowired Board board;
	@Autowired BoardService boardservice;
	
	
	
	@RequestMapping(value="/tryToWrite")
	public String tryToWrite() {
		return "/put-on-record";
	}
	
	@RequestMapping(value="/writePost")
	public String writePost() {
		
		Board board = new Board();
		
		boardservice.writePost(board);
		
		return "/put-on-record-compl";
	}
	
	
	
	
	
	
	
	
	
}


