package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Update implements View {
	private String name="";
	private int kor,eng,math;

	@Override
	public void display() {
		if (data.dtoArr.length == 0) {
			return;
		}
		System.out.println(updateTitle);
		System.out.print("수정할 학번 입력: ");
		int idx=0;;
		try {
			idx = Integer.parseInt(scan.next());
		} catch (NumberFormatException e) {
		}
		boolean flag = false;
		for (int i = 0; i < data.dtoArr.length; i++) {
			if (data.dtoArr[i].getIdx() == idx) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("잘못된 학번을 입력했습니다!");
			data.dto = new Dto(0, null, 0, 0, 0);
		} else {
			System.out.println("수정할 사항을 선택하세요");
			
			int num=0;
			do {
				System.out.print("이름(1) 국어(2) 영어(3) 수학(4) 완료(5): ");
					num = scan.nextInt();
					switch (num) {
					case 1:
						System.out.print("새 이름: ");
						name = scan.next();
						break;
					case 2:
						System.out.print("새 국어: ");
						kor = scan.nextInt();
						break;
					case 3:
						System.out.print("새 영어: ");
						eng = scan.nextInt();
						break;
					case 4:
						System.out.print("새 수학: ");
						math = scan.nextInt();
						break;
					}
			}while(num!=5);
			System.out.println("수정완료!");
			if(name.equals("")) name="n";
			data.dto = new Dto(idx, name, kor, eng, math);
		}
	}

}
