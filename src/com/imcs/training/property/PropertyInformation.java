package com.imcs.training.property;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PropertyInformation {

	private int custID;
	private String name;
	private String address;
	private double taxAmount;
	private LocalDate fillingDate;

}
