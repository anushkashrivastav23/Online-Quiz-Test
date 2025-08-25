package com.test;

import java.awt.Color;
import java.awt.Font;
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

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;
    JLabel timerLabel;

    Quiz(String name) {
        // Load and display the image
        String imagePath = "src/icons/quiz.png";
        File imageFile = new File(imagePath);

        if (!imageFile.exists()) {
            System.out.println("Image not found at: " + imageFile.getAbsolutePath());
            return;
        }

        ImageIcon i1 = new ImageIcon(imagePath);
        Image scaledImage = i1.getImage().getScaledInstance(1400, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 1400, 400);
        add(imageLabel);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "Which of the following is not an OOPS concept in Java?";
        questions[1][1] = "Polymorphism";
        questions[1][2] = "Inheritance";
        questions[1][3] = "Compilation";
        questions[1][4] = "Encapsulation";

        questions[2][0] = "Which exception is thrown when java is out of memory?";
        questions[2][1] = "MemoryError";
        questions[2][2] = "OutOfMemoryError";
        questions[2][3] = "MemoryOutOfBoundsException";
        questions[2][4] = "MemoryFullException";

        questions[3][0] = "Which of the following is not a Java features?";
        questions[3][1] = "Dynamic";
        questions[3][2] = "Architecture Neutral";
        questions[3][3] = "Use of pointers";
        questions[3][4] = "Object-oriented";

        questions[4][0] = "Which of these cannot be used for a variable name in Java?";
        questions[4][1] = "identifier & keyword";
        questions[4][2] = "identifier";
        questions[4][3] = "keyword";
        questions[4][4] = "none of the mentioned";

        questions[5][0] = "What is the extension of java code files?";
        questions[5][1] = ".js";
        questions[5][2] = ".txt";
        questions[5][3] = ".class";
        questions[5][4] = ".java";

        questions[6][0] = "Which environment variable is used to set the java path?";
        questions[6][1] = "MAVEN_Path";
        questions[6][2] = "JavaPATH";
        questions[6][3] = "JAVA";
        questions[6][4] = "JAVA_HOME";

        questions[7][0] = "Which of the following is not an IDE for Java?";
        questions[7][1] = "NetBeans";
        questions[7][2] = "Eclipse";
        questions[7][3] = "IntelliJ";
        questions[7][4] = "Jenkins";

        questions[8][0] = "Which of these are selection statements in Java?";
        questions[8][1] = "break";
        questions[8][2] = "continue";
        questions[8][3] = "for()";
        questions[8][4] = "if()";

        questions[9][0] = "Which of these keywords is used to define interfaces in Java?";
        questions[9][1] = "interface";
        questions[9][2] = "Interface";
        questions[9][3] = "intf";
        questions[9][4] = "Intf";

        answers[0][1] = "JDB";
        answers[1][1] = "Compilation";
        answers[2][1] = "OutOfMemoryError";
        answers[3][1] = "Use of pointers";
        answers[4][1] = "keyword";
        answers[5][1] = ".java";
        answers[6][1] = "JAVA_HOME";
        answers[7][1] = "Jenkins";
        answers[8][1] = "if()";
        answers[9][1] = "interface";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 500, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 540, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 580, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 620, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 500, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 570, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(Color.GREEN);
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 640, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(Color.RED);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // You can complete logic here
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt4.setText(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("Anushka");
    }
}
