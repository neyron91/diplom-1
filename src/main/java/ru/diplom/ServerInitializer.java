package ru.diplom;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.diplom.entity.User;

/**
 * Запуск приложения
 *
 * @author dmitry
 */
@WebListener
public class ServerInitializer implements ServletContextListener {

   public static final Logger log = LogManager.getLogger(ServerInitializer.class.getName());

   @Override
   public void contextInitialized(ServletContextEvent sce) {
      log.trace("НАЧАЛО");
      ServletContext context = sce.getServletContext();

      Main main = new Main();
      context.setAttribute(Main.class.getName(), main);
      
      main.getData().getListUser().put(0, new User(0, "test", "test", false));
      main.getData().getListUser().put(1, new User(1, "admin", "admin", true));
      
      log.trace("Иницализация приложения завершена");
   }

   @Override
   public void contextDestroyed(ServletContextEvent sce) {
      Main main = (Main) sce.getServletContext().getAttribute(Main.class.getName());
      if (main != null) {
         main.exit();
      }
   }

}
