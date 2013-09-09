package br.org.ipb.calendar.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.org.ipb.calendar.dao.UserDAO;
import br.org.ipb.calendar.model.User;

@Stateless
public class UserBO {

	@EJB
	private UserDAO userDAO;

	public User getUserById(long id) {
		return userDAO.getUser(id);
	}

	public void save(User user) {
		userDAO.save(user);
	}

	public List<User> listAll() {
		return userDAO.listAll();
	}
}
