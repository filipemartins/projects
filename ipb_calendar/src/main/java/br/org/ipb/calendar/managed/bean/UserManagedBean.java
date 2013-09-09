package br.org.ipb.calendar.managed.bean;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.org.ipb.calendar.dao.UserDAO;
import br.org.ipb.calendar.model.User;

@ManagedBean
@SessionScoped
public class UserManagedBean {

	@EJB
	UserDAO userDAO;

	private User user;
	private DataModel<User> listUsers;
	
	public void addUser(ActionEvent actionEvent) {
		userDAO.save(user);
	}
	
	public void updateUser(ActionEvent actionEvent) {
		userDAO.update(user);
	}
	
	public String deleteUser(ActionEvent actionEvent) {
		userDAO.delete(user);
		return "index";
	}
	
	public DataModel<User> listAll() {
		listUsers = new ListDataModel(userDAO.listAll());
		return listUsers;
	}
}
