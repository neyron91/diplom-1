package ru.diplom;

import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.diplom.db.ManagerDB;

/**
 *
 * @author dmitry
 */
public class Main {

   private final ManagerDB manager;
   private final Data data;

   public static final Logger log = LogManager.getLogger(Main.class.getName());

   public Main() {
      manager = new ManagerDB("jdbc/dbPool");
      manager.inic();
      this.data = new Data();
   }

   public ManagerDB getManager() {
      return manager;
   }

   public Data getData() {
      return data;
   }

   public void exit() {
      try {
         manager.getConnection().close();
      } catch (SQLException ex) {
         log.error("Ошибка", ex);
      }
   }

}
