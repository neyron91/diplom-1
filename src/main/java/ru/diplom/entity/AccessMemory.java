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
public class AccessMemory {

   private int id;
   private String manugfacture;
   private String frequency;
   private String type;
   private String capacity;
   private int count;
   private String dateBuy;

   public AccessMemory(int id, String manugfacture, String frequency, String type, String capacity, int count, String dateBuy) {
      this.id = id;
      this.manugfacture = manugfacture;
      this.frequency = frequency;
      this.type = type;
      this.capacity = capacity;
      this.count = count;
      this.dateBuy = dateBuy;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getManugfacture() {
      return manugfacture;
   }

   public void setManugfacture(String manugfacture) {
      this.manugfacture = manugfacture;
   }

   public String getFrequency() {
      return frequency;
   }

   public void setFrequency(String frequency) {
      this.frequency = frequency;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getCapacity() {
      return capacity;
   }

   public void setCapacity(String capacity) {
      this.capacity = capacity;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public String getDateBuy() {
      return dateBuy;
   }

   public void setDateBuy(String dateBuy) {
      this.dateBuy = dateBuy;
   }

}
