// New => web전용 class인 'Servlet' 생성함 

package com.mirim.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControl
 */
@WebServlet("*.do")		// .do로 끝나는 모든 요청들을 이 controller가 잡아옴
public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControl() {
        super();  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("ActionDo 실행 완료!!");
		
		String uri = request.getRequestURI();
		System.out.println(uri);		// /ProJSP_frontController_test_0629/join.do <= context path가 포함됨
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String command = uri.substring(contextPath.length());	// 요청한 부분의 이름
		System.out.println(command);	
		
		if (command.equals("/join.do")) {	// 받은 요청별로 분기시킴
			System.out.println("회원가입");
			request.getParameter(command);
			
		}
		
		if (command.equals("/modify.do")) {	
			System.out.println("화원정보수정");
			
		}
		
		if (command.equals("/delete.do")) {	
			System.out.println("화원탈퇴");
			
		}
	}
}
