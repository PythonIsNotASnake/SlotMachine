package backend;

public class Highscore {

	private int score;

	public Highscore() {
		this.score = 0;
	}

	public void calculate(Slot slotOne, Slot slotTwo, Slot slotThree) {

		if (slotOne.getZufallszahl() <= 3 && slotTwo.getZufallszahl() <= 3 && slotThree.getZufallszahl() <= 3) {
			score = score + 20;
		} else if (slotOne.getZufallszahl() > 6 && slotTwo.getZufallszahl() > 6 && slotThree.getZufallszahl() > 6) {
			score = score + 40;
		} else if (slotOne.getZufallszahl() > 3 && slotOne.getZufallszahl() <= 6 && slotTwo.getZufallszahl() > 3
				&& slotTwo.getZufallszahl() <= 6 && slotThree.getZufallszahl() > 3 && slotThree.getZufallszahl() <= 6) {
			score = score + 30;
		} else if (slotOne.getZufallszahl() > 3 && slotOne.getZufallszahl() <= 6 && slotTwo.getZufallszahl() > 3
				&& slotTwo.getZufallszahl() <= 6) {
			score = score + 10;
		} else if (slotOne.getZufallszahl() > 3 && slotOne.getZufallszahl() <= 6) {
			score = score + 5;
		}
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}
}
