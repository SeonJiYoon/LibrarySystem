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

public class UserModifyServlet extends HttpServlet {

	private static final long serialVersionUID = -6872208137141236240L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("사용자 정보 수정화면 입력");
		IMemberDao dao = new MemberDaoImpl();
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		MemberDto info = dao.getUserInfo(String.valueOf(loginDto.getMember_id()));
		
		req.setAttribute("userInfo", info);
		req.getRequestDispatcher("/WEB-INF/views/modifyForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("사용자 정보 수정 입력");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/HTML; charset=UTF-8;");
		
		HttpSession session = req.getSession();
		MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
		
		String password = req.getParameter("password");
		String tel = req.getParameter("tel");
		
		log.info(String.format("%s, %s", password, tel));
		
		MemberDto inDto = new MemberDto().builder()
										 .password(password)
										 .tel(tel)
										 .member_id(loginDto.getMember_id())
										 .build();
		IMemberDao dao = new MemberDaoImpl();
		int cnt = dao.updateUserInfo(inDto);
		
		if(cnt == 1) {
			resp.sendRedirect("./userInfo.do");
		} else {
			resp.getWriter().print("<script>alert('정보를 수정하지 못했습니다. 다시 진행해 주세요'); location.href='./userModifyServlet.do'</script>");
		}
	}
}
