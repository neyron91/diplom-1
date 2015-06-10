package ru.diplom.entity.table;

import javax.servlet.http.HttpServletRequest;
import ru.diplom.Main;

/**
 *
 * @author User
 */
public abstract class TableController {

   protected Main main;

   public TableController(Main main) {
      this.main = main;
   }

   public abstract String view(HttpServletRequest request);

   public abstract String updateViewControl(HttpServletRequest request);

   public abstract String update(HttpServletRequest request);

   public abstract String add(HttpServletRequest request);

   public abstract String remove(HttpServletRequest request);

   protected int readInt(String param) {
      int value = -1;
      try {
         value = Integer.parseInt(param);
      } catch (Exception e) {

      }
      return value;
   }

   public String JQuery(String key, String id) {
      return key + ":$('#" + id + "').val()";
   }

}
