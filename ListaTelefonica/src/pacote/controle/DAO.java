package pacote.controle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pacote.modelo.Contato;
import pacote.persistence.Factory;

public class DAO {

	private EntityManager manager;
	
	
	/**
	 * Adicionar contato ao banco
	 * @param contato
	 */
	public void adicionar(Contato contato) {
		setManager(Factory.createEntityManagerFactory());
		getManager().getTransaction().begin();
		getManager().persist(contato);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	
	/**
	 * Atualizar um contato
	 * @param contato
	 * @return void
	 */
	public void atualizar(Contato contato){
		setManager(Factory.createEntityManagerFactory());
		getManager().getTransaction().begin();		
		getManager().merge(contato);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	
	/**
	 * Remover um contato
	 * @param id
	 * @return void
	 */
	public void remover(int id){
		setManager(Factory.createEntityManagerFactory());
		getManager().getTransaction().begin();		
		Contato c = getManager().find(Contato.class, id);	
		getManager().remove(c);
		getManager().getTransaction().commit();
		getManager().close();
	}
	
	
	/**
	 * Listar todos os contatos
	 * @return lista de contatos
	 */
	public List<Contato>listarTodos(){
		setManager(Factory.createEntityManagerFactory());
		Query q = getManager().createQuery("select c from Contato c");		
		return q.getResultList();
	}
	
	
	/**
	 * Busca um contato por id
	 * @param id
	 * @return
	 */
	public Contato buscarPorId(int id){
		setManager(Factory.createEntityManagerFactory());
		Contato c = getManager().find(Contato.class, id);
		getManager().close();
		return c;
	}
	
	
	/**
	 * Busca uma lista de contatos por nome
	 * @param nome
	 * @return
	 */
	public List<Contato>buscarPorNome(String nome){
		setManager(Factory.createEntityManagerFactory());
		Query q = getManager().createQuery("select c from Contato c where c.nome = :nome");
		q.setParameter("nome", nome);
		List<Contato>l = q.getResultList();
		
		System.out.println("lista de contatos");
		for (Contato contato : l) {
			System.out.println("metodo de busca");
			System.out.println(contato.toString());
		}
		return q.getResultList();
	}
	
	
	/*************************************************/
	
	public EntityManager getManager() {
		return manager;
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


}
