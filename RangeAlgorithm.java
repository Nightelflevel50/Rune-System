package version4;

import java.awt.geom.Point2D;

public class RangeAlgorithm {

	Point2D cords;
	int counter = 0;
	Rune4 newRune;

	RangeAlgorithm(Point2D cords, Rune4 newRune) {
		this.cords = cords;
		this.newRune = newRune;
	}

	Point2D theAlgorithm() {

		int x = (int) cords.getX();
		int y = (int) cords.getY();

		int green = newRune.getGreen(x, y);

		while (x > (0 + green) & y > (0 + green)) {
			x = x - green;
			y = y - green;
			counterIncrease();
			green = newRune.getGreen(x, y);
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
