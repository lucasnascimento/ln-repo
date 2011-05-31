package br.com.ln.financeiro.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import br.com.ln.orm.GenericHibernateDAO;

@Entity
@EqualsAndHashCode(callSuper=true)
public @Data class Lancamento extends GenericHibernateDAO<Lancamento, Long> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Temporal(value=TemporalType.DATE)
	private Date data;
	
	private String descritivo;
	
	@ManyToOne
	private Conta conta;
	
	@ManyToOne
	private Categoria categoria;
	
	private float valor;
	
	private boolean conciliado;
	
	@Temporal(value=TemporalType.DATE)
	private Date dataConciliacao;

	@Override
	public boolean validate() {
		return true;
	}
}
