/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2.dao;

import com.mycompany.mavenproject2.Classes.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tjoao
 */
public class ProdutoDAO {
    public static boolean cadastrar(Produto obj){
        boolean Retorno = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/loja_moveis";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produtos " 
                    + "(nome, categoria, preco, codigo, quantidade) VALUES(?,?,?,?,?,?,?,?)");
           
           comandoSQL.setString(1,obj.getNome());
           comandoSQL.setString(2,obj.getCategoria());
           comandoSQL.setDouble(3,obj.getPreco());
           comandoSQL.setInt(4,obj.getCodigo());
           comandoSQL.setInt(5,obj.getQuantidade());
           
           // Passo 4 - Executar comando SQL
          int linhasAfetadas = comandoSQL.executeUpdate();
          
          if(linhasAfetadas>0){
              Retorno = true;
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return Retorno;
    } // Fim do metódo insert
    
     public static ArrayList<Produto> listar(){
        ArrayList<Produto> busca = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produtos");
           
           // Passo 4 - Executar comando SQL
          ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  Produto select = new Produto();
                  select.setNome(Rs_select.getString("nome"));
                  select.setCategoria(Rs_select.getString("categoria"));
                  select.setPreco(Rs_select.getDouble("preco"));
                  select.setCodigo(Rs_select.getInt("codigo"));
                  select.setQuantidade(Rs_select.getInt("quantidade"));
                  
                  busca.add(select);
              }
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return busca;
    } // Fim do metodo de select
    
     public static ArrayList<Produto> listarBusca(String codigo){
        ArrayList<Produto> buscaC = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/loja_moveis";
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produtos WHERE codigo = ?");
           comandoSQL.setString(1,codigo);
           
           // Passo 4 - Executar comando SQL
          ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  Produto select = new Produto();
                  select.setNome(Rs_select.getString("nome"));
                  select.setCategoria(Rs_select.getString("categoria"));
                  select.setPreco(Rs_select.getDouble("preco"));
                  select.setCodigo(Rs_select.getInt("email"));
                  select.setQuantidade(Rs_select.getInt("quantidade"));
                  
                  buscaC.add(select);
              }
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return buscaC;
    } // Fim do metodo de select com parametro
     
    public static boolean excluir(String codigo){
        boolean Retorno = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/loja_moveis";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM clientes WHERE codigo =? ");
           comandoSQL.setString(1, codigo);
           
           // Passo 4 - Executar comando SQL
          int linhasAfetadas = comandoSQL.executeUpdate();
          
          if(linhasAfetadas>0){
              Retorno = true;
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return Retorno;
    } // Fim do metódo delete
    
        public static boolean alterar(Produto alterar ){
        boolean Retorno = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/loja_moveis";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement(" UPDATE produtos SET nome = ?, "
                  + "categoria = ?, preco = ?, codigo = ?, qauntidade = ? WHERE codigo = ?");
           
           comandoSQL.setString(1,alterar.getNome());
           comandoSQL.setString(2,alterar.getCategoria());
           comandoSQL.setDouble(3,alterar.getPreco());
           comandoSQL.setInt(4,alterar.getCodigo());
           comandoSQL.setInt(5,alterar.getQuantidade());
           
           // Passo 4 - Executar comando SQL
          int linhasAfetadas = comandoSQL.executeUpdate();
          
          if(linhasAfetadas>0){
              Retorno = true;
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return Retorno;
    } 
}
