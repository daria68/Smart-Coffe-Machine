package com.ip.CaffeMachine.Request;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DayIntervalRequest {

	@DateTimeFormat(iso = ISO.TIME)
	@JsonFormat(pattern = "HH:mm")
	private LocalTime dayStart;
	
	@DateTimeFormat(iso = ISO.TIME)
	@JsonFormat(pattern = "HH:mm")
	private LocalTime dayEnd;
	
	public LocalTime getDayStart() {
		return dayStart;
	}
	public void setDayStart(LocalTime dayStart) {
		this.dayStart = dayStart;
	}
	public LocalTime getDayEnd() {
		return dayEnd;
	}
	public void setDayEnd(LocalTime dayEnd) {
		this.dayEnd = dayEnd;
	}
	
}
