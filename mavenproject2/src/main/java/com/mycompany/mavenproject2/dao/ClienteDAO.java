/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2.dao;

import com.mycompany.mavenproject2.Classes.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author joao.ptbasilio
 */
public class ClienteDAO {
    public static boolean cadastrar(Cliente obj){
        boolean Retorno = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/loja_moveis";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO clientes " 
                    + "(CPF, nome, data_nasciment, email, sexo, cep, endereco, num, bairro) VALUES(?,?,?,?,?,?,?,?)");
           
           comandoSQL.setString(1,obj.getCpf());
           comandoSQL.setString(2,obj.getNome());
           comandoSQL.setString(3,obj.getDataNasciment());
           comandoSQL.setString(4,obj.getEmail());
           comandoSQL.setString(5,obj.getSexo());
           comandoSQL.setInt(6,obj.getCep());
           comandoSQL.setString(7,obj.getEndereco());
           comandoSQL.setString(8,obj.getBairro());
           comandoSQL.setInt(9,obj.getNum());
           
           
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
    
     public static ArrayList<Cliente> listar(){
        ArrayList<Cliente> busca = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM clientes");
           
           // Passo 4 - Executar comando SQL
          ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  Cliente select = new Cliente();
                  select.setCpf(Rs_select.getString("CPF"));
                  select.setNome(Rs_select.getString("nome"));
                  select.setEmail(Rs_select.getString("email"));
                  select.setSexo(Rs_select.getString("genero"));
                  select.setCep(Rs_select.getInt("cep"));
                  select.setEndereco(Rs_select.getString("rua"));
                  select.setNum(Rs_select.getInt("num_casa"));
                  select.setBairro(Rs_select.getString("bairro"));
                  
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
    
     public static ArrayList<Cliente> listarBusca(String CPF){
        ArrayList<Cliente> buscaC = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/loja_moveis";
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM clientes WHERE CPF = ?");
           comandoSQL.setString(1,CPF);
           
           // Passo 4 - Executar comando SQL
          ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  Cliente select = new Cliente();
                  select.setCpf(Rs_select.getString("CPF"));
                  select.setNome(Rs_select.getString("nome"));
                  select.setDataNasciment(Rs_select.getString("data_nasciment"));
                  select.setEmail(Rs_select.getString("email"));
                  select.setSexo(Rs_select.getString("sexo"));
                  select.setCep(Rs_select.getInt("cep"));
                  select.setEndereco(Rs_select.getString("endereco"));
                  select.setNum(Rs_select.getInt("num"));
                  select.setBairro(Rs_select.getString("bairro"));
                  
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
     
    public static boolean excluir(String CPF){
        boolean Retorno = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/loja_moveis";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM clientes WHERE CPF =? ");
           comandoSQL.setString(1, CPF);
           
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
    
        public static boolean alterar(Cliente alterar ){
        boolean Retorno = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/loja_moveis";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement(" UPDATE clientes SET nome = ?, "
                  + "email = ?, sex = ?, data_nasciment = ?, cep = ?, enderec = ?, num = ?, bairro = ? WHERE CPF = ?");
           
           comandoSQL.setString(1,alterar.getCpf());
           comandoSQL.setString(2,alterar.getNome());
           comandoSQL.setString(3,alterar.getDataNasciment());
           comandoSQL.setString(4,alterar.getEmail());
           comandoSQL.setString(5,alterar.getSexo());
           comandoSQL.setInt(6,alterar.getCep());
           comandoSQL.setString(7,alterar.getEndereco());
           comandoSQL.setString(8,alterar.getBairro());
           comandoSQL.setInt(9,alterar.getNum());
           
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
