package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

public class DuplicateServlet extends HttpServlet {

	private static final long serialVersionUID = 1738503178630638547L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		IMemberDao dao = new MemberDaoImpl();
		String checkId = dao.duplicateId(id);
		
		boolean isc = false;
		
		if(checkId == null) {
			isc = true; // 사용할 수 있는 아이디
		}
		
		req.setAttribute("isc", isc);
		req.getRequestDispatcher("/WEB-INF/views/idCheck.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	
}
