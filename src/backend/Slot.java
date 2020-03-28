package backend;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Slot {

	private JLabel label;
	private ImageIcon symbol;
	private ImageIcon[] symbolArray;
	private int zufallszahl;

	public Slot(ImageIcon symbol) {
		this.symbol = symbol;
		this.label = new JLabel(this.symbol);
		ImageIcon[] symbolArray = { new ImageIcon("images/watermelon.png"), new ImageIcon("images/cherries.png"),
				new ImageIcon("images/number-seven.png") };
		this.symbolArray = symbolArray;

		Border border = BorderFactory.createLineBorder(Color.YELLOW, 3);
		label.setBorder(border);
	}

	public void rollIt() {

		// Random Wert von 0 bis 2
		this.zufallszahl = (int) (Math.random() * 9);
		// System.out.println(zufallszahl);
		if (zufallszahl <= 3) {
			this.label.setIcon(symbolArray[0]);
		} else if (zufallszahl <= 6) {
			this.label.setIcon(symbolArray[1]);
		} else if (zufallszahl <= 9) {
			this.label.setIcon(symbolArray[2]);
		}

	}

	public void setSymbol(ImageIcon symbol) {
		this.symbol = symbol;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public ImageIcon getSymbol() {
		return this.symbol;
	}

	public JLabel getLabel() {
		return this.label;
	}

	public ImageIcon getSymbolArray() {
		return this.getSymbolArray();
	}

	public int getZufallszahl() {
		return this.zufallszahl;
	}
}
