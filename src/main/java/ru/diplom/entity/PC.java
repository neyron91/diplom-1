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
public class PC {

   private int id;
   private int idMouse;
   private int idKeyboard;
   private int idMonitor;
   private int idMAC;
   private String numInventory;

   public PC(int id, int idMouse, int idKeyboard, int idMonitor, int idMAC, String numInventory) {
      this.id = id;
      this.idMouse = idMouse;
      this.idKeyboard = idKeyboard;
      this.idMonitor = idMonitor;
      this.idMAC = idMAC;
      this.numInventory = numInventory;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getIdMouse() {
      return idMouse;
   }

   public void setIdMouse(int idMouse) {
      this.idMouse = idMouse;
   }

   public int getIdKeyboard() {
      return idKeyboard;
   }

   public void setIdKeyboard(int idKeyboard) {
      this.idKeyboard = idKeyboard;
   }

   public int getIdMonitor() {
      return idMonitor;
   }

   public void setIdMonitor(int idMonitor) {
      this.idMonitor = idMonitor;
   }

   public int getIdMAC() {
      return idMAC;
   }

   public void setIdMAC(int idMAC) {
      this.idMAC = idMAC;
   }

   public String getNumInventory() {
      return numInventory;
   }

   public void setNumInventory(String numInventory) {
      this.numInventory = numInventory;
   }

}
