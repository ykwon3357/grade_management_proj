package org.comstudy21.model;

import static org.comstudy21.resource.R.scan;
import static org.comstudy21.resource.R.viewArr;

public class Dao {
	public static final int MAX = 100;
	private int seq = 1;
	private int top = 0;
	private Dto[] dtoArr = new Dto[MAX];
	private int num=0;

//	{
//		dtoArr[top++]=new Dto(seq++,"kim",90,92,91);
//		dtoArr[top++]=new Dto(seq++,"you",80,85,90);
//		dtoArr[top++]=new Dto(seq++,"kim",100,95,100);
//		dtoArr[top++]=new Dto(seq++,"lee",70,60,87);
//		dtoArr[top++]=new Dto(seq++,"kang",90,70,80);
//	}
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
		dtoArr[top].setGrade(dto.getGrade());
		dtoArr[top].setIdx(seq++);
		//dtoArr[top].setRank(top+1);
		top++;
		
		sortdown();

		System.out.println("입력 완료!");
	}

	public void sortdown() {
		/*
		for (int i = 0; i < top; i++) {
			dtoArr[i].setRank(i + 1);
		}
		int temp=0;
		        for (int i = 0; i < top - 1; i++) {
		            for (int j = i+1; j < top; j++){
		                if (dtoArr[i].getAvg() < dtoArr[j].getAvg()) {
		                    temp=dtoArr[i].getRank();
		                    dtoArr[i].setRank(dtoArr[j].getRank());
		                    dtoArr[j].setRank(temp);
		                }
		            }
		        }
		        */
		// 평균에 따라 등수 내림차순 정렬
		     
		Dto temp = new Dto();
		;
		for (int i = 0; i < top - 1; i++) {
			for (int j = i + 1; j < top; j++) {
				if (dtoArr[i].getAvg() < dtoArr[j].getAvg()) {
					temp = dtoArr[i];
					dtoArr[i] = dtoArr[j];
					dtoArr[j] = temp;
				}
			}
		}

		for (int i = 0; i < top; i++) {
			dtoArr[i].setRank(i + 1);
		}

		// 중복 등수 처리
		// 1 22 3위
		// 평균이 같으면 뒤에 등수를 앞 등수로, 그 뒤 등수들은 당겨준다
		for (int i = 0; i < top - 1; i++) {
			for (int j = i + 1; j < top; j++) {
				if (dtoArr[i].getTot() == dtoArr[j].getTot()) {
					dtoArr[j].setRank(dtoArr[i].getRank());
//					for (int k = j + 1; k < top; k++) {
//						dtoArr[k].setRank(dtoArr[k - 1].getRank() + 1);
//					}
				}
			}
		}
	}

	public void sortIdxUp() {
		// idx 오름차순 정렬
		Dto temp = new Dto();
		;
		for (int i = 0; i < top - 1; i++) {
			for (int j = i + 1; j < top; j++) {
				if (dtoArr[i].getIdx() > dtoArr[j].getIdx()) {
					temp = dtoArr[i];
					dtoArr[i] = dtoArr[j];
					dtoArr[j] = temp;
				}
			}
		}

	}

	public void sortIdxDown() {
		// idx 내림차순 정렬
		Dto temp = new Dto();
		;
		for (int i = 0; i < top - 1; i++) {
			for (int j = i + 1; j < top; j++) {
				if (dtoArr[i].getIdx() < dtoArr[j].getIdx()) {
					temp = dtoArr[i];
					dtoArr[i] = dtoArr[j];
					dtoArr[j] = temp;
				}
			}
		}

	}

	public Dto[] selectAll() {
		System.out.print("랭킹순(1) 최신순(2) 오래된 순(3): ");
		int num = 0;
			try {
				num = Integer.parseInt(scan.next());
				if(num < 1 || num > 3) {
					System.out.println("해당 사항 없습니다!");
					selectAll();
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못 입력했습니다!");
				selectAll();
			}
		
		if (num == 2) {
			sortIdxDown();
		} else if (num == 3) {
			sortIdxUp();
		}
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
		Dto[] newArr = new Dto[top];
		int cnt = 0;
		for (int i = 0; i < top; i++) {
			if (dtoArr[i].getName().toUpperCase().equals(dto.getName().toUpperCase())) {
				newArr[cnt] = new Dto();
				newArr[cnt].setIdx(dtoArr[i].getIdx());
				newArr[cnt].setName(dtoArr[i].getName());
				newArr[cnt].setKor(dtoArr[i].getKor());
				newArr[cnt].setEng(dtoArr[i].getEng());
				newArr[cnt].setMath(dtoArr[i].getMath());
				newArr[cnt].setTot(dtoArr[i].getTot());
				newArr[cnt].setAvg(dtoArr[i].getAvg());
				newArr[cnt].setGrade(dtoArr[i].getGrade());
				newArr[cnt].setRank(dtoArr[i].getRank());
				cnt++;
			}
		}
		Dto[] arr = new Dto[cnt];
		for (int i = 0; i < cnt; i++) {
			arr[i] = newArr[i];
		}
		return arr;
	}

	public void update(Dto dto) {
		boolean flag = false;
		for (int i = 0; i < top; i++) {
			if (dtoArr[i].getIdx() == dto.getIdx()) {
				if (!dto.getName().equals("n"))
					dtoArr[i].setName(dto.getName());
				if (dto.getKor() != 0)
					dtoArr[i].setKor(dto.getKor());
				if (dto.getEng() != 0)
					dtoArr[i].setEng(dto.getEng());
				if (dto.getMath() != 0)
					dtoArr[i].setMath(dto.getMath());
				flag = true;
				break;
			}
		}

		if (!flag) {
			//System.out.println("수정 실패!");
		} else {
			//System.out.println("수정 성공!");
			sortdown();
		}

	}

	public void delete(Dto dto) {
		boolean flag = false;
		for (int i = 0; i < top; i++) {
			if (dtoArr[i].getIdx() == dto.getIdx()) {
				for (int j = i; j < top - 1; j++) {
					dtoArr[j] = dtoArr[j + 1];
				}
				dtoArr[--top] = null;
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println("삭제 실패!");
		} else {
			System.out.println("삭제 성공!");
			sortdown();
		}

	}

}
