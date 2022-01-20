package com.ip.CaffeMachine.Models;

import java.time.LocalTime;

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
    private Long id; //primary key
	private LocalTime startingTime;
	private String day;
	
	@OneToOne(cascade = CascadeType.MERGE) //MERGE != ON DELETE CASCADE - ALL
	@JoinColumn(name = "recipe_id", referencedColumnName = "id")
	private RecipeEntity recipe;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "personalized_drink_id", referencedColumnName = "id")
	// nullable e default true
	private PresonalizedDrinkEntity personalizedDrink;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName = "userId")
    private UserEntity user;

	public RecipeEntity getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
	}

	public PresonalizedDrinkEntity getPersonalizedDrink() {
		return personalizedDrink;
	}

	public void setPersonalizedDrink(PresonalizedDrinkEntity personalizedDrink) {
		this.personalizedDrink = personalizedDrink;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
