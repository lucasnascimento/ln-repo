package br.com.ln.financeiro.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import br.com.ln.orm.GenericHibernateDAO;

@Entity
@EqualsAndHashCode(callSuper=true)
public @Data class Entidade extends GenericHibernateDAO<Entidade, Long> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Conta> contas;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Categoria> categorias;
	
	@OneToOne
	private Login login;

	@Override
	public boolean validate() {
		return true;
	}

}
