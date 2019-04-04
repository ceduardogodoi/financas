package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JpaUtil;

public class TesteInserirMovimentacao {

	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(2);

		Query query = em.createQuery("select m from Movimentacao m join m.conta c where m.conta = :pConta");
		query.setParameter("pConta", conta);

		List<Movimentacao> movimentacoes = query.getResultList();

		em.close();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Movimentação: " + movimentacao.getDescricao());
		}

	}

}
