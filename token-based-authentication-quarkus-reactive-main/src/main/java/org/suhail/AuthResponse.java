package org.suhail;
import lombok.*;
@NoArgsConstructor  @ToString
public class AuthResponse {
	
	public String token;

    public AuthResponse(String token) {
        this.token = token;
        System.out.println("Token: "+token);
    }
    
}
