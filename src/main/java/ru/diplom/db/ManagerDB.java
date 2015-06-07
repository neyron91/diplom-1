package ru.diplom.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * Настройка и работа с пулом соединений
 *
 * @author dmitry
 */
public class ManagerDB {

   public static final Logger log = LogManager.getLogger(ManagerDB.class.getName());

   private DataSource dataSource;

   public enum Query {

      SELECT, UPDATE;
   };

   public ManagerDB(String nameResorse) {
//      try {
//         InitialContext initContext = new InitialContext();
//         dataSource = (DataSource) initContext.lookup("java:comp/env/" + nameResorse);
//      } catch (NamingException ex) {
//         log.error(ex);
//      }
   }

   public void inic() {

   }

   public Connection getConnection() throws SQLException {
      Connection con = null;
      if (dataSource != null) {
         con = dataSource.getConnection();
      }
      if (con != null) {
         return con;
      } else {
         throw new SQLException("getConnection(): is Null");
      }
   }

   public void execute(SQLQuery query) {
      if (query != null) {
         try (Connection con = getConnection()) {
            Statement st = con.createStatement();
            switch (query.getTypeQuery()) {
               case SELECT: {
                  query.parseResultQuery(st.executeQuery(query.getSQL()));
                  break;
               }
               case UPDATE: {
                  query.onUpdate(st.executeUpdate(query.getSQL()));
                  break;
               }
            }
         } catch (SQLException ex) {
            log.error(ex);
         }
      }
   }

}
