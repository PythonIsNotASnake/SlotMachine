package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import backend.Highscore;
import backend.Slot;

public class Gui {

	public JButton play;
	public boolean pressed = false;
	public Slot slotOne;
	public Slot slotTwo;
	public Slot slotThree;
	public JPanel slotPanel;
	public Timer t;
	public JTextField scoreBox;
	public Highscore score;

	public Gui() {

		JFrame frame = new JFrame("");

		frame.setTitle("Slot-Machine");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();

		mainPanel.setLayout(new BorderLayout());
		this.slotPanel = new JPanel();
		slotPanel.setLayout(new BorderLayout());

		this.slotOne = new Slot(new ImageIcon("bin/images/watermelon.png"));
		this.slotTwo = new Slot(new ImageIcon("bin/images/cherries.png"));
		this.slotThree = new Slot(new ImageIcon("bin/images/number-seven.png"));

		slotPanel.add(slotOne.getLabel(), BorderLayout.WEST);
		slotPanel.add(slotTwo.getLabel(), BorderLayout.CENTER);
		slotPanel.add(slotThree.getLabel(), BorderLayout.EAST);

		score = new Highscore();
		scoreBox = new JTextField(score.getScore() + "", 10);
		Font schrift = new Font("Comic Sans MS", Font.BOLD, 36);
		scoreBox.setFont(schrift);
		scoreBox.setBackground(Color.GRAY);
		scoreBox.setForeground(Color.YELLOW);
		scoreBox.setEditable(false);
		slotPanel.add(scoreBox, BorderLayout.NORTH);

		this.t = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slotOne.rollIt();
				slotTwo.rollIt();
				slotThree.rollIt();
				slotPanel.repaint();
			}
		});

		this.play = new JButton("Roll");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				timer();

			}
		});

		slotPanel.add(play, BorderLayout.SOUTH);

		frame.getContentPane().add(slotPanel);

		frame.pack();
		frame.setSize(450, 300);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void timer() {
		if (pressed == false) {
			t.start();
			pressed = true;
		} else if (pressed == true) {
			t.stop();
			pressed = false;
			score.calculate(slotOne, slotTwo, slotThree);
			scoreBox.setText(score.getScore() + "");
		}
	}

	public static void main(String[] args) {
		new Gui();
	}

}
