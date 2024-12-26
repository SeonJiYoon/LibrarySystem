package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = -7839115776527726264L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/registForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		
		String params = String.format("%s, %s, %s, %s ", id, password, name, tel);
		log.info("요청 받은 parameters : " + params);
		
		IMemberDao dao = new MemberDaoImpl();
		MemberDto dto = new MemberDto(name, id, password, tel, "Y");
		
		int row = dao.insertUser(dto);
		if(row == 1) {
			resp.sendRedirect("./");
		} else {
			resp.sendRedirect("./registServlet.do");
		}
				
	
	}
}
