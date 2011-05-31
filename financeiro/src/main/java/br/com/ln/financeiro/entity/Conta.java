package br.com.ln.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public @Data class Conta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@OneToMany
	private Entidade proprietario;
	
	private float saldo;
	
}
