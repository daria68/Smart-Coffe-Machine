package com.ip.CaffeMachine.Models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coffe_recipes")
public class CoffeRecipeEntity {
	
	String title;
	String description;
	ArrayList ingredients;
	@Id 
	Long id;
	
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
	public ArrayList getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList ingredients) {
		this.ingredients = ingredients;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
