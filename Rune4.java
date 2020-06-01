package version4;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rune4 {

	Image Rune;

	Rune4() {

	}

	Rune4(String url) {

		URL url1 = null;
		try {
			url1 = new URL(url);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Rune = ImageIO.read(url1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Image getRune() {

		return Rune;
	}

	int getRGB(int x, int y) {

		int rgb = ((BufferedImage) getRune()).getRGB(x, y);

		return rgb;
	}

	int getRed(int x, int y) {
		int rgb = getRGB(x, y);
		int red = (rgb >>> 16) & 0xFF;
		return red;
	}

	int getGreen(int x, int y) {
		int rgb = getRGB(x, y);
		int green = (rgb >>> 8) & 0xFF;
		return green;
	}

	int getBlue(int x, int y) {
		int rgb = getRGB(x, y);
		int blue = (rgb >>> 0) & 0xFF;
		return blue;
	}
	
	boolean isWhite(int x, int y) {
		getRGB(x,y);
		if(getRGB(x,y) == -1) {
			return true;
		}		
		//else
		return false;
	}
	
	boolean pixelSurrounded(int x, int y) {
		//What this if statement does is find if colored pixles completely surround a certain pixel (the inital parameter). 
		//There is probably a better way to do this but I don't know it. 
		if ( /*
				 * checkWhite(--x,--y) & checkWhite(x,--y) & checkWhite(++x,--y) &
				 * checkWhite(--x, y) & checkWhite(++x,y) & checkWhite(--x, ++y)&
				 * checkWhite(x,++y) & checkWhite(++x,++y)
				 */
			
			!isWhite(x - 1,y -1) &
			!isWhite(x, y -1)   &
			!isWhite(x + 1,y -1) &
			!isWhite(x -1, y)  &
			!isWhite(x + 1,y)   &
			!isWhite(x - 1, y + 1)&
			!isWhite(x,y + 1)   &
			!isWhite(x + 1,y + 1) 
				) {
			return true;
		}
		//else
		return false;
	}
	

	/* I don't remember what I was planning with this
	 * Point2D allPixles(int x, int y) { Point2D pixles = new Point2D.Double(x, y);
	 * return pixles; }
	 */
	
	
	

	Void printImage() {
		JFrame frame2 = new JFrame();
		frame2.setSize(350, 350);
		JLabel label2 = new JLabel(new ImageIcon(getRune()));
		frame2.add(label2);
		frame2.setVisible(true);
		return null;

	}

}
