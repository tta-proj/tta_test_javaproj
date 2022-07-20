package tta.pro;


import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tta.base.Task;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



public class Change_Todo extends JFrame {
	String[] Todo = {"","","",""};	
	String[] data = {"","","","","",""};
	String Subject_Name;
	
	Task t_list = new Task();
	

	Change_Todo(final int SelectedRowNum,final String[] data,final String Subject_Name){
		this.Subject_Name = Subject_Name;
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    String[] Dead_day = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
		 		   "24","25","26","27","28","29","30","31"};
	    JComboBox Day_combo = new JComboBox(Dead_day);
	    this.add(Day_combo);
		    
		String[] Actual_day = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
			 		   "24","25","26","27","28","29","30","31"};
		JComboBox Day_Combo2 = new JComboBox(Actual_day);
		this.add(Day_Combo2);  
		
	    JLabel Todo_Label = new JLabel("To do �� :");
	    Todo_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Todo_Label);
	    
	    final JTextField Todo_text = new JTextField("�Է����ּ���");
	    this.add(Todo_text);
	   
	    JLabel Actual_Label = new JLabel("���� ������ :");
	    Actual_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Actual_Label);
	    
	    JLabel Title_Label = new JLabel("To Do ����");
	    Title_Label.setFont(new Font("HY�߰��",Font.BOLD,30));
	    this.add(Title_Label);
	    
	    String[] Done = {"","�غ�","����","�Ϸ�"};
	    final JComboBox Done_Combo = new JComboBox(Done);
	    this.add(Done_Combo);
	    
	    String[] Dead_mon = {"","1","2","3","4","5","6","7","8","9","10","11","12"};
	    JComboBox Month_combo = new JComboBox(Dead_mon);
	    this.add(Month_combo);
	          

	    JLabel Deadline_Label = new JLabel("���� ����:");
	    Deadline_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Deadline_Label);
	    
	   
	    
	    JLabel Month_Label = new JLabel("��");
	    Month_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Month_Label);
	    
	    Month_combo.addActionListener(new ActionListener() {
	 	   public void actionPerformed(ActionEvent e) {
	 		   JComboBox <String> cb = (JComboBox)e.getSource();
	 		   Todo[0] =cb.getSelectedItem().toString();
	 	   };
	    });
	    
    
	    Day_combo.addActionListener(new ActionListener() {
		 	   public void actionPerformed(ActionEvent e) {
		 		   JComboBox <String> cb = (JComboBox)e.getSource();
		 		   Todo[1] =cb.getSelectedItem().toString();
		 	   };
		    });
	    
	    
	    String[] Actual_mon = {"","1","2","3","4","5","6","7","8","9","10","11","12"};
	    JComboBox Month_Combo2 = new JComboBox(Actual_mon);

	    JLabel day_Label = new JLabel("��");
	    day_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(day_Label);
	    
	    JLabel Import_Label = new JLabel("�߿䵵 ");
	    Import_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Import_Label);
	    
	    Month_Combo2.addActionListener(new ActionListener() {
	 	   public void actionPerformed(ActionEvent e) {
	 		   JComboBox <String> cb = (JComboBox)e.getSource();
	 		   Todo[2]=cb.getSelectedItem().toString();
	 	   };
	    });
	    
	    
	    String[] Import = {"","1", "2", "3" };
	    final JComboBox Import_Combo = new JComboBox(Import);
	    this.add(Import_Combo);
	    
	    this.add(Month_Combo2);
	    JLabel Month_Label2 = new JLabel("��");
	    Month_Label2.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Month_Label2);
	    	   
	    JLabel IsDone_Label = new JLabel("�Ϸ� ���� ");
	    IsDone_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(IsDone_Label);
	    
	    Import_Combo.addActionListener(new ActionListener() {
		 	   public void actionPerformed(ActionEvent e) {
		 		   JComboBox <String> cb = (JComboBox)e.getSource();
		 		   data [4]=cb.getSelectedItem().toString();
		 	   };
		    });
	    
	     Day_Combo2.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent e) {
	         	JComboBox <String> cb = (JComboBox)e.getSource();
	         	Todo[3]=cb.getSelectedItem().toString();
	         };
	     });
	    JButton Cancel_Button = new JButton("���");
	    JLabel day_Label2 = new JLabel("��");
	    day_Label2.setFont(new Font("�������",Font.BOLD,15));
	    this.add(day_Label2);
	    
	    Cancel_Button.setFont(new Font("�������",Font.BOLD,20));
	    this.add(Cancel_Button);
	    
	    
	    Done_Combo.addActionListener(new ActionListener() {
	 	   public void actionPerformed(ActionEvent e) {
	 		   JComboBox <String> cb = (JComboBox)e.getSource();
	 		   data[3]=cb.getSelectedItem().toString();
	 	   };
	    });
	    
   
	    JButton Done_Button = new JButton("���� �Ϸ�");
	    Done_Button.setFont(new Font("�������",Font.BOLD,20));
	   
	    Container c = this.getContentPane();
	    c.setBackground(Color.white);
    
	    Cancel_Button.setBackground(Color.white);
	    Done_Button.setBackground(Color.white);
	    this.add(Done_Button);	    
	    this.setLayout(null);
	    Todo_Label.setBounds(80, 150, 450, 40);
	    Month_Label2.setBounds(280, 350, 450, 40);
	    Todo_text.setBounds(180,150,350,40);
	    Day_combo.setBounds(350,250,80,40);
	    Import_Label.setBounds(350, 450, 450, 40);
	    Done_Combo.setBounds(180,450,80,40);
	    Deadline_Label.setBounds(80, 250, 450, 40);
	    Month_Label.setBounds(280, 250, 450, 40);
	    day_Label.setBounds(450, 250, 450, 40);
	    Done_Button.setBounds(180,650,130,30);
	    day_Label2.setBounds(450, 350, 450, 40);
	    IsDone_Label.setBounds(80, 450, 450, 40);	    
	    Cancel_Button.setBounds(360, 650, 130, 30);
	    Actual_Label.setBounds(80, 350, 450, 40);
	    Month_combo.setBounds(180,250,80,40);	    
	    Month_Combo2.setBounds(180,350,80,40);	   
	    Day_Combo2.setBounds(350, 350, 80, 40);	    
	    Import_Combo.setBounds(430, 450, 80, 40);
		Title_Label.setBounds(230, 30, 450, 40);

		
	    setSize(650,750);
	    	
       Done_Button.addActionListener(new ActionListener(){
   	   	public void actionPerformed(ActionEvent arg0) {
   	   		 
   	   		UIManager UI =new UIManager();
   	   		data[0] = new String(Todo[0]+"��" + Todo[1]+"��");
			Font message = new Font("�������",Font.BOLD,20);
			UI.put("OptionPane.messageFont", message);
			data[2] = Todo_text.getText();
			data[4] = Import_Combo.getSelectedItem().toString();		
			boolean change = Boolean.FALSE;
			data[1] = new String(Todo[2]+"��" + Todo[3]+"��");
			UI.put("OptionPane.messageFont", message);
			data[3] = Done_Combo.getSelectedItem().toString();
   			Color navy = new Color(0,32,96);
   			UI.put("OptionPane.messageForeground", navy);
   			for(int i=0;i<1;i++) {
				if(Todo[i].equals("") || data[i+2].equals("�Է����ּ���") || data[i+4].equals("") || Todo[i+3].equals("") ||
						Todo[i+1].equals("") || data[i+3].equals("") ||Todo[i+2].equals("")) {
					JOptionPane.showMessageDialog(null , "�ʼ� �Է� �����Դϴ�.", "�˸�", JOptionPane.INFORMATION_MESSAGE);    									
				}
				else if(data[i].equals("2��30��") || data[i+1].equals("2��31��") || data[i].equals("4��31��") || data[i].equals("6��31��") || data[i].equals("9��31��") || data[i].equals("11��31��") ||
						data[i+1].equals("2��30��") || data[i].equals("2��31��") || data[i+1].equals("4��31��") || data[i+1].equals("6��31��") || data[i+1].equals("9��31��") || data[i+1].equals("11��31��")) {
					JOptionPane.showMessageDialog(null , "��¥�� �ٽ� �������ּ���.", "�˸�", JOptionPane.INFORMATION_MESSAGE);
				}
				else change = Boolean.TRUE;
   			}
   			
   			
   			if(change == Boolean.TRUE) {		
   				t_list.ReWriteTodo(SelectedRowNum, Subject_Name, data);
   				setVisible(false);
   				new Todolist(Subject_Name).setVisible(true);
   			}
   	   	}
   	   	
   	  });			
       
  
      Cancel_Button.addActionListener(new ActionListener(){
    	   	public void actionPerformed(ActionEvent arg0) {
    	   	setVisible(false);
    	   	new Todolist(Subject_Name).setVisible(true);
    	   	  }
    	  });
 
 }
}