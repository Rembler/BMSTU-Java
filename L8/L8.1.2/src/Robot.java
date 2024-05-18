import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Robot {
    private final Leg _leftLeg = new Leg("LEFT");
    private final Leg _rightLeg = new Leg("RIGHT");
    private ExecutorService _walkExecutorService = null;

    public void walk() throws Exception {
        _walkExecutorService = Executors.newFixedThreadPool(2);

        _walkExecutorService.submit(_leftLeg);
        Thread.sleep(_leftLeg.getActionExecutionTimeMs());
        _walkExecutorService.submit(_rightLeg);
    }

    public void stopWalking() {
        _walkExecutorService.shutdownNow();
    }

    public static class Leg implements Callable<Object> {
        private final String _completionMessage;
        private final long _actionExecutionTimeMs;
        private final long _idleTimeMs;

        public Leg(String completionMessage) {
            _completionMessage = completionMessage;
            _actionExecutionTimeMs = 500;
            _idleTimeMs = 500;
        }

        public long getActionExecutionTimeMs() {
            return _actionExecutionTimeMs;
        }

        @Override
        public Object call() throws Exception {
            move();

            return null;
        }

        private void move() throws Exception {
            while (true) {
                Thread.sleep(_actionExecutionTimeMs);

                System.out.println(_completionMessage);

                Thread.sleep(_idleTimeMs);
            }
        }
    }
}
