package com.clc.maven.GitSample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

import javax.print.DocFlavor.INPUT_STREAM;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	private static final String FILE_NAME ="D:emp.xlsx";
	
	
public static List<Emp> excleRead() throws IOException{
	FileInputStream outputStream = new FileInputStream(FILE_NAME);
	XSSFWorkbook workBook = new XSSFWorkbook(outputStream);
	XSSFSheet sheet = workBook.getSheet("empInfo");
	Iterator<Row> rows = sheet.rowIterator();
	List<Emp> listOfEmps = new ArrayList<Emp>();
	boolean headerRow = true;
	
	while(rows.hasNext()){
			
			Row row =rows.next();
			if(headerRow){
				headerRow=false;
				continue;
			}
		Emp emp = new Emp();
			
				Iterator<Cell> cells = row.cellIterator();
					int count = 1;
					while(cells.hasNext()){
						Cell cell = cells.next();
						if(cell.getCellType() == 0){
							if(count==1){
									emp.setEmpId((int)cell.getNumericCellValue());
							}else if(count==3){
								emp.setEmpAge((int)cell.getNumericCellValue());
							}
							count++;
						}else if(cell.getCellType() == 1){
							if(count==2){
								emp.setEmpName(cell.getStringCellValue());
							}else if(count==4){
								emp.setEmpAddress(cell.getStringCellValue());
							}
								count++;
						}
								
					}
					listOfEmps.add(emp);
	}
	//workBook.close();
	return listOfEmps;
}
	
	

public static void excleWrite(Set<Emp> setOfEmps) throws IOException{
	XSSFWorkbook workBook = new XSSFWorkbook();
	XSSFSheet sheet = workBook.createSheet("empInfo");
	XSSFRow row = sheet.createRow(0);
	
	XSSFCell idCell = row.createCell(0);
	XSSFCell nmCell =row.createCell(1);
	XSSFCell ageCell =row.createCell(2);
	XSSFCell addressCell =row.createCell(3);
	
	idCell.setCellType(CellType.NUMERIC);
	ageCell.setCellType(CellType.NUMERIC);
	nmCell.setCellType(CellType.STRING);
	addressCell.setCellType(CellType.STRING);
	
	idCell.setCellValue("Emp_ID");
	nmCell.setCellValue("Emp_NAME");
	ageCell.setCellValue("Emp_AGE");
	addressCell.setCellValue("Emp_ADDRESS");
	
	int rowCount =1;
	for(Emp emp : setOfEmps){
		row = sheet.createRow(rowCount);
		idCell = row.createCell(0);
		nmCell =row.createCell(1);
		ageCell =row.createCell(2);
		addressCell =row.createCell(3);
		
		idCell.setCellType(CellType.NUMERIC);
		ageCell.setCellType(CellType.NUMERIC);
		nmCell.setCellType(CellType.STRING);
		addressCell.setCellType(CellType.STRING);
		
		idCell.setCellValue(emp.getEmpId());
		nmCell.setCellValue(emp.getEmpName());
		ageCell.setCellValue(emp.getEmpAge());
		addressCell.setCellValue(emp.getEmpAddress());
		rowCount++;
	}
	FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
	workBook.write(outputStream);
    workBook.close();
    
    System.out.println("EmpInfo Written into an Excel...!");
}
	
	
	
}


