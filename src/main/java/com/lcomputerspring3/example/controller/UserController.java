package com.lcomputerspring3.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcomputerspring3.example.domain.Board;
import com.lcomputerspring3.example.domain.Pagination;
import com.lcomputerspring3.example.domain.User;
import com.lcomputerspring3.example.service.BoardService;
import com.lcomputerspring3.example.service.UserService;

@org.springframework.stereotype.Controller
public class UserController {
	
	
	//로그 https://velog.io/@backtony/Spring-%EB%A1%9C%EA%B7%B8-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0-Logback
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	@Autowired PasswordEncoder encoder;
	@Autowired Pagination pagination;
	
	@RequestMapping("/")
	public String home(Model model) {
		
		List<Board> list = boardservice.selectBoardList(pagination);
		model.addAttribute("list",list);
		//logger.debug("debug");
		//logger.info("info");
		//logger.error("error");
		return "/index";
	}
	
	@RequestMapping("/beforeSignUp")
	public String beforeSignUp() {
		
		logger.info("회원가입 하러 GO!");
		return "/signup";
	}
	
	@RequestMapping("/signup")
	public String signup(User user) {
		
		//비밀번호 암호화 
		String encodedPassword = encoder.encode(user.getPassword());
		
		//유저 데이터 세팅
		user.setPassword(encodedPassword);
		user.setAccountNonExpired(true);
		user.setEnabled(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));
		
		//유저 생성 
		userservice.createUser(user);
		
		//유저 권한 생성 
		userservice.createAuthorities(user);
				
		logger.info("가입 완료!!");
		return "/login";
	}
	
	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/admin")
	public String admin(Model model) {
		return "/admin";
	}
	
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/info")
	public String userInfo(Model model) {
		return "/user_info";
	}
	
	@RequestMapping(value="/denied")
	public String denied(Model model) {
		return "/denied";
	}
	
	
	
	
	
	
	
}
