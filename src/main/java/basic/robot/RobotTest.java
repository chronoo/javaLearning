package basic.robot;

/**
 * RobotTest
 */
public class RobotTest {

    public static void main(String[] args) {
        Robot robo = new Robot();
        moveRobot(robo, -3, -5);
        System.out.println(robo.getX() + ":" + robo.getY());
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int delta_x = toX - robot.getX();
        int delta_y = toY - robot.getY();
        Direction direction = robot.getDirection();

        if (delta_x > 0) {
            if (direction == Direction.LEFT) {
                robot.turnLeft();
                robot.turnLeft();
            }
            else if (direction == Direction.UP) {
                robot.turnRight();
            }
            else if (direction == Direction.DOWN) {
                robot.turnLeft();
            }
            for (int i = 0; i < delta_x; i++) {
                robot.stepForward();
            }
        } else if (delta_x < 0) {
            if (direction == Direction.RIGHT) {
                robot.turnLeft();
                robot.turnLeft();
            } else if (direction == Direction.DOWN) {
                robot.turnRight();
            } else if (direction == Direction.UP) {
                robot.turnLeft();
            }
            for (int i = 0; i < -delta_x; i++) {
                robot.stepForward();
            }
        }

        direction = robot.getDirection();

        if (delta_y > 0) {
            if (direction == Direction.DOWN) {
                robot.turnLeft();
                robot.turnLeft();
            }
            else if (direction == Direction.LEFT) {
                robot.turnRight();
            }
            else if (direction == Direction.RIGHT) {
                robot.turnLeft();
            }
            for (int i = 0; i < delta_y; i++) {
                robot.stepForward();
            }
        } else if (delta_y < 0) {
            if (direction == Direction.UP) {
                robot.turnLeft();
                robot.turnLeft();
            }
            else if (direction == Direction.RIGHT) {
                robot.turnRight();
            }
            else if (direction == Direction.LEFT) {
                robot.turnLeft();
            }
            for (int i = 0; i < -delta_y; i++) {
                robot.stepForward();
            }
        }
    }
}