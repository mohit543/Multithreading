package com.imcs.training.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.imcs.training.property.PropertyInformation;
import com.incs.training.validator.PropertyInformationValidator;

public class FileLoadService implements FileLoadServiceApi {
	List<PropertyInformation> propertyInfo = new ArrayList<>();

	@Override
	public void loadFile(String fileName) {
		System.out.println("Started loading file... " + fileName);
		Reader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line = null;

			try {
				while ((line = br.readLine()) != null) {
					PropertyInformation property = parseLine(line);
					propertyInfo.add(property);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Completed loading file... " + fileName);

	}

	private static PropertyInformation parseLine(String line) {
		String[] tokens = line.split(",");
		PropertyInformation propertyInfo = new PropertyInformation(Integer.parseInt(tokens[0]), tokens[1], tokens[2],
				Double.parseDouble(tokens[3]), LocalDate.parse(tokens[4]));
		return propertyInfo;
	}

	public void inDB() {
		PropertyInformationValidator pv = new PropertyInformationValidator();
		try {
			pv.getValidProperty(propertyInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
