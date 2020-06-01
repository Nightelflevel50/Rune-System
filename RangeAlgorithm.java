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
			//This is for diagonal upper left
			System.out.printf("Range UL %d %d\n", x, y);
			int temp_x = x - green;
			int temp_y = y - green;
			if (newRune.isWhite(temp_x, temp_y)) {
				System.out.printf("Range it returned white\n");
				break;
			}
			counterIncrease();
			x = temp_x;
			y = temp_y;
			green = newRune.getGreen(x, y);
		}
		
		while (x < (299 - green) & y > green) {
			//This is for diagonal upper right
			System.out.printf("Range UR %d %d\n", x, y);
			int temp_x = x - green;
			int temp_y = y - green;
			if (newRune.isWhite(temp_x, temp_y)) {
				System.out.printf("Range it returned white\n");
				break;
			}
			counterIncrease();
			x = temp_x;
			y = temp_y;
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
