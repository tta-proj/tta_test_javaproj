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
    
    //////////�ɹ� �ʵ�
    
    private JLabel Title_Label;
    private JTable tableArea;
    private JScrollPane scrollArea;
    
    //////////UI�ɹ� �ʵ�
    
    public ShowAll_Todo() {//������
    	//this.win = win;
    	Container con = getContentPane();
    	con.setBackground(Color.WHITE);
    	setSize(750,650);
    	setLayout(null);
    	
    	JPanel Label = new JPanel();
    	JPanel Table = new JPanel();
    	
    	////////////////////////////////////////////////////////////Title Label
    	Title_Label=new JLabel("��ü TO do LIST");
    	Title_Label.setFont(new Font("HY�߰��",Font.BOLD,30));
    	Title_Label.setForeground(new Color(0,32,96));
    	Title_Label.setOpaque(true); // �󺧿� ������������ ���������� �ؾ��Ѵ�
    	Title_Label.setBackground(Color.WHITE);
    	Label.add(Title_Label);
    	add(Label);
    	Label.setBackground(Color.WHITE);
    	Label.setBounds(220,70,300,50);
    	
    	////////////////////////////////////////////////////////////TableArea
    	String ColumnNames[] = {"����","TO do","���� ����","���� ������","�Ϸ� ����"};
    	
    	
    	DefaultTableModel model = new DefaultTableModel(ColumnNames,0) { // table ���� ���� �Ұ�
    		 public boolean isCellEditable(int rowIndex, int mColIndex) {
    	        	return false;
    	        }
    	};
    	tableArea = new JTable(model);
    	scrollArea = new JScrollPane(tableArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //��ũ�� �߰�
    	
    	
    	scrollArea.setPreferredSize(new Dimension(650,400)); // table ũ������ 
    	Table.setBounds(0,150,735,500); 
    	
        tableArea.getTableHeader().setReorderingAllowed(false); // table �Ӽ��� �̵� ����
        
        
        tableArea.setAutoCreateRowSorter(true); // �÷� �����ϱ� ���  
        
        JTableHeader header = tableArea.getTableHeader(); // ��� ���� ����
        header.setBackground(new Color(0,32,96));
        header.setForeground(Color.white); 
        
		//header.setReorderingAllowed(false);
		header.setResizingAllowed(false); // �� ��� �ʺ����� ����
        
        header.setFont(new Font("�������",Font.BOLD,15));
        tableArea.setFont(new Font("�������",Font.PLAIN,15)); //����� �� �� ��Ʈ�� ũ�⼳��
        
        header.setPreferredSize(new Dimension(100,25)); // �����������
        tableArea.setRowHeight(30); // ����������
        
        tableArea.getColumnModel().getColumn(0).setPreferredWidth(100); // ���ʺ�����
        tableArea.getColumnModel().getColumn(1).setPreferredWidth(150);
        tableArea.getColumnModel().getColumn(2).setPreferredWidth(50);
        tableArea.getColumnModel().getColumn(3).setPreferredWidth(50);
        tableArea.getColumnModel().getColumn(4).setPreferredWidth(50); 
        
       
        
        DefaultTableCellRenderer CR = new DefaultTableCellRenderer(); // �� ��� ����
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