/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.diplom.entity.table;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import ru.diplom.Main;
import ru.diplom.entity.AccessMemory;

/**
 *
 * @author User
 */
public class AccessMemoryTableController extends TableController {

   private enum Column {

      MANUFACTURER("Производитель", "manuf"),
      FREQUENCY("Частота", "freq"),
      TYPE("Тип", "type"),
      CAPACITY("Объем", "capac"),
      COUNT("Кол-во", "count"),
      DATE_BUY("Дата закупки", "date_b");

      private final String name;
      private final String alias;

      private Column(String name, String alias) {
         this.name = name;
         this.alias = alias;
      }

      public String getName() {
         return name;
      }

      public String getAlias() {
         return alias;
      }
   }

   public static final String PATH = "/tables";
   public static final String ID_TEMPL = "access_memory_";
   public static final String CLASS = AccessMemoryTableController.class.getName();

   public AccessMemoryTableController(Main main) {
      super(main);
   }

   private ConcurrentHashMap<Integer, AccessMemory> getData() {
      return main.getData().getListAccessMemory();
   }

   @Override
   public String view(HttpServletRequest request) {
      StringBuilder newRow = new StringBuilder();

      String idManuf = ID_TEMPL + Column.MANUFACTURER.getAlias();
      String idFreq = ID_TEMPL + Column.FREQUENCY.getAlias();
      String idType = ID_TEMPL + Column.TYPE.getAlias();
      String idCapacity = ID_TEMPL + Column.CAPACITY.getAlias();
      String idCount = ID_TEMPL + Column.COUNT.getAlias();
      String idDateB = ID_TEMPL + Column.DATE_BUY.getAlias();

      String data
              = JQuery(Column.MANUFACTURER.getAlias(), idManuf) + ","
              + JQuery(Column.FREQUENCY.getAlias(), idFreq) + ","
              + JQuery(Column.TYPE.getAlias(), idType) + ","
              + JQuery(Column.CAPACITY.getAlias(), idCapacity) + ","
              + JQuery(Column.COUNT.getAlias(), idCount) + ","
              + JQuery(Column.DATE_BUY.getAlias(), idDateB);
      String click = "sendCmd('" + CLASS + "','add', '" + PATH + "', {" + data + "});";

      newRow.append("<tr>")
              .append("<td style='padding-top: 20px;'><input id='").append(idManuf).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input id='").append(idFreq).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input id='").append(idType).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input id='").append(idCapacity).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input id='").append(idCount).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input id='").append(idDateB).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><button onclick=\"").append(click).append("\">Добавить</button></td>")
              .append("</tr>");

      StringBuilder html = new StringBuilder();
      ConcurrentHashMap<Integer, AccessMemory> listAccessMemory = getData();
      html.append("<h2 style='text-align: center;'>Мышки</h2>")
              .append("<br>")
              .append("<div class='tables-content'>");

      if (listAccessMemory.isEmpty()) {
         html.append("<center><font style='font-size: 16pt;margin: auto;'>Нет данных</font></center><br>");
      }

      html.append("<table id='data' style='width: 700px; margin: auto;'>")
              .append("<thead>")
              .append("<tr>")
              .append("<th>").append(Column.MANUFACTURER.getName()).append("</th>")
              .append("<th>").append(Column.FREQUENCY.getName()).append("</th>")
              .append("<th>").append(Column.TYPE.getName()).append("</th>")
              .append("<th>").append(Column.CAPACITY.getName()).append("</th>")
              .append("<th>").append(Column.COUNT.getName()).append("</th>")
              .append("<th>").append(Column.DATE_BUY.getName()).append("</th>")
              .append("<th></th>")
              .append("</tr>")
              .append("</thead>")
              .append("<tbody>");

      for (AccessMemory accessMemory : listAccessMemory.values()) {
         String id = ID_TEMPL + accessMemory.getId();

         String remove = "onclick=\"sendCmd('" + CLASS + "','remove', '" + PATH + "',{" + "id:" + accessMemory.getId() + "});\"";
         String modifi = "onclick=\"sendCmd('" + CLASS + "','updateViewControl', '" + PATH + "',{" + "id:" + accessMemory.getId() + "},function(html){$('#" + id + "').html(html)});\"";

         html.append("<tr id='").append(id).append("'>")
                 .append("<td>").append(accessMemory.getManugfacture()).append("</td>")
                 .append("<td>").append(accessMemory.getFrequency()).append("</td>")
                 .append("<td>").append(accessMemory.getType()).append("</td>")
                 .append("<td>").append(accessMemory.getCapacity()).append("</td>")
                 .append("<td>").append(accessMemory.getCount()).append("</td>")
                 .append("<td>").append(accessMemory.getDateBuy()).append("</td>")
                 .append("<td>")
                 .append("<button ").append(modifi).append(">Ред..</button>")
                 .append("<button ").append(remove).append(">Удал..</button>")
                 .append("</td>")
                 .append("</tr>");
      }

      html.append(newRow);
      html.append("</tbody>");

      html.append("</table>");
      html.append("</div>");
      return html.toString();
   }

   @Override
   public String updateViewControl(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      StringBuilder newRow = new StringBuilder();
      if (id > -1) {
         AccessMemory accessMemory = getData().get(id);

         String idTmp = ID_TEMPL + id + "_";

         String idManuf = idTmp + Column.MANUFACTURER.getAlias();
         String idFreq = idTmp + Column.FREQUENCY.getAlias();
         String idType = idTmp + Column.TYPE.getAlias();
         String idCapacity = idTmp + Column.CAPACITY.getAlias();
         String idCount = idTmp + Column.COUNT.getAlias();
         String idDateB = idTmp + Column.DATE_BUY.getAlias();

         String data
                 = JQuery(Column.MANUFACTURER.getAlias(), idManuf) + ","
                 + JQuery(Column.FREQUENCY.getAlias(), idFreq) + ","
                 + JQuery(Column.TYPE.getAlias(), idType) + ","
                 + JQuery(Column.CAPACITY.getAlias(), idCapacity) + ","
                 + JQuery(Column.COUNT.getAlias(), idCount) + ","
                 + JQuery(Column.DATE_BUY.getAlias(), idDateB) + ","
                 + "id:" + accessMemory.getId();
         String saveClick = "sendCmd('" + CLASS + "','update', '" + PATH + "', {" + data + "});";
         String cancelClick = "sendCmd('" + CLASS + "','view', '" + PATH + "');";

         newRow.append("<td><input id='").append(idManuf).append("' style='width: 100%' type='text' value='").append(accessMemory.getManugfacture()).append("'></td>")
                 .append("<td><input id='").append(idFreq).append("' style='width: 100%' type='text' value='").append(accessMemory.getFrequency()).append("'></td>")
                 .append("<td><input id='").append(idType).append("' style='width: 100%' type='text' value='").append(accessMemory.getType()).append("'></td>")
                 .append("<td><input id='").append(idCapacity).append("' style='width: 100%' type='text' value='").append(accessMemory.getCapacity()).append("'></td>")
                 .append("<td><input id='").append(idCount).append("' style='width: 100%' type='text' value='").append(accessMemory.getCount()).append("'></td>")
                 .append("<td><input id='").append(idDateB).append("' style='width: 100%' type='text' value='").append(accessMemory.getDateBuy()).append("'></td>")
                 .append("<td><button onclick=\"").append(saveClick).append("\">Сохранить</button><button onclick=\"").append(cancelClick).append("\">Закрыть</button></td>");
      }
      return newRow.toString();
   }

   @Override
   public String update(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      String manuf = request.getParameter(Column.MANUFACTURER.getAlias());
      String freq = request.getParameter(Column.FREQUENCY.getAlias());
      String type = request.getParameter(Column.TYPE.getAlias());
      String capac = request.getParameter(Column.CAPACITY.getAlias());
      String count = request.getParameter(Column.COUNT.getAlias());
      String dateB = request.getParameter(Column.DATE_BUY.getAlias());
      AccessMemory accessMemory = getData().get(id);
      if (accessMemory != null) {
         accessMemory.setManugfacture(manuf);
         accessMemory.setFrequency(freq);
         accessMemory.setType(type);
         accessMemory.setCapacity(capac);
         accessMemory.setCount(Integer.parseInt(count));
         accessMemory.setDateBuy(dateB);
      }
      return view(request);
   }

   @Override
   public String add(HttpServletRequest request) {
      String manuf = request.getParameter(Column.MANUFACTURER.getAlias());
      String freq = request.getParameter(Column.FREQUENCY.getAlias());
      String type = request.getParameter(Column.TYPE.getAlias());
      String capac = request.getParameter(Column.CAPACITY.getAlias());
      String count = request.getParameter(Column.COUNT.getAlias());
      String dateB = request.getParameter(Column.DATE_BUY.getAlias());

      int maxId = 0;
      for (Map.Entry<Integer, AccessMemory> entrySet : getData().entrySet()) {
         int id = entrySet.getKey();
         if (id > maxId) {
            maxId = id;
         }
      }
      maxId++;
      getData().put(maxId, new AccessMemory(maxId, manuf, freq, type, capac, Integer.parseInt(count), dateB));
      return view(request);
   }

   @Override
   public String remove(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      getData().remove(id);
      return view(request);
   }

}