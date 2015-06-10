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
public class Keyboard {

   private int id;
   private String name;
   private String manufactured;

   public Keyboard(int id, String name, String manufactured) {
      this.id = id;
      this.name = name;
      this.manufactured = manufactured;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getManufactured() {
      return manufactured;
   }

   public void setManufactured(String manufactured) {
      this.manufactured = manufactured;
   }

}
