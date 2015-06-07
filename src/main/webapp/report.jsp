<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="ru.diplom.web.other.ReportSelect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Учет комплектующих</title>
      <script>
         var PATH_CONTEXT = "<%=request.getContextPath()%>";
      </script>

      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/general.css"/>
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
      <h2 style="text-align: center;">Отчеты</h2>
      <br>
      <br>
      <br>

      <table style="width: 700px; margin: auto;">
         <tr style="">
            <td style="width: 50%; text-align: right;">Выберите отчет:</td>
            <td style="width: 50%;">
               <select style="min-width: 100px;" id="month">
                  <option selected value="-1">-</option>
                  <%
                     HashMap<Integer, ReportSelect> list = (HashMap<Integer, ReportSelect>) request.getAttribute("reports");
                     if (list != null) {
                        for (Map.Entry<Integer, ReportSelect> entrySet : list.entrySet()) {
                           int value = entrySet.getKey();
                           ReportSelect rep = entrySet.getValue();
                  %>
                  <option value="<%=rep.getValue()%>"><%=rep.getText()%></option>
                  <%    }
                     }%>
               </select>
            </td>
         </tr>
      </table>
      <br>
      <div id="report-content">
         Тут будет находится результаты какого-либо отчета
      </div>
   </body>
</html>