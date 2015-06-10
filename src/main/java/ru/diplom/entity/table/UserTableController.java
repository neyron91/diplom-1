package ru.diplom.entity.table;

import java.util.Map;
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

   public static final String PATH = "/admin";
   public static final String ID_TEMPL = "user_";

   public UserTableController(Main data) {
      super(data);
   }

   private ConcurrentHashMap<Integer, User> getData() {
      return main.getData().getListUser();
   }

   @Override
   public String view(HttpServletRequest request) {
      StringBuilder newRow = new StringBuilder();

      String idLogin = ID_TEMPL + "login";
      String idPass = ID_TEMPL + "pass";
      String idIsAdmin = ID_TEMPL + "is_admin";

      String data = "login:$('#" + idLogin + "').val(),pass:$('#" + idPass + "').val(),is_admin:$('#" + idIsAdmin + "').prop('checked')";
      String click = "sendCmd('" + UserTableController.class.getName() + "','add', '" + PATH + "', {" + data + "});";

      newRow.append("<tr>")
              .append("<td style='padding-top: 20px;'><input id='").append(idLogin).append("' style='width: 100%' type='text'></td>")
              .append("<td style='padding-top: 20px;'><input id='").append(idPass).append("' style='width: 100%' type='text'></td>")
              .append("<td style='text-align: center; padding-top: 20px;'><input id='").append(idIsAdmin).append("' type='checkbox'></td>")
              .append("<td style='padding-top: 20px;'><button onclick=\"").append(click).append("\">Добавить</button></td>")
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
         String id = "user_" + user.getId();

         String remove = "onclick=\"sendCmd('" + UserTableController.class.getName() + "','remove', '" + PATH + "',{" + "id:" + user.getId() + "});\"";
         String modifi = "onclick=\"sendCmd('" + UserTableController.class.getName() + "','updateViewControl', '" + PATH + "',{" + "id:" + user.getId() + "},function(html){$('#" + id + "').html(html)});\"";

         html.append("<tr id='").append(id).append("'>")
                 .append("<td>").append(user.getLogin()).append("</td>")
                 .append("<td>").append(user.getPassword()).append("</td>")
                 .append("<td>").append(user.isAdmin() ? "Да" : "Нет").append("</td>")
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
         User user = getData().get(id);

         String idTmp = ID_TEMPL + id + "_";

         String idLogin = idTmp + "login";
         String idPass = idTmp + "pass";
         String idIsAdmin = idTmp + "is_admin";

         String data = "login:$('#" + idLogin + "').val(),pass:$('#" + idPass + "').val(),is_admin:$('#" + idIsAdmin + "').prop('checked'), id:" + user.getId();
         String saveClick = "sendCmd('" + UserTableController.class.getName() + "','update', '" + PATH + "', {" + data + "});";
         String cancelClick = "sendCmd('" + UserTableController.class.getName() + "','view', '" + PATH + "');";

         newRow.append("<td><input id='").append(idLogin).append("' style='width: 100%' type='text' value='").append(user.getLogin()).append("'></td>")
                 .append("<td><input id='").append(idPass).append("' style='width: 100%' type='password' value='").append(user.getPassword()).append("'></td>")
                 .append("<td style='text-align: center;'><input id='").append(idIsAdmin).append("' type='checkbox' ").append(user.isAdmin() ? "checked" : "").append("></td>")
                 .append("<td><button onclick=\"").append(saveClick).append("\">Сохранить</button><button onclick=\"").append(cancelClick).append("\">Закрыть</button></td>");
      }
      return newRow.toString();
   }

   @Override
   public String update(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      String login = request.getParameter("login");
      String pass = request.getParameter("pass");
      boolean isAdmin = Boolean.parseBoolean(request.getParameter("is_admin"));
      User user = getData().get(id);
      if (user != null) {
         user.setAdmin(isAdmin);
         user.setLogin(login);
         user.setPassword(pass);
      }
      return view(request);
   }

   @Override
   public String add(HttpServletRequest request) {
      String login = request.getParameter("login");
      String pass = request.getParameter("pass");
      boolean isAdmin = Boolean.parseBoolean(request.getParameter("is_admin"));

      int maxId = 0;
      for (Map.Entry<Integer, User> entrySet : getData().entrySet()) {
         int id = entrySet.getKey();
         if (id > maxId) {
            maxId = id;
         }
      }
      maxId++;
      getData().put(maxId, new User(maxId, login, pass, isAdmin));
      return view(request);
   }

   @Override
   public String remove(HttpServletRequest request) {
      int id = readInt(request.getParameter("id"));
      getData().remove(id);
      return view(request);
   }
}
