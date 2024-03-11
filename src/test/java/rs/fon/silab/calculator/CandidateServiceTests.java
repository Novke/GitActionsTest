package rs.fon.silab.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvFileSource;

import rs.fon.silab.exception.ExamException;
import rs.fon.silab.model.Candidate;
import rs.fon.silab.service.CandidateService;
import rs.fon.silab.service.impl.CandidateServiceImpl;

public class CandidateServiceTests {
	private final CandidateService candidateService = new CandidateServiceImpl();

	@ParameterizedTest(name = "[{index}] {arguments}")
	@CsvFileSource(resources = "/mock_data.csv", useHeadersInDisplayName = true)
	public void calculateTotalsTest(long id, String firstName, String lastName, Double ptsSchool, Double ptsExam,
			Double ptsTotal) throws ExamException {
		Candidate candidate = new Candidate(id, firstName, lastName, ptsSchool, ptsExam, ptsTotal);
		Double total = candidateService.calculateTotal(candidate);
		assertEquals(candidate.getPtsTotal(), total);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/mock_data.csv", useHeadersInDisplayName = true)
	public void calculateTest(@AggregateWith(CandidateAggregator.class) Candidate candidate) throws ExamException {
		Double total = candidateService.calculateTotal(candidate);
		assertEquals(candidate.getPtsTotal(), total);
	}
}

class CandidateAggregator implements ArgumentsAggregator {

	@Override
	public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context)
			throws ArgumentsAggregationException {
		return new Candidate(accessor.getLong(0), accessor.getString(1), accessor.getString(2), accessor.getDouble(3),
				accessor.getDouble(4), accessor.getDouble(5));
	}

}
