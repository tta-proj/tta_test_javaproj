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



public class Register_Todo extends JFrame{
	String[] Todo = {"","","",""};	
	String[] data = {"","","","","",""};
	String Subject_Name;
	private Todolist TD;
	
	Task t_list = new Task();
	
	
	Register_Todo(final String Subject_Name){
		this.Subject_Name = Subject_Name;
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	    JLabel Title_Label = new JLabel("To Do ���");
	    Title_Label.setFont(new Font("HY�߰��",Font.BOLD,30));
	    this.add(Title_Label);
	    
	    
	    JLabel Todo_Label = new JLabel("To do �� :");
	    Todo_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Todo_Label);
	    final JTextField Todo_text = new JTextField("�Է����ּ���");
	    this.add(Todo_text);
	        

	    JLabel Deadline_Label = new JLabel("���� ���� :");
	    Deadline_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Deadline_Label);
	    
	    String[] Dead_mon = {"","1","2","3","4","5","6","7","8","9","10","11","12"};
	    JComboBox Month_combo = new JComboBox(Dead_mon);
	    this.add(Month_combo);
	    
	    Month_combo.addActionListener(new ActionListener() {
	 	   public void actionPerformed(ActionEvent e) {
	 		   JComboBox <String> cb = (JComboBox)e.getSource();
	 		   Todo[0] =cb.getSelectedItem().toString();
	 	   };
	    });
	    
	    
	    
	    JLabel Month_Label = new JLabel("��");
	    Month_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Month_Label);
	    
	    
	    String[] Dead_day = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
	 		   "24","25","26","27","28","29","30","31"};
	    JComboBox Day_combo = new JComboBox(Dead_day);
	    this.add(Day_combo);
	    
	    Day_combo.addActionListener(new ActionListener() {
	 	   public void actionPerformed(ActionEvent e) {
	 		   JComboBox <String> cb = (JComboBox)e.getSource();
	 		   Todo[1] =cb.getSelectedItem().toString();
	 	   };
	    });
	     
	    
	    
	    
	    
	    JLabel day_Label = new JLabel("��");
	    day_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(day_Label);
	    
	    
	    JLabel Actual_Label = new JLabel("���� ������ :");
	    Actual_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Actual_Label);
	    
	    String[] Actual_mon = {"","1","2","3","4","5","6","7","8","9","10","11","12"};
	    JComboBox Month_Combo2 = new JComboBox(Actual_mon);
	    
	    Month_Combo2.addActionListener(new ActionListener() {
	 	   public void actionPerformed(ActionEvent e) {
	 		   JComboBox <String> cb = (JComboBox)e.getSource();
	 		   Todo[2]=cb.getSelectedItem().toString();
	 	   };
	    });
	    
	    this.add(Month_Combo2);
	    JLabel Month_Label2 = new JLabel("��");
	    Month_Label2.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Month_Label2);
	    
	    String[] Actual_day = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
	 		   "24","25","26","27","28","29","30","31"};
	            JComboBox Day_Combo2 = new JComboBox(Actual_day);
	            this.add(Day_Combo2);
	    
	    Day_Combo2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JComboBox <String> cb = (JComboBox)e.getSource();
	    		Todo[3]=cb.getSelectedItem().toString();
	        };
	      });
	    
	    JLabel day_Label2 = new JLabel("��");
	    day_Label2.setFont(new Font("�������",Font.BOLD,15));
	    this.add(day_Label2);
	    
	    
	    JLabel IsDone_Label = new JLabel("�Ϸ� ���� ");
	    IsDone_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(IsDone_Label);
	    
	    String[] Done = {"","�غ�","����","�Ϸ�"};
	    JComboBox Done_Combo = new JComboBox(Done);
	    this.add(Done_Combo);
	    
	    Done_Combo.addActionListener(new ActionListener() {
	 	   public void actionPerformed(ActionEvent e) {
	 		   JComboBox <String> cb = (JComboBox)e.getSource();
	 		   data[3]=cb.getSelectedItem().toString();
	 	   };
	    });
	    
	    JLabel Import_Label = new JLabel("�߿䵵 ");
	    Import_Label.setFont(new Font("�������",Font.BOLD,15));
	    this.add(Import_Label);
	    
	    String[] Import = {"","1", "2", "3" };
	    JComboBox Import_Combo = new JComboBox(Import);
	    this.add(Import_Combo);
	    
	    Import_Combo.addActionListener(new ActionListener() {
	 	   public void actionPerformed(ActionEvent e) {
	 		   JComboBox <String> cb = (JComboBox)e.getSource();
	 		   data [4]=cb.getSelectedItem().toString();
	 	   };
	    });
	 
	    
	    JButton Done_Button = new JButton("���");
	    JButton Cancel_Button = new JButton("���");
	    this.add(Done_Button);
	    this.add(Cancel_Button);
	    Done_Button.setBackground(Color.white);
	    Done_Button.setFont(new Font("�������",Font.BOLD,20));
	    Cancel_Button.setBackground(Color.white);
	    Cancel_Button.setFont(new Font("�������",Font.BOLD,20));
	    
	    this.setLayout(null);
	    
	    Title_Label.setBounds(230, 30, 450, 40);
	    Todo_Label.setBounds(80, 150, 450, 40);
	    Deadline_Label.setBounds(80, 250, 450, 40);
	    Actual_Label.setBounds(80, 350, 450, 40);
	    IsDone_Label.setBounds(80, 450, 450, 40);
	    Import_Label.setBounds(350, 450, 450, 40);
	    Month_Label.setBounds(280, 250, 450, 40);
	    day_Label.setBounds(450, 250, 450, 40);
	    Month_Label2.setBounds(280, 350, 450, 40);
	    day_Label2.setBounds(450, 350, 450, 40);	    
	    Done_Button.setBounds(180,650,130,30);
	    Cancel_Button.setBounds(360,650,130,30);	    
	    Todo_text.setBounds(180,150,350,40);	    
	    Month_combo.setBounds(180,250,80,40);
	    Day_combo.setBounds(350,250,80,40);
	    Month_Combo2.setBounds(180,350,80,40);
	    Day_Combo2.setBounds(350,350,80,40);
	    Done_Combo.setBounds(180,450,80,40);
	    Import_Combo.setBounds(430,450,80,40);
	    
	    Container c = this.getContentPane();
	    c.setBackground(Color.white);
	    
	    setSize(650,750);
       
 	
       Done_Button.addActionListener(new ActionListener(){
    	   	public void actionPerformed(ActionEvent arg0) {
    	   			
    	   			UIManager UI =new UIManager();
    	   			Color navy = new Color(0,32,96);
    	   			Font message = new Font("�������",Font.BOLD,20);
    	   			UI.put("OptionPane.messageForeground", navy);
    	   			UI.put("OptionPane.messageFont", message);
    	   			
    	   			data[0] = new String(Todo[0]+"��" + Todo[1]+"��");
    	   			data[1] = new String(Todo[2]+"��" + Todo[3]+"��");
    	   			data[2] = Todo_text.getText();
    	   			boolean Done = Boolean.FALSE;
    	   			data[5] = Subject_Name;
    			
    				if(Todo[0].equals("") || Todo[1].equals("") ||Todo[2].equals("") || Todo[3].equals("") ||data[2].equals("�Է����ּ���") || data[3].equals("") ||data[4].equals("") ) {
    					JOptionPane.showMessageDialog(null , "�ʼ� �Է� �����Դϴ�.", "�˸�", JOptionPane.INFORMATION_MESSAGE);
    					    					
    				}
    				else if(data[0].equals("2��30��") || data[0].equals("2��31��") || data[1].equals("2��30��") || data[1].equals("2��31��") ||
    						data[0].equals("4��31��") || data[1].equals("4��31��") || data[0].equals("6��31��") || data[1].equals("6��31��") ||
    						data[0].equals("9��31��") || data[1].equals("9��31��") || data[0].equals("11��31��")|| data[1].equals("11��31��")) {
    					JOptionPane.showMessageDialog(null , "��¥�� �ٽ� �������ּ���.", "�˸�", JOptionPane.INFORMATION_MESSAGE);
    				}
    				else Done = Boolean.TRUE;
    			
    				if(Done == Boolean.TRUE) {
    					
    				t_list.WriteTodo(data);
    				setVisible(false);
    				TD = new Todolist(Subject_Name);
    				TD.setVisible(true);
    			}
    	   	}		
   	   	
    	  });			

       
  
      Cancel_Button.addActionListener(new ActionListener(){
    	   	public void actionPerformed(ActionEvent arg0) {
    	   	setVisible(false);
    	   	TD = new Todolist(Subject_Name);
    	   	TD.setVisible(true);
    	   	  }
    	  });
 
 }
}