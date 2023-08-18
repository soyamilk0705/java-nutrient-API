package com.heesoo.nutrient.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.heesoo.nutrient.dto.NutrientDTO;

@Mapper
public interface NutrientMapper {
	void insertData(NutrientDTO nutrientDTO);
	List<NutrientDTO> search(Map<String, Object> map);
}
