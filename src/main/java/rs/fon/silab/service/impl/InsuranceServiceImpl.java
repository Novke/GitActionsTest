package rs.fon.silab.service.impl;

import rs.fon.silab.model.InsuranceType;
import rs.fon.silab.service.InsuranceService;

public class InsuranceServiceImpl implements InsuranceService {

	@Override
	public int calculateInsurance(int age, InsuranceType type, boolean previousAccidents) {
		int total = 1000;
		if (age < 30 && type == InsuranceType.ECONOMY && !previousAccidents) {
			total -= 100;
		} else {
			if (previousAccidents || type == InsuranceType.PREMIUM) {
				total += 300;
			}
			if (age > 35 && age < 65) {
				total -= 100;
			}
		}
		return total;
	}

}
