package com.ip.CaffeMachine.Models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class RecipeEntity {
	
	@Id 
	private Long id;
	private String title;
	private String description;
	private ArrayList<String> ingredients;
	
	@OneToOne(mappedBy = "recipe")
    private DrinkEntity drink;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DrinkEntity getDrink() {
		return drink;
	}
	public void setDrink(DrinkEntity drink) {
		this.drink = drink;
	}
	
}
