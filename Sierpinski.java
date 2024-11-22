public class Sierpinski {

	
	/*
	 * this function draws each individual triangle
	 * @param double x0, x coordinate at bottom left of triangle
	 * @param double y0, y coordinate at bottom left of triangle
	 * @param double x1, x coordinate at bottom right of triangle
	 * @param double y1, y coordinate at bottom right of triangle
	 * @param double x2, x coordinate at top of triangle
	 * @param double y2, y coordinate at top of triangle
	 */
	public static void Triangle(double x0, double y0, double x1, double y1, double x2, double y2) {
		double[] x = new double[3];
		double[] y = new double[3];
		x[0] = x0;
		x[1] = x1;
		x[2] = x2;
		y[0] = y0;
		y[1] = y1;
		y[2] = y2;
		StdDraw.filledPolygon(x, y);
	}

	/*
	 * this function is doing the grunt work of making the fractal. it calls 
	 * the triangle function for each individual triangle at the coordinate points to make the smaller versions
	 * @param double x0, x coordinate at bottom left of triangle
	 * @param double y0, y coordinate at bottom left of triangle
	 * @param double x1, x coordinate at bottom right of triangle
	 * @param double y1, y coordinate at bottom right of triangle
	 * @param double x2, x coordinate at top of triangle
	 * @param double y2, y coordinate at top of triangle
	 * @param int level, the number of time it will run and make smaller triangles in the fractal
	 */
	public static void sierpinski(double x0, double y0, double x1, double y1, double x2, double y2, int level) {
		double x3 = (x0 + x2) / 2;// middle left
		double y3 = (y0 + y2) / 2;
		double x4 = (x1 + x0) / 2; // middle bottom
		double y4 = (y1 + y0) / 2;
		double x5 = (x1 + x2) / 2;// middle right
		double y5 = (y1 + y2) / 2;

		if (level == 0) {
			Triangle(x0, y0, x1, y1, x2, y2);
		} else {
			sierpinski(x0, y0, x4, y4, x3, y3, level - 1);// bottom left triangle
			sierpinski(x4, y4, x1, y1, x5, y5, level - 1);
			sierpinski(x3, y3, x5, y5, x2, y2, level - 1);// top triangle
		}
	}

	public static void main(String[] args) {
		Triangle(0, 0, 1, 0, .5, .866);
		sierpinski(0, 0, 1, 0, .7, .866, 5);

	}
}
