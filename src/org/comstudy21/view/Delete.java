package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Delete implements View {

	@Override
	public void display() {
		if(data.dtoArr.length==0) {
			return;
		}
		System.out.println(deleteTitle);
		System.out.print("삭제할 학번 입력: ");
		int idx = scan.nextInt();
		boolean flag = false;
		for(int i=0;i<data.dtoArr.length;i++) {
			if(data.dtoArr[i].getIdx()==idx) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("잘못된 학번을 입력했습니다!");
			data.dto=new Dto(0,null,0,0,0);
		}else {
			data.dto=new Dto(idx,null,0,0,0);
		}
	}

}
