import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Slots {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public void Slots(Gracz player) {
        boolean playAgain = false;
        boolean betAgain = true;
        boolean play = true;
        double reward = 0;
        double bet = 0;
        try {
        do {
            System.out.println("Witamy w Automacie! 1");
            System.out.println("Gra polega na wylosowaniu 3 tych samych liczb. Im większe liczby tym większa nagroda. Liczby są od 0 do 6 w 5 rzędach..");
            System.out.println("Twoje saldo wynosi: $" + player.getMoney());
            System.out.println("Jaką kwotę chcesz postawić?");
            do {

                System.out.println("Jaką kwotę chcesz postawić?");
                bet = scanner.nextDouble();
                if (bet > 0) {
                    if (player.getMoney() < bet) System.out.println("Nie masz tyle pieniędzy!");
                    else {
                        player.setMoney(player.getMoney() - bet);
                    }
                } else if (bet < 0) {
                    System.out.println("Podałeś złe dane.");
                }
            }while (betAgain);
            System.out.println("Twoje saldo bo obstawieniu = $" + player.getMoney());
            System.out.println("Automat losuje twoje liczby...");
            TimeUnit.SECONDS.sleep(3);
            int liczba1 = random.nextInt(7);
            int liczba2 = random.nextInt(7);
            int liczba3 = random.nextInt(7);



        }while(play);
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }
}
