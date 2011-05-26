package br.com.ln.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	private Categoria agrupador;
	
	private TipoOperacaoEnum tipoOperacao;

}
