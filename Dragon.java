public class Dragon {

	/*
	 * The function Dragon is similar to cCurve, but it makes it so that the lines on the bottom 
	 * are not doing the same thing as the lines on the top being split. this function after 
	 * level = ~6 starts to go off screen and at level = ~12 starts to take a while to draw
	 * @param double x0, the x coordinate for the bottom of the line/curve
	 * @param double y0, the y coordinate for the bottom of the line/curve
	 * @param double x1, the x coordinate for the top of the line/curve
	 * @param double y1, the y coordinate for the top of the line/curve
	 * @param int level, the amount of repetitons the dragon function will call itself (amount of times it will fractal)
	 */
public static void dragon(double x0, double y0, double x1, double y1, int level) {
		if (level == 0) {
			StdDraw.line(x0, y0, x1, y1);
		} else {
			double dx = x1 - x0;
			double dy = y1 - y0;
			double xm = (x1 + x1) / 2;
			double ym = (y1 + y1) / 2;
			double xNew = xm - dy/2;
			double yNew = ym + dx/2;
			dragon(x0, y0, xNew, yNew, level - 1);
			dragon(xNew, yNew, x1, y1, level - 1);
		}
	}

public static void main(String[] args) {
	int level = 8;
	double x0 = .5;
	double y0 = 0.33;
	double x1 = .5;
	double y1 = .57;
	
	dragon(x0, y0, x1, y1, level);
}
}
