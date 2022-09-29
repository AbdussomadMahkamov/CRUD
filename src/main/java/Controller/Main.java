package Controller;

import Model.Hodim;
import Services.Base;
import com.sun.javaws.exceptions.BadVersionResponseException;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Bazaga hodim ma'lumotlarini yaratish, o'qish, yangilash va o'chiruvchi dastur
        Scanner in=new Scanner(System.in);
        int i=-1;
        Base base = new Base();
        while (i!=0){
            System.out.print("0: Dasturni yakunlash\n" +
                    "1: Ma'lumot qo'shish\n" +
                    "2: Tahrirlash\n" +
                    "3: O'qish\n" +
                    "4: O'chirish\n" +
                    "Tanlovingiz: ");
            i= in.nextInt();
            switch (i){
                case 1:
                    in=new Scanner(System.in);
                    System.out.print("Ismi: ");
                    String ism= in.nextLine();
                    in=new Scanner(System.in);
                    System.out.print("Familya: ");
                    String familya= in.nextLine();
                    in=new Scanner(System.in);
                    System.out.print("Manzil: ");
                    String manzil= in.nextLine();
                    in=new Scanner(System.in);
                    System.out.print("E-Pochta: ");
                    String e_pochta= in.nextLine();
                    Hodim hodim=new Hodim(ism, familya, manzil, e_pochta);
                    base.Yaratish(hodim);
                    break;
                case 2:
                    System.out.print("Tahrirlamoqchi bo'lgan xodimingizni id sini kiriting: ");
                    in=new Scanner(System.in);
                    System.out.print("id: ");
                    int id1= in.nextInt();
                    base.Tahrirlash(id1);
                    break;
                case 3:
//                    Base base1=new Base();
//                    System.out.println(base1.Oqish());
                    base.Oqish();
                    break;
                case 4:
                    in=new Scanner(System.in);
                    System.out.print("id: ");
                    int id= in.nextInt();
                    base.Ochirish(id);
                    break;
            }
        }
    }
}
