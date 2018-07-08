package com.newer.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OpButton extends JButton implements ActionListener {
	
	public OpButton() {
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
