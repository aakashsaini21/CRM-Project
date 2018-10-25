import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.wb.swing.TreeDemoo;


import javax.swing.UIManager;
import javax.swing.JTree;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Point;

public class custpopup extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custpopup frame = new custpopup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}				
custpopup()
{		
					
}      
	/**
	 * Create the frame.
	 */
	
	public custpopup(String cust) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 543);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(253, 245, 230));
		contentPane.setBackground(UIManager.getColor("Button.darkShadow"));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(238, 11, 2, 504);
		separator.setForeground(UIManager.getColor("Button.darkShadow"));
		separator.setBackground(UIManager.getColor("Button.darkShadow"));
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(25, 101, 55, 14);
		lblName.setForeground(new Color(253, 245, 230));
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(25, 126, 55, 14);
		lblEmail.setForeground(new Color(253, 245, 230));
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 13));
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNo = new JLabel("Phone :");
		lblPhoneNo.setBounds(25, 151, 55, 14);
		lblPhoneNo.setForeground(new Color(253, 245, 230));
		lblPhoneNo.setFont(new Font("Tahoma", Font.ITALIC, 13));
		contentPane.add(lblPhoneNo);
		
		JLabel lblPlan = new JLabel("Plan :");
		lblPlan.setForeground(new Color(253, 245, 230));
		lblPlan.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblPlan.setBounds(25, 176, 55, 14);
		contentPane.add(lblPlan);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setForeground(new Color(253, 245, 230));
		lblAmount.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblAmount.setBounds(25, 201, 77, 14);
		contentPane.add(lblAmount);
		
		
		try
		{
			
		Connection con=Network.connection();
		String query="select *from ticket where customerId = '"+cust +"'";
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
		rs.next();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(120, 101, 108, 14);
		lblNewLabel.setForeground(new Color(253, 245, 230));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel.setBackground(new Color(128, 128, 128));
		
		lblNewLabel.setText(rs.getString("name"));
		
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(120, 126, 108, 14);
		label.setForeground(new Color(253, 245, 230));
		label.setFont(new Font("Tahoma", Font.ITALIC, 13));
		label.setBackground(new Color(128, 128, 128));
		label.setText(rs.getString("email"));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(120, 151, 108, 14);
		label_1.setForeground(new Color(253, 245, 230));
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		label_1.setBackground(new Color(128, 128, 128));
		
		label_1.setText(rs.getString("phone"));
		contentPane.add(label_1);
		
		JLabel planlabel = new JLabel("");
		planlabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		planlabel.setForeground(Color.WHITE);
		planlabel.setBounds(120, 176, 108, 14);
		contentPane.add(planlabel);
		planlabel.setText(rs.getString("plan"));
		
		JLabel amtlabel = new JLabel("");
		amtlabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		amtlabel.setForeground(Color.WHITE);
		amtlabel.setBounds(120, 201, 77, 14);
		contentPane.add(amtlabel);
		amtlabel.setText(rs.getString("amount"));
		
		
		JPanel panel = new JPanel();
		panel.setBounds(270, 0, 504, 504);
		panel.setBackground(new Color(211, 211, 211));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CustomerID:");
	
		lblNewLabel_1.setBackground(new Color(105, 105, 105));
		lblNewLabel_1.setBounds(23, 22, 72, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(UIManager.getColor("Button.disabledForeground"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		JLabel cstid1 = new JLabel("");
	    cstid1.setText(cust);
//		cstid1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				try
//				{
//				
//					Connection con=Network.connection();
//					String query="select orderId from  table2 where customerId = '"+cust +"'";
//					//System.out.println(cust);
//					
//					Statement st=con.createStatement();
//					ResultSet rs=st.executeQuery(query);
//					String [] s = new String[1000];
//					int i = 0;
//					
//				    //textArea.setText("OrderID:-"+rs.getString("orderID"));
//				
//				
//				}
//				catch(Exception e)
//				{ 
//					
//				}
//				
//			}
//		});
		cstid1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		cstid1.setForeground(Color.DARK_GRAY);
		cstid1.setBounds(123, 22, 213, 14);
		panel.add(cstid1);
		
		JButton btnNewButton = new JButton("Add OrderID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date date = new Date();
				SimpleDateFormat frmt = new SimpleDateFormat("ddMM");
				String time  = frmt.format(date) + Integer.toString(date.getHours()) + date.getMinutes() +  Integer.toString(date.getSeconds()) ;
				//System.out.println(time);
				
				//System.out.println("Hii"+cust);
				
			//dispose();	
			new addcase(cust,time).setVisible(true);
			
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(343, 455, 126, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 49, 462, 391);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try{
					
				Connection con=Network.connection();
				Statement st=con.createStatement();
				int row=table.getSelectedRow();
         		String orderID=(table.getModel().getValueAt(row, 0)).toString();
             
         		new cases(orderID,cust).setVisible(true);
         		
				}catch(Exception A){
				//	A.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer)    // for center alignment of data in table
		table.getDefaultRenderer(String.class);
		stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aakash\\Desktop\\icons8_User_48px_5.png"));
		
		lblNewLabel_3.setBounds(25, 11, 48, 79);
		contentPane.add(lblNewLabel_3);
		
		
		 
		st.close();
		con.close();
		
		}
		catch(Exception e)
		{
			
		}
		
	}
	public JTable table() throws Exception{
		return table;
	}
}


