package com.min.edu.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.MemberDto;

public class AccessFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = -5546043096359317691L;
	private List<String> excludeURL;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		String excludePattern = config.getInitParameter("excludeURL");
		excludeURL = Arrays.asList(excludePattern.split(","));
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		String pathURL = request.getServletPath();
		
		if(!excludeURL.contains(pathURL)) {
			// 로그인 상태 확인
			HttpSession session = request.getSession();
			MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");
			if(loginDto == null) {
				request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, res);
			} else {
				chain.doFilter(req, res);
			}
		} else {
			req.setCharacterEncoding("UTF-8");
			chain.doFilter(req, res);
		}
	}

}
