package br.com.ln.financeiro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.ln.orm.GenericHibernateDAO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper=true)
public @Data class Conta extends GenericHibernateDAO<Conta, Long> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@OneToMany
	private Entidade proprietario;
	
	private float saldo;

	@Override
	public boolean validate() {
		return true;
	}
	
}
