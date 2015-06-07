package ru.diplom;

/**
 * Константные значения подписей и общих переменных
 *
 *
 */
public class Value {

   public enum Logout {

      NO_AUTHORIZATION("Сессия была завершена, пройдите повторную авторизацию", 1),
      SERVER_REBOOT("Сервер был перезагружен. Необходима повторная авторизация", 2),
      NOT_RIGHT("Доступ запрещен", 3);

      private final String msg;
      private final int type;

      private Logout(String msg, int type) {
         this.msg = msg;
         this.type = type;
      }

      public String getMsg() {
         return msg;
      }

      public int getType() {
         return type;
      }
   }

   public enum Authorization {

      AUTHORIZATION_SUCCESSFUL("Авторизация прошла успешно!", 1),
      AUTHORIZATION_ERROR("Ошибка в процессе авторизации", 2),
      LOGIN_PASSWORD_INCORRECT("Неверный логин или пароль!", 3),
      NOT_RIGHT("Доступ запрещен", 4);

      private final String msg;

      private final int type;

      private Authorization(String msg, int type) {
         this.msg = msg;
         this.type = type;
      }

      public String getMsg() {
         return msg;
      }

      public int getType() {
         return type;
      }
   }
}
