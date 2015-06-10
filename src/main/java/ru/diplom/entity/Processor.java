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
public class Processor {

   private int id;
   private String manufacture;
   private String frequency;
   private String name;
   private String coast;
   private String dateBuy;

   public Processor(int id, String manufacture, String frequency, String name, String coast, String dateBuy) {
      this.id = id;
      this.manufacture = manufacture;
      this.frequency = frequency;
      this.name = name;
      this.coast = coast;
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

   public String getFrequency() {
      return frequency;
   }

   public void setFrequency(String frequency) {
      this.frequency = frequency;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCoast() {
      return coast;
   }

   public void setCoast(String coast) {
      this.coast = coast;
   }

   public String getDateBuy() {
      return dateBuy;
   }

   public void setDateBuy(String dateBuy) {
      this.dateBuy = dateBuy;
   }

}
