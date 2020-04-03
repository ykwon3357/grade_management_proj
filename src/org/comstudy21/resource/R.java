package org.comstudy21.resource;

import java.util.Scanner;

import org.comstudy21.model.Dao;
import org.comstudy21.view.Delete;
import org.comstudy21.view.Input;
import org.comstudy21.view.Menu;
import org.comstudy21.view.Output;
import org.comstudy21.view.Search;
import org.comstudy21.view.Update;
import org.comstudy21.view.View;

public interface R {
	String appTitle="::::: 성적 관리 프로그램 :::::";
	String inputTitle="::: 입력 기능 :::";
	String outputTitle="::: 출력 기능 :::";
	String searchTitle="::: 검색 기능 :::";
	String updateTitle="::: 수정 기능 :::";
	String deleteTitle="::: 삭제 기능 :::";
	String[] menuArr={"","입력","출력","검색","수정","삭제","종료"};
	View[] viewArr={new Menu(),new Input(),new Output(),new Search(),new Update(),new Delete()};
	
	Scanner scan = new Scanner(System.in);
	
	Dao dao = Dao.getInstance();
	
	Data data= new Data();

}
