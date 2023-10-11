package com.example.servlets;

import com.example.daos.PointDao;
import com.example.models.Point;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkArea")
public class AreaCheckServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    processRequest(request, response);
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    try {
      double x = Double.parseDouble(request.getParameter("X"));
      double y = Double.parseDouble(request.getParameter("Y"));
      int r = Integer.parseInt(request.getParameter("R"));
      Point point = new Point(x, y, r);

      HttpSession session = request.getSession();
      PointDao bean = (PointDao) session.getAttribute("bean");
      if (bean == null) {
        bean = new PointDao();
        session.setAttribute("bean", bean);
      }
      bean.addPoint(point);

      response.getWriter().write(new Gson().toJson("true"));
    } catch (Exception e) {
      request.getRequestDispatcher("./index.jsp").forward(request, response);
    }
  }
}
