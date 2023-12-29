package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	
	public static void main(String[] args) {
		Robot rob1 = new Robot(200, 200);
		Robot rob2 = new Robot(300, 200);
		Robot rob3 = new Robot(400, 200);
		Robot rob4 = new Robot(250, 280);
		Robot rob5 = new Robot(350, 280);
		rob1.setSpeed(100);
		rob2.setSpeed(100);
		rob3.setSpeed(100);
		rob4.setSpeed(100);
		rob5.setSpeed(100);
		
		rob1.penDown();
		rob1.setPenColor(Color.blue);
		
		rob2.penDown();
		rob2.setPenColor(Color.black);
		
		rob3.penDown();
		rob3.setPenColor(Color.red);
		
		rob4.penDown();
		rob4.setPenColor(Color.yellow);
		
		rob5.penDown();
		rob5.setPenColor(Color.green);
		
			Thread r1 = new Thread(()->circle(rob1));
			Thread r2 = new Thread(()->circle(rob2));
			Thread r3 = new Thread(()->circle(rob3));
			Thread r4 = new Thread(()->circle(rob4));
			Thread r5 = new Thread(()->circle(rob5));
			
			r1.start();
			r2.start();
			r3.start();
			r4.start();
			r5.start();
		}
		
	static void circle(Robot rob) {
		for (int i = 0; i < 360; i++) {
			rob.move(1);
			rob.turn(1);
		}
		rob.penUp();
		rob.moveTo(0, 0);
	}
}

