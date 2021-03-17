import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ruletka
{
    public static void main(String[] args) throws InterruptedException {
        Scanner keyboard = new Scanner(System.in);
        Random generator = new Random();
        double total = 500;
        double amount;
        int choice;
        int Liczba;
        int rouletteNum;
        int Wynik;
        char odpowiedz = 'y';
        int WynikArray[] = new int[36];

        while (odpowiedz == 'y' || odpowiedz == 'Y' && total <= 0)
        {
            System.out.print("Ile chcesz obstawić pieniędzy: ");
            amount = keyboard.nextDouble();
            System.out.print("[0] - Parzyste liczby\n[1] - Nieparzyste liczby\n[2] - Pojedynczą liczbę\n");
            choice = -1;
            while (choice < 0 || choice > 2)
            {
                System.out.print("Postaw zakład na: ");
                choice = keyboard.nextInt();
            }
            Liczba = 0;
            if (choice == 2)
            {
                while (Liczba < 1 || Liczba > 36)
                {
                    System.out.print("Postaw zakład na liczbę (1-36)");
                    Liczba = keyboard.nextInt();
                }
            }
            rouletteNum = generator.nextInt(37);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Losowanie liczby.");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Losowanie liczby..");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Losowanie liczby...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Roulette number: " + rouletteNum);

            if (choice == 2)
            {
                if (rouletteNum == Liczba)
                    Wynik = 35;
                else
                    Wynik = 0;
            }
            else
            {
                if (rouletteNum == 0 || rouletteNum % 2 != choice)
                    Wynik = 0;
                else
                    Wynik = 1;
            }

            if (Wynik > 0)
            {
                System.out.println("Gratulacje!!!");
                System.out.printf("Wygrałeś $%.2f \n", Wynik * amount);
                System.out.printf("Twoje saldo: $%.2f \n",
                        (Wynik + 1) * amount);
                total = (Wynik + 1) * amount + total;
                WynikArray[rouletteNum]++;

            }
            else
            {
                System.out.println("Przegrałeś zakład. Następnym razem ci się uda!");
                System.out.printf("Straciłeś $%.2f \n",
                        (Wynik + 1) * amount);
                total = total - (Wynik + 1) * (amount);
                WynikArray[rouletteNum]++;
                if (total <= 0) {
                    break;
                }

            }

            //Ask for another game
            for (int totals=1; totals<36; totals++) {
                if( WynikArray[totals] > 0 ) {
                    System.out.println("The number " + totals + " won " + WynikArray[totals] + " times.");
                }
            }





            System.out.println("You hayve $" + total + " remaining." );
            System.out.print("\nWould you like to play another game? (y/n) ");
            odpowiedz = keyboard.next().charAt(0);


        }

    }
}