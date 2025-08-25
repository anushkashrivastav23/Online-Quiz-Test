package com.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Test extends JFrame implements ActionListener{
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userAnswers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;
    JButton next,submit,help;
    public static int timer=15;
    public static int ans_given=0;
    public static int count=0;
    public static int score=0;

    Test() {
        // Load and display the image
        String imagePath = "src/icons/quiz.png";
        File imageFile = new File(imagePath);

        if (!imageFile.exists()) {
            System.out.println("Image not found at: " + imageFile.getAbsolutePath());
            return;
        }

        ImageIcon i1 = new ImageIcon(imagePath);
        Image scaledImage = i1.getImage().getScaledInstance(1200, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 1200, 250);
        add(imageLabel);

        // Question number
        qno = new JLabel("1.");
        qno.setBounds(100, 270, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        // Question text
        question = new JLabel("Sample Question?");
        question.setBounds(150, 270, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // Sample question and answers
        questions[0][0] = "Number of primitive data types in Java are.?";
        questions[0][1] = "6";
        questions[0][2] = "7";
        questions[0][3] = "8";
        questions[0][4] = "9";

        answers[0][1] = "8";

        // Radio buttons for options
        opt1 = new JRadioButton();
        opt1.setBounds(170, 320, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 370, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 420, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 470, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        // Next button
        next = new JButton("Next");
        next.setBounds(300, 550, 200, 30);
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(550, 550, 200, 30);
        submit.setBackground(new Color(255, 215, 0));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        help = new JButton("Help");
        help.setBounds(790, 550, 200, 30);
        help.setBackground(new Color(22, 99, 54));
        help.setForeground(Color.WHITE);
        help.addActionListener(this);
        add(help);

        start(count);
        
        // Frame settings
        setSize(1200, 700);
        setLocation(50, 0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	// TODO Auto-generated method 
     if(e.getSource()==next) {
    	 repaint();
    	 opt1.setEnabled(true);
    	 opt2.setEnabled(true);
    	 opt3.setEnabled(true);
    	 opt4.setEnabled(true);
    	 
    	 ans_given=1;
    	 if(group.getSelection()==null) {
    		 userAnswers[count][0]="";
    	 }
    	 else {
    		 userAnswers[count][0]=group.getSelection().getActionCommand();
    		 
    	 }
    	 if(count==8) {
    		 next.setEnabled(false);
    		 submit.setEnabled(true);
    	 }
    	 count++;
    	 start(count);
     }
     else if(e.getSource()==help) {
    	 if(count==2|| count==4||count==6||count==8||count==9) {
    		 opt2.setEnabled(false);
    		 opt3.setEnabled(false);
    	 }
    	 else {
    		 opt1.setEnabled(false);
    		 opt4.setEnabled(false);
    	 }
    	 help.setEnabled(false);
     }else if(e.getSource()==submit) {
    	 ans_given=1;
    	 if(group.getSelection()==null) {
    		 userAnswers[count][0]="";
    	 }else {
    		 userAnswers[count][0]=group.getSelection().getActionCommand();
    	 }
    	 for(int i=0;i<userAnswers.length;i++) {
    		 if(userAnswers[i][0].equals(answers[i][1])) {
    			 score+=10;
    		 }
    		 else {
    			 score+=0;
    		 }
    	 }
    	 setVisible(false);
     }
     
    	
    }
    
    public void paint(Graphics g) {
    	super.paint(g);
    	String time="Time left -"+timer+"seconds";
    	g.setColor(Color.RED);
    	g.setFont(new Font("Tahoma",Font.BOLD,25));
    	if(timer>0) {
    		g.drawString(time,1100,500);
    		
    	}else {
    		g.drawString("Times up !!",1100,500);
    	}
    	timer--;
    	try {
    		Thread.sleep(1000);
    		repaint();
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	if(ans_given==1) {
    		ans_given=0;
    		timer=15;
    	}
    	else if(timer<0) {
    		timer=15;
    		opt1.setEnabled(true);
    		opt2.setEnabled(true);
    		opt3.setEnabled(true);
    		opt4.setEnabled(true);
    		
    		if(count==8) {
    			next.setEnabled(false);
    			submit.setEnabled(true);
    			
    		}if(count==9) {
    			if(group.getSelection()==null) {
    				userAnswers[count][0]="";
    				
    			}else {
    				userAnswers[count][0]=group.getSelection().getActionCommand();
    			}
    			for(int i=0;i<userAnswers.length;i++) {
    				if(userAnswers[i][0].equals(answers[i][1])) {
    					score+=10;
    				}else {
    					score+=0;
    				}
    				
    			}
    			setVisible(false);
//    			new_Score(name,score);
    		}else {
    			if(group.getSelection()==null) {
    				userAnswers[count][0]="";
    			}else {
    				userAnswers[count][0]=group.getSelection().getActionCommand();
    			}
    			count++;
    			start(count);
    		}
    	}
    }
    public void start(int count) {
    	qno.setText(""+(count+1)+".");
    	question.setText(questions[count][0]);
    	opt1.setText(questions[count][1]);
    	opt1.setActionCommand(questions[count][1]);
    	
    	opt2.setText(questions[count][2]);
    	opt2.setActionCommand(questions[count][2]);
    	
    	opt3.setText(questions[count][3]);
    	opt3.setActionCommand(questions[count][3]);
    	
    	opt4.setText(questions[count][4]);
    	opt4.setActionCommand(questions[count][4]);
    	
    	group.clearSelection();
    	
    }

    public static void main(String[] args) {
        new Test();
    }
}
