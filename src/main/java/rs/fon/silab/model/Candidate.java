package rs.fon.silab.model;

public class Candidate {
	private final long id;
	private final String firstName;
	private final String lastName;
	private final Double ptsSchool;
	private final Double ptsExam;
	private final Double ptsTotal;

	public Candidate(long id, String firstName, String lastName, Double ptsSchool, Double ptsExam, Double ptsTotal) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ptsSchool = ptsSchool;
		this.ptsExam = ptsExam;
		this.ptsTotal = ptsTotal;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Double getPtsSchool() {
		return ptsSchool;
	}

	public Double getPtsExam() {
		return ptsExam;
	}

	public Double getPtsTotal() {
		return ptsTotal;
	}

}
