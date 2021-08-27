package com.toy.robot.entity;

import com.toy.robot.constant.Commands;
import com.toy.robot.constant.FaceDirection;

public class Robot {

	private Table table;
	private int xAxisLocation = -1;
	private int yAxisLocation = -1;
	
	private FaceDirection faceDirection;
	
   public Robot() {
		table = new Table();  // in future we can make changes in table if required but for now this is enough
	}

	public Robot(int xAxisLocation, int yAxisLocation,FaceDirection faceDirection) throws Exception {
		
		this.xAxisLocation = xAxisLocation;
		this.yAxisLocation = yAxisLocation;
		this.faceDirection = faceDirection;
		table = new Table();  // in future we can make changes in table if required but for now this is enough
		displayErrorIfWrongPlaced();
	}
	
	// we need to later if in case x and y axis increases from 5
	//if increased from 5 then show error and return false
	public boolean move() throws Exception {
		if (faceDirection == null || xAxisLocation < 0 || yAxisLocation < 0 || xAxisLocation > 4 || yAxisLocation > 4) {
			//Ignoring MOVE command as Correct PLACE command is not found yet
		} else {
			if (this.faceDirection.equals(FaceDirection.NORTH) && yAxisLocation <= (table.Y_AXIS_MAX_LENGTH -2)) {
				yAxisLocation++;
			} else if (this.faceDirection.equals(FaceDirection.SOUTH) && yAxisLocation >= 1) {
				yAxisLocation--;
			} else if (this.faceDirection.equals(FaceDirection.WEST) && xAxisLocation >= 1) {
				xAxisLocation--;
			} else if (this.faceDirection.equals(FaceDirection.EAST) && xAxisLocation <= (table.X_AXIS_MAX_LENGTH -2)) {
				xAxisLocation++;
			}
			//displayErrorIfWrongMove();
		}

			return true;
	}
  	
	
	public boolean setFaceDirection(Commands command) {
		if (faceDirection == null || xAxisLocation < 0 || yAxisLocation < 0 || xAxisLocation > 4 || yAxisLocation > 4) {
			//Ignoring MOVE command as Correct PLACE command is not found yet
		} else {
			if (command.equals(command.LEFT)) {
				if (this.faceDirection.equals(FaceDirection.NORTH)) {
					this.faceDirection = FaceDirection.WEST;
				} else if (this.faceDirection.equals(FaceDirection.SOUTH)) {
					this.faceDirection = FaceDirection.EAST;
				} else if (this.faceDirection.equals(FaceDirection.WEST)) {
					this.faceDirection = FaceDirection.SOUTH;
				} else if (this.faceDirection.equals(FaceDirection.EAST)) {
					this.faceDirection = FaceDirection.NORTH;
				}

			} else if (command.equals(command.RIGHT)) {
				if (this.faceDirection.equals(FaceDirection.NORTH)) {
					this.faceDirection = FaceDirection.EAST;
				} else if (this.faceDirection.equals(FaceDirection.SOUTH)) {
					this.faceDirection = FaceDirection.WEST;
				} else if (this.faceDirection.equals(FaceDirection.WEST)) {
					this.faceDirection = FaceDirection.NORTH;
				} else if (this.faceDirection.equals(FaceDirection.EAST)) {
					this.faceDirection = FaceDirection.SOUTH;
				}
			}
		}
		return true;

	}
	
	public boolean reportLocation() {		
		if (faceDirection == null || xAxisLocation < 0 || yAxisLocation < 0 || xAxisLocation > 4 || yAxisLocation > 4) {
			//Ignoring Report command as Correct PLACE command is not found yet
		}else {
			
			System.out.println(xAxisLocation+","+yAxisLocation+","+faceDirection);		
		}
		return true;

	}
	
	public void displayErrorIfWrongPlaced() throws Exception {
		if (xAxisLocation >= table.X_AXIS_MAX_LENGTH || xAxisLocation < 0 ||
				yAxisLocation >= table.Y_AXIS_MAX_LENGTH || yAxisLocation < 0) {
			System.out.println("Please try to place Robot in 5 * 5 table. "
					+ "Ignoring this place command as not correctly placed and will inore other command "
					+ "untill next place command found");
		}

	}
	
	/* Currently this method is not used but might need to use in future*/
	public void displayErrorIfWrongMove() throws Exception {
		if (xAxisLocation >= table.X_AXIS_MAX_LENGTH || xAxisLocation < 0) {
			throw new Exception("Robot has moved out of table in X direction");
		} else if (yAxisLocation >= table.Y_AXIS_MAX_LENGTH || yAxisLocation < 0) {
			throw new Exception("Robot has moved out of table in Y direction");
		}

	}

	public void setxAxisLocation(int xAxisLocation) {
		this.xAxisLocation = xAxisLocation;
	}

	public void setyAxisLocation(int yAxisLocation) {
		this.yAxisLocation = yAxisLocation;
	}


	public int getxAxisLocation() {
		return xAxisLocation;
	}

	public int getyAxisLocation() {
		return yAxisLocation;
	}



}
