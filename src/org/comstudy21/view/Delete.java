package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Delete implements View {

	@Override
	public void display() {
		Dto[] arr = (Dto[])mapper.get("search[]");
		if(arr.length==0) {
			return;
		}
		System.out.println(deleteTitle);
		System.out.print("삭제할 학번 입력: ");
		int idx = scan.nextInt();
		boolean flag = false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].getIdx()==idx) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("잘못된 학번을 입력했습니다!");
			Dto dto=new Dto(0,null,0,0,0);
			mapper.put("delete", dto);
		}else {
			Dto dto=new Dto(idx,null,0,0,0);
			mapper.put("delete", dto);
		}
	}

}
