package br.com.ln.financeiro.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
public @Data class Login {
	
	public String login;
	
	public String email;
	
	public String senha;

}