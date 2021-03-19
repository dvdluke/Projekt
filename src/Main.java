import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Gracz playerOne = new Gracz("Krzysiek",650,52,0);
        SzczesliwaLiczba SzczesliwaLiczba = new SzczesliwaLiczba();
        Pozyczka Pozyczka = new Pozyczka();

        System.out.println("Witamy w kasynie " + playerOne.getName() + "!");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        boolean stan = true;
        do{
            if(playerOne.getMoney() <= 0 && playerOne.getAge() >= 18 && playerOne.getRent() < 3){
                System.out.println("Nie masz wystarczająco pieniędzy!\nMenu:\n[1] Pożyczka\n[2] Wyjdź z kasyna\n----Saldo = $" + playerOne.getMoney() + "----");
                String choice = scanner.next();
                switch (choice) {
                    case "2" -> {
                        System.out.println("Wyszedłeś z Kasyna");
                        stan = false;
                    }
                    case "1" -> {
                        Pozyczka.PozyczkaPieniedzy(playerOne);
                    }
                    default -> System.out.println("Błąd");
                }
            }
            else if (playerOne.getAge() >= 18 && playerOne.getMoney() > 0){
                System.out.println("Opcje:\n[1] Slots\n[2] Ruletka\n[3] BlackJack\n[4] Lotto\n[5] Zasady gier\n[6] Wyjdź z kasyna\n----Saldo = $" + playerOne.getMoney() + "----");
                String choice = scanner.next();
                switch (choice) {

                    case "1" -> {
                        Slots.Slots(playerOne);
                    }
                    case "2" -> {
                        Ruletka.Ruletka(playerOne);
                    }
                    case "3" -> {
                        BlackJack.BlackJackGame(playerOne);
                    }
                    case "4" -> {
                        SzczesliwaLiczba.SzczesliwaLiczbaGame(playerOne);
                    }
                    case "5" -> {
                        System.out.println("Jesteś za młody na kasyno jeżeli nie znasz zasad.");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(" __    _  _______  __   __  ______    _______ ");
                        System.out.println("|  |  | ||   _   ||  | |  ||    _ |  |   _   |");
                        System.out.println("|   |_| ||  |_|  ||  | |  ||   | ||  |  |_|  |");
                        System.out.println("|       ||       ||  |_|  ||   |_||_ |       |");
                        System.out.println("|  _    ||       ||       ||    __  ||       |");
                        System.out.println("| | |   ||   _   ||       ||   |  | ||   _   |");
                        System.out.println("|_|  |__||__| |__||_______||___|  |_||__| |__|");
                        stan = false;
                    }
                    case "6" -> {
                        System.out.println("Wyszedłeś z kasyna.");
                        stan = false;
                    }
                    default -> System.out.println("Błąd");
                }
            }
            else{
                System.out.println("Jesteś niepełnoletni lub przekroczyłeś limit pożyczek kasyna");
                stan = false;
            }

        }while (stan);


    }
}