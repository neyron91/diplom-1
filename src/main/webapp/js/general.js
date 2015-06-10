function sendCmd(table, typeOperation, path, data, handler) {
   path = PATH_CONTEXT + path;
   data = data || {}
   handler = handler || function (html) {
      $('#content').html(html);
   }
   data["type_table"] = table;
   data["type_operation"] = typeOperation;
   
   console.log(data);
   
   $.post(path, data, handler, "html");
}