package br.com.ln.financeiro.orm;
/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.ln.financeiro.entity.Entidade;
import br.com.ln.financeiro.entity.Login;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericHibernateDAOTest {

//	@PersistenceContext
//	private EntityManager entityManager;

	@Test
	@Transactional
	public void testSaveOrUpdate() throws Exception {
		
		Entidade entidade = new Entidade();
		entidade.setName("Entidade Teste 1");
		Login login = new Login();
		login.setEmail("na@email.com");
		login.setLogin("usario1");
		login.setSenha("HASH_TO_PASSAWORD");
		entidade.setLogin(login);
		entidade.saveOrUpdate();
		
		
	
//		Order order = new Order();
//		order.getItems().add(new Item());
//		entityManager.persist(order);
//		entityManager.flush();
//		assertNotNull(order.getId());
	}

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
//		Order order = new Order();
//		order.getItems().add(new Item());
//		entityManager.persist(order);
//		entityManager.flush();
//		// Otherwise the query returns the existing order (and we didn't set the
//		// parent in the item)...
//		entityManager.clear();
//		Order other = (Order) entityManager.find(Order.class, order.getId());
//		assertEquals(1, other.getItems().size());
//		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
//		Order order = new Order();
//		Item item = new Item();
//		item.setProduct("foo");
//		order.getItems().add(item);
//		entityManager.persist(order);
//		entityManager.flush();
//		// Otherwise the query returns the existing order (and we didn't set the
//		// parent in the item)...
//		entityManager.clear();
//		Order other = (Order) entityManager
//				.createQuery("select o from Order o join o.items i where i.product=:product").setParameter("product",
//						"foo").getSingleResult();
//		assertEquals(1, other.getItems().size());
//		assertEquals(other, other.getItems().iterator().next().getOrder());
	}

}
