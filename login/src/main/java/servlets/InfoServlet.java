package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import utils.JspConst;
import utils.UrlConst;

@WebServlet(name = "infoServlet", urlPatterns = {
		UrlConst.INFO
})
public class InfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		req.setAttribute("user", user);
		req.getRequestDispatcher(JspConst.INFO)
		.forward(req, resp);
	}
}
