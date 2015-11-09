package br.aedu.anhanghera.poo.locadora.carro.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    /**
     * Represeenta uma conexao com o banco de dados no java.
     */
    private static Connection con;

    /**
     * Cria uma conexao com o banco de dados, 
     * garante que só tenha uma conexão aberta
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {
        if (con == null) {//verificacao para garantir unica conexao com o banco de dados.
            //Carregando o Driver do mysql na memoria do java
            Class.forName("com.mysql.jdbc.Driver");
            //Estabelecendo a conexao com o banco de dados.
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/locadora_carro", 
                            "root", "root");

        }
        return con;
    }

}
