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
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
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
