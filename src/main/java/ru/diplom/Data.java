package ru.diplom;

import java.util.concurrent.ConcurrentHashMap;
import ru.diplom.entity.Mouse;
import ru.diplom.entity.User;

/**
 *
 * @author User
 */
public class Data {

   private ConcurrentHashMap<Integer, Mouse> listMouse = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, User> listUser = new ConcurrentHashMap();

   public ConcurrentHashMap<Integer, Mouse> getListMouse() {
      return listMouse;
   }

   public void setListMouse(ConcurrentHashMap<Integer, Mouse> listMouse) {
      this.listMouse = listMouse;
   }

   public ConcurrentHashMap<Integer, User> getListUser() {
      return listUser;
   }

}
