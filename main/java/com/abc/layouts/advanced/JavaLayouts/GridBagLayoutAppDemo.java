package com.abc.layouts.advanced.JavaLayouts;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GridBagLayoutAppDemo {
	final static boolean shouldFill=true;
	final static boolean shouldWeightX=true;
	final static boolean RIGHT_TO_LEFT=false;
	static JButton btn;
	//JTextField txt1, txt2, txt3, txt4;
	
	public static void addComponentsToPane(Container pane) {
		if(RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		pane.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		if(shouldFill) {
			gbc.fill=GridBagConstraints.HORIZONTAL;
		}
		btn=new JButton("My Button 1");
		if(shouldWeightX) {
			gbc.weightx=0.5;
		}
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=0;
		pane.add(btn,gbc);
		
		btn=new JButton("My Button 2");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weightx=0.5;
		gbc.gridx=1;
		gbc.gridy=0;
		pane.add(btn, gbc);
		
		btn=new JButton("My Button 3");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weightx=0.5;
		gbc.gridx=2;
		gbc.gridy=0;
		pane.add(btn, gbc);
		
		btn=new JButton("My Long Texed Button Number 4");
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.ipady=40;
		gbc.weightx=0.0;
		gbc.gridwidth=4;
		gbc.gridx=0;
		gbc.gridy=1;
		pane.add(btn, gbc);
		
		btn=new JButton("ABC");
		//gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.ipady=0;
		gbc.weighty=1.0;
		//gbc.anchor=GridBagConstraints.PAGE_END;
		gbc.insets=new Insets(10, 0, 0, 0);
		gbc.gridwidth=2;
		gbc.gridx=1;
		gbc.gridy=2;
		pane.add(btn, gbc);
		
		JFXPanel fxp=createBtnPanel();
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=3;
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.insets=new Insets(3, 3, 3, 3);
		pane.add(fxp, gbc);
	}
	private static JFXPanel createBtnPanel() {
		JFXPanel fxPanel=new JFXPanel();
		VBox root=new VBox();
		Scene scene=new Scene(root,Color.ALICEBLUE);
		HBox thb=new HBox();
		HBox hb=new HBox();
		Label lbl=new Label("MY JFX LABEL FOR TITLE");
		HBox.setHgrow(lbl, Priority.ALWAYS);
		thb.getChildren().add(lbl);
		thb.setAlignment(Pos.CENTER);
		TextArea ta=new TextArea("This ia a Text Area Created in JavaFx");
		HBox.setMargin(ta, new javafx.geometry.Insets(5));
		HBox.setHgrow(ta, Priority.ALWAYS);
		hb.getChildren().add(ta);
		hb.setAlignment(Pos.CENTER);
		root.getChildren().addAll(thb,hb);
		fxPanel.setScene(scene);
		return fxPanel;
	}
	private static void initializeUI() {
		JFrame frame=new JFrame("GridBagLayout Test by Andere");
		frame.setPreferredSize(new Dimension(550, 450));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			initializeUI();
		});
	}

}
