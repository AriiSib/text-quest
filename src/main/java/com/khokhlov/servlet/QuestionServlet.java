package com.khokhlov.servlet;

import com.khokhlov.model.Answer;
import com.khokhlov.model.Data;
import com.khokhlov.model.Question;
import com.khokhlov.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "questionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Загрузить в листнер свой json и затем через инит обращаться к нему?
        QuestionService questionService = new QuestionService();

        Data data = questionService.readFromFile();
        if (req.getParameter("question") == null) {
            req.setAttribute("question", data.questions.get(0).getQuestion());
            req.setAttribute("answer_1", data.answers.get(0).getName());
            req.setAttribute("answerId_1", data.questions.get(0).getAnswer().get(0));
            req.setAttribute("answer_2", data.answers.get(1).getName());
            req.setAttribute("answerId_2", data.questions.get(0).getAnswer().get(1));

            req.getRequestDispatcher("/question.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionService questionService = new QuestionService();
        Data data = questionService.readFromFile();

        int answerId = Integer.parseInt(req.getParameter("answer"));
        Answer answer = data.answers.stream().filter(a -> a.getId() == answerId).findFirst().get();
        Question question = data.questions.stream().filter(x -> x.getId() == answer.getQuestion()).findFirst().get();

        req.setAttribute("question", question.getQuestion());

        if (!question.isFailed() && !question.isSuccess()) {
            int answerId_1 = question.getAnswer().get(0);
            int answerId_2 = question.getAnswer().get(1);

            req.setAttribute("answer_1", data.answers.stream().filter(x -> x.getId() == answerId_1).findFirst().get().getName());
            req.setAttribute("answerId_1", question.getAnswer().get(0));
            req.setAttribute("answer_2", data.answers.stream().filter(x -> x.getId() == answerId_2).findFirst().get().getName());
            req.setAttribute("answerId_2", question.getAnswer().get(1));

            req.getRequestDispatcher("/question.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
        }
    }
}
