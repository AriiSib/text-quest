package com.khokhlov.servlet;

import com.khokhlov.consts.Consts;
import com.khokhlov.model.Answer;
import com.khokhlov.model.Data;
import com.khokhlov.model.Question;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

import static com.khokhlov.consts.Consts.QUESTION;
import static com.khokhlov.consts.Consts.QUESTION_JSP;
import static com.khokhlov.consts.Consts.RESULT_JSP;
import static com.khokhlov.consts.Consts.ANSWER_1;
import static com.khokhlov.consts.Consts.ANSWER_2;
import static com.khokhlov.consts.Consts.ANSWER_ID_1;
import static com.khokhlov.consts.Consts.ANSWER_ID_2;

@WebServlet(name = "questionServlet", value = QUESTION)
public class QuestionServlet extends HttpServlet {

    private Data data;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        this.data = (Data) context.getAttribute(Consts.DATA);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("question", data.questions.get(0).getQuestion());
        req.setAttribute(ANSWER_1, data.answers.get(0).getName());
        req.setAttribute(ANSWER_ID_1, data.questions.get(0).getAnswer().get(0));
        req.setAttribute(ANSWER_2, data.answers.get(1).getName());
        req.setAttribute(ANSWER_ID_2, data.questions.get(0).getAnswer().get(1));

        req.getRequestDispatcher(QUESTION_JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int answerId = Integer.parseInt(req.getParameter("answer"));
        Answer answer = getAnswerById(answerId);
        Question question = getNextQuestion(answer);

        req.setAttribute("question", question.getQuestion());

        if (!question.isFailed() && !question.isSuccess()) {
            int answerId_1 = question.getAnswer().get(0);
            int answerId_2 = question.getAnswer().get(1);

            req.setAttribute(ANSWER_1, getAnswerName(answerId_1));
            req.setAttribute(ANSWER_ID_1, question.getAnswer().get(0));
            req.setAttribute(ANSWER_2, getAnswerName(answerId_2));
            req.setAttribute(ANSWER_ID_2, question.getAnswer().get(1));

            req.getRequestDispatcher(QUESTION_JSP).forward(req, resp);
        } else {
            req.setAttribute("success", question.isSuccess());
            req.getRequestDispatcher(RESULT_JSP).forward(req, resp);
        }
    }

    private Question getNextQuestion(Answer answer) {
        return data.questions.stream().filter(x -> x.getId() == answer.getQuestion()).findFirst().orElse(null);
    }

    private Answer getAnswerById(int answerId) {
        return data.answers.stream().filter(a -> a.getId() == answerId).findFirst().orElse(null);
    }

    private String getAnswerName(int answerId) {
        return Objects.requireNonNull(getAnswerById(answerId)).
                getName();
    }
}