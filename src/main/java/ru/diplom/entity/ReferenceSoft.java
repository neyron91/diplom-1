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
public class ReferenceSoft {

   private int idNum;
   private String version;
   private String name;
   private String manufacture;
   private String type;
   private String coast;
   private String numLicence;
   private String dateRegistered;

   public ReferenceSoft(int idNum, String version, String name, String manufacture, String type, String coast, String numLicence, String dateRegistered) {
      this.idNum = idNum;
      this.version = version;
      this.name = name;
      this.manufacture = manufacture;
      this.type = type;
      this.coast = coast;
      this.numLicence = numLicence;
      this.dateRegistered = dateRegistered;
   }

   public int getIdNum() {
      return idNum;
   }

   public void setIdNum(int idNum) {
      this.idNum = idNum;
   }

   public String getVersion() {
      return version;
   }

   public void setVersion(String version) {
      this.version = version;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getManufacture() {
      return manufacture;
   }

   public void setManufacture(String manufacture) {
      this.manufacture = manufacture;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getCoast() {
      return coast;
   }

   public void setCoast(String coast) {
      this.coast = coast;
   }

   public String getNumLicence() {
      return numLicence;
   }

   public void setNumLicence(String numLicence) {
      this.numLicence = numLicence;
   }

   public String getDateRegistered() {
      return dateRegistered;
   }

   public void setDateRegistered(String dateRegistered) {
      this.dateRegistered = dateRegistered;
   }

}
