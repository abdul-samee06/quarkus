package org.suhail;

import lombok.*;
@NoArgsConstructor 
@ToString
public class Message {
	
	public String content;

    public Message(String content) {
        this.content = content;
    }
    
}