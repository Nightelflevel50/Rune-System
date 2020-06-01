package version4;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.Scanner;

public class Image_Reader4 {

	/*
	 * public static int[] damage(int x, int y, Rune4 newRune) {
	 * 
	 * int red = newRune.getRed(x, y); int[] cords = { 0, 0, 0 }; while (x < (299 -
	 * red) & y < (299 - red)) { x = x + red; y = y + red; cords[2] += 1; red =
	 * newRune.getRed(x, y); }
	 * 
	 * cords[0] = x; cords[1] = y;
	 * 
	 * return cords; }
	 */

	/*
	 * public static int[] range(int x, int y, Rune4 newRune) { int green =
	 * newRune.getGreen(x, y); int[] cords = {0,0,0}; while (x > (0 + green) & y >
	 * (0 + green)) { x = x - green; y = y - green; cords[2] +=1; green =
	 * newRune.getGreen(x, y); }
	 * 
	 * cords[0] = x; cords[1] = y;
	 * 
	 * return cords; }
	 */

	public static int[] mana(int x, int y, Rune4 newRune) {
		int[] cords = { 0, 0, 0 };

		return cords;

	}

	public static Point2D startingPixel(Point2D Point1, Rune4 newRune) {
		Point2D crash = new Point2D.Double(6969, 6969);

		int x = (int) Point1.getX();
		int y = (int) Point1.getY();

		for (y = 1; y <= 298; y++) {

			for (x = 1; x <= 298; x++) {
				if(!newRune.isWhite(x, y) & newRune.pixelSurrounded(x, y)) {	
					Point1.setLocation(x,y);
					return Point1;
				}
			}
		}
		return crash;
	}

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);

		int x = 0;
		int y = 0;
		int[] cords = { 0, 0 };
		int[] damage_cords;
		int[] range_cords;
		Point2D Point1 = new Point2D.Double(0, 0);

		System.out.print("Paste the URL of the image you want to process: ");
		String url = myObj.nextLine();

		Rune4 newRune = new Rune4(url);

		
		  Point2D startingPixel = startingPixel(Point1, newRune); x = (int)
		  startingPixel.getX(); y = (int) startingPixel.getY();
		  
		  System.out.printf("The starting pixel for this is %d,%d\n", x, y);
		  
		  DamageAlgorithm damage = new DamageAlgorithm(startingPixel, newRune); Point2D
		  damagePixel = damage.theAlgorithm(); x = (int) damagePixel.getX(); y = (int)
		  damagePixel.getY();
		  System.out.printf("The damage stops at (%d,%d) and went for %d iterations\n",
		  x, y, damage.getCounter());
		  
		  RangeAlgorithm range = new RangeAlgorithm(damagePixel, newRune); Point2D
		  rangePixel = range.theAlgorithm(); x = (int) rangePixel.getX(); y = (int)
		  rangePixel.getY();
		  System.out.printf("The range stops at (%d,%d) and went for %d iterations\n",
		  x, y, range.getCounter()); myObj.close();
		 
		
		
		
		newRune.printImage();

	}

}
