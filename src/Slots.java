import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Slots {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public static void Slots(Gracz player) {
        boolean playAgain = false;
        boolean betAgain = true;
        boolean play = true;
        double reward = 0;
        double bet = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        try {
            do {
                System.out.println("Witamy w Automacie! 1");
                System.out.println("Gra polega na wylosowaniu 3 tych samych liczb.");
                System.out.println("Twoje saldo wynosi: $" + player.getMoney());
                do {
                    System.out.println("Podaj kwotę którą chcesz postawić?");
                    bet = scanner.nextDouble();

                    if(bet > 0){
                        if(player.getMoney() < bet) System.out.println("Nie masz funduszy by tyle obstawić!");
                        else{
                            player.setMoney(player.getMoney() - bet);
                            betAgain = false;
                        }
                    }
                    else if(bet < 0){
                        System.out.println("Złe dane");
                    }
                }while (betAgain);
                System.out.println("Twoje saldo bo obstawieniu = $" + player.getMoney());
                System.out.println("Automat losuje twoje znaczki...");
                TimeUnit.SECONDS.sleep(3);
                int a = random.nextInt(100);
                int b = random.nextInt(5);
                int c = random.nextInt(5);
                int pierwsza = 0;
                int druga = 0;
                int trzecia = 0;
                if (a < 40)
                {
                    pierwsza = 5;
                }else if (a > 39 && a < 60)
                {
                    pierwsza = 4;
                }else if (a > 59 && a < 75)
                {
                    pierwsza = 3;
                }else if (a > 74 && a < 80)
                {
                    pierwsza = 2;
                }else if (a > 79 && a < 90)
                switch (pierwsza)
                {
                    case 0:
                        System.out.print(" 7");
                        break;
                    case 1:
                        System.out.print(" $");
                        break;
                    case 2:
                        System.out.print(" A");
                        break;
                    case 3:
                        System.out.print(" B");
                        break;
                    case 4:
                        System.out.print(" C");
                        break;
                    default:
                        System.out.print(" D");
                }

                switch (b)
                {
                    case 0:
                        System.out.print(" 7");
                        break;
                    case 1:
                        System.out.print(" $");
                        break;
                    case 2:
                        System.out.print(" A");
                        break;
                    case 3:
                        System.out.print(" B");
                        break;
                    case 4:
                        System.out.print(" C");
                        break;
                    default:
                        System.out.print(" D");
                }

                switch (c)
                {
                    case 0:
                        System.out.print(" 7");
                        break;
                    case 1:
                        System.out.print(" $");
                        break;
                    case 2:
                        System.out.print(" A");
                        break;
                    case 3:
                        System.out.print(" B");
                        break;
                    case 4:
                        System.out.print(" C");
                        break;
                    default:
                        System.out.print(" D");
                }
                if (a != b && a != c && b != c)
                {
                    System.out.println("\nNiestety nic nie wygrałeś.");
                }
                else if (a == b || a == c || b == c)
                {

                    System.out.println("\nGratuluję, wygrałeś $" + reward);
                    player.setMoney(player.getMoney() + reward); ;
                }
                else if (a == b && a == c && a != 0)
                {

                    System.out.println("\nGratuluję, wygrałeś $" + reward );
                    player.setMoney(player.getMoney() + reward);
                }
                else if (a == 0 && b == 0 && c == 0)
                {

                    System.out.println("\nGratuluję wygrałeś główną nagrodę $" + reward);

                }

                System.out.println("Continue? y/n ");
                scanner.next();






            }while(play);
        } catch (Exception exception) {
            exception.printStackTrace();
        }


    }
}
