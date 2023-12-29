package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	// 1. make a main method
	public static void main(String[] args) {
		// 2. create an array of 5 robots.

		Robot[] robs = new Robot[5];
		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < robs.length; i++) {
			robs[i] = new Robot();

		}
		// 4. make each robot start at the bottom of the screen, side by side, facing up
		for (int i = 0; i < robs.length; i++) {
			robs[i].setX(robs.length * i * 8 + 100);
			robs[i].setY(500);
			robs[i].setSpeed(10);
		}
		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
		Thread r1 = new Thread(()->race(robs[0]));
		Thread r2 = new Thread(()->race(robs[1]));
		Thread r3 = new Thread(()->race(robs[2]));
		Thread r4 = new Thread(()->race(robs[3]));
		Thread r5 = new Thread(()->race(robs[4]));
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
		// 6. use a while loop to repeat step 5 until a robot has reached the top of the
		// screen.

		// 7. declare that robot the winner and throw it a party!

		// 8. try different races with different amounts of robots.

		// 9. make the robots race around a circular track.

	}

	static void race(Robot rob) {
		Random random = new Random();
		boolean running = true;
		boolean canWin = false;
		String winner;
		while (running) {
			int rand = random.nextInt(50);
			rob.move(rand);
			if (rob.getY() - 100 <= 0) {
				rob.setAngle(90);

			}
			if (rob.getX() >= 600) {
				rob.setAngle(180);
				if (rob.getY() + 100 >= 600) {
					rob.setAngle(270);
					canWin = true;
				}
			}
			if (rob.getX() - 200 <= 100 && canWin == true) {
				running = false;
				System.out.println("stopped");
				winner = "rob";
				JOptionPane.showMessageDialog(null, "Robot " + winner + " is the winner");
				break;
			}

		}
	}
}
