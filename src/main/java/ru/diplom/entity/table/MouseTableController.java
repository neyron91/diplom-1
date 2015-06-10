package ru.diplom.entity.table;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import ru.diplom.Main;
import ru.diplom.entity.Mouse;

/**
 *
 * @author User
 */
public class MouseTableController extends TableController {

   private enum Column {

      NAME("Наименование", "nam"),
      MANUFACTURER("Производитель", "manuf");

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
   public static final String ID_TEMPL = "mouse_";
   public static final String CLASS = MouseTableController.class.getName();

   public MouseTableController(Main data) {
      super(data);
   }

   private ConcurrentHashMap<Integer, Mouse> getData() {
      return main.getData().getListMouse();
   }

   @Override
   public String view(HttpServletRequest request) {
      StringBuilder newRow = new StringBuilder();

      String idName = ID_TEMPL + Column.NAME.getAlias();
      String idManuf = ID_TEMPL + Column.MANUFACTURER.getAlias();

      String data = Column.NAME.getAlias() + ":$('#" + idName + "').val()," + Column.MANUFACTURER.getAlias() + ":$('#" + idManuf + "').val()";
      String click = "sendCmd('" + CLASS + "','add', '" + PATH + "', {" + data + "});";

      newRow.append("<tr>")
              .append("<td style='padding-top: 20px;'><input id='").append(idName).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input id='").append(idManuf).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><button onclick=\"").append(click).append("\">Добавить</button></td>")
              .append("</tr>");

      StringBuilder html = new StringBuilder();
      ConcurrentHashMap<Integer, Mouse> listMouse = getData();
      html.append("<h2 style='text-align: center;'>Мышки</h2>")
              .append("<br>")
              .append("<div class='tables-content'>");

      if (listMouse.isEmpty()) {
         html.append("<center><font style='font-size: 16pt;margin: auto;'>Нет данных</font></center><br>");
      }

      html.append("<table id='data' style='width: 700px; margin: auto;'>")
              .append("<thead>")
              .append("<tr>")
              .append("<th>").append(Column.NAME.getName()).append("</th>")
              .append("<th>").append(Column.MANUFACTURER.getName()).append("</th>")
              .append("<th></th>")
              .append("</tr>")
              .append("</thead>")
              .append("<tbody>");

      for (Mouse mouse : listMouse.values()) {
         String id = ID_TEMPL + mouse.getId();

         String remove = "onclick=\"sendCmd('" + CLASS + "','remove', '" + PATH + "',{" + "id:" + mouse.getId() + "});\"";
         String modifi = "onclick=\"sendCmd('" + CLASS + "','updateViewControl', '" + PATH + "',{" + "id:" + mouse.getId() + "},function(html){$('#" + id + "').html(html)});\"";

         html.append("<tr id='").append(id).append("'>")
                 .append("<td>").append(mouse.getName()).append("</td>")
                 .append("<td>").append(mouse.getManufacturer()).append("</td>")
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
         Mouse mouse = getData().get(id);

         String idTmp = ID_TEMPL + id + "_";

         String idName = idTmp + Column.NAME.getAlias();
         String idManuf = idTmp + Column.MANUFACTURER.getAlias();

         String data = Column.NAME.getAlias() + ":$('#" + idName + "').val()," + Column.MANUFACTURER.getAlias() + ":$('#" + idManuf + "').val(), id:" + mouse.getId();
         String saveClick = "sendCmd('" + CLASS + "','update', '" + PATH + "', {" + data + "});";
         String cancelClick = "sendCmd('" + CLASS + "','view', '" + PATH + "');";

         newRow.append("<td><input id='").append(idName).append("' style='width: 100%' type='text' value='").append(mouse.getName()).append("'></td>")
                 .append("<td><input id='").append(idManuf).append("' style='width: 100%' value='").append(mouse.getManufacturer()).append("'></td>")
                 .append("<td><button onclick=\"").append(saveClick).append("\">Сохранить</button><button onclick=\"").append(cancelClick).append("\">Закрыть</button></td>");
      }
      return newRow.toString();
   }

   @Override
   public String update(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      String name = request.getParameter(Column.NAME.getAlias());
      String manuf = request.getParameter(Column.MANUFACTURER.getAlias());
      Mouse mouse = getData().get(id);
      if (mouse != null) {
         mouse.setName(name);
         mouse.setManufacturer(manuf);
      }
      return view(request);
   }

   @Override
   public String add(HttpServletRequest request) {
      String name = request.getParameter(Column.NAME.getAlias());
      String manuf = request.getParameter(Column.MANUFACTURER.getAlias());

      int maxId = 0;
      for (Map.Entry<Integer, Mouse> entrySet : getData().entrySet()) {
         int id = entrySet.getKey();
         if (id > maxId) {
            maxId = id;
         }
      }
      maxId++;
      getData().put(maxId, new Mouse(maxId, name, manuf));
      return view(request);
   }

   @Override
   public String remove(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      getData().remove(id);
      return view(request);
   }

}
