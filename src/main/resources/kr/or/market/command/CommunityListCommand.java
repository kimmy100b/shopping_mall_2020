package kr.or.market.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.market.dao.CommunityDAO;
import kr.or.market.dto.CommunityDTO;

@WebServlet("/community")
public class CommunityListCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		CommunityDAO comDao = new CommunityDAO();
		List<CommunityDTO> comlist = comDao.getCommunity();
		
		req.setAttribute("comList", comlist);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("communityListView.jsp");
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException e) {
			System.out.println(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
