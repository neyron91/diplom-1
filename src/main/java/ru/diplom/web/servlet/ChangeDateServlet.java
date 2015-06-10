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
import ru.diplom.entity.table.ARMTableController;
import ru.diplom.entity.table.AccessMemoryTableController;
import ru.diplom.entity.table.AccessoriesPCTableController;
import ru.diplom.entity.table.AssistantTableController;
import ru.diplom.entity.table.AudienceTableController;
import ru.diplom.entity.table.HarddiskTableController;
import ru.diplom.entity.table.HistoryTableController;
import ru.diplom.entity.table.KeyboardTableController;
import ru.diplom.entity.table.MonitorTableController;
import ru.diplom.entity.table.MotherboardTableController;
import ru.diplom.entity.table.MouseTableController;
import ru.diplom.entity.table.PCTableController;
import ru.diplom.entity.table.PowerSupplyTableController;
import ru.diplom.entity.table.ProcessorTableController;
import ru.diplom.entity.table.ReferenceSoftTableController;
import ru.diplom.entity.table.SoftARMTableController;
import ru.diplom.entity.table.TableController;
import ru.diplom.entity.table.VideocardTableController;

/**
 * Сервлет для обработки страниц, доступные из браузера
 *
 *
 */
@WebServlet(urlPatterns = {"/tables"})
public class ChangeDateServlet extends HttpServlet {

   public static final Logger logS = LogManager.getLogger(ChangeDateServlet.class.getName());

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      HashMap<Class, String> list = new HashMap();
      list.put(MouseTableController.class, "Мышки");
      list.put(ARMTableController.class, "АРМ");
      list.put(AccessMemoryTableController.class, "Оперативная память");
      list.put(AccessoriesPCTableController.class, "Комплектующие");
      list.put(AssistantTableController.class, "Лаборант");
      list.put(AudienceTableController.class, "Аудитория");
      list.put(HarddiskTableController.class, "Жеские диски");
      list.put(HistoryTableController.class, "История");
      list.put(KeyboardTableController.class, "Клавиатуры");
      list.put(MonitorTableController.class, "Мониторы");
      list.put(PCTableController.class, "ПК");
      list.put(PowerSupplyTableController.class, "Блоки питания");
      list.put(ProcessorTableController.class, "Процессоры");
      list.put(ReferenceSoftTableController.class, "эталонное ПО");
      list.put(SoftARMTableController.class, "ПО АРМ");
      list.put(VideocardTableController.class, "Видеокарты");
      list.put(MotherboardTableController.class, "Материнские платы");
      request.setAttribute("tables", list);
      outputPage("tables.jsp", request, response);
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
