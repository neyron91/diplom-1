package ru.diplom.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.diplom.Main;
import ru.diplom.web.other.ReportSelect;

/**
 * Сервлет для обработки страниц, доступные из браузера
 *
 *
 */
@WebServlet(urlPatterns = {"/report"})
public class ReportServlet extends HttpServlet {

   public static final Logger logS = LogManager.getLogger(ReportServlet.class.getName());

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      HashMap<Integer, ReportSelect> list = new HashMap();
      list.put(1, new ReportSelect(1, "Отчет"));

      request.setAttribute("reports", list);
      outputPage("report.jsp", request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain; charset=utf-8");

      Main main = (Main) request.getServletContext().getAttribute(Main.class.getName());

      String typeStr = request.getParameter("type_report");
      int type = Integer.parseInt(typeStr);

      StringBuilder html = new StringBuilder();

      switch (type) {
         // Тут обрабатываем отчеты
         default:
      }

      PrintWriter out = response.getWriter();
      out.println(html.toString());

   }

   public void outputPage(String namePage, HttpServletRequest aRequest, HttpServletResponse aResponse) throws IOException, ServletException {
      RequestDispatcher dispatcher = aRequest.getRequestDispatcher(namePage);
      dispatcher.forward(aRequest, aResponse);
   }
}
