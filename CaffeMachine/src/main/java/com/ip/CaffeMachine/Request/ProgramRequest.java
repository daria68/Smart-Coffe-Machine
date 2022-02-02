package com.ip.CaffeMachine.Request;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ip.CaffeMachine.Models.DrinkEntity;


public class ProgramRequest {

	@DateTimeFormat(iso = ISO.TIME)
	@JsonFormat(pattern = "HH:mm")
	private LocalTime startingTime;
	private String day;
	private DrinkRequest drink;
	
	public LocalTime getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(LocalTime startingTime) {
		this.startingTime = startingTime;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public DrinkRequest getDrink() {
		return drink;
	}
	public void setDrink(DrinkRequest drink) {
		this.drink = drink;
	}
	
}
