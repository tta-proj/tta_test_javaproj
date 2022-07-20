package tta.pro;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.io.File;
import java.io.FileInputStream;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tta.base.Task;

public class ShowAll_Todo extends JFrame {
	String Todo,Done,Sub,VALUE;
	String Dead_day,Actual_day;
	XSSFRow row;
	XSSFCell cell;
    Boolean Is_import;
    File file;
    
    Task task = new Task();

    MainFrame win;
    
    //////////맴버 필드
    
    private JLabel Title_Label;
    private JTable tableArea;
    private JScrollPane scrollArea;
    
    //////////UI맴버 필드
    
    public ShowAll_Todo() {//생성자
    	//this.win = win;
    	Container con = getContentPane();
    	con.setBackground(Color.WHITE);
    	setSize(750,650);
    	setLayout(null);
    	
    	JPanel Label = new JPanel();
    	JPanel Table = new JPanel();
    	
    	////////////////////////////////////////////////////////////Title Label
    	Title_Label=new JLabel("전체 TO do LIST");
    	Title_Label.setFont(new Font("HY견고딕",Font.BOLD,30));
    	Title_Label.setForeground(new Color(0,32,96));
    	Title_Label.setOpaque(true); // 라벨에 색깔입히려면 불투명세팅을 해야한다
    	Title_Label.setBackground(Color.WHITE);
    	Label.add(Title_Label);
    	add(Label);
    	Label.setBackground(Color.WHITE);
    	Label.setBounds(220,70,300,50);
    	
    	////////////////////////////////////////////////////////////TableArea
    	String ColumnNames[] = {"과목","TO do","마감 기한","실제 마감일","완료 여부"};
    	
    	
    	DefaultTableModel model = new DefaultTableModel(ColumnNames,0) { // table 내용 수정 불가
    		 public boolean isCellEditable(int rowIndex, int mColIndex) {
    	        	return false;
    	        }
    	};
    	tableArea = new JTable(model);
    	scrollArea = new JScrollPane(tableArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //스크롤 추가
    	
    	
    	scrollArea.setPreferredSize(new Dimension(650,400)); // table 크기지정 
    	Table.setBounds(0,150,735,500); 
    	
        tableArea.getTableHeader().setReorderingAllowed(false); // table 속성들 이동 금지
        
        
        tableArea.setAutoCreateRowSorter(true); // 컬럼 정렬하기 기능  
        
        JTableHeader header = tableArea.getTableHeader(); // 헤더 색상 지정
        header.setBackground(new Color(0,32,96));
        header.setForeground(Color.white); 
        
		//header.setReorderingAllowed(false);
		header.setResizingAllowed(false); // 셀 헤더 너비조절 금지
        
        header.setFont(new Font("맑은고딕",Font.BOLD,15));
        tableArea.setFont(new Font("맑은고딕",Font.PLAIN,15)); //헤더와 각 셀 폰트와 크기설정
        
        header.setPreferredSize(new Dimension(100,25)); // 헤더높이조절
        tableArea.setRowHeight(30); // 셀높이조절
        
        tableArea.getColumnModel().getColumn(0).setPreferredWidth(100); // 셀너비조절
        tableArea.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableArea.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableArea.getColumnModel().getColumn(3).setPreferredWidth(50);
        tableArea.getColumnModel().getColumn(4).setPreferredWidth(50); 
        
       
        
        DefaultTableCellRenderer CR = new DefaultTableCellRenderer(); // 셀 가운데 정렬
        CR.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel CM = tableArea.getColumnModel();
        for(int i =0; i<CM.getColumnCount(); i++) {
        	CM.getColumn(i).setCellRenderer(CR);
        }
        
        Table.add(scrollArea);
        Table.setBackground(Color.WHITE);
        add(Table);
    	        
        List<Object[]> tasklist = task.ReadAllTodo();
        
        for(int i=0; i<tasklist.size(); i++)
        {
        	model.addRow(tasklist.get(i));
        }

		setVisible(true);	
    
    }
}