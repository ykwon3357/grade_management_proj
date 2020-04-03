package org.comstudy21.model;

public class Dao {
	public static final int MAX = 100;
	private int seq = 1;
	private int top = 0;
	private Dto[] dtoArr = new Dto[MAX];

	private Dao() {

	}

	public static Dao instance;

	public static Dao getInstance() {
		if (instance == null) {
			instance = new Dao();
		}
		return instance;
	}

	public void insert(Dto dto) {
		if (top >= MAX) {
			System.out.println("더 이상 입력 불가합니다!");
			return;
		}
		dtoArr[top] = dto;
		dtoArr[top].setIdx(seq++);
		dtoArr[top].setTot(dto.getKor() + dto.getEng() + dto.getMath());
		dtoArr[top].setAvg(Math.round((dto.getTot() / 3.0) * 10) / 10.0);
		switch ((int) dto.getAvg() / 10) {
		case 10:
		case 9:
			dtoArr[top].setGrade("A");
			break;
		case 8:
			dtoArr[top].setGrade("B");
			break;
		case 7:
			dtoArr[top].setGrade("C");
			break;
		case 6:
			dtoArr[top].setGrade("D");
			break;
		default:
			dtoArr[top].setGrade("F");
		}

		dtoArr[top].setRank(top + 1);
		//System.out.println(dtoArr[top].getRank());
		
		top++;
		System.out.println(">>>>>> 정렬 전");
		int temp=0;
		for (int i = 0; i < top - 1; i++) {
			for (int j = i+1; j < top; j++){
				if (dtoArr[i].getAvg() < dtoArr[j].getAvg()) {
					System.out.println("랭크교체!");
					temp=dtoArr[i].getRank();
					dtoArr[i].setRank(dtoArr[j].getRank());
					dtoArr[j].setRank(temp);
				}
			}
		}
		System.out.println(">>>>>> 정렬 후");
		
		System.out.println("입력 완료!");

	}

	public Dto[] selectAll() {
		Dto[] newArr = new Dto[top];
		for (int i = 0; i < top; i++) {
			newArr[i] = new Dto();
			newArr[i].setIdx(dtoArr[i].getIdx());
			newArr[i].setName(dtoArr[i].getName());
			newArr[i].setKor(dtoArr[i].getKor());
			newArr[i].setEng(dtoArr[i].getEng());
			newArr[i].setMath(dtoArr[i].getMath());
			newArr[i].setTot(dtoArr[i].getTot());
			newArr[i].setAvg(dtoArr[i].getAvg());
			newArr[i].setGrade(dtoArr[i].getGrade());
			newArr[i].setRank(dtoArr[i].getRank());

		}
		return newArr;
	}

	public Dto[] select(Dto dto) {
		return null;
	}

	public void update(Dto dto) {

	}

	public void delete(Dto dto) {

	}

}
