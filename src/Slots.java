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
                System.out.println("Gra polega na wylosowaniu 3 tych samych liczb. Im większe liczby tym większa nagroda. Liczby są od 0 do 6.");
                System.out.println("Twoje saldo wynosi: $" + player.getMoney());
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
                int a = random.nextInt(7);
                int b = random.nextInt(7);
                int c = random.nextInt(7);
                switch (a)
                {
                    case 0:
                        System.out.println("7");
                        break;
                    case 1:
                        System.out.println("$");
                        break;
                    case 2:
                        System.out.println("A");
                        break;
                    case 3:
                        System.out.println("B");
                        break;
                    case 4:
                        System.out.println("C");
                        break;
                    default:
                        System.out.println("D");
                }

                switch (b)
                {
                    case 0:
                        System.out.println("7");
                        break;
                    case 1:
                        System.out.println("$");
                        break;
                    case 2:
                        System.out.println("A");
                        break;
                    case 3:
                        System.out.println("B");
                        break;
                    case 4:
                        System.out.println("C");
                        break;
                    default:
                        System.out.println("D");
                }

                switch (c)
                {
                    case 0:
                        System.out.println("7");
                        break;
                    case 1:
                        System.out.println("$");
                        break;
                    case 2:
                        System.out.println("A");
                        break;
                    case 3:
                        System.out.println("B");
                        break;
                    case 4:
                        System.out.println("C");
                        break;
                    default:
                        System.out.println("D");
                }
                if (a != b && a != c && b != c)
                {
                    System.out.println("Niestety nic nie wygrałeś.");
                }
                else if (a == b || a == c || b == c)
                {

                    System.out.println("Gratuluję, wygrałeś $" + reward);
                    player.setMoney(player.getMoney() + reward); ;
                }
                else if (a == b && a == c && a != 0)
                {

                    System.out.println("Gratuluję, wygrałeś $" + reward );
                    player.setMoney(player.getMoney() + reward);
                }
                else if (a == 0 && b == 0 && c == 0)
                {

                    System.out.println("Gratuluję wygrałeś główną nagrodę $" + reward);

                }

                System.out.println("Continue? y/n ");
                scanner.next();






            }while(play);
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }
}
