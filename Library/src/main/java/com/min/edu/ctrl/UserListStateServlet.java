package com.min.edu.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

public class UserListStateServlet extends HttpServlet {

	private static final long serialVersionUID = 2944384636462403819L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		IMemberDao dao = new MemberDaoImpl();
		List<MemberDto> lists = dao.getAllUserStatus();
		
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/userListStatus.jsp").forward(req, resp);
	
	}
}
