package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GameRecord;
import models.User;
import services.GameService;
import utils.JspConst;
import utils.UrlConst;

@WebServlet(name = "gamePlayServlet", urlPatterns = {
		UrlConst.GAME_PLAY
})
public class GamePlayServlet extends HttpServlet {

	private GameService gameService;

	public GamePlayServlet() {
		gameService = GameService.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");

		GameRecord gameRecord = gameService.findGameRecordNoFinnishByUser(user);

		req.setAttribute("gameRecord", gameRecord);
		req.setAttribute("suggest", gameRecord.getNumberCurrent() < gameRecord.getNumberTarget() ? "bigger" : "smaller");

		req.getRequestDispatcher(JspConst.GAME_PLAY)
		.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		int inputNumber = 0;
		try {
			inputNumber =  Integer.parseInt( req.getParameter("number"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		GameRecord gameRecord = gameService.setNumberCurrentWithUser(inputNumber, user);
		
		if(gameRecord.isFinished()) {
			req.setAttribute("gameRecord", gameRecord);
			req.getRequestDispatcher(JspConst.GAME_WIN)
			.forward(req, resp);
			
		}else {
			resp.sendRedirect(req.getContextPath() + UrlConst.GAME_PLAY);
		}
		
	}
}
