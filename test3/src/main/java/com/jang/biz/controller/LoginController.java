package com.jang.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.jang.biz.member.MemberVO;
import com.jang.biz.member.impl.MemberDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그: LoginController클래스 handleRequest메서드 실행");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));

		vo = dao.selectOneMember(vo);

		ModelAndView mav = new ModelAndView();

		if(vo == null) { // 로그인 실패 시
			mav.setViewName("redirect:login.jsp"); //redirect: 를 붙이게 되면 sandRedirect방식
		}
		else { // 로그인 성공 시
			HttpSession session = request.getSession();
			session.setAttribute("member", vo);

			mav.setViewName("redirect:main.do");
		}
		return mav;
	}

}
