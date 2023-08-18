package com.heesoo.nutrient.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.heesoo.nutrient.dto.NutrientDTO;
import com.heesoo.nutrient.service.NutrientService;

import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController를 사용하면 주로 API 엔드포인트를 만들 때 사용하게 됩니다.
// RESTful API를 구현하는 데 특화되어 있어 JSON 또는 XML과 같은 데이터를 반환합니다.
// 그러나 HTML 화면을 렌더링하고 보여주려면 @Controller 어노테이션을 사용하는 것이 적합합니다.
@RestController
@Tag(name="API", description="Sample API 입니다.")
public class NutrientApiController {
	
	@Autowired
	private NutrientService nutrientService;
	
	@PostMapping("/insert")
	public void insertData(@RequestParam("file") MultipartFile file) throws IOException {
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
	
		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			throw new IOException("엑셀 파일만 업로드 해주세요.");
		} 
		
		nutrientService.insert(file, extension);
	}
	
	// food_name : 식품이름, research_year : 연도(YYYY), maker_name : 지역/제조사, food_code : 식품코드
	@GetMapping("/search")
	public List<NutrientDTO> search(@RequestParam(name = "foodName", required = false) String foodName, 
														@RequestParam(name = "researchYear", required = false) String researchYear, 
														@RequestParam(name = "makerName", required = false) String makerName, 
														@RequestParam(name = "foodCode", required = false) String foodCode,
														@RequestParam Integer page) {
		
		return nutrientService.search(foodName, researchYear, makerName, foodCode, page);
	
	}
	
	
	
}
