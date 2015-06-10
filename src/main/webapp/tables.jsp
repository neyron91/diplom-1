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
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/general.js"></script>
   </head>
   <body>
      <div class="top-panel">
         <h1 style="margin-left: 100px;">Управление конфигурацией :: Таблицы</h1>
      </div>

      <div class="right-panel">
         <%
        HashMap<Class, String> list = (HashMap<Class, String>) request.getAttribute("tables");
        if (list != null) {
           for (Map.Entry<Class, String> entrySet : list.entrySet()) {
              Class cls = entrySet.getKey();
              String rep = entrySet.getValue();
         %>
         <font id="table-user" class="custom_link" onclick="sendCmd('<%=cls.getName()%>', 'view', '/tables');"><%=rep%></font><br>
         <% }
         }%>
      </div>

      <div id="content" class="content-panel">
         Выберите справа поле для дальнейшей работы
      </div>
   </body>
</html>