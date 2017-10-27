package com.cgLee079.tpgame.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cgLee079.tpgame.graphic.GlobalGraphic;
import com.cgLee079.tpgame.graphic.GraphicButton;

public class PauseFrame extends JFrame {
	GraphicButton homeBtn;
	GraphicButton resumeBtn;
	GraphicButton exitBtn;

	public PauseFrame() {
		setLayout(new FlowLayout());
		setSize(150, 180);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);// 크기 고정
		setUndecorated(true);
		getContentPane().setBackground(GlobalGraphic.character);
		setVisible(true);
		this.setShape(new RoundRectangle2D.Float(0, 0, this.getWidth(), this.getHeight(), 50, 50));
		Dimension frameSize = getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

		add(new ButtonPanel());
	}

	class ButtonPanel extends JPanel {
		ButtonPanel() {
			setPreferredSize(new Dimension(200, 200));
			this.setBackground(null);
			homeBtn = new GraphicButton("images/PauseFrame/", "Homebtn", 120, 50);
			homeBtn.addActionListener(new ButtonActionListener());

			resumeBtn = new GraphicButton("images/PauseFrame/", "resumebtn", 120, 50);
			resumeBtn.addActionListener(new ButtonActionListener());

			exitBtn = new GraphicButton("images/PauseFrame/", "exitbtn", 120, 50);
			exitBtn.addActionListener(new ButtonActionListener());

			add(homeBtn);
			add(resumeBtn);
			add(exitBtn);
		}

		class ButtonActionListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				GraphicButton btn = (GraphicButton) e.getSource();
				if (btn.getFilename().equals("homebtn"))
					;
				else if (btn.getFilename().equals("resumebtn"))
					MainFrame.mf.playPanel.play.resumeGame();
				else if (btn.getFilename().equals("exitbtn"))
					System.exit(0);

				/*
				 * switch(btn.getFILENAME()){ case "homebtn": break; case
				 * "resumebtn":MainFrame.mf.playPanel.play.resumeGame(); break;
				 * case "exitbtn": System.exit(0); }
				 */

				PauseFrame.this.dispose();
			}

		}
	}
}
