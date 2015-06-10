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
public class Monitor {

   private int id;
   private String resolution;
   private String diagonal;
   private String manufactured;
   private String numInventory;
   private String name;
   private String dateDelivery;
   private String dateAcceptance;
   private String coast;
   private String comment;

   public Monitor(int id, String resolution, String diagonal, String manufactured, String numInventory, String name, String dateDelivery, String dateAcceptance, String coast, String comment) {
      this.id = id;
      this.resolution = resolution;
      this.diagonal = diagonal;
      this.manufactured = manufactured;
      this.numInventory = numInventory;
      this.name = name;
      this.dateDelivery = dateDelivery;
      this.dateAcceptance = dateAcceptance;
      this.coast = coast;
      this.comment = comment;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getResolution() {
      return resolution;
   }

   public void setResolution(String resolution) {
      this.resolution = resolution;
   }

   public String getDiagonal() {
      return diagonal;
   }

   public void setDiagonal(String diagonal) {
      this.diagonal = diagonal;
   }

   public String getManufactured() {
      return manufactured;
   }

   public void setManufactured(String manufactured) {
      this.manufactured = manufactured;
   }

   public String getNumInventory() {
      return numInventory;
   }

   public void setNumInventory(String numInventory) {
      this.numInventory = numInventory;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDateDelivery() {
      return dateDelivery;
   }

   public void setDateDelivery(String dateDelivery) {
      this.dateDelivery = dateDelivery;
   }

   public String getDateAcceptance() {
      return dateAcceptance;
   }

   public void setDateAcceptance(String dateAcceptance) {
      this.dateAcceptance = dateAcceptance;
   }

   public String getCoast() {
      return coast;
   }

   public void setCoast(String coast) {
      this.coast = coast;
   }

   public String getComment() {
      return comment;
   }

   public void setComment(String comment) {
      this.comment = comment;
   }

}
