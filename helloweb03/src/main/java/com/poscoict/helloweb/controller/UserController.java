package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping : 클래스(타입) + 메서드(핸들러) 매핑
 * 
 */
@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
	
	/*
	 * 만일, n이라는 이름의 파라미터가 없는 경우
	 * 400 bad request에러가 발생한다.
	 */
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) {
		System.out.println(name);
		return "UserController.update()";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value="n", required=true, defaultValue="guest") String name, 
						  @RequestParam(value="a", required=true, defaultValue="0") Integer age) {
		System.out.println(name);
		System.out.println(age);
		return "UserController.update()";
	}
}


