package com.jang.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.jang.biz.board.BoardVO;
import com.jang.biz.board.impl.BoardDAO;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bDatas", dao.selectAllBoard(vo));
		// 다음 new ModelAndView까지 이 정보가 유지 된다 (jsp내장객체 출신이 아님 그냥 자바 객체)
		mav.setViewName("main"); // viewResolver를 통해 경로가 지정됨
		return mav;
	}

}
