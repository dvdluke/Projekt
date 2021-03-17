import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BlackJack {


    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void BlackJackGame(Gracz player) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int SumaGracza = 0;
        int SumaKrupiera = 0;
        int WylosowanaKarta = 0;
        boolean playAgain = false;
        boolean betAgain = true;
        double reward = 0;
        double bet = 0;
        String[] talia = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        System.out.println("It's time for soooooommme");
        System.out.println(" _______   ___       _______   _______   ___   _       ___   _______   _______   ___   _   __ ");
        System.out.println("|   _   | |   |     |   _   | |       | |   | | |     |   | |   _   | |       | |   | | | |  |");
        System.out.println("|  |_|  | |   |     |  |_|  | |       | |   |_| |     |   | |  |_|  | |       | |   |_| | |  |");
        System.out.println("|       | |   |     |       | |       | |      _|     |   | |       | |       | |      _| |  |");
        System.out.println("|   _  |  |   |___  |       | |      _| |     |_   ___|   | |       | |      _| |     |_  |__|");
        System.out.println("|  |_|  | |       | |   _   | |     |_  |    _  | |       | |   _   | |     |   |    _  |  __ ");
        System.out.println("|_______| |_______| |__| |__| |_______| |___| |_| |_______| |__| |__| |_______| |___| |_| |__|");


        do {
            System.out.println("Podaj kwotę którą chcesz postawić?");
            bet = scanner.nextDouble();

            if (bet > 0) {
                if (player.getMoney() < bet) System.out.println("Nie masz funduszy by tyle obstawić!");
                else {
                    player.setMoney(player.getMoney() - bet);
                    betAgain = false;
                }
            } else if (bet < 0) {
                System.out.println("Złe dane");
            }


        }
        while (betAgain);
        System.out.println("Twoje saldo po transakcji = " + player.getMoney());



            int losowa = random.nextInt(13);
            if (losowa)

        System.out.println("Suma Kart krupiera to: " + SumaKrupiera);
    }
}
