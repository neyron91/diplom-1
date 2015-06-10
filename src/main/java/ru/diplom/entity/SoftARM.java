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
public class SoftARM {

   private int id;
   private int idNumReferenceSoft;
   private String comment;
   private String dateInstall;

   public SoftARM(int id, int idNumReferenceSoft, String comment, String dateInstall) {
      this.id = id;
      this.idNumReferenceSoft = idNumReferenceSoft;
      this.comment = comment;
      this.dateInstall = dateInstall;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getIdNumReferenceSoft() {
      return idNumReferenceSoft;
   }

   public void setIdNumReferenceSoft(int idNumReferenceSoft) {
      this.idNumReferenceSoft = idNumReferenceSoft;
   }

   public String getComment() {
      return comment;
   }

   public void setComment(String comment) {
      this.comment = comment;
   }

   public String getDateInstall() {
      return dateInstall;
   }

   public void setDateInstall(String dateInstall) {
      this.dateInstall = dateInstall;
   }

}
