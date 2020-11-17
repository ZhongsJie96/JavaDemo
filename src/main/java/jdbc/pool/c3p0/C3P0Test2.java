package jdbc.pool.c3p0;

import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class C3P0Test2 {
    public C3P0Test2() {
    }

    public static void main(String[] args) throws SQLException {
        // 通过工厂方式
        DataSource ds_unpooled = DataSources.unpooledDataSource("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8", "root", "");
        Map overrides = new HashMap();
        overrides.put("maxStatements", "200");
        overrides.put("maxPoolSize", new Integer(50));
        DataSource ds_pooled = DataSources.pooledDataSource(ds_unpooled, overrides);
        Connection connection = ds_pooled.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
