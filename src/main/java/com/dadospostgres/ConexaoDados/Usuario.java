package com.dadospostgres.ConexaoDados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long Id_usuario;
	
	private String Nome;
	
	private String Carro;
	
	private int Placa;
	
	private double Tempo;

	public long getId_usuario() {
		return Id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		Id_usuario = id_usuario;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCarro() {
		return Carro;
	}

	public void setCarro(String carro) {
		Carro = carro;
	}

	public int getPlaca() {
		return Placa;
	}

	public void setPlaca(int placa) {
		Placa = placa;
	}

	public double getTempo() {
		return Tempo;
	}

	public void setTempo(double tempo) {
		Tempo = tempo;
	}

	@Override
	public String toString() {
		return "Usuario [Id_usuario=" + Id_usuario + ", Nome=" + Nome + ", Carro=" + Carro + ", Placa=" + Placa
				+ ", Tempo=" + Tempo + "]";
	}
	
	
	
}
