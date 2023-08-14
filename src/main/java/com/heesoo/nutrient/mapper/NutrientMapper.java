package com.heesoo.nutrient.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.heesoo.nutrient.dto.NutrientDTO;

@Mapper
public interface NutrientMapper {
	void insertData(NutrientDTO nutrientDTO);
}
