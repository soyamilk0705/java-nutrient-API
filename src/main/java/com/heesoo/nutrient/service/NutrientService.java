package com.heesoo.nutrient.service;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NutrientService {

	public void insert(MultipartFile file, String extension) throws IOException {
		Workbook workbook = null;
		
		// xlsx : Excel2007 이상의 파일 형식 -> XSSFWorkbook() 사용
		// xls : Excel2003 이하의 파일 형식 -> HSSFWorkbook()  사용
		if(extension.equals("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		} else if (extension.equals("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}
		
		// Sheet 하나 가져오기
		Sheet worksheet = workbook.getSheetAt(0);
		
		System.out.println(worksheet.getRow(1).getCell(2).getStringCellValue());
		
//		for (int i=1; i<worksheet.getPhysicalNumberOfRows(); i++) {
//			Row row = worksheet.getRow(i);
//		}
	}
}
