<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Учет комплектующих</title>
      <script>
         var PATH_CONTEXT = "<%=request.getContextPath()%>";
      </script>

      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css"/>
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jq-ui/jquery-ui.min.css"/>

      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-ui.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js"></script>
   </head>
   <body>
      <br>
      <br>
      <h1 style="text-align: center;">Учет комплектующих</h1>
      <br>
      <br>
      <br>
      <br>

      <table style="width: 500px; margin: auto;">
         <tr style="height: 50px; text-align: center;">
            <td>Выберите действие для дальнейшей работы:</td>
         </tr>
         <tr style="text-align: center;">
            <td>
               <form action="<%=request.getContextPath()%>/report" method="GET">
                  <button id="button-report">Отчеты</button>
               </form>
            </td>
         </tr>
         <tr style="text-align: center;">
            <td>
               <form action="<%=request.getContextPath()%>/tables" method="GET">
                  <button id="button-tables">Работа с данными</button>
               </form>
            </td>
         </tr>
      </table>
   </body>
</html>