package com.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.model.Product;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.service.ProductService;
import com.service.ProductServiceImpl;


public class ProductForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField companyTxt;
	private JTextField priceTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm frame = new ProductForm();
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
	public ProductForm() {
		setTitle("ProductForm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		nameLbl.setBounds(80, 125, 89, 31);
		contentPane.add(nameLbl);
		
		JLabel companyLbl = new JLabel("Company");
		companyLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		companyLbl.setBounds(80, 173, 116, 31);
		contentPane.add(companyLbl);
		
		JLabel priceLbl = new JLabel("Price");
		priceLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		priceLbl.setBounds(80, 230, 73, 31);
		contentPane.add(priceLbl);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(220, 128, 190, 31);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		companyTxt = new JTextField();
		companyTxt.setBounds(220, 176, 190, 31);
		contentPane.add(companyTxt);
		companyTxt.setColumns(10);
		
		priceTxt = new JTextField();
		priceTxt.setBounds(220, 233, 190, 31);
		contentPane.add(priceTxt);
		priceTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Add product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product pd = new Product();
				pd.setName(nameTxt.getText());
				pd.setCompany(companyTxt.getText());
				pd.setPrice(Integer.parseInt(priceTxt.getText()));
				
				ProductService service = new ProductServiceImpl();
				service.addProduct(pd);
				
				JOptionPane.showMessageDialog(null, "Added Success");				

				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(170, 306, 141, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Product Details");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3.setBounds(160, 37, 223, 46);
		contentPane.add(lblNewLabel_3);
	}
}
