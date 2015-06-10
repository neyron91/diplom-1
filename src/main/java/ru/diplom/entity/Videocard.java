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
public class Videocard {

   private int id;
   private String capacityMemory;
   private String bitBus;
   private String manufacture;
   private String name;
   private String dateBuy;

   public Videocard(int id, String capacityMemory, String bitBus, String manufacture, String name, String dateBuy) {
      this.id = id;
      this.capacityMemory = capacityMemory;
      this.bitBus = bitBus;
      this.manufacture = manufacture;
      this.name = name;
      this.dateBuy = dateBuy;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getCapacityMemory() {
      return capacityMemory;
   }

   public void setCapacityMemory(String capacityMemory) {
      this.capacityMemory = capacityMemory;
   }

   public String getBitBus() {
      return bitBus;
   }

   public void setBitBus(String bitBus) {
      this.bitBus = bitBus;
   }

   public String getManufacture() {
      return manufacture;
   }

   public void setManufacture(String manufacture) {
      this.manufacture = manufacture;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDateBuy() {
      return dateBuy;
   }

   public void setDateBuy(String dateBuy) {
      this.dateBuy = dateBuy;
   }

}
