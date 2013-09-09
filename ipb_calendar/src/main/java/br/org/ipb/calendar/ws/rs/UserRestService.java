package br.org.ipb.calendar.ws.rs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.org.ipb.calendar.business.UserBO;
import br.org.ipb.calendar.model.User;

@Path("/user")
@Stateless
public class UserRestService {

	@EJB
	private UserBO userBO;

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(User user) {
		userBO.save(user);
	}

	@GET
	@Path("/listAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listAll() {
		return userBO.listAll();
	}

}
