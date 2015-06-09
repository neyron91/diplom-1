package ru.diplom.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.diplom.Main;
import ru.diplom.entity.User;
import ru.diplom.web.other.ReportSelect;

/**
 * Сервлет для обработки страниц, доступные из браузера
 *
 *
 */
@WebServlet(urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {

   public static final Logger logS = LogManager.getLogger(MainServlet.class.getName());

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      HashMap<Integer, ReportSelect> list = new HashMap();

      request.setAttribute("reports", list);
      outputPage("report.jsp", request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain; charset=utf-8");

      String login = request.getParameter("login");
      String pass = request.getParameter("pass");

      Main main = (Main) request.getServletContext().getAttribute(Main.class.getName());
      ConcurrentHashMap<Integer, User> listUser = main.getData().getListUser();
      for (Iterator<User> iterator = listUser.values().iterator(); iterator.hasNext();) {
         User user = iterator.next();
         if (user.getLogin().equals(login) && user.getPassword().equals(pass)) {
            request.getSession().setAttribute("login", user.getLogin());
            request.getSession().setAttribute("auth", true);
            
            request.setAttribute("isAdmin", user.isAdmin());
            outputPage("main.jsp", request, response);
            return;
         }
      }

      request.setAttribute("msg", "Неверный логин или пароль");
      outputPage("index.jsp", request, response);
   }

   public void outputPage(String namePage, HttpServletRequest aRequest, HttpServletResponse aResponse) throws IOException, ServletException {
      RequestDispatcher dispatcher = aRequest.getRequestDispatcher(namePage);
      dispatcher.forward(aRequest, aResponse);
   }
}
