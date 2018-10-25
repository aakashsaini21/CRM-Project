import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Date;
import java.sql.*;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import java.sql.Statement;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class NewTicket extends JFrame {

	private JPanel contentPane;
	private JTextField namef;
	private JTextField subjectf;
	private JTextField customeridf;
	private JTextField orderidf;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField amtField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTicket frame = new NewTicket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public NewTicket() {
		setTitle("Incinque CRM");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 733);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFillDetails = new JLabel("Add Ticket");
		lblFillDetails.setForeground(new Color(253, 245, 230));
		lblFillDetails.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFillDetails.setBounds(253, 11, 119, 14);
		contentPane.add(lblFillDetails);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblName.setForeground(new Color(253, 245, 230));
		lblName.setBackground(new Color(0, 128, 0));
		lblName.setBounds(39, 43, 46, 23);
		contentPane.add(lblName);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblSubject.setForeground(new Color(253, 245, 230));
		lblSubject.setBackground(new Color(0, 128, 0));
		lblSubject.setBounds(39, 77, 46, 14);
		contentPane.add(lblSubject);
		
		JLabel lblCaseid = new JLabel("CustomerID");
		lblCaseid.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCaseid.setForeground(new Color(253, 245, 230));
		lblCaseid.setBackground(new Color(0, 128, 0));
		lblCaseid.setBounds(39, 170, 75, 14);
		contentPane.add(lblCaseid);
		
		JLabel lblOrderid = new JLabel("OrderID");
		lblOrderid.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblOrderid.setForeground(new Color(253, 245, 230));
		lblOrderid.setBackground(new Color(0, 128, 0));
		lblOrderid.setBounds(39, 201, 98, 14);
		contentPane.add(lblOrderid);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblType.setForeground(new Color(253, 245, 230));
		lblType.setBackground(new Color(0, 128, 0));
		lblType.setBounds(39, 232, 46, 14);
		contentPane.add(lblType);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPriority.setForeground(new Color(253, 245, 230));
		lblPriority.setBackground(new Color(0, 128, 0));
		lblPriority.setBounds(39, 257, 46, 26);
		contentPane.add(lblPriority);
		
		JLabel lblAgent = new JLabel("Plan");
		lblAgent.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblAgent.setForeground(new Color(253, 245, 230));
		lblAgent.setBackground(new Color(0, 128, 0));
		lblAgent.setBounds(39, 294, 46, 14);
		contentPane.add(lblAgent);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(253, 245, 230));
		lblDescription.setBackground(new Color(0, 128, 0));
		lblDescription.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDescription.setBounds(20, 396, 75, 14);
		contentPane.add(lblDescription);
		
		namef = new JTextField();
		namef.setBorder(null);
		namef.setFont(new Font("Tahoma", Font.PLAIN, 13));
		namef.setBackground(Color.WHITE);
		namef.setBounds(173, 43, 234, 20);
		contentPane.add(namef);
		namef.setColumns(10);
		
		subjectf = new JTextField();
		subjectf.setBorder(null);
		subjectf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		subjectf.setForeground(Color.BLACK);
		subjectf.setBackground(Color.WHITE);
		subjectf.setBounds(173, 74, 234, 20);
		contentPane.add(subjectf);
		subjectf.setColumns(10);
		
		customeridf = new JTextField();
		customeridf.setBorder(null);
		customeridf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		customeridf.setForeground(Color.BLACK);
		customeridf.setBackground(Color.WHITE);
		customeridf.setBounds(173, 167, 234, 20);
		
		
		Date d = new Date();
		SimpleDateFormat frmt = new SimpleDateFormat("ddMMyyyy");
		String customerid = frmt.format(d) + d.getHours() + d.getMinutes();                                                               // Creating CustomerId
		customeridf.setText(customerid);
		contentPane.add(customeridf);
		customeridf.setColumns(10);
		
		orderidf = new JTextField();
		orderidf.setBorder(null);
		orderidf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		orderidf.setForeground(Color.BLACK);
		orderidf.setBackground(Color.WHITE);
		orderidf.setBounds(173, 198, 234, 20);
		
		long orderid = Long.parseLong(frmt.format(d) + d.getMinutes() + d.getSeconds());                                   // Creating OrderId
		orderidf.setText(Long.toString(orderid));
		contentPane.add(orderidf);
		orderidf.setColumns(10);
		
		JComboBox typecomboBox = new JComboBox();
		typecomboBox.setFont(new Font("Tahoma", Font.ITALIC, 13));
		typecomboBox.setForeground(Color.WHITE);
		typecomboBox.setBackground(Color.GRAY);
		
		typecomboBox.setBounds(173, 229, 154, 20);
		contentPane.add(typecomboBox);
		typecomboBox.addItem(" ");
		typecomboBox.addItem("Inbound");
		typecomboBox.addItem("Outbound");
		typecomboBox.addItem("Email");
		
		
		JComboBox prioritycomboBox = new JComboBox();
		prioritycomboBox.setFont(new Font("Tahoma", Font.ITALIC, 13));
		prioritycomboBox.setBackground(Color.GRAY);
		prioritycomboBox.setForeground(Color.WHITE);
		prioritycomboBox.setBounds(173, 260, 154, 20);
		contentPane.add(prioritycomboBox);
		prioritycomboBox.addItem(" ");
		prioritycomboBox.addItem("Low");
		prioritycomboBox.addItem("Medium");
		prioritycomboBox.addItem("High");
		prioritycomboBox.addItem("Urgent");
		
		JComboBox agentcomboBox = new JComboBox();
		agentcomboBox.setFont(new Font("Tahoma", Font.ITALIC, 13));
		agentcomboBox.setBackground(Color.GRAY);
		agentcomboBox.setForeground(Color.WHITE);
		agentcomboBox.setBounds(173, 291, 154, 20);
		contentPane.add(agentcomboBox);
		agentcomboBox.addItem(" ");
		agentcomboBox.addItem("6 months");
		agentcomboBox.addItem("1 year");
		agentcomboBox.addItem("2 years");
		agentcomboBox.addItem("3 years");
		agentcomboBox.addItem("4 years");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 421, 583, 237);
		contentPane.add(scrollPane);
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(253, 245, 230));
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setBounds(39, 108, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(173, 105, 234, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(253, 245, 230));
		lblNewLabel_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1.setBounds(39, 139, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setForeground(Color.BLACK);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(173, 136, 234, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
//		JLabel Mailerrr = new JLabel("");   
//		Mailerrr.setBounds(417, 109, 140, 14);        // for Error on side of mail label
//		contentPane.add(Mailerrr);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(null);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(textArea);
		int caseid=1;
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBorder(null);
		btnSubmit.setIcon(null);
		btnSubmit.setForeground(SystemColor.text);
		btnSubmit.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnSubmit.setBackground(new Color(47, 79, 79));
		btnSubmit.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0){
				try
				{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","7225");
				String custid = customeridf.getText();
				long custid1 = Long.parseLong(custid);
				
			/*	String mail = textField.getText();
				StringBuilder revmail = new StringBuilder();
			    revmail.append(mail);
			    revmail = revmail.reverse();
			    int index = revmail.indexOf("@");*/
				
				if(namef.getText().equals("") || subjectf.getText().equals("") || textField.getText().equals("") )
					JOptionPane.showMessageDialog(null, "All Enteries Required");
			/*	else if (index < 9 )                                  // Email validation 
			    {
			    	JOptionPane.showMessageDialog(null, "Wrong E-mail", "Error", 0);
			    	//Mailerrr.setText("Wrong Email");
			   
			    	
			    } */
				
				
				else if(textField_1.getText().length() != 10)
					JOptionPane.showMessageDialog(null, "Wrong Number");
				else
				{
					Date d = new Date();
					SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
					
					String name=System.getProperty("user.name");
					
					String query="insert into ticket values('"+namef.getText()+"','"+subjectf.getText()+"','"+custid+"','"+typecomboBox.getSelectedItem()+"','"+prioritycomboBox.getSelectedItem()+"','"+agentcomboBox.getSelectedItem()+"','"+textArea.getText()+"','"+textField_1.getText()+"','"+textField.getText()+"','"+s.format(d)+"','"+name+"','"+amtField.getText()+"')";
					String query1="insert into table2 values('"+custid+"','"+orderid+"','"+caseid+"','"+textArea.getText()+"','"+s.format(d)+"')";
					
					Statement st= con.createStatement();
					Statement st1= con.createStatement();
					st.executeUpdate(query);
					st1.executeUpdate(query1);
					JOptionPane.showMessageDialog(null, "Ticket created Successfully");
					
					st1.close();
					st.close();
					con.close();
					dispose();
					/*namef.setText("");
					subjectf.setText("");
					customeridf.setText("");
					textArea.setText("");
					textField_1.setText("");
					textField.setText("");*/
				}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(517, 669, 98, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(new Color(253, 245, 230));
		lblAmount.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblAmount.setBackground(new Color(0, 128, 0));
		lblAmount.setBounds(39, 319, 46, 14);
		contentPane.add(lblAmount);
		
		amtField = new JTextField();
		amtField.setBorder(null);
		amtField.setBounds(173, 322, 154, 20);
		contentPane.add(amtField);
		amtField.setColumns(10);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblFillDetails, lblName, lblSubject, lblCaseid, lblOrderid, lblType, lblPriority, lblAgent, lblDescription, namef, subjectf, customeridf, orderidf, typecomboBox, prioritycomboBox, agentcomboBox, scrollPane, textArea, lblNewLabel, textField, lblNewLabel_1, textField_1, btnSubmit}));
		
		
		
	}
}
