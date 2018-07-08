package com.newer.demo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalcUI extends JFrame {

	JLabel labelResult;
	String[] buttonsText = { "+" };
	JButton[] buttons = new JButton[20];

	NumListener numListener;
	OpListner opListner;

	public CalcUI() {

		setTitle("计算器");
		setSize(320, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initUI();
	}

	private void initUI() {
		// 显示结果
		labelResult = new JLabel("显示结果");
		getContentPane().add(labelResult, BorderLayout.NORTH);

		// 按钮
		GridLayout gridLayout = new GridLayout(4, 5);
		JPanel gridPanel = new JPanel(gridLayout);

		getContentPane().add(gridPanel, BorderLayout.CENTER);

		for (int i = 0; i < buttons.length; i++) {

			buttons[i] = new JButton(buttonsText[0]);
			buttons[i].addActionListener(new NumListener());

			gridPanel.add(buttons[i]);

		}

	}

	class NumListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

	class OpListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

}
