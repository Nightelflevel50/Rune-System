package version4;

import java.awt.geom.Point2D;

public class DamageAlgorithm {

	Point2D cords;
	int counter = 0;
	Rune4 newRune;

	DamageAlgorithm(Point2D cords, Rune4 newRune) {
		this.cords = cords;
		this.newRune = newRune;
	}

	Point2D theAlgorithm() {

		int x = (int) cords.getX();
		int y = (int) cords.getY();

		int red = newRune.getRed(x, y);

		while (x < (299 - red) & y < (299 - red)) {
			x = x + red;
			y = y + red;
			counterIncrease();
			red = newRune.getRed(x, y);
		}
		
		cords.setLocation(x, y);

		return cords;
	}

	void counterIncrease() {
		counter += 1;
	}

	int getCounter() {
		return counter;
	}

}
