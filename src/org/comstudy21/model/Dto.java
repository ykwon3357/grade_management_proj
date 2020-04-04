package org.comstudy21.model;

public class Dto {
	private int idx;
	private int kor,eng,math,tot,rank;
	private double avg;
	private String name;
	private String grade;
	
	public Dto(){
		
	}

	public Dto(int idx, String name, int kor, int eng, int math) {
		this.idx = idx;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return kor+eng+math;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return Math.round((this.getTot())/3.0)*10/10.0;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		switch ((int) this.getAvg() / 10) {
		case 10:
		case 9:
			grade="A";
			break;
		case 8:
			grade="B";
			break;
		case 7:
			grade="C";
			break;
		case 6:
			grade="D";
			break;
		default:
			grade="F";
		}
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Dto [idx=" + idx + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", tot=" + tot + ", avg=" + avg + ", rank=" + rank
				+ ", name=" + name + ", grade=" + grade + "]";
	}
	
	

}
