package com.company;

public class Strut {
    public static class strut {
        /*структура базы данных(запись содержит следующие поля:
         1.numbcard-номер карты
         2.password-пароль для карты
         3.balance- баланс
         ......................
         getNumbcard- получение номера карты из листа(коллекции информации)
         getPassword-получение пароля из листа(коллекции информации)
         getBalance-получение баланса из листа(коллекции информации)
         setBalance- изменение баланса в листе(коллекции информации)
          */
        String numbcard = "";
        int password = 0;
        double balance = 0;

        public strut(String s, int a, double b) {
            this.numbcard = s;
            this.password = a;
            this.balance = b;
        }

        public String getNumbcard(){
            return numbcard;
        }
        public int getPassword(){
            return password;
        }
        public double getBalance(){
            return balance;
        }
        public double setBalance(double numb){
            return balance=numb;
        }
    }
}
