package lambda_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C3_Array_StreamOrnekleri {
    public static void main(String[] args) {

        // Arraylerde Stream kullanabilmek icin 2 yol vardir
            // 1) Stream <Integer> isim=StreamOf(cevrilecek olan) -> Stream objesi
            // 2) Arrays.stream(arr).  ->  Array sinifindan yararlanarak
        //Array ler collection sinifinda degillerdir..set ve MAp ler gibi degildir..
        // kullanabilmek icin donusum yapilmalidir

        Integer arr1 [] ={1,5,-5,6,12,-8,9,3,4};
        int arr2 [] ={1,5,-5,6,12,-8,9,3,4};

        System.out.println("listele(arr) = " + listele(arr1));
        System.out.println("top1(arr) = " + top1(arr1));
        System.out.println("top2(arr1) = " + top2(arr2));
        ort1(arr2);


    }
    //S1: arrayin elemanlarini bir liste yazdiralim
    public static List<Integer> listele (Integer[] arr){
        return  Arrays.stream(arr).collect(Collectors.toList());
        //Array i listelemek icin data type -> Wrapper class olmali
   }

    //S2: Arrayin elemanlarini toplamini bulalim
    public static int top1(Integer [] arr){ //toplam int doner
        Stream <Integer> arrYeni=Stream.of(arr); //arrYeni yi Stream objesi olarak kullaniyoruz
        return arrYeni.reduce(0,(x,y)->x+y); //her elemana islem, 0:etkisiz eleman olarak aldik..terminal islem
    }
    public static int top2(int[] arr){
        return Arrays.stream(arr).sum();
}

    // S3: Array in elemanlarinin ortalamasini bulalim yazdir

    public static void ort1(int [] arr){   //return type i int oldugunda hata verir, cunku
         Arrays.stream(arr).average().ifPresent(t-> System.out.println(t));
        //Bu method Optional türde olan bir nesne için eğer tanımlı ise içerisinde işlem yapılmasına izin verir.
    }



}
