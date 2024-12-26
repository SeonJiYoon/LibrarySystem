package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3828164570372890792L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("GET 로그아웃");
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("./");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("POST 로그인");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8;");
		
		IMemberDao dao = new MemberDaoImpl();
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		log.info("전달받은 요청 값 : " + map);
		
		MemberDto loginDto = dao.getLogin(map);
		log.info("로그인된 사용자 정보 : " + loginDto);
		
		if(loginDto != null) {
			HttpSession session = req.getSession();
			session.setAttribute("loginDto", loginDto);
			session.setMaxInactiveInterval(20*60); // 20분동안 활동 없으면 자동으로 session 객체 삭제
			
			req.getRequestDispatcher("/WEB-INF/views/userMain.jsp").forward(req, resp);
		} else {
			resp.getWriter().print("<script>('회원이 존재하지 않습니다.'); location.href=('./')</script>");
		}
	}
	
	
}
