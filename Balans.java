package com.company;
/*класс работы с балансом:
1.addbalans-пополнение счета
2.cutbalans- снятие денег со счета
*/
public class Balans
{
    public static double addbalans(double numb, double balans)
    {
        balans+=numb;
        return balans;
    }
    public static double cutbalans(double numb, double balans)
    {
        balans-=numb;
        return balans;
    }
}
