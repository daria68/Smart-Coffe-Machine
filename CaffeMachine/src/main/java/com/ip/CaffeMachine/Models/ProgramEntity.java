package com.ip.CaffeMachine.Models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "programs")
public class ProgramEntity {

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //primary key
	private LocalDateTime starting_time;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id", referencedColumnName = "id")
	private RecipeEntity recipe;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personalized_drink_id", referencedColumnName = "id")
	// nullable e default true
	private RecipeEntity personalizedDrink;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "userId")
    private UserEntity user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getStarting_time() {
		return starting_time;
	}

	public void setStarting_time(LocalDateTime starting_time) {
		this.starting_time = starting_time;
	}

	public RecipeEntity getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
	}

	public RecipeEntity getPersonalizedDrink() {
		return personalizedDrink;
	}

	public void setPersonalizedDrink(RecipeEntity personalizedDrink) {
		this.personalizedDrink = personalizedDrink;
	}

}
