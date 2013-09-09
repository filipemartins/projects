package br.org.ipb.calendar.ws.rs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.org.ipb.calendar.business.UserBO;
import br.org.ipb.calendar.model.User;

@Path("/user")
@Stateless
public class UserRestService {

	@EJB
	private UserBO userBO;

	public void save(User user) {
		userBO.save(user);
	}

	@GET
	@Path("/listAll")
	public List<User> listAll() {
		return userBO.listAll();
	}

	public List<User> listAll2() {
		return userBO.listAll();
	}
}
