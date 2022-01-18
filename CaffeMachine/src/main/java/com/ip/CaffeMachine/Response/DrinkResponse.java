package com.ip.CaffeMachine.Response;

public class DrinkResponse {

	String title;
	Double temperature;
	Double sugar;
	String liquid;
	String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
