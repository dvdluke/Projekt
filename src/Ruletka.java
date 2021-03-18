import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ruletka
{
    public static void Ruletka(Gracz player) throws InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Random generator = new Random();
        boolean playAgain = false;
        boolean betAgain = true;
        boolean play = true;
        double reward = 0;
        double bet = 0;
        double amount = 0;
        int Choice;
        int Liczba;
        int rouletteNum;
        int Wynik;
        char odpowiedz = 'y';
        int WynikArray[] = new int[37];

        System.out.println(" ");System.out.println(" ");System.out.println(" ");
        System.out.println("It's time for soooooommme");
        System.out.println(" ______    _______  __   __  ___      _______  _______  _______  _______ ");
        System.out.println("|    _ |  |       ||  | |  ||   |    |       ||       ||       ||       |");
        System.out.println("|   | ||  |   _   ||  | |  ||   |    |    ___||_     _||_     _||    ___|");
        System.out.println("|   |_||_ |  | |  ||  |_|  ||   |    |   |___   |   |    |   |  |   |___ ");
        System.out.println("|    __  ||  |_|  ||       ||   |___ |    ___|  |   |    |   |  |    ___|");
        System.out.println("|   |  | ||       ||       ||       ||   |___   |   |    |   |  |   |___ ");
        System.out.println("|___|  |_||_______||_______||_______||_______|  |___|    |___|  |_______|");
        System.out.println(" ");System.out.println(" ");System.out.println(" ");




        while (odpowiedz == 'y' || odpowiedz == 'Y')
        {
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
            System.out.print("\n[0] - Parzyste liczby\n[1] - Nieparzyste liczby\n[2] - Pojedynczą liczbę\n");
            Choice = -1;
            while (Choice < 0 || Choice > 2)
            {
                System.out.print("Na co chcesz obstawić zakład: ");
                Choice = keyboard.nextInt();
            }
            Liczba = 0;
            if (Choice == 2)
            {
                while (Liczba < 1 || Liczba > 36)
                {
                    System.out.print("Postaw zakład na liczbę (1-36)");
                    Liczba = keyboard.nextInt();
                }
            }
            rouletteNum = generator.nextInt(37);
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println("Losowanie liczby.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println("Losowanie liczby..");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println(" ");System.out.println(" ");System.out.println(" ");System.out.println(" ");
            System.out.println("Losowanie liczby...");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(" ");
            System.out.println("Wypadła liczba: " + rouletteNum);
            System.out.println(" ");
            if (Choice == 2)
            {
                if (rouletteNum == Liczba)
                    Wynik = 35;
                else
                    Wynik = 0;
            }
            else
            {
                if (rouletteNum == 0 || rouletteNum % 2 != Choice)
                    Wynik = 0;
                else
                    Wynik = 1;
            }
            if (Wynik > 0)
            {
                System.out.println("Gratulacje!!!");
                System.out.printf("Wygrałeś $%.2f \n",
                (Wynik + 1) * bet);
                player.setMoney((((Wynik + 1) * bet) + player.getMoney()));
                WynikArray[rouletteNum]++;
            }
            else
            {
                System.out.println("Przegrałeś zakład. Następnym razem ci się uda!");
                WynikArray[rouletteNum]++;
                if (player.getMoney() <= 0) {
                    break;
                }
            }

            System.out.println("Twój aktualny balans to $" + player.getMoney());
            System.out.print("\nCzy chcesz ponownie spróbować swojego szczęścia? (y/n)\n ");
            odpowiedz = keyboard.next().charAt(0);
        }
    }
}