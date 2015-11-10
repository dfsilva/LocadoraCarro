package br.aedu.anhanghera.poo.locadora.carro.bd;

import br.aedu.anhanghera.poo.locadora.carro.dominio.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarroDAO {
    
    
    
    public static Carro inserir(Carro carro) throws Exception{
        
        //Objeto responsavel por executar o sql no banco de dados
        PreparedStatement stm = null;
        //Objeto que representa o retorno do banco de dados.
        ResultSet rs = null;
        //Representa conexao com o banco de dados
        Connection con = null;
        try {
            con = FabricaConexao.getConnection();
            
            //Prepara o comendo para execucao no banco de dados.
            stm = con.prepareStatement("insert into carro(nome, modelo)"
                    + " values(?,?)", Statement.RETURN_GENERATED_KEYS);
            
            //Atribuindo os parametros na consulta.
            stm.setString(1, carro.getNome());
            stm.setString(2, carro.getModelo());
            
            int qtdRegistros = stm.executeUpdate();
            
            if(qtdRegistros > 0){
                rs = stm.getGeneratedKeys();
                if(rs.next()){
                    carro.setId(rs.getInt(1));
                }else{
                    throw new SQLException("Erro ao inserir carro");
                }
            }
        } catch (Exception e) {
            throw e;
        }finally{
            rs.close();
            stm.close();
        }
        return carro;
    }
    
    
    public static List<Carro> listar(){
        
        PreparedStatement stm = null;
        ResultSet rs = null;
        Connection con = null;
        List<Carro> retorno = new ArrayList<Carro>();
        
        try {
           
            con = FabricaConexao.getConnection();
            stm = con.prepareStatement("select * from carro");
            rs = stm.executeQuery();
            
            while(rs.next()){
                Carro c = new Carro();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setModelo(rs.getString("modelo"));
                retorno.add(c);
            }
            
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
                try {
                    if(rs != null)
                        rs.close();
                    
                    if(stm != null)
                        stm.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
        
        return retorno;
    }
    
    
}
