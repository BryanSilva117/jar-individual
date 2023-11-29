package Conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {
    private JdbcTemplate conexaoDoBanco;
    private JdbcTemplate conexaoDoBancoServer;

    public Conexao() {
        BasicDataSource dataSource = new BasicDataSource();
        BasicDataSource dataSourceServer = new BasicDataSource();

        //MYSQL
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://0.0.0.0:3306/performee?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("001performee");

        //SQL Server
        dataSourceServer.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceServer.setUrl("jdbc:sqlserver://3.215.254.176:1433;databaseName=model;trustServerCertificate=true;");
        dataSourceServer.setUsername("cruduser");
        dataSourceServer.setPassword("UsuarioCrud@12345");

        conexaoDoBanco = new JdbcTemplate(dataSource);
        conexaoDoBancoServer = new JdbcTemplate(dataSourceServer);

    }
    public  JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBanco;
    }

    public JdbcTemplate getConexaoDoBancoServer() {
        return conexaoDoBancoServer;
    }

}
