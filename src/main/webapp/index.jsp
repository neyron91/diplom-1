<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Управление конфигурацией</title>
      <script>
         var PATH_CONTEXT = "<%=request.getContextPath()%>";
      </script>

      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jq-ui/jquery-ui.min.css"/>

      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-migrate-1.2.1.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-ui.min.js"></script>
   </head>
   <body>
      <br>
      <br>
      <br>
      <br>
      <div>
         <table style="text-align: center;">
            <tr>
               <td colspan="3" style="text-align:center">
            <center><b><h3>Управление конфигурацией</h3></b></center>
            </td>
            </tr>

            <tr>
               <td style="width:50%"></td>
               <td>
                  <div id="div_form_auth" name="div_form_auth" class="login_form ui-widget ui-widget-content ui-corner-all">
                     <form id="loginform" action="<%=request.getContextPath()%>/main" method="post">
                        <center>
                           <p>
                           <table>
                              <tr>
                                 <td style="text-align:right;">
                                    Логин: 
                                 </td>
                                 <td>
                                    <input name="login" id="login" type="text" size="30">
                                 </td>                        
                              </tr>
                              <tr>
                                 <td colspan="2"><br /></td>                          
                              </tr>
                              <tr>
                                 <td style="text-align:right;">
                                    Пароль: 
                                 </td>
                                 <td>
                                    <input name="pass" id="pass" type="password" size="30"><br />
                                 </td>                        
                              </tr> 
                           </table>
                           </p>
                           <input name="submit" id="submit" type="submit" value="Войти" style="width:99%; opacity:1;" />
                           <br />
                        </center>
                     </form>
                  </div>                
               </td>
               <td style="width:50%"></td>
            </tr>
            <tr>
               <td colspan="3">
               </td>
            </tr>        
         </table>
         <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
         %>
         <br>
         <div style="text-align: center;">
            <%=msg%>
         </div>
         <%}%>       
      </div>
   </body>
</html>