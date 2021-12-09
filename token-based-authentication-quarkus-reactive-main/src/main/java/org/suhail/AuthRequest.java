package org.suhail;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor 
@ToString
public class  AuthRequest {
	
	public String username;
	public String password;
}