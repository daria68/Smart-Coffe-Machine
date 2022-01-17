package com.ip.CaffeMachine.Models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user; //primary key

    private String username;
    private String password;

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
