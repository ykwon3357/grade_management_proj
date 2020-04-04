package org.comstudy21.controller;
import static org.comstudy21.resource.R.*;

import org.comstudy21.view.Search;
public class Controller {
	public static void search(){
		viewArr[3].display();
		data.dtoArr=dao.select(data.dto);
		((Search)viewArr[3]).display(data.dtoArr);
		
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
			search();
			viewArr[data.no].display();
			if(data.dto.getIdx()!=0) {
				dao.update(data.dto);
			}
			break;
		case 5:
			search();
			viewArr[data.no].display();
			if(data.dto.getIdx()!=0) {
				dao.delete(data.dto);
			}
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
