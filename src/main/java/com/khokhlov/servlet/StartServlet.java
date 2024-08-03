package com.khokhlov.servlet;

import com.khokhlov.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.khokhlov.consts.Consts.START;
import static com.khokhlov.consts.Consts.QUESTION;
import static com.khokhlov.consts.Consts.INDEX_JSP;

@WebServlet(name = "StartServlet", value = START)
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(INDEX_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionIdFromForm = req.getParameter("sessionId");
        User user = (User) req.getSession().getAttribute("user");

        HttpSession session = req.getSession();

        if (session.getId().equals(sessionIdFromForm) && user != null) {
            session.setAttribute("attemptsCount", user.incrementGameCounter());
        } else {
            user = new User();
            user.setUserName(req.getParameter("username"));
            session.setAttribute("username", user.getUserName());
            session.setAttribute("attemptsCount", user.getGameCounter());
            session.setAttribute("user", user);
            session.setAttribute("sessionId", sessionIdFromForm);
        }

        resp.sendRedirect(req.getContextPath() + QUESTION);
    }
}