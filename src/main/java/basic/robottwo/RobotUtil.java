package basic.robottwo;

/**
 * RobotUtil
 */
public class RobotUtil {
    public static void main(String[] args) {
        RobotConnectionManager manager = new RobotConnectionManagerImpl();
        moveRobot(manager, 2, 3);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean done = false;
        int tryCount = 0;
        do {
            tryCount++;
            try (RobotConnection connect = robotConnectionManager.getConnection()) {
                connect.moveRobotTo(toX, toY);
                done = true;
            } catch (RobotConnectionException e) {
            }
        } while (tryCount < 3 && !done);
        if (!done) {
            throw new RobotConnectionException("fail");
        }
    }
}

class RobotConnectionImpl implements RobotConnection {
    public RobotConnectionImpl() {
        // throw new RobotConnectionException("don't open");
    }

    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("move to " + x + ":" + y + "!");
        // throw new RuntimeException();
    }

    @Override
    public void close() {
        System.out.println("Close connection");
        throw new RobotConnectionException("don't close");
    }
}

class RobotConnectionManagerImpl implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        return new RobotConnectionImpl();
    }
}