package ru.diplom.entity.table;

import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import ru.diplom.Main;
import ru.diplom.entity.Mouse;

/**
 *
 * @author User
 */
public class MouseTable extends Table {

   public static final String COLUMN_NAME = "Наименование";
   public static final String COLUMN_MANUFACTURER = "Производитель";

   public MouseTable(Main data) {
      super(data);
   }

   @Override
   public String view(HttpServletRequest request) {
      StringBuilder html = new StringBuilder();
      ConcurrentHashMap<Integer, Mouse> listMouse = main.getData().getListMouse();
      if (!listMouse.isEmpty()) {
         html.append("<table style='width: 700px; margin: auto;'>")
                 .append("<thead>")
                 .append("<tr>")
                 .append("<th>").append(COLUMN_NAME).append("/th")
                 .append("<th>").append(COLUMN_MANUFACTURER).append("/th")
                 .append("<th>").append("").append("/th")
                 .append("</tr>")
                 .append("</thead>")
                 .append("<tbody>");

         for (Mouse mouse : listMouse.values()) {
            html.append("<tr>")
                    .append("<td>").append(mouse.getName()).append("</td>")
                    .append("<td>").append(mouse.getManufacturer()).append("</td>")
                    .append("<td>").append("<button>Ред..</button><button>Удал..</button>").append("</td>")
                    .append("</tr>");
         }

         html.append("<tr>")
                 .append("<td style='padding-top: 20px;'>").append("<input style='width: 100%' type='text'>").append("</td>")
                 .append("<td style='padding-top: 20px;'>").append("<input style='width: 100%' type='text'>").append("</td>")
                 .append("<td style='padding-top: 20px;'>").append("<button>Добавить</button>").append("</td>")
                 .append("</tr>");

         html.append("</tbody>")
                 .append("</table>");
      } else {
         html.append("<div style='text-align: center;'>")
                 .append("<font style='font-size: 16pt'>Нет данных.</font>")
                 .append("<br>")
                 .append("<a href='#' onClick=''>Добавить</a>")
                 .append("</div>");
      }
      return html.toString();
   }

   @Override
   public String update(HttpServletRequest request) {
      return "";
   }

   @Override
   public String add(HttpServletRequest request) {
      return "";
   }

   @Override
   public String remove(HttpServletRequest request) {
      return "";
   }

}
