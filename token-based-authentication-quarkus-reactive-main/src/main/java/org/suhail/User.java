package org.suhail;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import lombok.*;


// @ToString 
// @EqualsAndHashCode(callSuper = false)
@Entity
// @Cacheable
public class User  extends PanacheEntityBase{

    @Id
    @GeneratedValue
    public long id;
	public String username;
	public String password;
    public String roles;

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	// this is just an example, you can load the user from the database (via PanacheEntityBase)
	public static Uni<User> findByUsername(String username,String password) {

		//if using Panache pattern (extends or PanacheEntity PanacheEntityBase)
		//return find("username", username).firstResult();

        // find("username",name).firstResult();
		
		// String userUsername = "user";

		//generated from password encoder
		// String userPassword = "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=";

		// String adminUsername = "admin";

		// //generated from password encoder
		// String adminPassword = "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=";
		
		// if (name.equals(userUsername)) {
		// 	return new User(userUsername, userPassword, "USER");
		// } else if (name.equals(adminUsername)) {
		// 	return new User(adminUsername, adminPassword, "ADMIN");
		// } else {
		// 	return null;
		// }
		Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
       // find("email = :email and password = :password", params).firstResult().onItem().transform(item->System.out.println(item));
        return find("username = :username and password = :password", params).firstResult();
        // return find("email", email).firstResult();
	}

}
