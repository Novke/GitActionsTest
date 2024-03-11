package rs.fon.silab.service.impl;

import rs.fon.silab.exception.ExamException;
import rs.fon.silab.model.Candidate;
import rs.fon.silab.service.CandidateService;

public class CandidateServiceImpl implements CandidateService {

	@Override
	public Double calculateTotal(Candidate candidate) throws ExamException {
		if (candidate == null || candidate.getPtsSchool() == null || candidate.getPtsExam() == null) {
			throw new ExamException("Invalid Candidate Data!");
		}
		return candidate.getPtsSchool() * 4 + candidate.getPtsExam();
	}

}
