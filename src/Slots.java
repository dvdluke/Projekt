import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Slots {

    public static void Slots(Gracz player) throws InterruptedException {
        boolean playAgain = false;
        boolean betAgain = true;
        boolean play = true;
        boolean kłódka;
        double reward;
        double bet;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println(" ");System.out.println(" ");System.out.println(" ");
        System.out.println("It's time for soooooommme");
        System.out.println(" _______  ___      _______  _______  _______ ");
        System.out.println("|       ||   |    |       ||       ||       |");
        System.out.println("|  _____||   |    |   _   ||_     _||  _____|");
        System.out.println("| |_____ |   |    |  | |  |  |   |  | |_____ ");
        System.out.println("|_____  ||   |___ |  |_|  |  |   |  |_____  |");
        System.out.println(" _____| ||       ||       |  |   |   _____| |");
        System.out.println("|_______||_______||_______|  |___|  |_______|");
        System.out.println(" ");System.out.println(" ");System.out.println(" ");

        try {
                System.out.println("Witamy w Automacie! ");
                System.out.println("Gra polega na wylosowaniu 3 tych samych liczb.");
                System.out.println("Twoje saldo wynosi: $" + player.getMoney());
                do {
                do {
                    kłódka = true;
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
                int a = random.nextInt(101);
                int b = random.nextInt(101);
                int c = random.nextInt(101);
                int pierwsza = 0;
                int druga = 0;
                int trzecia = 0;
                if (a < 19)
                {
                    pierwsza = 5;
                }else if (a > 18 && a < 38)
                {
                    pierwsza = 4;
                }else if (a > 37 && a < 57)
                {
                    pierwsza = 3;
                }else if (a > 56 && a < 76)
                {
                    pierwsza = 2;
                }else if (a > 75 && a < 95)
                {
                    pierwsza = 1;
                }else if (a > 94 && a < 101)
                {
                    pierwsza = 0;
                }
                switch (pierwsza)
                {
                    case 0:
                        System.out.print("|| 7 ||");
                        break;
                    case 1:
                        System.out.print("|| $ ||");
                        break;
                    case 2:
                        System.out.print("|| A ||");
                        break;
                    case 3:
                        System.out.print("|| B ||");
                        break;
                    case 4:
                        System.out.print("|| C ||");
                        break;
                    default:
                        System.out.print("|| D ||");
                }
                if (b < 19)
                {
                    druga = 5;
                }else if (b > 18 && b < 38)
                {
                    druga = 4;
                }else if (b > 37 && b < 57)
                {
                    druga = 3;
                }else if (b > 56 && b < 76)
                {
                    druga = 2;
                }else if (b > 75 && b < 95)
                {
                    druga = 1;
                }else if (b > 94 && b < 101)
                {
                    druga = 0;
                }
                switch (druga)
                {
                    case 0:
                        System.out.print(" 7 ||");
                        break;
                    case 1:
                        System.out.print(" $ ||");
                        break;
                    case 2:
                        System.out.print(" A ||");
                        break;
                    case 3:
                        System.out.print(" B ||");
                        break;
                    case 4:
                        System.out.print(" C ||");
                        break;
                    default:
                        System.out.print(" D ||");
                }
                if (c < 19)
                {
                    trzecia = 5;
                }else if (c > 18 && c < 38)
                {
                    trzecia = 4;
                }else if (c > 37 && c < 57)
                {
                    trzecia = 3;
                }else if (c > 56 && c < 76)
                {
                    trzecia = 2;
                }else if (c > 75 && c < 95)
                {
                    trzecia = 1;
                }else if (c > 94 && c < 101)
                {
                    trzecia = 0;
                }
                switch (trzecia)
                {
                    case 0:
                        System.out.print(" 7 ||");
                        break;
                    case 1:
                        System.out.print(" $ ||");
                        break;
                    case 2:
                        System.out.print(" A ||");
                        break;
                    case 3:
                        System.out.print(" B ||");
                        break;
                    case 4:
                        System.out.print(" C ||");
                        break;
                    default:
                        System.out.print(" D ||");
                }
                if (pierwsza != druga && pierwsza != trzecia && druga != trzecia)
                {
                    System.out.println("\nNiestety nic nie wygrałeś. ;(");

                }
                else if (pierwsza == druga || pierwsza == trzecia || druga == trzecia)
                {
                    reward = bet;
                    System.out.println("\nGratulujemy, nie wygrałeś nic ale odzyskałeś postawioną sumę o wartości $"
                            + reward);
                    player.setMoney(player.getMoney() + reward);
                    reward = 0;
                }
                else if (pierwsza == druga && pierwsza == trzecia && pierwsza != 0)
                {
                    reward = bet * 2;
                    System.out.println("\nGratulujemy, wygrałeś $" + reward );
                    player.setMoney(player.getMoney() + reward);
                    reward = 0;
                }
                else if (pierwsza == 0 && druga == 0 && trzecia == 0)
                {
                    reward = bet * 50;
                    System.out.println("\nGratulujemy wygrałeś główną nagrodę $" + reward);
                    player.setMoney(player.getMoney() + reward);
                    reward = 0;
                }
                    do{ if (!playAgain && player.getMoney() > 0) {
                        System.out.println("Twój aktualny balans to $" + player.getMoney());
                        System.out.println("Czy chciałbyś znowu zagrać? Tak [y] Nie [n]");
                        String draw = scanner.next();
                        if (draw.equals("n") || draw.equals("N")) {
                            play = false;
                            kłódka = false;
                        } else if (draw.equals("y") || draw.equals("Y")) {
                            kłódka = false;
                        } else {
                            System.out.println("Złe dane!");
                        }

                    }
                    } while (kłódka);






            }while(play);
        }catch (Exception exception){
            System.out.println("Error");
            System.out.println("Z powodu awarii prosimy podejść do drugiej maszyny bądź wybrać inną grę.");
            TimeUnit.SECONDS.sleep(5);
            scanner.next();
        }


    }
}
