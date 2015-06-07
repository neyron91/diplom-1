package ru.diplom.entity.table;

import javax.servlet.http.HttpServletRequest;
import ru.diplom.Main;

/**
 *
 * @author User
 */
public abstract class Table {

   protected Main main;

   public Table(Main main) {
      this.main = main;
   }

   public abstract String view(HttpServletRequest request);
   
   public abstract String update(HttpServletRequest request);

   public abstract String add(HttpServletRequest request);

   public abstract String remove(HttpServletRequest request);
}
