package com.heesoo.nutrient.dto;

import lombok.Data;

@Data
public class NutrientDTO {
	private String id;										// 번호-SAMPLE_ID(1)
	private String foodCd;								// 식품코드-식품코드(2)
	private String groupName;						// 식품군-DB군(3)
	private String foodName;							// 식품이름-식품명(5)
	private String researchYear;							// 조사년도-연도(6)
	private String makerName;						// 지역/제조사-지역 / 제조사(7)
	private String refName;							// 자료출처-성분표출처(98)
	private String servingSize;						// 1회 제공량-1회제공량(11)
	private String calorie;								// 열랑(kcal)(1회제공량당)-에너지(15)
	private String carbohydrate;					// 탄수화물(g)(1회제공량당)-탄수화물(g)(19)
	private String protein;							// 단백질(g)(1회제공량당)-단백질(g)(17)
	private String province;							// 지방(g)(1회제공량당)-지방(g)(18)
	private String sugars;								// 총당류(g)(1회제공량당)-총당류(g)(20)
	private String salt;									// 나트륨(mg)(1회제공량당)-나트륨(㎎)(33)
	private String cholesterol;						// 콜레스테롤(mg)(1회제공량당)-콜레스테롤(mg)(67)
	private String saturatedFattyAcids;			// 포화 지방산(g)(1회제공량당)-총 포화 지방산(g)(68)
	private String transFat;							// 트랜스 지방(g)(1회제공량당)-트랜스 지방산(g)(92)
	
	// 정밀한 계산과 오차를 최소화하며 안정적인 연산을 위해 float 보다 double을 사용
	
}
