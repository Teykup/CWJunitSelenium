package Intellegent;

import java.util.Scanner;

public class asal2_break_countineu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("bir sayı giriniz : ");
        int sayi = scan.nextInt();

        for (int i = 2; i < sayi; i++) {
            if (((sayi % i) == 0)){
                continue;
            }else System.out.println("asal");
        }
    }
}
