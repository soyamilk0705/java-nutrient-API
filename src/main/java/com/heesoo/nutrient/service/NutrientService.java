package com.heesoo.nutrient.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.heesoo.nutrient.dto.NutrientDTO;
import com.heesoo.nutrient.mapper.NutrientMapper;

@Service
public class NutrientService {
	
	@Autowired
	private NutrientMapper nutrientMapper;

	public void insert(MultipartFile file, String extension) {
		Workbook workbook = null;
		InputStream inputStream = null;
		
		try {
			// xlsx : Excel2007 이상의 파일 형식 -> XSSFWorkbook() 사용
			// xls : Excel2003 이하의 파일 형식 -> HSSFWorkbook()  사용
			inputStream = file.getInputStream();
			
			if(extension.equals("xlsx")) {
				workbook = new XSSFWorkbook(inputStream);
			} else if (extension.equals("xls")) {
				workbook = new HSSFWorkbook(file.getInputStream());
			}

			Sheet worksheet = workbook.getSheetAt(0);
			
			for(int i=1; i<worksheet.getPhysicalNumberOfRows(); i++) {
				Row row = worksheet.getRow(i);
				
				NutrientDTO nutrientDTO = new NutrientDTO();
				
				nutrientDTO.setId(row.getCell(1).getStringCellValue());
				nutrientDTO.setFoodCd(row.getCell(2).getStringCellValue());
				nutrientDTO.setGroupName(row.getCell(3).getStringCellValue());
				nutrientDTO.setFoodName(row.getCell(5).getStringCellValue());
				nutrientDTO.setResearchYear(Integer.parseInt(row.getCell(6).getStringCellValue()));
				nutrientDTO.setMakerName(row.getCell(7).getStringCellValue());
				nutrientDTO.setRefName(row.getCell(98).getStringCellValue());
				nutrientDTO.setServingSize(row.getCell(11).getStringCellValue());
				nutrientDTO.setCalorie(row.getCell(15).getStringCellValue());
				nutrientDTO.setCarbohydrate(row.getCell(19).getStringCellValue());
				nutrientDTO.setProtein(row.getCell(17).getStringCellValue());
				nutrientDTO.setProvince(row.getCell(18).getStringCellValue());
				nutrientDTO.setSugars(row.getCell(20).getStringCellValue());
				nutrientDTO.setSalt(row.getCell(33).getStringCellValue());
				nutrientDTO.setCholesterol(row.getCell(67).getStringCellValue());
				nutrientDTO.setSaturatedFattyAcids(row.getCell(68).getStringCellValue());
				nutrientDTO.setTransFat(row.getCell(92).getStringCellValue());
				
				nutrientMapper.insertData(nutrientDTO);
				
			}
			
			System.out.println("생성 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
}
