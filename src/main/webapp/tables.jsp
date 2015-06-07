<%@page import="ru.diplom.web.other.TableSelect"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Учет комплектующих</title>
      <script>
         var PATH_CONTEXT = "<%=request.getContextPath()%>";
      </script>

      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/tables.css"/>
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jq-ui/jquery-ui.min.css"/>

      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-ui.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/tables.js"></script>
   </head>
   <body style="position:relative;">
      <div class="right-panel">
         <a href="#">Мышки</a><br>
         Клавиатуры<br>
         Мониторы<br>
      </div>

      <div class="content">
         <br>
         <h1 style="margin-left: 100px;">Учет комплектующих</h1>
         <br>
         <hr>
         <br>
         <h2 style="text-align: center;">Таблица "Мышки"</h2>
         <br>
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
                     <th>Наименование</th>
                     <th>Производитель</th>
                     <th></th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td>M360</td>
                     <td>Logitec</td>
                     <td><button>Ред..</button><button>Удал..</button></td>
                  </tr>
                  <tr>
                     <td>M300</td>
                     <td>Logitec</td>
                     <td><button>Ред..</button><button>Удал..</button></td>
                  </tr>
                  <tr>
                     <td>Z7</td>
                     <td>Microsoft</td>
                     <td><button>Ред..</button><button>Удал..</button></td>
                  </tr>
                  <tr>
                     <td style="padding-top: 20px;"><input style="width: 100%" type="text"></td>
                     <td style="padding-top: 20px;"><input style="width: 100%" type="text"></td>
                     <td style="padding-top: 20px;"><button>Добавить</button></td>
                  </tr>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>