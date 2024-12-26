package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

public class UserInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 6777807851843178524L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserInfoServlet GET 사용자 상세 정보");
		
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		log.info("로그인 된 사용자의 session의 seq 값 : " + loginDto.getMember_id());
		
//		String testID = req.getParameter("member_id");
		
		IMemberDao dao = new MemberDaoImpl();
		MemberDto dto = dao.getUserInfo(String.valueOf(loginDto.getMember_id()));
		log.info("조회된 사용자 상세 정보 : " + dto);
		
		req.setAttribute("userInfo", dto);
		req.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(req, resp);
	
	}
}
