public class Main {
    public static void main(String[] args) {
    ConsoleService serviceConsole = new ConsoleService();
    StateDAO state = new StateDAO();
    while (state.isRunning()){
    serviceConsole.main();

    }
    }
}
