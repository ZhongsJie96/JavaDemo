package jdbc.pool.hikariCP;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPDemo {
    public static void main(String[] args) throws SQLException {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8");
//        config.setUsername("root");
//        config.setPassword("");
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//
//        HikariDataSource dataSource = new HikariDataSource(config);
//        System.out.println(dataSource.getConnection());

        HikariConfig config = new HikariConfig("src/main/java/jdbc/pool/hikariCP/hikari.properties");
        HikariDataSource dataSource = new HikariDataSource(config);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
