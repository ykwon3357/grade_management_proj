package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Input implements View {

	@Override
	public void display() {
		System.out.println(inputTitle);
		data.dto=new Dto();
		System.out.print("성명 입력: ");
		data.dto.setName(scan.next());
		System.out.print("국어 입력: ");
		data.dto.setKor(scan.nextInt());
		System.out.print("영어 입력: ");
		data.dto.setEng(scan.nextInt());
		System.out.print("수학 입력: ");
		data.dto.setMath(scan.nextInt());
		
	}

}
