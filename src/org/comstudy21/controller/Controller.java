package org.comstudy21.controller;
import static org.comstudy21.resource.R.*;

import org.comstudy21.model.Dto;
import org.comstudy21.view.Search;
public class Controller {
	public static void search(){
		viewArr[3].display();
		mapper.put("search[]", dao.select((Dto)mapper.get("search")));
		((Search)viewArr[3]).display((Dto[])mapper.get("search[]"));
		
	}
	public static void service(){
			viewArr[0].display();
			int no=(Integer)mapper.get("menu");
		switch(no){
		case 1:
			viewArr[no].display();
			dao.insert((Dto)mapper.get("input"));
			break;
		case 2:
			mapper.put("output", dao.selectAll());
			viewArr[no].display();
			break;
		case 3:
			search();
			break;
		case 4:
			search();
			viewArr[no].display();
			Dto dto = (Dto)mapper.get("update");
			if(dto.getIdx()!=0) {
				dao.update(dto);
			}
			break;
		case 5:
			search();
			viewArr[no].display();
			dto = (Dto)mapper.get("delete");
			if(dto.getIdx()!=0) {
				dao.delete(dto);
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
