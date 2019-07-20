package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.*;

public class Main
{
    public static void Menu(){  // меню
        System.out.println("1. Баланс.");
        System.out.println("2. Пополнение счета.");
        System.out.println("3. Снятие денежных средств.");
        System.out.println("4. Выход.");
    }

    public static boolean ShablonNumbCard(String str) // шаблон номера карты
    {
        String regex = "\\d{4}+[-]+\\d{4}+[-]+\\d{4}+[-]+\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches())
            return true;
        else
            return false;
    }

    public static boolean equals(String str1, String str2)//сравнение двух строк
    {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    public static void main(String[] args)throws Exception, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        ArrayList<Strut.strut> listStrut = new ArrayList<Strut.strut>(); // объявление листа(коллекции данных)
        boolean provIn;//переменная проверки ввода
        String numbercard;// номер карты
        do {
            System.out.print("Введите номер карты или 0 для выхода из программы: ");
            do {
                numbercard = in.nextLine();//ввод номера карты
            }while(equals(numbercard,""));
            provIn = ShablonNumbCard(numbercard);
            if (provIn==false)
                if(equals(numbercard,"0"))
                    break;
            if (provIn) {
                int numb = 0;// объявление количества карт в коллекции данных
                String nameFile = "DataBase.txt";// файл с данными карточек
                numb = file.InputFile(numb, nameFile, listStrut);
                int i = 0;
                boolean prov = true;// инициализация флага на выход из цикла
                while (i < numb && prov) {
                    if (equals(listStrut.get(i).getNumbcard(), numbercard)) {
                        prov = false;
                        boolean flag = true;
                        // int numbIn=0;
                        do {
                            System.out.println("Введите пароль: ");
                            int inpassword;// переменная "введенный пароль"
                            do {
                                while (!in.hasNextInt()) {//проверка на правильность ввода пароля
                                    System.out.println("Неверный ввод!\n Введите еще раз.");
                                    in.next();
                                }
                                inpassword = in.nextInt();
                                if (inpassword < 1000 || inpassword > 9999)
                                    System.out.println("Неверный ввод!\n Введите еще раз.");
                            } while (inpassword < 1000 || inpassword > 9999);
                            if (listStrut.get(i).getPassword() == inpassword) {// проверка на совпадение пароля с картой
                                flag = false;
                                boolean sost = true;// переменная на выход из программы
                                do {
                                    int choice;// переменная выбора пользователя
                                    int allbankschet = 1000000;
                                    do {//проверка на ввод выбора действия
                                        Menu();
                                        System.out.println("\n Введите цифру действия");
                                        while (!in.hasNextInt()) {
                                            System.out.println("Неверный ввод!");
                                            in.next();
                                        }
                                        choice = in.nextInt();
                                        if(choice<1||choice>4)
                                            System.out.println("Ошибка ввода");
                                    } while (choice < 1 || choice > 4);
                                    switch (choice) {
                                        case 1:// вывод баланса карточки
                                            System.out.println("Баланс равен= " + listStrut.get(i).getBalance());
                                            break;
                                        case 2:// пополнение счета
                                            double addnumb;// переменная "сумма пополнения счета"
                                            do// проверка на ввод
                                            {
                                                System.out.print("Введите сумму пополнения: ");
                                                while (!in.hasNextDouble()) {
                                                    System.out.println("Неверный ввод!");
                                                    in.next();
                                                }
                                                addnumb = in.nextDouble();
                                                if (addnumb < 0.000000001)
                                                    System.out.println("Сумма не может быть меньше или равна нулю.");

                                            } while (addnumb < 0.000000001);
                                            if (addnumb <= allbankschet) {//проверка может ли банк пополнить счет
                                                listStrut.get(i).setBalance(Balans.addbalans(addnumb, listStrut.get(i).getBalance()));
                                                file.OutputFile(numb, nameFile, listStrut);
                                            } else
                                                System.out.println("Слишком большое пополнение, максимальная сумма не должна привышать 1 000 000");
                                            break;
                                        case 3:// снятие денежных средств со счета
                                            double cutnumb;
                                            do// проверка ввода
                                            {
                                                System.out.print("Введите сумму для снятия: ");
                                                while (!in.hasNextDouble()) {
                                                    System.out.println("Неверный ввод!");
                                                    in.next();
                                                }
                                                cutnumb = in.nextDouble();
                                                if (cutnumb < 0.000000001) {

                                                    System.out.println("Сумма не может быть меньше или равна нулю.");
                                                }
                                            } while (cutnumb < 0.000000001);
                                            // проверка хватает ли денежных средств на карте
                                            if (cutnumb <= listStrut.get(i).getBalance()) {
                                                listStrut.get(i).setBalance(Balans.cutbalans(cutnumb, listStrut.get(i).getBalance()));
                                                file.OutputFile(numb, nameFile, listStrut);
                                            } else
                                                //if (cutnumb>listStrut.get(i).getBalance())
                                                System.out.println("Недостаточно денежных средств на карте");
                                            break;
                                        case 4://выход из программы
                                            provIn=false;
                                            sost = false;
                                            break;
                                    }
                                } while (sost);

                            } else {
                                System.out.println("Ошибка ввода пароля.");
                            }
                        } while (flag);
                    } else if (i == numb - 1 && prov) {
                        provIn=false;
                        System.out.println("Карты с таким номерном не сушествует.");
                    }
                    i++;
                }
            } else
                System.out.println("Неправильный номер карты.");

        } while (provIn == false);
    }
}

