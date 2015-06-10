package ru.diplom.entity;

/**
 *
 * @author User
 */
public class Assistant {

   private int id;
   private String tel;
   private String name;

   public Assistant(int id, String tel, String name) {
      this.id = id;
      this.tel = tel;
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}
