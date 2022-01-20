package com.ip.CaffeMachine.Response;

import java.time.LocalTime;

public class ProgramResponse {

	private LocalTime startingTime;
	private String day;
	private RecipeResponse recipe;
	private PersonalizedDrinkResponse personalizedDrink;
	
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
	public RecipeResponse getRecipe() {
		return recipe;
	}
	public void setRecipe(RecipeResponse recipe) {
		this.recipe = recipe;
	}
	public PersonalizedDrinkResponse getPersonalizedDrink() {
		return personalizedDrink;
	}
	public void setPersonalizedDrink(PersonalizedDrinkResponse personalizedDrink) {
		this.personalizedDrink = personalizedDrink;
	}
	
}
