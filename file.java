package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/*Класс работы с файлом:
 1.InputFile-чтение информации из файла
 2.OutputFile- заполнение файла
 */
public class file {

    public static int InputFile(int numb, String nameFile, ArrayList<Strut.strut>listStrut)throws Exception
    {
        FileReader note =new FileReader(nameFile);
        Scanner scan = new Scanner(note);
        while (scan.hasNextLine()) {
            String str=scan.nextLine();
            String []retval=str.split(" ");
            Strut.strut obj=new Strut.strut(retval[0],Integer.parseInt(retval[1]),Double.parseDouble(retval[2]));
            listStrut.add(obj);
            numb++;
        }
        return numb;
    }

    public static void OutputFile(int numb, String nameFile, ArrayList<Strut.strut>listStrut)throws Exception
    {
        FileWriter note =new FileWriter(nameFile);
        for(int i=0;i<numb;i++)
        {
            note.write(listStrut.get(i).getNumbcard()+" ");
            note.write(listStrut.get(i).getPassword()+" ");
            note.write(listStrut.get(i).getBalance()+"\n");
        }
        note.close();
    }
}
