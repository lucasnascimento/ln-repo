package br.com.ln.financeiro.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper=true)
public @Data class CartaoCredito extends Conta {

	private int diaVencimento;
	
}
