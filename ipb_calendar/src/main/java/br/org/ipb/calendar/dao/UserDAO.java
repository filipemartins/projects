package br.org.ipb.calendar.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.org.ipb.calendar.model.User;

@Stateless
public class UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(User user) {
		em.persist(user);		
	}
	
	public List<User> listAll() {
		Query query = em.createQuery("SELECT c FROM User c");
		List<User> list = query.getResultList();
				
		return list;		
	}
	
	public User getUser(long id) {
		return em.find(User.class, id);
	}
}
