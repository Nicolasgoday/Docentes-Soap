package com.baeldung.jaxws.server.repository;

import java.sql.Connection;
import java.sql.SQLException;


import com.zaxxer.hikari.*;

public class DataSource {
	 
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
 
    static {
    	//sm9j2j5q6c8bpgyq.cbetxkdyhwsb.us-east-1.rds.amazonaws.com
        config.setJdbcUrl( "jdbc:mysql://sm9j2j5q6c8bpgyq.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/pod3i2eblsvv0rz1?reconnect=true" );
        config.setUsername( "lqo0ahe9urejc5cw" );
        config.setPassword( "yznskdvuv9lj45on" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }
 
    private DataSource() {}
 
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}