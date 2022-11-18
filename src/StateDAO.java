public class StateDAO {
    private static boolean running;
    public StateDAO(){
        running = true;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        StateDAO.running = running;
    }
}
