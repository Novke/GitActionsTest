package rs.fon.silab.service;

import rs.fon.silab.model.InsuranceType;

public interface InsuranceService {
	int calculateInsurance(int age, InsuranceType type, boolean previousAccidents);
}
