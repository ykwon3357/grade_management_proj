package org.comstudy21.view;

import org.comstudy21.model.Dto;

public class Output implements View {

	
	@Override
	public void display() {
		
		if(((Dto[])mapper.get("output")).length==0){
			System.out.println("출력할 데이터가 없습니다!");
			return;
		}
		System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
		System.out.println(outputTitle);
	 	for(Dto d: (Dto[])mapper.get("output")){
			System.out.println(d);
		}
	 	System.out.println("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――");
	}
}


