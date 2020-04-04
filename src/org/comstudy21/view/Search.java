package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Search implements View {

	@Override
	public void display() {
		System.out.println(searchTitle);
		data.dto=new Dto();
		System.out.print("검색할 이름 입력: ");
		data.dto.setName(scan.next());
	}
	public void display(Dto[] arr) {
		if(arr.length==0) {
			System.out.println("검색결과 없습니다!");
			return;
		}
		for(Dto d :arr) {
			System.out.println(d);
		}
	}

}
