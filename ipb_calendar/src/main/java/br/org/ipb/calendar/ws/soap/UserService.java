package br.org.ipb.calendar.ws.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import br.org.ipb.calendar.business.UserBO;
import br.org.ipb.calendar.model.User;

@WebService
@Stateless
public class UserService {

	@EJB
	private UserBO userBO;
	
	public void save(User user) {
		userBO.save(user);
	}

	public List<User> listAll() {
		return userBO.listAll();
	}
}
