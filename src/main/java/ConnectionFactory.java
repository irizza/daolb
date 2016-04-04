


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class ConnectionFactory {

        private static final String dbHost = "localhost:3306";
        private static final String dbName = "filials";
        private static final String dbUser = "root";
        private static final String dbPassword = "root";




        private static String dbUrl = "jdbc:mysql://" + dbHost + "/" + dbName;

        public static Connection getConnection() throws SQLException {
            try {
                Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                throw new SQLException("Can't get mysql driver");
            }
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            connection.setAutoCommit(false);
            return connection;
        }
    }


