package com.ip.CaffeMachine.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personalized_drinks")
public class PresonalizedDrinkEntity {

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; //primary key
	private String drinkTitle;
	private Double sugar;
	private String liquid;
	private Double temperature;
	
	@OneToOne(mappedBy = "personalizedDrink")
    private ProgramEntity program;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDrinkTitle() {
		return drinkTitle;
	}
	public void setDrinkTitle(String drinkTitle) {
		this.drinkTitle = drinkTitle;
	}
	public Double getSugar() {
		return sugar;
	}
	public void setSugar(Double sugar) {
		this.sugar = sugar;
	}
	public String getLiquid() {
		return liquid;
	}
	public void setLiquid(String liquid) {
		this.liquid = liquid;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public ProgramEntity getProgram() {
		return program;
	}
	public void setProgram(ProgramEntity program) {
		this.program = program;
	}
	
}
