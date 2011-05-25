package br.com.ln.financeiro.entity;

import javax.persistence.Entity;

import lombok.Data;

@Entity
public @Data class Entidade  {
	private Long id;
	private String nome;
}