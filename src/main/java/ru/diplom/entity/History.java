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
public class History {

   private int idEvent;
   private int idNumARM;
   private int idElement;
   private String action;
   private String dateAction;

   public History(int idEvent, int idNumARM, int idElement, String action, String dateAction) {
      this.idEvent = idEvent;
      this.idNumARM = idNumARM;
      this.idElement = idElement;
      this.action = action;
      this.dateAction = dateAction;
   }

   public int getIdEvent() {
      return idEvent;
   }

   public void setIdEvent(int idEvent) {
      this.idEvent = idEvent;
   }

   public int getIdNumARM() {
      return idNumARM;
   }

   public void setIdNumARM(int idNumARM) {
      this.idNumARM = idNumARM;
   }

   public int getIdElement() {
      return idElement;
   }

   public void setIdElement(int idElement) {
      this.idElement = idElement;
   }

   public String getAction() {
      return action;
   }

   public void setAction(String action) {
      this.action = action;
   }

   public String getDateAction() {
      return dateAction;
   }

   public void setDateAction(String dateAction) {
      this.dateAction = dateAction;
   }

}
