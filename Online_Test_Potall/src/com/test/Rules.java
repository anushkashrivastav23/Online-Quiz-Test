package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rules extends JFrame  implements ActionListener{
	JButton start,back;
	Rules() {
		JLabel heading = new JLabel("Welcome" + "  to TEST");
		heading.setBounds(150, 100, 700, 30);
		heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
		heading.setForeground(new Color(22, 99, 54));
		add(heading);

		JLabel rules = new JLabel("Welcome" + "  to TEST");
		rules.setBounds(70, 120, 700, 350);
		rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rules.setForeground(new Color(22, 99, 54));
		rules.setText(

				"<html>" + "1. Participation in the quiz is free and open to all persons above 18 years old."
						+ "<br><br>" + "2. There are a total 10 questions. " + "<br><br>"
						+ "3. You only have 15 seconds to answer the question." + "<br><br>"
						+ "4. No cell phones or other secondary devices in the room or test area." + "<br><br>"
						+ "5. No talking." + "<br><br>" + "6. No one else can be in the room with you." + "<br><br>"
						+ "<html>"

		);
		add(rules);
		
		back=new JButton("Back");
		back.setBounds(280, 450, 100, 30);
		back.setBackground(new Color(22,99,54));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		

		start=new JButton("Start");
		start.setBounds(410, 450, 100, 30);
	    start.setBackground(new Color(22,99,54));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		add(start);
		
		String imagePath = "src/icons/back.png";
		File imageFile = new File(imagePath);

		if (!imageFile.exists()) {
			System.out.println("Image not found at: " + imageFile.getAbsolutePath());
			return;
		}

		ImageIcon i1 = new ImageIcon(imagePath);
		Image i = i1.getImage().getScaledInstance(800, 550, Image.SCALE_SMOOTH);
		ImageIcon i2 = new ImageIcon(i);
		JLabel image = new JLabel(i2);
		image.setBounds(0, 0, 800, 550);
		add(image);

		setSize(800, 550);
		setLocation(350, 150);
		setLayout(null);
		setVisible(true);
	}

	public Rules(String name) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==start) {
			
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new Login();
		}
		
	}



	public static void main(String[] args) {
		new Rules();
	}
}