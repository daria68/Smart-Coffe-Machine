package com.ip.CaffeMachine.Response;

import java.util.Objects;

public class DrinkResponse {

	private String title;
	private Double temperature;
	private Double sugar;
	private String liquid;
	private String description;
	
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



	@Override
	public int hashCode() {
		return Objects.hash(title, temperature, sugar, liquid, description);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DrinkResponse that = (DrinkResponse) o;
		return Objects.equals(title, that.title) && Objects.equals(temperature, that.temperature) && Objects.equals(sugar, that.sugar) && Objects.equals(liquid, that.liquid) && Objects.equals(description, that.description);
	}
}
