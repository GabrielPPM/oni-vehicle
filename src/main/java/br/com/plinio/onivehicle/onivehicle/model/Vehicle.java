package br.com.plinio.onivehicle.onivehicle.model;

public class Vehicle {
    private String codigo;
    private String nome;

    public Vehicle(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
