package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JpaUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo order by m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		List<Movimentacao> resultado = query.getResultList();
		for (Movimentacao movimentacao : resultado) {
			System.out.println("Descri��o: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
	}

}
