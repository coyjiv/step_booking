import java.util.Scanner;

public class ConsoleService {
    private boolean exit;
    public ConsoleService(){
        exit = false;
    }
    static {
        System.out.println("Приветствуем в программе для бронировки авиабилетов");
    }
    public void dispayMenu(){
        System.out.println("1. Онлайн-табло");
        System.out.println("2. Посмотреть информацию о рейсе");
        System.out.println("3. Поиск и бронировка рейса");
        System.out.println("4. Отменить бронирование");
        System.out.println("5. Мои рейсы");
        System.out.println("6. Выход");
    }

    public void main() {
        Scanner optionScanner = new Scanner(System.in);
        StateDAO state = new StateDAO();
        int option;
        this.dispayMenu();
        while(!optionScanner.hasNextInt()){
            System.out.println("Вы ввели не число");
            System.out.println("Введите заново");
            optionScanner.next();
        }
        option = optionScanner.nextInt();
        switch (option) {
            case 1 -> System.out.println("online tb");
            case 2 -> System.out.println("info");
            case 3 -> System.out.println("Search");
            case 4 -> System.out.println("Cancel");
            case 5 -> System.out.println("My tickets");
            case 6 -> state.setRunning(false);
            default -> {
                System.out.println("Error");
                optionScanner.next();
            }
        }
    }
}
