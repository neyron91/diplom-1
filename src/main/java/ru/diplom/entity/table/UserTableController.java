package ru.diplom.entity.table;

import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import ru.diplom.Main;
import ru.diplom.entity.User;

/**
 *
 * @author User
 */
public class UserTableController extends TableController {

   public static final String COLUMN_LOGIN = "Логин";
   public static final String COLUMN_PASSWORD = "Пароль";
   public static final String COLUMN_ADMIN = "Администратор";

   public UserTableController(Main data) {
      super(data);
   }

   private ConcurrentHashMap<Integer, User> getData() {
      return main.getData().getListUser();
   }

   @Override
   public String view(HttpServletRequest request) {
      StringBuilder newRow = new StringBuilder();
      newRow.append("<tr>")
              .append("<td style='padding-top: 20px;'><input style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input style='width: 100%' type='text'></td>")
              .append("<td style='text-align: center; padding-top: 20px;'><input type='checkbox'></td>")
              .append("<td style='padding-top: 20px;'><button>Добавить</button></td>")
              .append("</tr>");

      StringBuilder html = new StringBuilder();
      ConcurrentHashMap<Integer, User> listUser = getData();
      html.append("<h2 style='text-align: center;'>Пользователи</h2>")
              .append("<br>")
              .append("<div class='tables-content'>");

      if (listUser.isEmpty()) {
         html.append("<center><font style='font-size: 16pt;margin: auto;'>Нет данных</font></center><br>");
      }

      html.append("<table id='data' style='width: 700px; margin: auto;'>")
              .append("<thead>")
              .append("<tr>")
              .append("<th>").append(COLUMN_LOGIN).append("</th>")
              .append("<th>").append(COLUMN_PASSWORD).append("</th>")
              .append("<th>").append(COLUMN_ADMIN).append("</th>")
              .append("<th></th>")
              .append("</tr>")
              .append("</thead>")
              .append("<tbody>");

      for (User user : listUser.values()) {
         html.append("<tr>")
                 .append("<td>").append(user.getLogin()).append("</td>")
                 .append("<td>").append(user.getPassword()).append("</td>")
                 .append("<td>").append(user.isAdmin() ? "Да" : "Нет").append("</td>")
                 .append("<td>")
                 .append("<button>Ред..</button>")
                 .append("<button onclick=\"sendCmd('").append(UserTableController.class.getName()).append("','remove', '/admin',{").append("id:").append(user.getId()).append("});\">Удал..</button>")
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
   public String update(HttpServletRequest request) {
      return view(request);
   }

   @Override
   public String add(HttpServletRequest request) {
      return view(request);
   }

   @Override
   public String remove(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      getData().remove(id);
      return view(request);
   }
}
