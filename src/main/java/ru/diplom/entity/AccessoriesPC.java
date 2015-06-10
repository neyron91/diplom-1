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
public class AccessoriesPC {

   private int idMAC;
   private int idVideocard;
   private int idMotherboard;
   private int idHarddisk;
   private int idPowerSupply;
   private int idAccessMemory;
   private int idProcessor;
   private String BIOS;
   private String IPAddress;
   private String comment;

   public AccessoriesPC(int idMAC, int idVideocard, int idMotherboard, int idHarddisk, int idPowerSupply, int idAccessMemory, int idProcessor, String BIOS, String IPAddress, String comment) {
      this.idMAC = idMAC;
      this.idVideocard = idVideocard;
      this.idMotherboard = idMotherboard;
      this.idHarddisk = idHarddisk;
      this.idPowerSupply = idPowerSupply;
      this.idAccessMemory = idAccessMemory;
      this.idProcessor = idProcessor;
      this.BIOS = BIOS;
      this.IPAddress = IPAddress;
      this.comment = comment;
   }

   public int getIdMAC() {
      return idMAC;
   }

   public void setIdMAC(int idMAC) {
      this.idMAC = idMAC;
   }

   public int getIdVideocard() {
      return idVideocard;
   }

   public void setIdVideocard(int idVideocard) {
      this.idVideocard = idVideocard;
   }

   public int getIdMotherboard() {
      return idMotherboard;
   }

   public void setIdMotherboard(int idMotherboard) {
      this.idMotherboard = idMotherboard;
   }

   public int getIdHarddisk() {
      return idHarddisk;
   }

   public void setIdHarddisk(int idHarddisk) {
      this.idHarddisk = idHarddisk;
   }

   public int getIdPowerSupply() {
      return idPowerSupply;
   }

   public void setIdPowerSupply(int idPowerSupply) {
      this.idPowerSupply = idPowerSupply;
   }

   public int getIdAccessMemory() {
      return idAccessMemory;
   }

   public void setIdAccessMemory(int idAccessMemory) {
      this.idAccessMemory = idAccessMemory;
   }

   public int getIdProcessor() {
      return idProcessor;
   }

   public void setIdProcessor(int idProcessor) {
      this.idProcessor = idProcessor;
   }

   public String getBIOS() {
      return BIOS;
   }

   public void setBIOS(String BIOS) {
      this.BIOS = BIOS;
   }

   public String getIPAddress() {
      return IPAddress;
   }

   public void setIPAddress(String IPAddress) {
      this.IPAddress = IPAddress;
   }

   public String getComment() {
      return comment;
   }

   public void setComment(String comment) {
      this.comment = comment;
   }

}
