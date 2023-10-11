package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    processRequest(request, response);
  }

  public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    final var INVALID_DATA_MSG = "Please set the data values in correct form.";

    try {
      if (
        request.getParameter("R") == null
          || request.getParameter("X") == null
          || request.getParameter("Y") == null
      ) {
        sendError(response, INVALID_DATA_MSG);
        return;
      }
      if (
        request.getParameter("R").isEmpty()
          || request.getParameter("X").isEmpty()
          || request.getParameter("Y").isEmpty()
      ) {
        sendError(response, INVALID_DATA_MSG);
        return;
      }
      if (
        Double.parseDouble(request.getParameter("Y")) < -3
          || Double.parseDouble(request.getParameter("Y")) > 5
      ) {
        sendError(response, INVALID_DATA_MSG);
        return;
      }

      response.sendRedirect("./checkArea?" + request.getQueryString());
    } catch (Exception e) {
      sendError(response, e.toString());
    }
  }

  private void sendError(HttpServletResponse response, String errorMessage) throws IOException {
    var json = new Gson();
    Map<String, Object> jsonResponse = new HashMap<>() {{
      put("error", errorMessage);
      put("status", "UNPROCESSABLE_ENTITY");
    }};

    response.setContentType("application/json");
    response.getWriter().write(json.toJson(jsonResponse));
    response.setStatus(422);
  }
}
