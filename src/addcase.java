import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class addcase extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcase frame = new addcase();
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
	public addcase()
	{
		
	}
	
	//
	public addcase(String cust,String order) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JLabel lblNewLabel = new JLabel("enter case id number");
//		lblNewLabel.setBounds(26, 252, 122, 14);
//		contentPane.add(lblNewLabel);
//		
//		textField = new JTextField();
//		textField.setBounds(156, 249, 86, 20);
//		contentPane.add(textField);
//		textField.setColumns(10);
		
		
		
		JLabel lblDate = new JLabel("Date:-");
		lblDate.setBounds(20, 11, 46, 14);
		contentPane.add(lblDate);
		
		JLabel dlabel = new JLabel("Date");
		dlabel.setForeground(new Color(72, 61, 139));
		dlabel.setBounds(107, 11, 91, 14);
		contentPane.add(dlabel);
		
		JLabel lblTechname = new JLabel("TechName:-");
		lblTechname.setBounds(20, 39, 77, 14);
		contentPane.add(lblTechname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 776, 399);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel TechLabel = new JLabel("Date");
		TechLabel.setForeground(new Color(72, 61, 139));
		TechLabel.setBounds(107, 39, 138, 14);
		contentPane.add(TechLabel);
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		
		dlabel.setText(s.format(d));
		TechLabel.setText(System.getProperty("user.name"));
		
		JButton btnAddCase = new JButton("Add Case");
		btnAddCase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				
				Connection con=Network.connection();
				
				
				
				String getquery = "Select caseid from table2 where orderid = "+order+" AND CustomerId = "+cust+"";
				Statement cst = con.createStatement();
				ResultSet crs = cst.executeQuery(getquery);
				
				long caseid = 0;
				while(crs.next())
				{
					 caseid = crs.getLong("caseid");
				}
				
				caseid++;
				
				String query="insert into table2 values('"+cust+"','"+order+"','"+ caseid +"','" + "Date:- " + s.format(d) + 
						"                                                                           TechName: " + System.getProperty("user.name") +"\n\n" + textArea.getText() +"','"+s.format(d)+"')";
				
				Statement st=con.createStatement();
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Case Added");
				
			    custpopup cust12=new custpopup(cust);
			    
				JTable table1=cust12.table();
				String query1 = "select  DISTINCT (orderid), date  from table2 where customerid="+cust+" group by orderid";
				ResultSet rs=st.executeQuery(query1);
//				while(rs.next())
//				{	
					table1.setModel(DbUtils.resultSetToTableModel(rs));
		       // }  
				 
        		cust12.setVisible(true);
				st.close();
				con.close();
				
				}
				catch(Exception E)
				{ 
					 //E.printStackTrace();
				}
				dispose();
			}
		});
		btnAddCase.setBounds(668, 516, 89, 23);
		contentPane.add(btnAddCase);
		
		
		

		
		
		
	}
}
