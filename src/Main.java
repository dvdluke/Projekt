import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Gracz playerOne = new Gracz("Filip",500,18,0);
        LuckyMachine luckyMachine = new LuckyMachine();
        Pozyczka rent = new Pozyczka();

        Scanner scanner = new Scanner(System.in);
        boolean stan = true;
        do{
            if(playerOne.getMoney() <= 0 && playerOne.getAge() >= 18 && playerOne.getRent() < 3){
                System.out.println("Nie masz wystarczająco pieniędzy!\nMenu:\n[1] Pożyczka\n[2] Wyjdź z kasyna\n----Saldo = " + playerOne.getMoney() + "----");
                String choice = scanner.next();
                switch (choice) {
                    case "2" -> {
                        System.out.println("Wyszedłeś z Kasyna");
                        stan = false;
                    }
                    case "1" -> {
                        rent.PozyczkaPieniedzy(playerOne);
                    }
                    default -> System.out.println("Błąd");
                }
            }
            else if (playerOne.getAge() >= 18 && playerOne.getMoney() > 0){
                System.out.println("Opcje:\n[1] luckyMachine\n[2] luckyMachine\n[3] luckyMachine\n[4] luckyMachine\n[5] Wyjdź z kasyna\n----Saldo = " + playerOne.getMoney() + "----");
                String choice = scanner.next();
                switch (choice) {

                    case "1" -> {
                        luckyMachine.luckyMachineGame(playerOne);
                    }
                    case "2" -> {
                        System.out.println("Exit");
                        stan = false;
                    }
                    case "3" -> {
                        System.out.println("Exi");
                        stan = false;
                    }
                    case "4" -> {
                        System.out.println("Ex");
                        stan = false;
                    }
                    case "5" -> {
                        System.out.println("E");
                        stan = false;
                    }
                    default -> System.out.println("Błąd");
                }
            }
            else{
                System.out.println("jesteś niepełnoletni");
                stan = false;
            }

        }while (stan);


    }
}