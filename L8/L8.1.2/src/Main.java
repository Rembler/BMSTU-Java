public class Main {
    public static void main(String[] args) throws Exception {
        var robot = new Robot();

        robot.walk();

        Thread.sleep(5000);

        robot.stopWalking();
    }
}

