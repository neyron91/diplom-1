package ru.diplom;

import java.util.concurrent.ConcurrentHashMap;
import ru.diplom.entity.Mouse;

/**
 *
 * @author User
 */
public class Data {

   private ConcurrentHashMap<Integer, Mouse> listMouse = new ConcurrentHashMap();

   public ConcurrentHashMap<Integer, Mouse> getListMouse() {
      return listMouse;
   }

   public void setListMouse(ConcurrentHashMap<Integer, Mouse> listMouse) {
      this.listMouse = listMouse;
   }

}
