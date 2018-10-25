import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.Date;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.DefaultComboBoxModel;

public class CRM2 {

	private JFrame frmIncinqueCrm;
	private JTextField search;
	private JTable table;
	private JTextField cstfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRM2 window = new CRM2();
					window.frmIncinqueCrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public CRM2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	String comboval = "";
	private void initialize() {
		frmIncinqueCrm = new JFrame();
		frmIncinqueCrm.setForeground(Color.WHITE);
		frmIncinqueCrm.setTitle("Incinque CRM");
		frmIncinqueCrm.getContentPane().setBackground(SystemColor.activeCaption);
		frmIncinqueCrm.setResizable(false);
		frmIncinqueCrm.setBounds(100, 100, 1194, 671);
		frmIncinqueCrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIncinqueCrm.getContentPane().setLayout(null);
		
		JButton btnAddTicket = new JButton("");
		btnAddTicket.setIcon(new ImageIcon("C:\\Users\\Aakash\\Desktop\\icons8_Plus_32px.png"));
		btnAddTicket.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnAddTicket.setForeground(Color.BLACK);
		btnAddTicket.setBackground(Color.WHITE);
		btnAddTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewTicket obj=new NewTicket();
				obj.setVisible(true);
			}
		});
		btnAddTicket.setBounds(1135, 90, 43, 32);
		frmIncinqueCrm.getContentPane().add(btnAddTicket);
		
		cstfield = new JTextField();
		cstfield.setForeground(Color.BLACK);
		cstfield.setFont(new Font("Tahoma", Font.ITALIC, 13));
		cstfield.setBackground(Color.WHITE);
		//cstfield.setText();
		cstfield.setToolTipText("CustomerId");
		cstfield.setBounds(539, 583, 124, 20);
		frmIncinqueCrm.getContentPane().add(cstfield);
		cstfield.setColumns(10);

		JLabel label0 = new JLabel("");
		label0.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label0.setBounds(368, 22, 176, 31);
		frmIncinqueCrm.getContentPane().add(label0);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(368, 64, 176, 37);
		frmIncinqueCrm.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(674, 22, 114, 31);
		frmIncinqueCrm.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(674, 64, 114, 37);
		frmIncinqueCrm.getContentPane().add(label_3);
		
		JLabel lblPlan = new JLabel("Plan:");
		lblPlan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPlan.setBounds(809, 34, 69, 14);
		frmIncinqueCrm.getContentPane().add(lblPlan);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmount.setBounds(809, 75, 56, 14);
		frmIncinqueCrm.getContentPane().add(lblAmount);
		
		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(880, 22, 124, 30);
		frmIncinqueCrm.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(875, 64, 124, 37);
		frmIncinqueCrm.getContentPane().add(label_5);
		
         table = new JTable();
         table.setColumnSelectionAllowed(true);
         table.setCellSelectionEnabled(true);
      
         table.setForeground(Color.BLACK);
         table.setFont(new Font("Tahoma", Font.PLAIN, 14));
         table.setBackground(Color.WHITE);
         JScrollPane scrollPane = new JScrollPane();
         scrollPane.setViewportBorder(UIManager.getBorder("ToolBar.border"));
 		scrollPane.setBounds(267, 133, 911, 427);
 		frmIncinqueCrm.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		search = new JTextField();
		search.setBorder(null);
		search.setForeground(Color.BLACK);
		search.setFont(new Font("Tahoma", Font.ITALIC, 13));
		search.setBackground(Color.WHITE);
	
		search.setBounds(10, 181, 224, 23);
		frmIncinqueCrm.getContentPane().add(search);
		search.setColumns(10);
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(302, 33, 46, 14);
		frmIncinqueCrm.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("CustomerID:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(575, 33, 89, 14);
		frmIncinqueCrm.getContentPane().add(lblEmail);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail_1.setBounds(302, 74, 46, 14);
		frmIncinqueCrm.getContentPane().add(lblEmail_1);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setBounds(575, 74, 46, 14);
		frmIncinqueCrm.getContentPane().add(lblPhone);
		
		JButton custpop = new JButton("Submit");
		custpop.setBackground(Color.WHITE);
		custpop.setFont(new Font("Tahoma", Font.ITALIC, 13));
		custpop.setForeground(Color.BLACK);
		custpop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{
					Connection con1=Network.connection();
					Statement st=con1.createStatement();
					custpopup cust1=new custpopup(cstfield.getText());
					
	               // System.out.println("CRM" + cstfield.getText());
					cust1.setVisible(true);
					JTable table1=cust1.table();
					
					String query = "select  DISTINCT (orderid), date  from table2 where customerid="+cstfield.getText()+" group by orderid";
					ResultSet rs=st.executeQuery(query);
					table1.setModel(DbUtils.resultSetToTableModel(rs));
					while(rs.next())
					{	
						table1.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
					rs.close();
					st.close();
					con1.close();
				
			}catch(Exception q){
				q.printStackTrace();
			 }
			}
		});
		
		custpop.setBounds(677, 582, 89, 23);
		frmIncinqueCrm.getContentPane().add(custpop);
		
		JLabel date = new JLabel("");
		date.setFont(new Font("Tahoma", Font.PLAIN, 13));
		date.setForeground(Color.WHITE);
		date.setBounds(1097, 53, 69, 19);
		Date date1=new Date();
		SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
		String date2=s.format(date1);
		date.setText(date2);
		frmIncinqueCrm.getContentPane().add(date);
		
		JLabel Techname = new JLabel("New label");
		Techname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Techname.setForeground(SystemColor.text);
		Techname.setBounds(1080, 11, 98, 16);
		frmIncinqueCrm.getContentPane().add(Techname);
		Techname.setText("Hello, "+System.getProperty("user.name"));
		
		JLabel lblHello = new JLabel("");
		lblHello.setIcon(new ImageIcon("C:\\Users\\Aakash\\Desktop\\icons8_Online_Support_40px.png"));
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHello.setForeground(SystemColor.text);
		lblHello.setBounds(1039, 0, 40, 47);
		frmIncinqueCrm.getContentPane().add(lblHello);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Aakash\\Desktop\\logo.png"));
		label.setBounds(10, 11, 257, 101);
		frmIncinqueCrm.getContentPane().add(label);
		
		JLabel label_6 = new JLabel("                Name");
		
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String str="name";
					String searchtxt = search.getText().trim();
					Connection con = Network.connection();
					String query = "Select name , customerID , email , phone, plan, amount, Date from ticket where "+str+"='"+searchtxt+"'";
					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					
					int count = 0 ;
					while(rs.next())
					{
						String r = rs.getString("Name");
						if(r.equalsIgnoreCase(searchtxt))
						{
							count++;
						}
					}
					
					 if(count == 0)
					 {
						 JOptionPane.showMessageDialog(null, "No Record found", "Error", 0);
					 }
					 
					 else
					 {
						 rs = st.executeQuery(query);
						 table.setModel(DbUtils.resultSetToTableModel(rs));
				
					 }
					
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});	
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBackground(Color.BLUE);
		label_6.setBounds(10, 228, 224, 20);
		frmIncinqueCrm.getContentPane().add(label_6);
		
		JLabel lblCustomeridd = new JLabel("             CustomerID");
		lblCustomeridd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String str = "CustomerId";
					String searchtxt1 = search.getText().trim();
					long searchtxt = Long.parseLong(searchtxt1);
					Connection con = Network.connection();
					String query = "Select name , customerID , email , phone, plan, amount, Date from ticket where "+str+"='"+searchtxt+"'";
					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					int count = 0 ;
					while(rs.next())
					{
						long r =  rs.getLong("CustomerId"); 						 
						
						if(r == searchtxt)
						{
							count++;
						}
					}
					
					 if(count == 0)
					 {
						 JOptionPane.showMessageDialog(null, "No Record found", "Error", 0);
					 }
					 
					 else
					 {	 
						 rs = st.executeQuery(query);
						 table.setModel(DbUtils.resultSetToTableModel(rs));
					 }
					 rs.close();
					 st.close();
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		lblCustomeridd.setForeground(Color.BLUE);
		lblCustomeridd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomeridd.setBackground(Color.BLUE);
		lblCustomeridd.setBounds(10, 259, 224, 20);
		frmIncinqueCrm.getContentPane().add(lblCustomeridd);
		
		JLabel lblEmail_2 = new JLabel("                Email");
		lblEmail_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					String str="email";
					String searchtxt = search.getText().trim();
					Connection con = Network.connection();
					String query = "Select name , customerID , email , phone, plan, amount, Date from ticket where "+str+"='"+searchtxt+"'";
					
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					
					
					
					int count = 0 ;
					while(rs.next())
					{
						String r = rs.getString("email");
						if(r.equalsIgnoreCase(searchtxt))
						{
							count++;
						}
					}
					
					 if(count == 0)
					 {
						 JOptionPane.showMessageDialog(null, "No Record found", "Error", 0);
					 }
					 
					 else
					 {
						 rs = st.executeQuery(query);
						 table.setModel(DbUtils.resultSetToTableModel(rs));
				
					 }
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		lblEmail_2.setForeground(Color.BLUE);
		lblEmail_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail_2.setBackground(Color.BLUE);
		lblEmail_2.setBounds(10, 290, 224, 20);
		frmIncinqueCrm.getContentPane().add(lblEmail_2);
		   table.addMouseListener(new MouseAdapter() {
	         	@Override
	         	public void mouseClicked(MouseEvent arg0) {
	         		
	         		int row=table.getSelectedRow();
	         		String name1=(table.getModel().getValueAt(row, 0)).toString();
	         		String name=(table.getModel().getValueAt(row, 1)).toString();
	         		String email=(table.getModel().getValueAt(row, 2)).toString();
	         		String phone=(table.getModel().getValueAt(row, 3)).toString();
	         		String plan	=(table.getModel().getValueAt(row, 4)).toString();
	         		String amount=(table.getModel().getValueAt(row, 5)).toString();
	         		 
	         		cstfield.setText(name);
	         		label0.setText(name1);
	         		label_1.setText(email);
	         		label_2.setText(name);
	         		label_3.setText(phone);
	         		label_4.setText(plan);
	         		label_5.setText(amount);
	         		
	        		
	         	}
	         });		
	}
}
