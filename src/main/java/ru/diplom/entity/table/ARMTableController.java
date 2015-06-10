package ru.diplom.entity.table;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import ru.diplom.Main;
import ru.diplom.entity.ARM;

/**
 *
 * @author User
 */
public class ARMTableController extends TableController {

   private enum Column {

      ID_PO("ID ПО", "id_po"),
      ID_PC("ID ПК", "id_pc");

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
   public static final String ID_TEMPL = "arm_";
   public static final String CLASS = ARMTableController.class.getName();

   public ARMTableController(Main main) {
      super(main);
   }

   private ConcurrentHashMap<Integer, ARM> getData() {
      return main.getData().getListARM();
   }

   @Override
   public String view(HttpServletRequest request) {
      StringBuilder newRow = new StringBuilder();

      String idPO = ID_TEMPL + Column.ID_PO.getAlias();
      String idPC = ID_TEMPL + Column.ID_PC.getAlias();

      String data = Column.ID_PO.getAlias() + ":$('#" + idPO + "').val()," + Column.ID_PC.getAlias() + ":$('#" + idPC + "').val()";
      String click = "sendCmd('" + CLASS + "','add', '" + PATH + "', {" + data + "});";

      newRow.append("<tr>")
              .append("<td style='padding-top: 20px;'><input id='").append(idPO).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input id='").append(idPC).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><button onclick=\"").append(click).append("\">Добавить</button></td>")
              .append("</tr>");

      StringBuilder html = new StringBuilder();
      ConcurrentHashMap<Integer, ARM> listARM = getData();
      html.append("<h2 style='text-align: center;'>Мышки</h2>")
              .append("<br>")
              .append("<div class='tables-content'>");

      if (listARM.isEmpty()) {
         html.append("<center><font style='font-size: 16pt;margin: auto;'>Нет данных</font></center><br>");
      }

      html.append("<table id='data' style='width: 700px; margin: auto;'>")
              .append("<thead>")
              .append("<tr>")
              .append("<th>").append(Column.ID_PO.getName()).append("</th>")
              .append("<th>").append(Column.ID_PC.getName()).append("</th>")
              .append("<th></th>")
              .append("</tr>")
              .append("</thead>")
              .append("<tbody>");

      for (ARM arm : listARM.values()) {
         String id = ID_TEMPL + arm.getIdNum();

         String remove = "onclick=\"sendCmd('" + CLASS + "','remove', '" + PATH + "',{" + "id:" + arm.getIdNum() + "});\"";
         String modifi = "onclick=\"sendCmd('" + CLASS + "','updateViewControl', '" + PATH + "',{" + "id:" + arm.getIdNum() + "},function(html){$('#" + id + "').html(html)});\"";

         html.append("<tr id='").append(id).append("'>")
                 .append("<td>").append(arm.getIdSOFT()).append("</td>")
                 .append("<td>").append(arm.getIdPC()).append("</td>")
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
         ARM arm = getData().get(id);

         String idTmp = ID_TEMPL + id + "_";

         String idPO = idTmp + Column.ID_PO.getAlias();
         String idPC = idTmp + Column.ID_PC.getAlias();

         String data = Column.ID_PO.getAlias() + ":$('#" + idPO + "').val()," + Column.ID_PC.getAlias() + ":$('#" + idPC + "').val(), id:" + arm.getIdNum();
         String saveClick = "sendCmd('" + CLASS + "','update', '" + PATH + "', {" + data + "});";
         String cancelClick = "sendCmd('" + CLASS + "','view', '" + PATH + "');";

         newRow.append("<td><input id='").append(idPO).append("' style='width: 100%' type='text' value='").append(arm.getIdSOFT()).append("'></td>")
                 .append("<td><input id='").append(idPC).append("' style='width: 100%' value='").append(arm.getIdPC()).append("'></td>")
                 .append("<td><button onclick=\"").append(saveClick).append("\">Сохранить</button><button onclick=\"").append(cancelClick).append("\">Закрыть</button></td>");
      }
      return newRow.toString();
   }

   @Override
   public String update(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      String idPO = request.getParameter(Column.ID_PO.getAlias());
      String idPC = request.getParameter(Column.ID_PC.getAlias());
      ARM arm = getData().get(id);
      if (arm != null) {
         arm.setIdSOFT(Integer.parseInt(idPO));
         arm.setIdPC(Integer.parseInt(idPC));
      }
      return view(request);
   }

   @Override
   public String add(HttpServletRequest request) {
      String idPO = request.getParameter(Column.ID_PO.getAlias());
      String idPC = request.getParameter(Column.ID_PC.getAlias());

      int maxId = 0;
      for (Map.Entry<Integer, ARM> entrySet : getData().entrySet()) {
         int id = entrySet.getKey();
         if (id > maxId) {
            maxId = id;
         }
      }
      maxId++;
      getData().put(maxId, new ARM(maxId, Integer.parseInt(idPO), Integer.parseInt(idPC)));
      return view(request);
   }

   @Override
   public String remove(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      getData().remove(id);
      return view(request);
   }

}
