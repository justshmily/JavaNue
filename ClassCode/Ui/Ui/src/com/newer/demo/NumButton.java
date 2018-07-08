package com.newer.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumButton extends JButton implements ActionListener {

	public NumButton(String text) {
		setText(text);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
