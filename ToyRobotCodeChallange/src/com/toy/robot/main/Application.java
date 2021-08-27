package com.toy.robot.main;

import com.toy.robot.constant.Commands;
import com.toy.robot.constant.FaceDirection;
import com.toy.robot.entity.Robot;


/*This class is main class*/
public class Application {

	public static void main(String[] args) throws Exception{
		
		
		Robot robot = null;
		String[] locationArray = new String[3];
		
		for (int i = 0; i < args.length; i++) {
			
			switch (Commands.valueOf(args[i])) {
			case PLACE:
				try {
				locationArray = args[i+1].split(",");
				robot = new Robot(Integer.parseInt(locationArray[0]),
						        Integer.parseInt(locationArray[1]),
						        FaceDirection.valueOf(locationArray[2]));
				}catch (Exception e) {
					robot = new Robot();
					e.printStackTrace();
					 //throw new Exception("Invalid PLACE command found check below logs for more details \n"+e.getMessage());
					 System.out.println("Invalid PLACE command found."
								+ " Ignoring this PLACE command as not correctly placed and will inore other command "
								+ "untill next PLACE command found");
				}
				i++;       //increase index by one as in PLACE command they will provide location detains in next index
				break;

			case MOVE:
				if(robot == null) robot = new Robot();
				robot.move();
				break;

			case LEFT:
				if(robot == null) robot = new Robot();
				robot.setFaceDirection(Commands.LEFT);
				break;

			case RIGHT:
				if(robot == null) robot = new Robot();
				robot.setFaceDirection(Commands.RIGHT);
				break;

			case REPORT:
				robot.reportLocation();
				break;
			default:
				break;
			}
			
		}

	}

}
