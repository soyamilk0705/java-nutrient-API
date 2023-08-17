package com.heesoo.nutrient.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.heesoo.nutrient.dto.NutrientDTO;

@Mapper
public interface NutrientMapper {
	void insertData(NutrientDTO nutrientDTO);
	void search(@Param("foodName") String foodName, 
						@Param("researchYear") String researchYear, 
						@Param("makerName") String makerName, 
						@Param("foodCode") String foodCode);
}
