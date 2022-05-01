package lambda_practice;

import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {

        ilk30(30);
        ilk30dahil(30);
        System.out.println("top(a,b) = " + top(10, 20));
        ort(30,40);
        System.out.println("sekizeBolunen(325,468) = " + sekizeBolunen(325, 468));
        sekizeBolunenleriYaz(325,468);
        System.out.println("sekizeBolunenTop(325,468) = " + sekizeBolunenTop(325, 468));
        System.out.println("carpim(7,15) = " + carpim(7, 15));
        ilk10(10);
        yedininKati(10);
        System.out.println("yedininKatlariTop(20) = " + yedininKatlariTop(20));


    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void ilk30(int a){ //method yazarak kodu dinamik yaptik
        IntStream.range(1,a).sorted().forEach(t-> System.out.print(t+" "));

    }

    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void  ilk30dahil(int a){
        System.out.println();
        IntStream.rangeClosed(1,a).sorted().forEach(t-> System.out.print(t+" "));
        //        range (1,a+1)  olursa da 30 dahil yazar
    }

    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
    public  static int top(int bas,int bitis){
        System.out.println();
        return IntStream.rangeClosed(bas,bitis).sum();
    }

    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static void ort(int a, int b){
        //IntStream.rangeClosed(a,b).average().ifPresent(t-> System.out.println(t));  1.yol  aynen yaz .soutv ekle yanina 2.yol olur
        System.out.println("IntStream.rangeClosed(a,b).average() = " + IntStream.rangeClosed(a, b).average());
    }

    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static long sekizeBolunen(int a,int b){
        return IntStream.rangeClosed(a,b).filter(t->t%8==0).count();
    }
    //count :dizideki istenilen elemanlarin sayisini doner terminal islemdir long data type alir


    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void sekizeBolunenleriYaz(int a,int b){
        IntStream.rangeClosed(a,b).filter(t->t%8==0).forEach(t-> System.out.print(t+" "));
    }

    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
    public static int sekizeBolunenTop(int a,int b){
        System.out.println();
        return   IntStream.rangeClosed(a,b).filter(t->t%8==0).sum();
    }

    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static double carpim(int a, int b){ //sayi araliklari cok buyuk olunca Math classii kulanilirsa Integer overflow hatasi verir
        return IntStream.rangeClosed(a,b).filter(Methods::tekMi).reduce(1,(x,y)->x*y);
    }

    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void ilk10(int a){ // tek sayi old icin 1 den baslar, cift dese idi 0 dan baslardi
        IntStream.rangeClosed(1,a).limit(10).filter(Methods::tekMi).forEach(Methods::yazInteger); // 1-10 arasindaki tek sayilari verir.YANLiS
        System.out.println("yandaki yanlis asagidaki dogru ");
        IntStream.iterate(1,t->t+2).limit(10).filter(Methods::tekMi).forEach(Methods::yazInteger); //ilk 10 elemani verir

        //iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
        //iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
        // limit() ile belilioruz
    }

    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void yedininKati(int son){
        System.out.println();
        IntStream.iterate(21,t->t+7).limit(son).forEach(t-> System.out.print(t+" "));
        //rangeClose burda kullanilamaz
        //double da range tok , iterate var
    }


    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
    public static int yedininKatlariTop(int son){
        System.out.println();
        return IntStream.iterate(21,t->t+7).limit(20).sum();
    }

}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz