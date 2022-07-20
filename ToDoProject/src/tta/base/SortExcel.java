package tta.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SortExcel {
	public void sort(String FilePath, String FileName) {
		try {	
			FileInputStream inputStream = new FileInputStream(FilePath + FileName);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Row row; 
			Row NextRow = sheet.getRow(0);
			Cell NextCell = NextRow.getCell(0);
			NextCell = NextRow.getCell(0);
			// Subject_List.xlsx ����
			// ���� ���� ��ȸ
			Cell cell;
			for(int searchRow = 1; searchRow < sheet.getPhysicalNumberOfRows();searchRow++) {
				row = sheet.getRow(searchRow);
				cell = row.getCell(0);
				// Row�� ù��° Cell�� �����̸� ���� ������ �ƴ� Row ã��
				System.out.println("cell : " + cell.getStringCellValue());
				
				if (cell.getStringCellValue() == ""){
					System.out.println("���� row �߰�");
					for(int NextRowNum = searchRow; NextRowNum < sheet.getPhysicalNumberOfRows(); NextRowNum++) {
						// ������ ��� ���� ������ �ƴ� �� ã��
						NextRow = sheet.getRow(NextRowNum);
						NextCell = NextRow.getCell(0);
						if(NextCell.getStringCellValue() != "") {
							// ���� ������ �ƴ� ���� �����̿��� ���� �̵�
							System.out.println("������ �ƴ� ���� row �߰� �� �̵�");
							for(int r = 0; r <row.getPhysicalNumberOfCells(); r++) {
								NextCell = NextRow.getCell(r);
								row.getCell(r).setCellValue(NextCell.getStringCellValue());
								NextCell.setCellValue("");
							}
							break;
						}
					}
				}
			}
			// ���� ���� ���̱�
			for(int i=0; i < sheet.getPhysicalNumberOfRows() ; i++) {
				row = sheet.getRow(sheet.getLastRowNum());
				cell = row.getCell(0);
				if(cell.getStringCellValue() == "") {
					sheet.removeRow(row);
				}
				else {
					break;
				}	
			}
		
			FileOutputStream outFile;
			outFile = new FileOutputStream(FilePath + "Subject_List.xlsx");
			workbook.write(outFile);	
			outFile.close();
			workbook.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} 	
		
	}
}
