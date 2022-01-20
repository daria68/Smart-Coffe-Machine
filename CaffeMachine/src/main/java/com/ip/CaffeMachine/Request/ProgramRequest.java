package com.ip.CaffeMachine.Request;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ip.CaffeMachine.Models.PresonalizedDrinkEntity;


public class ProgramRequest {

	@DateTimeFormat(iso = ISO.TIME)
	@JsonFormat(pattern = "HH:mm")
	private LocalTime startingTime;
	
	private String day;
	private String recipeTitle = null; // optional
	private PresonalizedDrinkEntity personalizedDrink = null; //optional
	
	
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
	
	public String getRecipeTitle() {
		return recipeTitle;
	}
	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}
	public PresonalizedDrinkEntity getPersonalizedDrink() {
		return personalizedDrink;
	}
	public void setPersonalizedDrink(PresonalizedDrinkEntity personalizedDrink) {
		this.personalizedDrink = personalizedDrink;
	}
}
