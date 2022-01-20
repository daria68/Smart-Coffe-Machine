package com.ip.CaffeMachine.Response;

public class PersonalizedDrinkResponse {

	private String drinkTitle;
	private Double sugar;
	private String liquid;
	private Double temperature;
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
	
}
