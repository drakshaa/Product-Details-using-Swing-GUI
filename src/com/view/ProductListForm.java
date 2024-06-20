package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import javax.swing.JSpinner;


public class ProductListForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField nameTxt;
	private JTextField companyTxt;
	private JTextField priceTxt;
	private int pid = 0;
	private JTextField searchTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductListForm frame = new ProductListForm();
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
	public ProductListForm() {
		setTitle("Product List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(230, 107, 434, 283);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Company", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Product List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(286, 11, 114, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Please select any row");
					return;
				}
				
				int srow = table.getSelectedRow();
				int pid = (int) table.getModel().getValueAt(srow, 0);
				ProductService service = new ProductServiceImpl();
				service.deleteProduct(pid);
				JOptionPane.showMessageDialog(null, "deleted success");
				displayData(); // get all product after deleted
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(541, 414, 119, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Please select any row");
					return;
				}
				
				int srow = table.getSelectedRow();
				 pid = (int) table.getModel().getValueAt(srow, 0);
				
				nameTxt.setText(table.getModel().getValueAt(srow, 1).toString());
				companyTxt.setText(table.getModel().getValueAt(srow, 2).toString());
				priceTxt.setText(table.getModel().getValueAt(srow, 3).toString());
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(410, 415, 106, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(21, 118, 86, 28);
		contentPane.add(lblNewLabel_1);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(93, 118, 127, 32);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Company");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(21, 203, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Price");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(21, 265, 86, 14);
		contentPane.add(lblNewLabel_2_1);
		
		companyTxt = new JTextField();
		companyTxt.setColumns(10);
		companyTxt.setBounds(93, 195, 127, 32);
		contentPane.add(companyTxt);
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		priceTxt.setBounds(93, 262, 127, 32);
		contentPane.add(priceTxt);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product pd = new Product();
				pd.setId(pid);
				pd.setName(nameTxt.getText());
				pd.setCompany(companyTxt.getText());
				pd.setPrice(Integer.parseInt(priceTxt.getText()));
				
				ProductService service = new ProductServiceImpl();
				service.updateProduct(pd);
				
				displayData();
				JOptionPane.showMessageDialog(null, "Update Success");				
				
			}
		});
		btnNewButton_2.setBounds(72, 337, 100, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("print");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						table.print();
					} catch (PrinterException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(272, 414, 106, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add New Product");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductForm().setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(21, 15, 162, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Refresh");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				displayData();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setBounds(525, 11, 106, 32);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(230, 68, 86, 28);
		contentPane.add(lblNewLabel_1_1);
		
		searchTxt = new JTextField();
		searchTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String sdata = searchTxt.getText().trim();
				
				ProductService service = new ProductServiceImpl();
				List<Product> plist = service.searchProduct(sdata);
				
				DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
				
				tmodel.setRowCount(0); //table reset
				
				for(Product p : plist) {
					
					
					tmodel.addRow(new Object[] {p.getId(), p.getName(), p.getCompany(), p.getPrice()});
				}
			}
		});
		searchTxt.setColumns(10);
		searchTxt.setBounds(286, 76, 184, 20);
		contentPane.add(searchTxt);
		
		displayData(); // load product list and display in JTable
	}
	
	//display product data in JTable
	
	private void displayData() {
		 ProductService service = new ProductServiceImpl();
		List<Product> plist = service.getAllProducts();
		
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		
		tmodel.setRowCount(0); //table reset
		
		for(Product p : plist) {
			
			// new int[]{1,2,3,23,45,6,90,7};
			tmodel.addRow(new Object[] {p.getId(), p.getName(), p.getCompany(), p.getPrice()});
			
		}
	}
}
