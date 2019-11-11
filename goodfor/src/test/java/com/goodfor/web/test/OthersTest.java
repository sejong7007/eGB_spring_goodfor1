package com.goodfor.web.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OthersTest {

	public static void main(String[] args) {
		
		for (int i = 0 ; i<10 ; i++) {
			
			List<String> lastName = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
			        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
			        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
			        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
			        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
			List<String> name = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
			        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
			        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
			        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
			        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
			        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
			        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
			        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
			        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
			        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
			 Collections.shuffle(lastName);
			 Collections.shuffle(name);
			 System.out.println(lastName.get(0)+name.get(0)+name.get(1));
			
			/*List<String> smallLetter = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			        "r", "s", "t", "u", "v", "w", "x", "y", "z");
			List<String> capitalLetter = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			        "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
			List<String> number = Arrays.asList("1","2","3","4","5","6","7","8","9","0");
			List<String> email = Arrays.asList("naver.com","daum.net","gmail.com","hotmail.com");
			 Collections.shuffle(smallLetter);
			 Collections.shuffle(capitalLetter);		 
			 Collections.shuffle(number);
			 Collections.shuffle(email);
			 		 
			 String frontEmail = smallLetter.get((int)(Math.random()*26))+
					 			 smallLetter.get((int)(Math.random()*26))+
					 			 smallLetter.get((int)(Math.random()*26)) +
					 			 smallLetter.get((int)(Math.random()*26))+
					 			 number.get(0);
			 
			 System.out.println(frontEmail+"@"+email.get(0));*/
			
		
			/*//int phoneNum1 = (int)(Math.random() * 10000) ;
			//int phoneNum2 = (int)(Math.random() * 10000) ;	
			int maxBirthYear = 90;
			int minBirthYear = 60;
			int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        int iMinMonth = 1;
	        int iMaxMonth = 12;
	        int iRandomYear = (int)(Math.random()*maxBirthYear- minBirthYear+1) + minBirthYear;
	        int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
	        //int iRandomDay = (int)(Math.random() * maxDays[iRandomMonth-1] + 1);
	        int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);
	        System.out.println(String.format("%02d월 %02d일",iRandomMonth,iRandomDay));*/
	       
		}
		
		
		/*List<String> smallLetter = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
		        "r", "s", "t", "u", "v", "w", "x", "y", "z");
		List<String> capitalLetter = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
		        "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
		List<String> number = Arrays.asList("1","2","3","4","5","6","7","8","9","0");
		 Collections.shuffle(smallLetter);
		 Collections.shuffle(capitalLetter);		 
		 Collections.shuffle(number);
		 		 
		 String newId = smallLetter.get((int)(Math.random()*26))+
				 		smallLetter.get((int)(Math.random()*26))+
				 		smallLetter.get((int)(Math.random()*26)) +
				 		smallLetter.get((int)(Math.random()*26))+
				 		number.get(0);
		 
		 System.out.println(newId);*/
		
	}

}
