package com.ip.CaffeMachine.Request;

public class DrinkRequest {

	String title;
	Double temperature;
	Double sugar;
	String liquid;
	
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
}
