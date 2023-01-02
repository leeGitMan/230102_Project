package edu.kh.assignment.model.vo;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.assignment.book.Book;

public class Service {
	
	static int count = 0;
	
	
	
	Scanner sc = new Scanner(System.in);
	
	private List<Book>bookList = new ArrayList<Book>();
	private List<Book>favoriteList = new ArrayList<Book>();
	
	
	
	
	
	public void displayMenu() {
		
		
		int menuNum = 0;
		
		
		try {
			
			do {
				
				System.out.println("===== 메뉴 선택 =====");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 조회");
				System.out.println("3. 도서 수정");
				System.out.println("4. 도서 삭제");
				System.out.println("5. 모든 도서 삭제하기");
				System.out.println("6. 모든 도서 정보 조회");
				System.out.println("7. 도서 목록 내보내기");
				System.out.println("8. 즐겨찾기 등록");
				System.out.println("9. 즐겨찾기 목록 내보내기");
				System.out.println("0. 프로그램 종료");
				
				menuNum = sc.nextInt();
				sc.nextLine();
				
				
				switch(menuNum) {
				case 1 : System.out.println(addBook()); break;
				case 2 : System.out.println(selectBook()); break;
				case 3 : System.out.println(updateBook()); break;
				case 4 : System.out.println(deleteBook()); break;
				case 5 : System.out.println(deleteAllBook()); break;
				case 6 : System.out.println(allBookInfo()); break;
				case 7 : outBook(); break;
				case 8 : System.out.println(addFavoriteBook()); break;
				case 9 : favoriteBook(); break;
				case 0 : System.out.println("프로그램 종료");break; 
				
				}
				
				
				
			}while(menuNum != 0);
			
		}catch(InputMismatchException e) {
			
			System.out.println("유효하지 않은 입력");
			e.printStackTrace();
			menuNum = -1;
			
			
		}
		
	}
	
	
	public String addBook() {
		
		
		System.out.println("==== 책 등록 페이지 ====");
		System.out.println();
		
		System.out.println("책을 등록 하시겠습니까?(Y/N)");
		char ch = sc.next().toUpperCase().charAt(0);
		
		if(ch == 'Y') {
			// 도서 제목
			System.out.print("도서 제목 : ");
			String bookName = sc.next();
			
			// 작가
			System.out.print("작가 명 : ");
			String author = sc.next();
			
			// 가격
			System.out.print("가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			//책 번호
			System.out.print("책 번호 : ");
			int bookNum = sc.nextInt();
			sc.nextLine();
			
			
			// 도서 출판사
			System.out.print("출판사 : ");
			String company = sc.next();
			
			if(bookList.add(new Book(bookName, author, price, bookNum, company))) {
				return "책 등록 성공";
			}
			else {
				return "책 등록 실패";
			}
		}
		else {
			return "책 등록 종료";
		}
	}
	
	
	// 도서 조회
	
	public String selectBook() {
		
		System.out.println("===== 책 조회 페이지 =====");
		System.out.println();
		System.out.println();
		
		System.out.println("조회 하고 싶은 책 제목을 입력하세요");
		
		String input = sc.next();
		
		String result = "책 정보가 없는데용?"; 
		
		// 인풋 값과 조회
		
		if(bookList.isEmpty()) {
			return result;
		}
		else {
			for(Book bok : bookList) {
				if(bok.getBookName().equals(input)) {
					return bok.toString();
				}
			}
		}
		return "성공";
	}
	
	public String updateBook() {
		
		System.out.println(" ==== 책 수정 페이지 ==== ");
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("수정 하고 싶은 책 제목 인덱스 입력.");
		int index = sc.nextInt();
		sc.nextLine();
		
		if(bookList.isEmpty()) { // 조건 까먹지 말고 두기
			return "수정할 책들이 없는데용?";
		}
		else if(index < 0) {
			return "인덱스 값은 마이너스가 될 수 없습니다.";
		}
		else if(index > bookList.size()) {
			return "인덱스 범위가 초과 되었습니다.";
		}
		else {
			
			System.out.print("책 제목 변경 : ");
			String bookName = sc.next();
			
			System.out.print("작가 입력 : ");
			String author = sc.next();
			
			System.out.print("가격 입력 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.print("책 번호 : ");
			int bookNum = sc.nextInt();
			sc.nextLine();
			
			System.out.print("출판사 입력 : ");
			String company = sc.next();
			
			// set 은 기존의 값을 반환하기에 기존의 값을 받을 변수 하나 선언
			// 타입은 북
			
			Book asd = bookList.set(index, new Book(bookName,author,price,bookNum,company));
			
			return asd + "의 정보가 변경되었습니다.";
		}
					
			
	}
	
	
	public String deleteBook() {
		
		System.out.println("==== 책 삭제 페이지 ====");
		
		System.out.println();
		System.out.println();
		
		System.out.println(" 삭제하고 싶은 책 인덱스 번호를 입력하세요. ");
		int index = sc.nextInt();
		sc.nextLine();
		
		System.out.println(" 책 정말 삭제 할까요?(Y/N) ");
		char ch = sc.next().toUpperCase().charAt(0);
		
		
		if(bookList.isEmpty()) {
			return "수정할 책들이 없는데용?";
		}
		else if(index < 0) {
			return "인덱스 값은 마이너스가 될 수 없습니다.";
		}
		else if(index > bookList.size()) {
			return "인덱스 범위가 초과 되었습니다.";
		}
		else {
			if( ch == 'Y') {
				Book temp = bookList.remove(index);
				return  temp + "의 책이 삭제 되었습니다.";
			}
			else {
				return " 책 삭제가 실패되었습니다.";
			}
		}
		
		
//		if(ch=='Y') {
//			Book temp = bookList.remove(index);
//			return temp + "의 책이 삭제 되었습니다.";
//		}else {
//			return " 책 삭제가 실패되었습니다. ";
//		}
		
	}
	
	public String deleteAllBook() {
		
		System.out.println(" ====  책 전부 삭제하기 ==== ");
		
		System.out.println();
		System.out.println();
		
		System.out.println("책을 정말로 전부 다 삭제할까요?(Y/N)");
		char ch = sc.next().toUpperCase().charAt(0);
		
		
		
		if(bookList.isEmpty()) {
			return " 책 리스트가 비어있습니다.";
		}
		else {
			if( ch =='Y') { // clear 반환타입이.................void ㅇㅇ
				bookList.clear();
				return "모두 삭제되었습니다.";
				
			}
			else {
					return "삭제 하기 아깝죠..";
			}
		}
	}
	
	
	public String allBookInfo() {
		
		System.out.println(" ==== 등록된 모든 도서 출력 ==== ");
		System.out.println();
		System.out.println();
		
		
		if(bookList.isEmpty()) { // 빈 도서 있는지 없는지 먼저 조회
			return "등록된 책이 없습니다.";
		}else {
			for(Book bok : bookList) {
				return bok.toString();
			}
		}
		return "";
	}
	
	
	public void outBook() { 
		
		
		
		FileWriter fos = null;
		
		try {
			if(bookList.isEmpty()) {
				System.out.println("책들이 없습니다.");
				
			}
			else {
				fos = new FileWriter("text.txt", true);
				
				String a = bookList.toString();
				System.out.println(" ===== 2조 도서목록 ===== ");
				
				
				for(int i = 0; i < a.length(); i++) {
					System.out.println();
					fos.write(a.charAt(i));
				}
			}
		}catch(IOException e) {
			
			System.out.println("예외 발생");
			e.printStackTrace();
			
		}finally {
			
			try {
				System.out.println("도서 목록 등록 성공!");
				fos.close();
			}catch(IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
	public String addFavoriteBook() {
		
		System.out.println("==== 즐겨찾기 등록 페이지 ====");
		System.out.println();
		allBookInfo();
		
		
		System.out.println("즐겨찾기를 원하는 도서 제목을 입력하세요.");
		
		String result = "안됨";
			
		System.out.print("도서 제목 : ");
		String bookName = sc.next();
		
		for(int i = 0 ; i < bookList.size(); i++) {
			
//			System.out.println(bookList.get(i).getBookName());
			
			if(bookName.equals(bookList.get(i).getBookName())){
				favoriteList.add(bookList.get(i));
				result = "성공!";
			}else {
				result = "도서가 없는데용";
			}
		}return result;
		
	}
			
			
		
	
	
	public void favoriteBook() {
		
		
		
		FileWriter fos = null;
		
		try {
			if(favoriteList.isEmpty()) {
				System.out.println("책들이 없습니다.");
			}
			else {
				fos = new FileWriter("favorite Book.txt", true);
				
				System.out.println("즐찾 리스트에 내보낼 책 번호 입력 : ");
				int bookNum = sc.nextInt();
				
				Collections.sort(favoriteList, new Comparator<Book>() {
				    
						@Override
						public int compare(Book o1, Book o2) {
							  return o1.getBookNum() - o2.getBookNum();
						}
				 });
				 
				System.out.println(" ===== 2조 즐찾목록 ===== ");
				 for(Book bok : favoriteList) {
					 if(bok.getBookNum() == bookNum) {
						 String a = bok.information();
						 
						 for(int i = 0; i < a.length(); i++) {
							 fos.write(a.charAt(i));
						 }
					 }
				 }
			}
		}
		catch(IOException e) {
			
			System.out.println("예외 발생!");
			e.printStackTrace();
			
		}
		finally{
			
			try {
				System.out.println("즐겨 찾기 등록 성공!");
				fos.close();
			}
			catch(IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
