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
public class Motherboard {

   private int id;
   private String manufacture;
   private String model;
   private String socket;
   private int countSlotMemory;
   private String systemBusFrequency;
   private int countUSB;
   private int dateBuy;

   public Motherboard(int id, String manufacture, String model, String socket, int countSlotMemory, String systemBusFrequency, int countUSB, int dateBuy) {
      this.id = id;
      this.manufacture = manufacture;
      this.model = model;
      this.socket = socket;
      this.countSlotMemory = countSlotMemory;
      this.systemBusFrequency = systemBusFrequency;
      this.countUSB = countUSB;
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

   public String getSocket() {
      return socket;
   }

   public void setSocket(String socket) {
      this.socket = socket;
   }

   public int getCountSlotMemory() {
      return countSlotMemory;
   }

   public void setCountSlotMemory(int countSlotMemory) {
      this.countSlotMemory = countSlotMemory;
   }

   public String getSystemBusFrequency() {
      return systemBusFrequency;
   }

   public void setSystemBusFrequency(String systemBusFrequency) {
      this.systemBusFrequency = systemBusFrequency;
   }

   public int getCountUSB() {
      return countUSB;
   }

   public void setCountUSB(int countUSB) {
      this.countUSB = countUSB;
   }

   public int getDateBuy() {
      return dateBuy;
   }

   public void setDateBuy(int dateBuy) {
      this.dateBuy = dateBuy;
   }

}
