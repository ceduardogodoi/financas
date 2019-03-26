package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JpaUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();

		Conta conta = em.find(Conta.class, 1);

		conta.setTitular("João");
		conta.setAgencia("456");
		System.out.println(conta.getTitular());

		em.getTransaction().commit();
		em.close();

		EntityManager em2 = new JpaUtil().getEntityManager();
		em2.getTransaction().begin();

		conta.setTitular("Leonardo1");
		em2.merge(conta);

		em2.getTransaction().commit();
		em2.close();
	}

}
