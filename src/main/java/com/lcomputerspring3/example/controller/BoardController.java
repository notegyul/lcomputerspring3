package com.lcomputerspring3.example.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.Pagination;
import com.lcomputerspring3.example.domain.User;
import com.lcomputerspring3.example.service.BoardService;
import com.lcomputerspring3.example.service.UserService;


@org.springframework.stereotype.Controller
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	int result = 0;
	
	@Autowired BoardService boardservice;
	@Autowired UserService userservice;
	@Autowired Pagination pagination;
	@Autowired Board board;
	@Autowired User user;
	
	
	@RequestMapping(value="/tryToWrite")
	public String tryToWrite() {
		return "/put-on-record";
	}
	
	@RequestMapping(value="/writePost")
	public String writePost(@AuthenticationPrincipal UserDetails userDetails, Board board) {
		if(userDetails != null) {
			String username = userDetails.getUsername();	//u_id
			board.setbWriter(userservice.readUser(username).getuName());	//b_writer
			board.setUsername(username);
			boardservice.writePost(board);
			boardservice.writePostGroupUpdate(board);
			logger.info("게시글 등록 성공!");
		
		}
		return "/put-on-record-compl";
		
	}
	
	@GetMapping({"/boardList","/boardList/{pageOpt}"})
	public String getBoardList(Model model, @PathVariable("pageOpt") Optional<Integer> pageOpt){
		
		int page = pageOpt.stream()
		        .findFirst() // Optional 값을 스트림의 첫 번째 요소로 변환
		        .orElse(1);
		
		pagination.setCount(boardservice.boardCountAll());
		pagination.setPage(page);
		pagination.init();
		List<Board> list = boardservice.selectBoardList(pagination);	
		
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		logger.info("list 불러오기 성공!");
		return "/board-list";
	}
	
	
	
	@GetMapping("/readBoard/{bId}")
	public String readBoard(@PathVariable("bId") int bId, Model model) {
		
		board = boardservice.readBoard(bId);
		String author = board.getUsername(); 	//u_id(username)-작성자 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = authentication.getName();	//u_id(username)-로그인한 유저 
		
		//u_auth 읽기 위함(관리자 삭제 버튼 노출) 
		Collection<GrantedAuthority> authorities = userservice.getAuthorities(currentUser);
		List<String> userAuthList = userservice.getUserAuth(authorities);
		boolean userAuthContainsAdmin = userAuthList.contains("ROLE_ADMIN");
		
		model.addAttribute("userAuthContainsAdmin", userAuthContainsAdmin);
		model.addAttribute("board", board);
		model.addAttribute("author", author);
		model.addAttribute("currentUser", currentUser);
		
		logger.info("게시글 불러오기 성공!!");
		return "/board-detail";
	}
	
	@GetMapping("/tryToEditBoard/{bId}")
	public String tryToEditBoard(@PathVariable("bId") int bId, Model model) {
		
		board = boardservice.readBoard(bId);
		model.addAttribute("board", board);
	
		logger.info("게시글 수정 시도!");
		return "/edit";
	}
	
	@PostMapping("/editBoard-Pro")
	public String editBoard(Board board) {
		
		result = boardservice.editBoard(board);
		logger.info("게시글 수정 완료!!");
		return "/edit-compl";
	}
	
	@GetMapping("/deleteBoard/{bId}")
	public String deleteBoard(@PathVariable("bId") int bId) {
		
		board= boardservice.readBoard(bId);
		if(board == null)	return "존재하지 않는 게시글";
		
		result = boardservice.deleteBoard(board);
		
		logger.info("게시글 삭제 성공!");
		return "/delete-compl";
	}
	
	@GetMapping("/replyToOriginBoard/{bGroup}/{bOrder}/{bDepth}")
	public String replyToOriginBoard(@PathVariable("bGroup") int bGroup, 
			@PathVariable("bOrder") int bOrder, @PathVariable("bDepth") int bDepth, Board board) {
		
		board.setbGroup(bGroup);
		board.setbOrder(bOrder);
		board.setbDepth(bDepth);
		
		return "/reply-form";
	}
	
	@PostMapping("/replyToOriginBoardPro")
	public String replyToOriginBoardPro(@AuthenticationPrincipal UserDetails userDetails,Board board, @RequestParam("bGroup") int bGroup,
			@RequestParam("bOrder") int bOrder, @RequestParam("bDepth") int bDepth) {
		if(userDetails != null) {
			String username = userDetails.getUsername();
			board.setUsername(username);
			board.setbWriter(userservice.readUser(username).getuName());
		}
		
		
		board.setbGroup(bGroup);
		board.setbOrder(bOrder +1);
		board.setbDepth(bDepth +1);
		
		
	    boardservice.replyTo(board);
	    boardservice.updateBOrder(board);
		
		return "/put-on-record-compl";
	}
	
	
	
	
	
	
	
	
}


