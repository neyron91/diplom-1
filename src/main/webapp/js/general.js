function sendCmd(table, typeOperation, path, data) {
   path = PATH_CONTEXT + path;
   data = data || {}
   data["type_table"] = table;
   data["type_operation"] = typeOperation;
   $.post(path, data, function (html) {
      $('#content').html(html);
   }, "html");
}