import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class QueryAnalyzer extends JFrame implements ActionListener
{
	JTextField txtDriver,txtUrl,txtUn,txtPwd;
	JTextArea	txtQuery,txtResult ;
	JLabel lblDriver,lblUrl,lblUn,lblPwd;
	JButton btnConnect,btnReset,btnExec,btnClear;
	JScrollPane scrR,scrQ;
	Connection conn=null;
	void createUI()
	{
		setLayout(new GridLayout(7,2));
		lblDriver = new JLabel("Enter Driver:");
		txtDriver =new JTextField(20);
		
		add(lblDriver);
		add(txtDriver);
		
		lblUrl = new JLabel("Enter URL:");
		txtUrl =new JTextField(20);

		add(lblUrl);
		add(txtUrl);

		lblUn= new JLabel("Enter User Name:");
		txtUn =new JTextField(20);
		
		add(lblUn);
		add(txtUn);

		lblPwd = new JLabel("Enter Password:");
		txtPwd =new JTextField(20);
		
		add(lblPwd);
		add(txtPwd);

		btnReset=new JButton("Reset");
		btnReset.addActionListener(this);
		btnConnect=new JButton("Connect");
		btnConnect.addActionListener(this);
		btnConnect.addActionListener(this);
		
		add(btnReset);
		add(btnConnect);

		txtQuery=new JTextArea(20,20);
		scrQ=new JScrollPane(txtQuery);
		add(scrQ);
	
		txtResult=new JTextArea(20,20);
		scrR=new JScrollPane(txtResult);
		add(scrR);

		btnExec=new JButton("Execute");
		btnExec.addActionListener(this);
		add(btnExec);

		btnClear=new JButton("Clear");
		btnClear.addActionListener(this);
		add(btnClear);
		}
	public void actionPerformed(ActionEvent ae)
	{
	String actionCmd=ae.getActionCommand();

	if(actionCmd.equals("Connect")){
	try{
	Class.forName(txtDriver.getText());
	JOptionPane.showMessageDialog(this,"Driver Loaded Successfully");
	conn=DriverManager.getConnection(txtUrl.getText(),txtUn.getText(),txtPwd.getText());
	JOptionPane.showMessageDialog(this,"Driver Loaded Successfully");
	
	

	}catch(Exception ex){
	ex.printStackTrace();
	
	}
	
	}
	}

QueryAnalyzer()
	{
		setTitle("My Query Analyzer");
		createUI();
		setSize(200,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new QueryAnalyzer();
	}
}