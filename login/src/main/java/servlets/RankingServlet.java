package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GameRecord;
import services.GameService;
import utils.JspConst;
import utils.UrlConst;

@WebServlet(name = "rankingServlet", urlPatterns = {
		UrlConst.RANKING
})
public class RankingServlet extends HttpServlet  {

	private GameService gameService;

	public RankingServlet() {
		gameService = GameService.init();
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<GameRecord> gameRecords = gameService.getRank();
		
		req.setAttribute("ranks", gameRecords);
		
		req.getRequestDispatcher(JspConst.RANKING).forward(req, resp);
	}
	
}
