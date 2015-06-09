package ru.diplom.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import ru.diplom.entity.table.TableController;

/**
 * Сервлет для обработки страниц, доступные из браузера
 *
 *
 */
@WebServlet(urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

   public static final int OPERATION_VIEW = 1;
   public static final int OPERATION_ADD = 2;
   public static final int OPERATION_REMOVE = 3;

   public static final Logger logS = LogManager.getLogger(AdminServlet.class.getName());

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      outputPage("admin.jsp", request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain; charset=utf-8");

      Main main = (Main) request.getServletContext().getAttribute(Main.class.getName());
      String table = request.getParameter("type_table");             // Класс
      String typeOperation = request.getParameter("type_operation"); // Метод
      String html = "Ошибка";

      if (table != null) {
         try {
            Class<? extends TableController> cls = (Class<? extends TableController>) Class.forName(table);
            Constructor<? extends TableController> constructor = cls.getConstructor(Main.class);
            TableController tableInst = constructor.newInstance(main);
            Method method = tableInst.getClass().getMethod(typeOperation, HttpServletRequest.class);
            html = (String) method.invoke(tableInst, request);
         } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            logS.error("Ошибка во время работы с классом", ex);
         }
      }

      PrintWriter out = response.getWriter();
      out.println(html);
   }

   public void outputPage(String namePage, HttpServletRequest aRequest, HttpServletResponse aResponse) throws IOException, ServletException {
      RequestDispatcher dispatcher = aRequest.getRequestDispatcher(namePage);
      dispatcher.forward(aRequest, aResponse);
   }
}
