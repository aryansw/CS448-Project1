package simpledb.jdbc.embedded;

import java.util.Properties;
import java.sql.SQLException;
import simpledb.server.SimpleDB;
import simpledb.jdbc.DriverAdapter;

/**
 * The RMI server-side implementation of RemoteDriver.
 * @author Edward Sciore
 */

public class EmbeddedDriver extends DriverAdapter {   
   /**
    * Creates a new RemoteConnectionImpl object and 
    * returns it.
    * @see simpledb.jdbc.network.RemoteDriver#connect()
    */

   private SimpleDB db;

   public EmbeddedConnection connect(String url, Properties p) throws SQLException {
      String dbname = url.replace("jdbc:simpledb:", "");
      this.db = new SimpleDB(dbname);
      return new EmbeddedConnection(db);
   }

   public EmbeddedConnection connect(String url, int blockSize, int buffSize, Properties p) throws SQLException {
      String dbname = url.replace("jdbc:simpledb:", "");
      this.db = new SimpleDB(dbname, blockSize, buffSize);
      return new EmbeddedConnection(db);
   }

   public SimpleDB getDb() {
      return db;
   }
}

