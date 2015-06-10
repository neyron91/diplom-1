package ru.diplom;

import java.util.concurrent.ConcurrentHashMap;
import ru.diplom.entity.ARM;
import ru.diplom.entity.AccessMemory;
import ru.diplom.entity.AccessoriesPC;
import ru.diplom.entity.Assistant;
import ru.diplom.entity.Audience;
import ru.diplom.entity.Harddisk;
import ru.diplom.entity.History;
import ru.diplom.entity.Keyboard;
import ru.diplom.entity.Monitor;
import ru.diplom.entity.Motherboard;
import ru.diplom.entity.Mouse;
import ru.diplom.entity.PC;
import ru.diplom.entity.PowerSupply;
import ru.diplom.entity.Processor;
import ru.diplom.entity.ReferenceSoft;
import ru.diplom.entity.SoftARM;
import ru.diplom.entity.User;
import ru.diplom.entity.Videocard;

/**
 *
 * @author User
 */
public class Data {

   private ConcurrentHashMap<Integer, Mouse> listMouse = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, User> listUser = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, ARM> listARM = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, AccessMemory> listAccessMemory = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, AccessoriesPC> listAccessoriesPC = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, Assistant> listAssistant = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, Audience> listAudience = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, Harddisk> listHarddisk = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, History> listHistory = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, Keyboard> listKeyboard = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, Monitor> listMonitor = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, Motherboard> listMotherboard = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, PC> listPC = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, PowerSupply> listPowerSupply = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, Processor> listProcessor = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, ReferenceSoft> listReferenceSoft = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, SoftARM> listSoftARM = new ConcurrentHashMap();
   private ConcurrentHashMap<Integer, Videocard> listVideocard = new ConcurrentHashMap();

   public ConcurrentHashMap<Integer, Mouse> getListMouse() {
      return listMouse;
   }

   public ConcurrentHashMap<Integer, User> getListUser() {
      return listUser;
   }

   public ConcurrentHashMap<Integer, ARM> getListARM() {
      return listARM;
   }

   public ConcurrentHashMap<Integer, AccessMemory> getListAccessMemory() {
      return listAccessMemory;
   }

   public ConcurrentHashMap<Integer, AccessoriesPC> getListAccessoriesPC() {
      return listAccessoriesPC;
   }

   public ConcurrentHashMap<Integer, Assistant> getListAssistant() {
      return listAssistant;
   }

   public ConcurrentHashMap<Integer, Audience> getListAudience() {
      return listAudience;
   }

   public ConcurrentHashMap<Integer, Harddisk> getListHarddisk() {
      return listHarddisk;
   }

   public ConcurrentHashMap<Integer, History> getListHistory() {
      return listHistory;
   }

   public ConcurrentHashMap<Integer, Keyboard> getListKeyboard() {
      return listKeyboard;
   }

   public ConcurrentHashMap<Integer, Monitor> getListMonitor() {
      return listMonitor;
   }

   public ConcurrentHashMap<Integer, Motherboard> getListMotherboard() {
      return listMotherboard;
   }

   public ConcurrentHashMap<Integer, PC> getListPC() {
      return listPC;
   }

   public ConcurrentHashMap<Integer, PowerSupply> getListPowerSupply() {
      return listPowerSupply;
   }

   public ConcurrentHashMap<Integer, Processor> getListProcessor() {
      return listProcessor;
   }

   public ConcurrentHashMap<Integer, ReferenceSoft> getListReferenceSoft() {
      return listReferenceSoft;
   }

   public ConcurrentHashMap<Integer, SoftARM> getListSoftARM() {
      return listSoftARM;
   }

   public ConcurrentHashMap<Integer, Videocard> getListVideocard() {
      return listVideocard;
   }

}
