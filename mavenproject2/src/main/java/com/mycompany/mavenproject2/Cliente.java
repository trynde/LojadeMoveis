/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author Carolina
 */
public class Cliente {
    
    private int cpf;
    private String sexo;
    private String estadoCivil; 
    private String dataNasciment;
    private String telefone;
    private String email;
            
    public Cliente() {
        
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDataNasciment() {
        return dataNasciment;
    }

    public void setDataNasciment(String dataNasciment) {
        this.dataNasciment = dataNasciment;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(int cpf, String sexo, String estadoCivil, String dataNasciment, String telefone, String email) {
        this.cpf = cpf;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.dataNasciment = dataNasciment;
        this.telefone = telefone;
        this.email = email;
    }
    
}