package ru.diplom.entity;

/**
 *
 * @author User
 */
public class Mouse {
   
   private int id;
   private String manufacturer;
   private String name;

   public Mouse(int id, String manufacturer, String name) {
      this.id = id;
      this.manufacturer = manufacturer;
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getManufacturer() {
      return manufacturer;
   }

   public void setManufacturer(String manufacturer) {
      this.manufacturer = manufacturer;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}
