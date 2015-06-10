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
public class PowerSupply {

   private int id;
   private String manufacture;
   private String model;
   private String power;
   private String dateBuy;

   public PowerSupply(int id, String manufacture, String model, String power, String dateBuy) {
      this.id = id;
      this.manufacture = manufacture;
      this.model = model;
      this.power = power;
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

   public String getPower() {
      return power;
   }

   public void setPower(String power) {
      this.power = power;
   }

   public String getDateBuy() {
      return dateBuy;
   }

   public void setDateBuy(String dateBuy) {
      this.dateBuy = dateBuy;
   }

}
