package smcs.advtopics.FunnyFaceAndTopHat;

import objectdraw.*;

public class FunnyFaceWithTopHatV1 {
	private FunnyFace ff;
	private FilledOval brim, top;
	private FilledRect hat;
	
	private static final int
			HAT_WIDTH = 50,
			HAT_HEIGHT = 40,
			HAT_Y_OFFSET = 30 + HAT_HEIGHT,
			HAT_X_OFFSET = HAT_WIDTH / 2;

	public FunnyFaceWithTopHatV1(double x, double y, DrawingCanvas canvas) {
		ff = new FunnyFace(x, y, canvas);
		hat = new FilledRect(x-HAT_X_OFFSET, y-HAT_Y_OFFSET, HAT_WIDTH, HAT_HEIGHT, canvas);
	}

	public void moveTo(Location point) {
		ff.moveTo(point);
		hat.moveTo(point.getX() - HAT_X_OFFSET, point.getY() - HAT_Y_OFFSET);
	}
}
