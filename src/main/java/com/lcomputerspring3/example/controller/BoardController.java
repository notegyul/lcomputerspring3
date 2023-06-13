package com.lcomputerspring3.example.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.Pagination;
import com.lcomputerspring3.example.service.BoardService;
import com.lcomputerspring3.example.service.UserService;


@org.springframework.stereotype.Controller
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired BoardService boardservice;
	@Autowired UserService userservice;
	@Autowired Pagination pagination;
	
	
	@RequestMapping(value="/tryToWrite")
	public String tryToWrite() {
		return "/put-on-record";
	}
	
	@RequestMapping(value="/writePost")
	public String writePost(Board board) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String username = userDetails.getUsername();	
			board.setuName(userservice.readUser(username).getuName());
		}
		
		boardservice.writePost(board);
		logger.info("게시글 등록 성공!");
		return "/put-on-record-compl";
	}
	
	@RequestMapping(value={"/boardList","/boardList/{pageOpt}"})
	public String getBoardList(Model model, @PathVariable("pageOpt") Optional<Integer> pageOpt){
		
		pagination.setCount(boardservice.boardCountAll());
		
		pagination.init();
		List<Board> list = boardservice.selectBoardListWithPage(pagination);	
		
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		logger.info("list 불러오기 성공!");
		return "/board-list";
	}
	
	
	
	//optional stream -> if else 대체
	//query에서 limit 변경
	
	
	
	
	
}


