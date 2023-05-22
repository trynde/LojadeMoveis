/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2.Classes;

/**
 *
 * @author Carolina
 */
public class Cliente {
    
    private int cpf;
    private String sexo;
    private String dataNasciment;
    private String email;
    private int cep;
    private String endereco;
    private int num;
    private String bairro;
    private String nome;

    public Cliente() {
    }
     public Cliente(int cpf, String sexo, String dataNasciment, String email, int cep, String endereco, int num, String bairro, String nome) {
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNasciment = dataNasciment;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.num = num;
        this.bairro = bairro;
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNasciment() {
        return dataNasciment;
    }

    public void setDataNasciment(String dataNasciment) {
        this.dataNasciment = dataNasciment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}