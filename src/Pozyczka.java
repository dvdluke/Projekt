public class Pozyczka
{
    public void PozyczkaPieniedzy(Gracz player){
        player.setMoney(player.getMoney() + 100);
        player.setRent(player.getRent() + 1);
    }
}