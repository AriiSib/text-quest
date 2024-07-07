package com.khokhlov.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khokhlov.consts.Consts;
import com.khokhlov.model.Data;
import com.khokhlov.service.QuestionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();

        QuestionService questionService = new QuestionService(new ObjectMapper());
        Data data = questionService.readFromFile();
        ctx.setAttribute(Consts.DATA, data);

        ServletContextListener.super.contextInitialized(sce);
    }
}
