package com.jang.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.jang.biz.member.MemberVO;
import com.jang.biz.member.impl.MemberDAO;

public class SignUpController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo.setName(request.getParameter("name"));
		vo.setRole(request.getParameter("role"));
		
		dao.insertMember(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}

}
