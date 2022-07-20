package tta.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class User {

	Hashtable<String, String> userStaff = new Hashtable<String, String>();//
	
	String Todo,Done,Sub,VALUE;
	String Dead_day,Actual_day;
	XSSFRow row;
	XSSFCell cell;
    Boolean Is_import;
    File file;
    
    
    public Hashtable<String, String> getStaff()
    {
    	return userStaff;
    }
	
	public void ReadStaff()
	{
		String folder="./Subject_Dir/"; //���� ������ ����
		String file_name = "User_List.xlsx"; // ���� �����̸�
		File file=new File(folder);
		
		if(!file.isDirectory()) {
			System.out.println("�ش���丮�� �����ϴ�");
			System.exit(1);
		}
		
		if(!file.exists()) {
			System.out.println("�ش� ������ �����ϴ�");
			System.exit(1);
		}
		
	
		System.out.println(folder + file_name);
        try {
				FileInputStream inputStream = new FileInputStream(folder + file_name);
				XSSFWorkbook wb = new XSSFWorkbook(inputStream);
					
				//sheet�� ���

				int sheetCn = wb.getNumberOfSheets();

				for(int cn = 0; cn < sheetCn; cn++){

					//0��° sheet ���� ���
					XSSFSheet sheet = wb.getSheetAt(cn);
	
					//���� sheet���� rows�� ���
					int rows = sheet.getPhysicalNumberOfRows();
	
					//���� row���� ����� cell�� ���
					int cells = sheet.getRow(cn).getPhysicalNumberOfCells(); 
						
					for (int r = 1; r < rows; r++) { // ������ �ι�°�ٺ��� �ҷ���
						row = sheet.getRow(r); // row ��������
	
						if (row != null) {	
							for (int c = 0; c < cells; c++) {
								String temp_id = row.getCell(0).getStringCellValue();
								String temp_pw = row.getCell(1).getStringCellValue();
								
								userStaff.put(temp_id, temp_pw);
							}
						}
					}
				}
				
        } catch (Exception e) {

			e.printStackTrace();
		}
				
	}	
	
}
