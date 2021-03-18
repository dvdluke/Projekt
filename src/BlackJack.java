import java.util.Random;
import java.util.Scanner;



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
        String[] talia = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jopek", "Dama", "Król"};
        String[] kolor = {"Serce","Pik","Trefl","Karo"};

        System.out.println("It's time for soooooommme");
        System.out.println(" _______   ___       _______   _______   ___   _       ___   _______   _______   ___   _   __ ");
        System.out.println("|   _   | |   |     |   _   | |       | |   | | |     |   | |   _   | |       | |   | | | |  |");
        System.out.println("|  |_|  | |   |     |  |_|  | |       | |   |_| |     |   | |  |_|  | |       | |   |_| | |  |");
        System.out.println("|       | |   |     |       | |       | |      _|     |   | |       | |       | |      _| |  |");
        System.out.println("|   _  |  |   |___  |       | |      _| |     |_   ___|   | |       | |      _| |     |_  |__|");
        System.out.println("|  |_|  | |       | |   _   | |     |_  |    _  | |       | |   _   | |     |   |    _  |  __ ");
        System.out.println("|_______| |_______| |__| |__| |_______| |___| |_| |_______| |__| |__| |_______| |___| |_| |__|");

    boolean graj = true;
    try {
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

        System.out.println(); System.out.println(); System.out.println(); System.out.println();
        System.out.println(); System.out.println(); System.out.println(); System.out.println();

        System.out.println("Twoje saldo po transakcji = " + player.getMoney());

        System.out.println(); System.out.println();


        int losowykolor = random.nextInt(3);
        int losowakarta = random.nextInt(13);

        if (losowakarta == 0) {
            SumaKrupiera = 11;
        } else if (losowakarta > 0 && losowakarta < 9) {
            SumaKrupiera = losowakarta + 1;
        } else if (losowakarta > 9) {
            SumaKrupiera = 10;
        }
        System.out.println("Karty krupiera to: " + talia[losowakarta] + " " + kolor[losowykolor] + " |Suma Kart: " + SumaKrupiera);


        losowakarta = random.nextInt(13);
        losowykolor = random.nextInt(3);

        System.out.print("Twoje karty to: " + talia[losowakarta] + " " + kolor[losowykolor] + " ");

        if (losowakarta == 0) {
            SumaGracza = 11;
        } else if (losowakarta > 0 && losowakarta < 9) {
            SumaGracza = losowakarta + 1;
        } else if (losowakarta > 9) {
            SumaGracza = 10;
        }

        losowakarta = random.nextInt(13);
        losowykolor = random.nextInt(3);

        if (losowakarta == 0) {
            if(SumaGracza < 11){
                SumaGracza += 11;
            }else  SumaGracza += 1;
        } else if (losowakarta > 0 && losowakarta < 9) {
            SumaGracza += losowakarta + 1;
        } else if (losowakarta > 9) {
            SumaGracza += 10;
        }

        System.out.print(" oraz " + talia[losowakarta] + " " + kolor[losowykolor] + " |Suma Kart: " + SumaGracza);

        System.out.println(); System.out.println(); System.out.println(); System.out.println();
        System.out.println("Czy chcesz dobrać? tak [y] nie [n]");
        String draw = scanner.next();
        if(draw == "y" || draw == "Y"){

            losowakarta = random.nextInt(13);
            losowykolor = random.nextInt(3);

            if (losowakarta == 0) {
                if(SumaGracza < 11){
                    SumaGracza += 11;
                }else  SumaGracza += 1;
            } else if (losowakarta > 0 && losowakarta < 9) {
                SumaGracza += losowakarta + 1;
            } else if (losowakarta > 9) {
                SumaGracza += 10;
            }


            System.out.println("Wylosowałeś " + talia[losowakarta] + kolor[losowykolor] + "|Suma Kart: " + SumaGracza);
        }
        else playAgain = true;



        }catch (Exception exception){
        System.out.println("Error");
        player.setMoney(bet);
        scanner.next();
         }
    }

    }


