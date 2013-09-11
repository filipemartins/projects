package br.org.ipb.calendar.dao;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.org.ipb.calendar.model.User;

@Stateful
@Alternative
public class UserDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(User user) {
		em.persist(user);		
	}
	
	public void update(User user) {
		em.merge(user);
	}
	
	public void delete(User user) {
		em.remove(user);
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
