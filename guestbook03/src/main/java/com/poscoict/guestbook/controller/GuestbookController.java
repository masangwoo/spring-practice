package com.poscoict.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscoict.guestbook.repository.GuestbookRepository;
import com.poscoict.guestbook.vo.GuestbookVo;


@Controller
public class GuestbookController {
	@Autowired
	private GuestbookRepository guestbookRepository;

	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list",list);	
		return "/WEB-INF/views/index.jsp";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	/*public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}*/
	

	@RequestMapping(value = "/deleteform", method = RequestMethod.GET)
	public String deleteform(Integer no, Model model) {
		System.out.println(no);
		
		//no = 21;
		model.addAttribute("no", no);
		//no = 20;
		
		return "/WEB-INF/views/deleteform.jsp";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(GuestbookVo vo) {
		System.out.println(vo.getNo());
		guestbookRepository.delete(vo);
		return "redirect:/";
	}

}