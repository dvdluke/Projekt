import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LuckyMachine {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void luckyMachineGame(Gracz player) {
        boolean playAgain = false;
        boolean betAgain = true;
        double reward = 0;
        double bet = 0;
        int[] luckyNumbers = new int[3];
        for(int i = 0; i < 3; i++){
            luckyNumbers[i] = random.nextInt(20); // 0 - 19
        }
        boolean play = true;
        int strike = 0;
        try {
            do {
                System.out.println("\t\tINSTRUKCJA\t\t\nMusisz wylosować jedną z szczęśliwych liczb dnia.\n" +
                        "Jak wylosujesz liczbę:" + "\n" +
                        "1 raz - dostajesz +50% kwoty postawionej\n" +
                        "2 raz pod rząd- dostajesz +100% kwoty postawionej\n" +
                        "3 raz pod rząd- dostajesz +200% kwoty postawionej");
                System.out.print("\n Szczęśliwe liczby to :\n");
                for (int number : luckyNumbers) {
                    System.out.println(number + "\t");
                }
                System.out.println("\n Twoje saldo = $" + player.getMoney());
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
                System.out.println("Twoje saldo po transakcji = " + player.getMoney());
                System.out.println("Losowanie liczby...");
                TimeUnit.SECONDS.sleep(1);
                int yourNumber = random.nextInt(20);
                System.out.println("\nTwoja liczba to = " + yourNumber);

                boolean youCanPlay = false;
                for (int number : luckyNumbers) {
                    if (number == yourNumber) {
                        System.out.println("Trafiono szczęśliwą liczbę!!!!!\n" +
                                "liczba szczęśliwa = " + number + ", twoja liczba = " + yourNumber);
                        strike++;
                        youCanPlay = true;
                    }
                }
                if (strike > 0 && youCanPlay && strike < 3) {
                    boolean stan = true;
                    do {
                        System.out.println("Masz serie = " + strike + "\n" +
                                "Czy grasz dalej czy wolisz brać pieniądze? tak [y] nie [n]");
                        char choice = scanner.next().charAt(0);
                        switch (choice) {
                            case 'y' -> {
                                player.setMoney(player.getMoney() + bet);
                                playAgain = true;
                                stan = false;
                            }
                            case 'n' -> {
                                if (strike == 1) {
                                    reward += bet * 1.5;
                                } else {
                                    reward += bet * 2;
                                }
                                player.setMoney(player.getMoney() + reward);
                                strike = 0;
                                reward = 0;
                                playAgain = false;
                                stan = false;
                            }
                            default -> System.out.println("Zły wybór");
                        }
                    } while (stan);
                }
                else if (strike == 3) {
                    reward += bet * 3;
                    player.setMoney(player.getMoney() + reward);
                    System.out.println("Masz strike 3 i wygrywasz największy bonus = " + player.getMoney());
                    strike = 0;
                    reward = 0;
                    playAgain = false;
                }
                else {
                    System.out.println("Nie trafiłeś szczęśliwej liczby :(");
                    strike = 0;
                    reward = 0;
                }
                if (!playAgain && player.getMoney() > 0) {
                    System.out.println("chcesz znowu zagrać ? tak [y] nie [n]");
                    String choice = scanner.next();
                    if (choice.equals("n")) play = false;
                }
                else if (player.getMoney() <= 0){
                    play = false;
                }
            } while (play);
        }catch (Exception exception){
            System.out.println("Error");
            player.setMoney(bet);
            scanner.next();
        }
    }
}