package com.koreait.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.app.Result;

public class MemberFrontController extends HttpServlet{
	@Override // Get 방식
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override // Post 방식
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
//	↓  데이터 전송 방식에만 차이가 있을 뿐 처리 방법은 동일하게 설정
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		↓ 한글이 깨졌을 때
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html; charset=utf-8");
		
		String requestURI = req.getRequestURI(); // 사용자가 요청한 경로
		String contextPath = req.getContextPath(); // 루트 경로
		String request = requestURI.substring(contextPath.length()); // 사용자가 요청한 경로에서 루트의 길이만큼 제외시켜줌
		Result result = null;
		
		if(request.equals("/member/checkIdOk.me")) {
			new CheckIdOkController().execute(req, resp);
			
		}else if(request.equals("/member/join.me")) {
			result = new Result();
			result.setPath("/app/member/join.jsp");
			
		}else if(request.equals("/member/joinOk.me")) {
			result = new JoinOkController().execute(req, resp);
			
		}else if(request.equals("/member/login.me")) {
			result = new LoginController().execute(req, resp);
			
		}else if(request.equals("/member/loginOk.me")) {
			result = new LoginOkController().execute(req, resp);
			
		}else if(request.equals("/member/logout.me")) {
			result = new LogOutController().execute(req, resp);
			
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(result.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
















