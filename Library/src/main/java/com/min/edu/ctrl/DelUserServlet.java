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

public class DelUserServlet extends HttpServlet {

	private static final long serialVersionUID = 2686802384167383673L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberDto loginDto = (MemberDto)req.getSession().getAttribute("loginDto");
		req.getSession().invalidate();
		
		IMemberDao dao = new MemberDaoImpl();
		int row = dao.delUser(String.valueOf(loginDto.getMember_id()));
		
		if(row == 1) {
			resp.sendRedirect("./");
		}else {
			req.getRequestDispatcher("/WEB-INF/views/err/error.html").forward(req, resp);
		}
		
	}
}
