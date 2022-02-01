package com.ip.CaffeMachine.Response;

import java.time.LocalTime;
import java.util.Objects;

public class ProgramResponse {

	private LocalTime startingTime;
	private String day;
	private RecipeResponse recipe;
	private DrinkResponse drink;
	
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
	public DrinkResponse getDrink() {
		return drink;
	}
	public void setDrink(DrinkResponse drink) {
		this.drink = drink;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProgramResponse that = (ProgramResponse) o;
		return Objects.equals(startingTime, that.startingTime) && Objects.equals(day, that.day) && Objects.equals(recipe, that.recipe) && Objects.equals(drink, that.drink);
	}

	@Override
	public int hashCode() {
		return Objects.hash(startingTime, day, recipe, drink);
	}
}
