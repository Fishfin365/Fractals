public class CoolFractal {
	
	/*
	 * this Square function draws the square  y using the 4 x,y coordinated given to the function
	 * @param double x0, bottom left coordinate of the square to be drawn
	 * @param double y0, bottom left coordinate of the square to be drawn
	 * @param double x1, bottom right coordinate of the square to be drawn
	 * @param double y1, bottom right coordinate of the square to be drawn
	 * @param double x2, top right coordinate of the square to be drawn
	 * @param double y2, top right coordinate of the square to be drawn
	 * @param double x3, top left coordinate of the square to be drawn
	 * @param double y3, top left coordinate of the square to be drawn
	 */
	
	public static void Square (double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3) {
		double[] x = new double[4];
		double[] y = new double[4];
		x[0] = x0;
		x[1] = x1;
		x[2] = x2;
		x[3] = x3;
		
		y[0] = y0;
		y[1] = y1;
		y[2] = y2;
		y[3] = y3;
		StdDraw.filledPolygon(x, y);
	}
	
	
	/*
	 * Squactal draws is a fractal function that calls itself.
	 * the over all shape it will make is a kite shape made of squares of various sizes based on the level. 
	 * the main function is the best spot to have the function in order to see it until 9 the first it will 
	 * make one square, then it will add a square (3 smaller and 1 same size) to each corner of the existing 
	 * square. it continues to do thiz for each level inputted. once it goes beyond about the level value 
	 * of 9, it goes of screen and takes a long time to draw the squares. 
	 * @param double x0, bottom left coordinate of the square
	 * @param double y0, bottom left coordinate of the square
	 * @param double x1, bottom right coordinate of the square
	 * @param double y1, bottom right coordinate of the square
	 * @param double x2, top right coordinate of the square
	 * @param double y2, top right coordinate of the square
	 * @param double x3, top left coordinate of the square
	 * @param double y3, top left coordinate of the square
	 * @param int level, the number of fractal branches it makes (how many times it repeats and adds a square to each squares corner
	 * @param double squareSize, the size of the initial squares length of a side  (after the first iteration it gets divided by 2 each time)
	 */
	
	public static void Squactal (double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, int level, double squareSize) {
		if (level == 1) {
			Square(x0,y0, x1,y1, x2,y2, x3,y3);
		}
		else {
			Square(x0,y0, x1,y1, x2,y2, x3,y3);
			Squactal(x0-squareSize,y0-squareSize, x0,y0-squareSize, x0,y0, x0-squareSize,y0, level-1, squareSize /= 2);//bottom left
			Squactal(x1,y1-squareSize, x1+squareSize,y1-squareSize, x1+squareSize,y1, x1,y1, level-1, squareSize );//bottom right
			Squactal(x2,y2, x2+squareSize,y2, x2+squareSize,y2+squareSize, x2,y2+squareSize, level-1, squareSize );//top right
			Squactal(x3-squareSize,y3, x3,y3, x3,y3+squareSize, x3-squareSize,y3+squareSize, level-1, squareSize );//top left
		}
	}
	
	public static void main (String[] args) {
		Squactal (.43,.43, .76,.43, .76,.76, .43,.76, 7, .2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}