package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot[] robots = new Robot[5];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot("batman");
			robots[i].penDown();
			robots[i].setSpeed(30);
		}
		
		robots[0].setPenColor(Color.blue);
		robots[0].setX(100);
		robots[0].setY(300);
		
		robots[1].setPenColor(Color.BLACK);
		robots[1].setX(250);
		robots[1].setY(300);
		
		robots[2].setPenColor(Color.RED);
		robots[2].setX(400);
		robots[2].setY(300);
		
		robots[3].setPenColor(Color.YELLOW);
		robots[3].setX(175);
		robots[3].setY(350);
		
		robots[4].setPenColor(Color.GREEN);
		robots[4].setX(325);
		robots[4].setY(350);
		Thread first = new Thread(() -> move(robots[0]));
		Thread second = new Thread(() -> move(robots[1]));
		Thread third = new Thread(() -> move(robots[2]));
		Thread fourth = new Thread(() -> move(robots[3]));
		Thread fifth = new Thread(() -> move(robots[4]));
		
		first.start();
		second.start();
		third.start();
		fourth.start();
		fifth.start();

	}
	
	private static void move(Robot r) {
		for (int k = 0; k < 360; k++) {
			r.move(1);
			r.setAngle(k);
		}
	}
}
