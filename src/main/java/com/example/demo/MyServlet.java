package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/*")
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writeLine(writer, "<pre>");
		writeLine(writer, "Server name "+req.getServerName());
		writeLine(writer, "Server info "+req.getServletContext().getServerInfo());
		writeLine(writer, "");
		writeLine(writer, "Request URI: " + req.getRequestURI());
		writeLine(writer, "Request URL: " + req.getRequestURL());
		writeLine(writer, "Request path info: " + req.getPathInfo());
		writeLine(writer, "Request path translated: " + req.getPathTranslated());
		writeLine(writer, "Request context path: " + req.getContextPath());
		writeLine(writer, "</pre>");
		resp.setContentType("text/html");
	}

	private void writeLine(PrintWriter writer, String string) {
		writer.write(string + "\n");
	}
}
