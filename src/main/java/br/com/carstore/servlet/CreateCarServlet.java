package br.com.carstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("car-name");
        String cor  = req.getParameter("car-color");

        String nomeJson = String.format("{\"nome\":\"%s\", \"cor\":\"%s\"}", nome, cor);

        System.out.println(nomeJson);

        PrintWriter out = resp.getWriter();

        out.println("<h1 style=\"margin-bottom:1em;\"> Json gerado </h1>");
        out.printf("<p style=\"margin-bottom:2em;\"> %s </p>", nomeJson);
        out.println("<a href=\"http://localhost:8080/\"> Gerar outro </a>");

        //req.getRequestDispatcher("index.html").forward(req,resp);
    }
}


