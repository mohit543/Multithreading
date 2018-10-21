package com.incs.training.validator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imcs.training.property.PropertyInformation;
import com.imcs.trng.database.PropertyDatabase;

public class PropertyInformationValidator {
	public void getValidProperty(List<PropertyInformation> list) throws SQLException {
		PropertyDatabase db = new PropertyDatabase();
		for (PropertyInformation li : list) {
			if (li.getTaxAmount() > 1000) {
				db.saveProperty(li);
			}

		}

	}

	public List<PropertyInformation> getinvalidList(List<PropertyInformation> list) {
		List<PropertyInformation> invalidList = new ArrayList<>();

		for (PropertyInformation li : list) {
			if (li.getTaxAmount() < 1000) {
				invalidList.add(li);
			}
		}
		return invalidList;
	}

}
