public class Gracz {
        private String name;
        private double money;
        private int age;
        private int rent;

        public Gracz(String name, double money, int age, int rent)
        {
            this.name = name;
            this.money = money;
            this.age = age;
            this.rent = rent;
        }
        public int getRent()
        {
            return rent;
        }
        public void setRent(int rent)
        {
            this.rent = rent;
        }
        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public double getMoney()
        {
            return money;
        }
        public void setMoney(double money)
        {
            this.money = money;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age)
        {
            this.age = age;
        }
}