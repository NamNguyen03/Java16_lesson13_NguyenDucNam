package servlets;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import services.UserService;
import utils.JspConst;
import utils.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = {
		UrlConst.REGISTER,
		UrlConst.LOGIN
})
public class UserServlet extends HttpServlet {

	private UserService service;

	public UserServlet() {
		service = UserService.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch (req.getServletPath()) {
		case UrlConst.REGISTER:
			req.getRequestDispatcher(JspConst.REGISTER)
			.forward(req, resp);
			break;

		case UrlConst.LOGIN:
			req.getRequestDispatcher(JspConst.LOGIN)
			.forward(req, resp);
			break;

		default:
			break;
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		switch (req.getServletPath()) {
		case UrlConst.REGISTER:
			register(req, resp);
			break;

		case UrlConst.LOGIN:
			String email;
			String password;
			email = req.getParameter("email");
			password = req.getParameter("password");
			boolean flag = true;
			if(email == null || "".equals(email)) {
				flag = false;
				req.setAttribute("errEmail", "email not null");
			}else {
				Pattern patternEmail = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
				if(!patternEmail.matcher(email).matches()) {
					flag = false;
					req.setAttribute("errEmail", "email invalid");
				}
			}

			if( password.length() < 6) {
				flag = false;
				req.setAttribute("errPassword", "length password longer 6 character");
			}
			
			if(flag) {
				Optional<User> user = service.login(email, password);
				
				if(user.isEmpty()) {
					req.setAttribute("message", "email or password invalid");
					req.getRequestDispatcher(JspConst.LOGIN)
					.forward(req, resp);
				}else {
					HttpSession session = req.getSession(); 
					session.setAttribute("user", user.get());
					resp.sendRedirect(req.getContextPath() + UrlConst.HOME);
				}
				
			}else {
				req.getRequestDispatcher(UrlConst.LOGIN)
				.forward(req, resp);
			}
			
			break;

		default:
			break;
		}
		
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String email;
		String password;
		String fullname;
		String phone;
		String rpassword;
		boolean flag = true;

		email = req.getParameter("email");
		password = req.getParameter("password");
		fullname = req.getParameter("fullname");
		phone = req.getParameter("phone");
		rpassword = req.getParameter("rpassword");


		if(email == null || "".equals(email)) {
			flag = false;
			req.setAttribute("errEmail", "email not null");
		}else {
			Pattern patternEmail = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
			if(!patternEmail.matcher(email).matches()) {
				flag = false;
				req.setAttribute("errEmail", "email invalid");
			}
		}

		if( password.length() < 6) {
			flag = false;
			req.setAttribute("errPassword", "length password longer 6 character");
		}else {
			if(!password.equals(rpassword)) {
				flag = false;
				req.setAttribute("errRpassword", "repeat password not equals password");
			}
		}

		if(phone.length() < 8) {
			flag = false;
			req.setAttribute("errPhone", "phone password longer 8 character");
		}


		if(fullname == null || "".equals(fullname)) {
			flag = false;
			req.setAttribute("errFullname", "fullname not null");
		}

		if(flag) {
			User user = new User(email, password, fullname, phone);
			if( service.saveUser(user)) {
				resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
			}else {
				req.setAttribute("errEmail", "email exsist");
				req.getRequestDispatcher(JspConst.REGISTER)
				.forward(req, resp);
			}

		}else {
			req.getRequestDispatcher(JspConst.REGISTER)
			.forward(req, resp);
		}
	}


}
