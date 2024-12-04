package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
// MemberMapper mm = new MemberMapper()
	MemberMapper mm;
	
	
	//@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping(value = "/login")
	public String abc() {
		System.out.println("login");
		return "member/login";
	}
	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	@PostMapping(value = "/login")
	//public String def(@RequestParam String id,@RequestParam String password) {
	public String def(MemberDTO mdto) {
		
		// add(10)
		MemberDTO login = mm.login(mdto);
		System.out.println(login);
		if(login !=null) {	// 로그인을 해야 되는 대상
			// sesssion저장
			// main페이지로 이동
		}else {				// 로그인을 하면 안되는 대상
			// login페이지로 이동
		}
		
		return "member/login";
	}
}
