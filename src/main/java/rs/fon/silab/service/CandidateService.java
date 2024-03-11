package rs.fon.silab.service;

import rs.fon.silab.exception.ExamException;
import rs.fon.silab.model.Candidate;

public interface CandidateService {
	Double calculateTotal(Candidate candidate) throws ExamException;
}
