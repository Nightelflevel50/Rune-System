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
			// This is for diagonal bottom right
			System.out.printf("Damage BR %d %d\n", x, y);
			int temp_x = x + red;
			int temp_y = y + red;
			if (newRune.isWhite(temp_x, temp_y)) {
				System.out.printf("poopy it returned white\n");
				break;
			}
			counterIncrease();
			x = temp_x;
			y = temp_y;
			red = newRune.getRed(x, y);
		}

		while (x > red & y < (299 - red)) {
			// This is for diagonal bottom left
			System.out.printf("Damage BL %d %d\n", x, y);
			int temp_x = x - red;
			int temp_y = y + red;
			if (newRune.isWhite(temp_x, temp_y)) {
				System.out.printf("poopy it returned white\n");
				break;
			}
			counterIncrease();
			x = temp_x;
			y = temp_y;
			red = newRune.getRed(x, y);
		}

		/* These are for upper left and upper right, I am not sure if I want to use these yet
		 * 
		 * while (x > red & y > red) {
		 * 
		 * // This is for diagonal upper left x = x - red; y = y - red;
		 * counterIncrease(); red = newRune.getRed(x, y); }
		 * 
		 * while (x < (299 - red) & y > red) { // This is for diagonal upper right
		 * System.out.printf("%d %d\n", x, y); x = x + red; y = y - red;
		 * counterIncrease(); red = newRune.getRed(x, y); }
		 */

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

