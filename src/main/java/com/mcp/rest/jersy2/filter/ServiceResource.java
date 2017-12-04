
package com.mcp.rest.jersy2.filter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcp.rest.jersy2.service.UserService;

@Path("/service")
@Component
public class ServiceResource {

	private static final String text = "Message from Server :%s ";

	@Autowired
	private UserService userService;
	

	@GET
	@Path("{name}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getMsg(@PathParam("name") String name) {
		String response = String.format(text, name);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
