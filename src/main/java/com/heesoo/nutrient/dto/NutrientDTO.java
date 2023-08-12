package com.heesoo.nutrient.dto;

import lombok.Data;

@Data
public class NutrientDTO {
	private int id;											// 번호-NO(1)
	private String foodCd;								// 식품코드-식품코드(3)
	private String groupName;						// 식품군-DB군(4)
	private String foodName;							// 식품이름-식품명(6)
	private int researchYear;							// 조사년도-연도(7)
	private String makerName;						// 지역/제조사-지역 / 제조사(8)
	private String refName;							// 자료출처-성분표출처(99)
	private String servingSize;						// 1회 제공량-1회제공량(12)
	private double calorie;								// 열랑(kcal)(1회제공량당)-에너지(16)
	private double carbohydrate;					// 탄수화물(g)(1회제공량당)-탄수화물(g)(20)
	private double protein;							// 단백질(g)(1회제공량당)-단백질(g)(18)
	private double province;							// 지방(g)(1회제공량당)-지방(g)(19)
	private double sugars;								// 총당류(g)(1회제공량당)-총당류(g)(21)
	private double salt;									// 나트륨(mg)(1회제공량당)-나트륨(㎎)(34)
	private double cholesterol;						// 콜레스테롤(mg)(1회제공량당)-콜레스테롤(mg)(68)
	private double saturatedFattyAcids;			// 포화 지방산(g)(1회제공량당)-총 포화 지방산(g)(69)
	private double transFat;							// 트랜스 지방(g)(1회제공량당)-트랜스 지방산(g)(93)
	
	// 정밀한 계산과 오차를 최소화하며 안정적인 연산을 위해 float 보다 double을 사용
}
