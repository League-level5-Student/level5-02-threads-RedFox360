package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// 1. make a main method
	static boolean raceOver = false;

	public static void main(String[] args) {
		// 2. create an array of 5 robots.
		Robot[] r = new Robot[5];
		// 3. use a for loop to initialize the robots.
		int x = 100;
		for (int i = 0; i < r.length; i++) {
			r[i] = new Robot("mini");
			r[i].setY(550);
			r[i].setSpeed(8);
			r[i].setX(x);
			x += 180;
		}
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
		Thread first = new Thread(() -> move(r[0], 0));
		Thread second = new Thread(() -> move(r[1], 1));
		Thread third = new Thread(() -> move(r[2], 2));
		Thread fourth = new Thread(() -> move(r[3], 3));
		Thread fifth = new Thread(() -> move(r[4], 4));
		// 6. use a while loop to repeat step 5 until a robot has reached the top of the
		// screen.
		first.start();
		second.start();
		third.start();
		fourth.start();
		fifth.start();
		// 7. declare that robot the winner and throw it a party!

		// 8. try different races with different amounts of robots.

		// 9. make the robots race around a circular track.
	}

	private static void move(Robot r, int pos) {
		while (raceOver == false) {
			if (r.getY() < 0) {
				System.out.println("Robot " + (pos + 1) + " won the race!");
				raceOver = true;
			} else {
				r.move(new Random().nextInt(50));
			}
		}
	}
}
