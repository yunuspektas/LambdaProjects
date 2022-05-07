package lambda_practice;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL= Arrays.asList(-2,-8,-5,0,2,5,6,7,15,6,8);
        tekYaz(intL);
        System.out.println("ciftCarp(intL) = " + ciftCarp(intL));
        System.out.println("karetoplam1(9) = " + karetoplam1(intL));
        System.out.println("karetoplam2(intL) = " + karetoplam2(intL));
        System.out.println("kupMAX(intL) = " + kupMAX(intL));

    }
    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void tekYaz(List<Integer>l){
        l.stream().filter(Methods::tekMi).forEach(Methods::yazInteger);
    }

    // S2: ciftlein carpimini bulalim
    public static Optional<Integer> ciftCarp(List<Integer>l){
        System.out.println(); //ust satirda birlestirme yapmasin diye ekledik
        return l.stream().filter(Methods::ciftMi).reduce(Math::multiplyExact);
    }

    // S3: negatiflerin kare toplamlarini  bulalim
    public static Optional<Integer> karetoplam1(List<Integer>l){
        return l.stream().filter(Methods::negatifMi).map(Methods::kareBul).reduce(Methods::toplam);
    }
    public static int karetoplam2(List<Integer>l){ //2.yol
        return l.stream().filter(Methods::negatifMi).map(Methods::kareBul).reduce(0,(x,y)->x+y);
    }

    // S4: poziflerin kuplerinden max yazdiralim
    public static Optional<Integer> kupMAX(List<Integer> l){
     return l.stream().filter(Methods::pozitifMi).map(Methods::kupBul).reduce(Math::max);
    }


}
