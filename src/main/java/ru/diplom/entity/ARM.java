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
public class ARM {

   private int idNum;
   private int idSOFT;
   private int idPC;

   public ARM(int idNum, int idSOFT, int idPC) {
      this.idNum = idNum;
      this.idSOFT = idSOFT;
      this.idPC = idPC;
   }

   public int getIdNum() {
      return idNum;
   }

   public void setIdNum(int idNum) {
      this.idNum = idNum;
   }

   public int getIdSOFT() {
      return idSOFT;
   }

   public void setIdSOFT(int idSOFT) {
      this.idSOFT = idSOFT;
   }

   public int getIdPC() {
      return idPC;
   }

   public void setIdPC(int idPC) {
      this.idPC = idPC;
   }

}
