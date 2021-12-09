package org.suhail;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.config.inject.ConfigProperty;


import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

@Path("/hello")
public class userController {

	@Inject
	PBKDF2Encoder passwordEncoder;
	static String token;

	@ConfigProperty(name = "com.ard333.quarkusjwt.jwt.duration")
	public Long duration;
	@ConfigProperty(name = "mp.jwt.verify.issuer")
	public String issuer;

	@PermitAll
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	// @Blocking
	public Response login(AuthRequest authRequest) throws Exception {
		System.out.println("Request Recived....");
		// Uni<User> u = User.findByUsername(authRequest.username,
		// passwordEncoder.encode(authRequest.password));
		Uni<User> u = User.findByUsername(authRequest.username, authRequest.password);

		if (u != null) {
			try {
				u.onItem().transform(user -> {
					try {

						return TokenUtils.generateToken(user.username, user.roles, duration, issuer);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						return Response.status(Status.UNAUTHORIZED).build();
					}
				}

				).subscribe().with(item -> token =item.toString());

				// return Response.ok(u.onItem().invoke(user -> {
				// try {
				// System.out.println(""+user.username);
				// new AuthResponse(TokenUtils.generateToken(
				// user.username, user.roles, duration, issuer
				// // u.username, u.roles, duration, issuer
				// ));
				// } catch (Exception a) {
				// Response.status(Status.UNAUTHORIZED).build();
				// }
				// })).build();
			} catch (Exception e) {
				return Response.status(Status.UNAUTHORIZED).build();
			}
		} else {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		//Thread.sleep(1000);

		System.out.println("TOken === " + token);
		return Response.ok(token).build();
	}
	//  @Blocking
	public void setMethod(String obj) {
		// return Response.ok(obj).build();
		token = obj;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Uni<Response> addUser(User user) {

		if (user == null)
			throw new WebApplicationException("Details were not updated on request", 422);
		else {
			// user.password = passwordEncoder.encode(user.password);
			return Panache.withTransaction(user::persist).replaceWith(Response.ok(user).status(Status.CREATED)::build);
		}

	}

}