package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

public class AuthUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = -7694153740009520123L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String member_id = req.getParameter("member_id");
		
		IMemberDao dao = new MemberDaoImpl();
		MemberDto dto = dao.getUserInfo(member_id);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/authUpdateForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String member_id = req.getParameter("member_id");
		String auth = req.getParameter("role");
		
		IMemberDao dao = new MemberDaoImpl();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", member_id);
		map.put("auth", auth);
		
		int row = dao.updateAuthUser(map);
		
		if(row == 1) {
			resp.sendRedirect("./userListServlet.do");
		} else {
			resp.sendRedirect("./userListServlet.do");
		}
	}
}
