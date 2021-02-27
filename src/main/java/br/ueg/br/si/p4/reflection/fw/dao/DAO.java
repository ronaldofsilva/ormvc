package br.ueg.br.si.p4.reflection.fw.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


public class DAO<T> {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("financeiro");
	
	@PersistenceContext
	private EntityManager em = emf.createEntityManager();
	
	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	public void adiciona(T t) {		
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		//em.close();
	}

	public void remove(T t) {		
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		
	}

	public void atualiza(T t) {		
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();		
	}

	public List<T> listaTodos(Class<T> classe) {		
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).getResultList();
		em.close();

		return lista;
	}

	public T buscaPorId(Long id) {		
		T instancia = em.find(classe, id);		
		return instancia;
	}

	public int contaTodos() {
		
		long result = (Long) em.createQuery("select count(n) from conta c").getSingleResult();
		em.close();
		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		//EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));
		List<T> lista = em.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
		em.close();
		return lista;
	}

	/*
	 * public List<?> getLista(T t) {
	 * 
	 * List<?> movies = entityManager.
	 * createQuery("SELECT movie from  movie where movie.language = ?1")
	 * .setParameter(1, "English") .getResultList(); return movies; Session session
	 * = HibernateUtil.getSessionFactory().openSession();
	 * 
	 * CriteriaBuilder cb = session.getCriteriaBuilder(); CriteriaQuery<?> cr =
	 * cb.createQuery(t.getClass()); Root<?> root = cr.from(t.getClass());
	 * cr.multiselect(root); Query<?> query = session.createQuery(cr); List<?>
	 * results = query.getResultList(); return results;
	 * 
	 * 
	 * 
	 * }
	 *

	public List<?> getLista(T t) {

		TypedQuery<?> query = entityManager.createQuery("from", t.getClass());
		List<?> list = query.getResultList();
		return list;
		/*
		 * Session session = HibernateUtil.getSessionFactory().openSession();
		 * 
		 * return session.getSession().createCriteria(classs).list();
		 */
	

}
