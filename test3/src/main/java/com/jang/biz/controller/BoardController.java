package com.jang.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.jang.biz.board.BoardVO;
import com.jang.biz.board.impl.BoardDAO;

public class BoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bData", dao.selectOneBoard(vo));
		mav.setViewName("board"); // viewResolver를 통해 경로가 지정됨
		return mav;
	}

}
