package com.jbedu.member.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jbedu.member.dao.MemberDao;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MemberController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="joinOk")
	public String joinOk(HttpServletRequest request, Model model ) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		int mage = Integer.parseInt( request.getParameter("mage"));
		
		MemberDao mdao = sqlSession.getMapper(MemberDao.class);
		
		mdao.joinMemberDao(mid, mpw, mname, memail, mage);
		
		model.addAttribute("mid", mid);
		
		return "joinOk";
	}
	
	
}
