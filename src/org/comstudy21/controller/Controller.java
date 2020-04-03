package org.comstudy21.controller;
import static org.comstudy21.resource.R.*;
public class Controller {
	public static void search(){
		
	}
	public static void service(){
			viewArr[0].display();
		switch(data.no){
		case 1:
			viewArr[data.no].display();
			dao.insert(data.dto);
			break;
		case 2:
			data.dtoArr=dao.selectAll();
			viewArr[data.no].display();
			break;
		case 3:
			search();
			break;
		case 4:
			viewArr[data.no].display();
			break;
		case 5:
			viewArr[data.no].display();
			break;
		case 6:
			System.out.println("프로그램 종료!");
			System.exit(0);
			default:
				System.out.println("해당 메뉴 없습니다!");
		}
		service();
	}
}
