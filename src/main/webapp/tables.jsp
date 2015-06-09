<%@page import="ru.diplom.web.other.TableSelect"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Управление конфигурацией</title>
      <script>
         var PATH_CONTEXT = "<%=request.getContextPath()%>";
      </script>

      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jq-ui/jquery-ui.min.css"/>

      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-ui.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/tables.js"></script>
   </head>
   <body>
      <div class="top-panel">
         <h1 style="margin-left: 100px;">Управление конфигурацией :: Таблицы</h1>
      </div>

      <div class="right-panel">
         <font class="custom_link" onclick="">Мышки</font><br>
         <font class="custom_link">Клавиатуры</font><br>
         <font class="custom_link">Мониторы</font><br> 
      </div>

      <div class="content-panel">
         <h2 style="text-align: center;">Мышки</h2>
         <br>
         <div id="tables-content">
            <!--         <div style="text-align: center;">
                        <font style="font-size: 16pt">Нет данных.</font>
                        <br>
                        <a href="#" onClick="">Добавить</a>
                     </div>-->

            <table style="width: 700px; margin: auto;">
               <thead>
                  <tr>
                     <th>Логин</th>
                     <th>Пароль</th>
                     <th>Администратор</th>
                     <th></th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td>test</td>
                     <td>test</td>
                     <td><input type="checkbox"></td>
                     <td><button>Ред..</button><button>Удал..</button></td>
                  </tr>
                  <tr>
                     <td>admin</td>
                     <td>admin</td>
                     <td><input type="checkbox" checked></td>
                     <td><button>Ред..</button><button>Удал..</button></td>
                  </tr>
                  <tr>
                     <td style="padding-top: 20px;"><input style="width: 100%" type="text"></td>
                     <td style="padding-top: 20px;"><input style="width: 100%" type="text"></td>
                     <td style="padding-top: 20px;"><input type="checkbox"></td>
                     <td style="padding-top: 20px;"><button>Добавить</button></td>
                  </tr>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>