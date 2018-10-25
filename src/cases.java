

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class cases extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cases frame = new cases();
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
	public cases()
	{
		
	}
	
	//
	
	public cases(String order,String cust) {
		setTitle("Customer Cases");
		//String order= " " , cust = " ";
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 519);
		contentPane = new JPanel();
		//System.out.print(cust);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 608, 330);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		try
		{

			Connection con = Network.connection();
        
			String query="select *from table2 where orderId= '"+order +"' and CustomerId='"+cust+"'";
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			//System.out.print(cust);
			//textArea.setText("CaseID:-"+rs.getString("caseId")+" \n "+rs.getString("TechNote") + "\n");
//			while(rs.next())
//				
//				{
//				   textArea.append("CaseID:-"+rs.getString("caseId")+" \n "+rs.getString("TechNote") + "\n");
//				}
			
			String [] s = new String[1000];
			int i = 0;
			while(rs.next())
			{
				s[i] = rs.getString("technote"); 
				i++;
			}
		
			for(int j = 0 ; j < i ; j++)
			{
				
				textArea.append("CaseID:-" + (j + 1)+ "\n\n" + s[j] + "\n\n");
				textArea.append("\n\n**********************************************************************************************************\n\n");
			}
		
		JButton btnNewButton = new JButton("Add case ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 new addcase(cust,order).setVisible(true);
			}
		});
		btnNewButton.setBounds(512, 386, 106, 23);
		contentPane.add(btnNewButton);	
		
		JLabel lblCaseDetail = new JLabel("Case Details");
		lblCaseDetail.setBounds(10, 10, 73, 14);
		contentPane.add(lblCaseDetail);
		
	
		}
		catch(Exception e)
		{
			
		}
	}
}
