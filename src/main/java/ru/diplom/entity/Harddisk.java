/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.diplom.entity;

/**
 *
 * @author User
 */
public class Harddisk {

   private int id;
   private String manufacture;
   private String model;
   private String capacity;
   private String speedRead;
   private String speedWrite;
   private String dateBuy;

   public Harddisk(int id, String manufacture, String model, String capacity, String speedRead, String speedWrite, String dateBuy) {
      this.id = id;
      this.manufacture = manufacture;
      this.model = model;
      this.capacity = capacity;
      this.speedRead = speedRead;
      this.speedWrite = speedWrite;
      this.dateBuy = dateBuy;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getManufacture() {
      return manufacture;
   }

   public void setManufacture(String manufacture) {
      this.manufacture = manufacture;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getCapacity() {
      return capacity;
   }

   public void setCapacity(String capacity) {
      this.capacity = capacity;
   }

   public String getSpeedRead() {
      return speedRead;
   }

   public void setSpeedRead(String speedRead) {
      this.speedRead = speedRead;
   }

   public String getSpeedWrite() {
      return speedWrite;
   }

   public void setSpeedWrite(String speedWrite) {
      this.speedWrite = speedWrite;
   }

   public String getDateBuy() {
      return dateBuy;
   }

   public void setDateBuy(String dateBuy) {
      this.dateBuy = dateBuy;
   }

}
