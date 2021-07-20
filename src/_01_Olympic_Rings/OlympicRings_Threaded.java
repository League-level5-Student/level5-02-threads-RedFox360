package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot[] robots = new Robot[5];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot((i+1) * 200, 700);
			robots[i].penDown();
		}
		for (int i = 0; i < robots.length; i++) {
			for (int k = 0; k < 360; k++) {
				robots[1].move(2);
				robots[1].setAngle(k);
			}
		}

	}
}
