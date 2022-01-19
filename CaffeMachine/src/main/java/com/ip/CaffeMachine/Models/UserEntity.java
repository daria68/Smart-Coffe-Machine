package com.ip.CaffeMachine.Models;

import java.time.LocalTime;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId; //primary key

    private String username;
    private String password;
    private LocalTime dayStart = LocalTime.of(5, 30);
	private LocalTime dayEnd = LocalTime.of(19, 0);
	
	@OneToMany(mappedBy="user")
    private Set<ProgramEntity> programs;

	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public LocalTime getDayStart() {
		return dayStart;
	}

	public void setDayStart(LocalTime dayStart) {
		this.dayStart = dayStart;
	}

	public LocalTime getDayEnd() {
		return dayEnd;
	}

	public void setDayEnd(LocalTime dayEnd) {
		this.dayEnd = dayEnd;
	}

	public Set<ProgramEntity> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<ProgramEntity> programs) {
		this.programs = programs;
	}

}
