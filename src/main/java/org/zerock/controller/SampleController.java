package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.dto.SampleDTO;
import org.zerock.dto.SampleDTOList;
import org.zerock.dto.TodoDTO;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		System.out.println("" + dto);
		
		return "ex01";
	}
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		System.out.println("" + name);
		System.out.println("" + age);
		
		return "ex02";
	}
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		
		System.out.println("ids:" + ids);
		
		return "ex02List";
	}
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		
		System.out.println("ids:" + list);
		
		return "ex02Bean";
	}
	
//	@InitBinder
//	public void intiBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		System.out.println("todo : "+todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, RedirectAttributes rttr) {
		
		System.out.println("dto : "+dto);
		
		//model.addAttribute("abcd", dto);
		//rttr.addFlashAttribute("abcd", dto);
		rttr.addAttribute("name", dto.getName());
		rttr.addAttribute("age", dto.getAge());
		
		//return "/sample/ex04";// forward 방식으로 화면 이동
		return "redirect:/";// redirect 방식으로 화면 이동
		
	}
	//http://localhost:8080/sample/ex05 실행하면
	// WEB-INF/views/sample/ex05.jsp 실행됨.
	@GetMapping("/ex05")
	public void ex05(){
		
	}
	//http://localhost:8080/sample/ex06 실행하면
	// WEB-INF/views/ex06.jsp 실행됨.
//	@GetMapping("/ex06")
//	public String ex06(){
//		return "ex06";	// forward 방식 화면 이동
//		//return "redirect:/ex06";	// redirect 방식 화면 이동
//	}
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;
	}
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		String msg="{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		
		//header.add("Content-Type", "text/plain");
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	@GetMapping("/exUpload")
	public void exUpload() {
		System.out.println("/exUpload.......");
	}
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		for(MultipartFile file : files) {
			System.out.println("------------------------");
			System.out.println("name:" + file.getOriginalFilename());
			System.out.println("size:" + file.getSize());
		}
//		files.forEach(file->{
//			System.out.println(file.getOriginalFilename());
//			System.out.println(file.getSize());	
//		});
	}
}


