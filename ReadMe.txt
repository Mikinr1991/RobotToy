install java and put it in classpath.
Download RobotToy.jar file from github/mail and put in some folder(called desktop). 
open command prompt and go to the folder where this jar file exists.
below is command how to run application.
syntax:
java -jar jarfilename inputparameter
example: 
java -jar RobotToy.jar PLACE 1,2,EAST MOVE MOVE LEFT MOVE REPORT

Input: 
java -jar RobotToy.jar PLACE 0,0,NORTH MOVE REPORT
Output: 0,1,NORTH

Input: 
java -jar RobotToy.jar PLACE 0,0,NORTH LEFT REPORT

Output: 0,0,WEST

Input: 
java -jar RobotToy.jar PLACE 1,2,EAST MOVE MOVE LEFT MOVE REPORT

Output: 3,3,NORTH

Input:
java -jar RobotToy.jar MOVE MOVE LEFT MOVE
REPORT
Output:

Input: 
java -jar RobotToy.jar PLACE 0,0,NORTH LEFT MOVE MOVE RIGHT MOVE LEFT MOVE RIGHT MOVE MOVE RIGHT MOVE  LEFT REPORT MOVE MOVE LEFT MOVE REPORT 

Output:1,3,NORTH
0,4,WEST

Input: 
java -jar RobotToy.jar PLACE 0,0,NORTH LEFT MOVE MOVE MOVE MOVE MOVE MOVE MOVE MOVE RIGHT MOVE  MOVE RIGHT MOVE MOVE RIGHT MOVE  LEFT REPORT MOVE MOVE LEFT MOVE

Output:2,1,EAST

Input: 
java -jar RobotToy.jar PLACE 0,0,NORTH RIGHT MOVE MOVE MOVE MOVE MOVE MOVE MOVE MOVE LEFT MOVE  MOVE LEFT MOVE MOVE RIGHT MOVE  REPORT  MOVE MOVE MOVE MOVE MOVE MOVE MOVE MOVE LEFT MOVE REPORT

Output:2,3,NORTH
1,4,WEST

Input: 
java -jar RobotToy.jar PLACE 0,0,NORTH RIGHT MOVE MOVE MOVE MOVE MOVE MOVE MOVE MOVE REPORT PLACE 3,4,WEST REPORT LEFT MOVE  MOVE LEFT MOVE MOVE RIGHT MOVE  REPORT PLACE 4,4,SOUTH MOVE MOVE MOVE MOVE MOVE MOVE MOVE MOVE LEFT MOVE REPORT

Output:4,0,EAST
3,4,WEST
4,1,SOUTH
4,0,EAST


Input: 
java -jar RobotToy.jar PLACE 5,5,NORTH RIGHT MOVE MOVE MOVE MOVE MOVE MOVE MOVE MOVE REPORT PLACE 3,4,WEST REPORT LEFT MOVE  MOVE LEFT MOVE MOVE RIGHT MOVE  REPORT PLACE 4,4,SOUTH MOVE MOVE MOVE MOVE MOVE MOVE MOVE MOVE LEFT MOVE REPORT 

Output:Please try to place Robot in 5 * 5 table. Ignoring this place command as not correctly placed and will inore other command untill next place command found
3,4,WEST
4,1,SOUTH
4,0,EAST