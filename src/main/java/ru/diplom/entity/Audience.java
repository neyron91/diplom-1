package ru.diplom.entity;

/**
 *
 * @author User
 */
public class Audience {

   private int idNum;
   private int idNumARM;
   private int idAssistent;
   private int housing;
   private int countARM;
   private int countPM;

   public Audience(int idNum, int idNumARM, int idAssistent, int housing, int countARM, int countPM) {
      this.idNum = idNum;
      this.idNumARM = idNumARM;
      this.idAssistent = idAssistent;
      this.housing = housing;
      this.countARM = countARM;
      this.countPM = countPM;
   }

   public int getIdNum() {
      return idNum;
   }

   public void setIdNum(int idNum) {
      this.idNum = idNum;
   }

   public int getIdNumARM() {
      return idNumARM;
   }

   public void setIdNumARM(int idNumARM) {
      this.idNumARM = idNumARM;
   }

   public int getIdAssistent() {
      return idAssistent;
   }

   public void setIdAssistent(int idAssistent) {
      this.idAssistent = idAssistent;
   }

   public int getHousing() {
      return housing;
   }

   public void setHousing(int housing) {
      this.housing = housing;
   }

   public int getCountARM() {
      return countARM;
   }

   public void setCountARM(int countARM) {
      this.countARM = countARM;
   }

   public int getCountPM() {
      return countPM;
   }

   public void setCountPM(int countPM) {
      this.countPM = countPM;
   }

}
