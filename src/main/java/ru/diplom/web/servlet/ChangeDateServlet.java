package ru.diplom.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.diplom.Main;
import ru.diplom.entity.table.Table;

/**
 * Сервлет для обработки страниц, доступные из браузера
 *
 *
 */
@WebServlet(urlPatterns = {"/tables"})
public class ChangeDateServlet extends HttpServlet {

   public static final int TABLE_MOUSE = 1;

   public static final int OPERATION_VIEW = 1;
   public static final int OPERATION_ADD = 2;
   public static final int OPERATION_REMOVE = 3;

   public static final Logger logS = LogManager.getLogger(ChangeDateServlet.class.getName());

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      HashMap<Class, String> list = new HashMap();
//      list.put(MouseTable.class, "Мышки");
      request.setAttribute("tables", list);
      outputPage("tables.jsp", request, response);
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain; charset=utf-8");

      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/plain; charset=utf-8");

      Main main = (Main) request.getServletContext().getAttribute(Main.class.getName());
      String typeOperation = request.getParameter("type_operation");
      String table = request.getParameter("type_table");
      String html = null;

      if (!"null".equalsIgnoreCase(table)) {
         try {
            Class<? extends Table> cls = (Class<? extends Table>) Class.forName(table);
            Constructor<? extends Table> constructor = cls.getConstructor(Main.class);
            Table tableInst = constructor.newInstance(main);
            Method method = tableInst.getClass().getMethod(typeOperation, HttpServletRequest.class);
            html = (String) method.invoke(tableInst, response);
         } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangeDateServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NoSuchMethodException ex) {
            java.util.logging.Logger.getLogger(ChangeDateServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SecurityException ex) {
            java.util.logging.Logger.getLogger(ChangeDateServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeDateServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeDateServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalArgumentException ex) {
            java.util.logging.Logger.getLogger(ChangeDateServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InvocationTargetException ex) {
            java.util.logging.Logger.getLogger(ChangeDateServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
      } else {
         html = "";
      }

      PrintWriter out = response.getWriter();
      out.println(html);

   }

   public void outputPage(String namePage, HttpServletRequest aRequest, HttpServletResponse aResponse) throws IOException, ServletException {
      RequestDispatcher dispatcher = aRequest.getRequestDispatcher(namePage);
      dispatcher.forward(aRequest, aResponse);
   }
}
