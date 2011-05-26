package br.com.ln.financeiro.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Lancamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date data;
	
	private String descritivo;
	
	private Conta conta;
	
	private Categoria categoria;
	
	private float valor;
	
	private boolean conciliado;
	
	private Date dataConciliacao;
}
