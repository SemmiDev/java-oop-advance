package com.sammidev.set;
import java.util.*;

public class App {
    public static void main(String[] args) {

/*        HashSet lebih cepat dari TreeSet tapi HashSet tidak terurut, sedangkan TreeSet terurut
          Tips menggunakan HashSet : Jika memilih initial capacity terlalu besar bisa mubazir ruang penyimpanan
                                     Jika memilih initial capacity terlalu kecil bisa menghabiskan waktu dalam proses copy data jika ukurannya perlu diperbesar

          TreeSet menggunakan interface SortedSet Sehingga unsur yang ditambah akan disusun menjadi terurut
                                    Digunakan jika anda perlu membuat set yang nilainya harus terurut

        LinkedHashSet Merupakan hash table yang memanfaatkan konsep linked list
        Unsur yang masuk sesuai dengan insertion-ordered
        Hampir secepat HashSet namun urutannya tidak aneh seperti HashSet, dan tidak memerlukan proses pengurutan seperti pada TreeSet
*/


        Set s = new HashSet();
        App.isi("HASH SET",s,args);
        System.out.println();

        s = new TreeSet();
        App.isi("TREE SET",s,args);

        System.out.println();
        s = new LinkedHashSet();
        App.isi("LINKED HASH SET",s,args);
    }

    public static void isi(String name, Set s, String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (!s.add(args[i])) {
                System.out.println("===" + name);
                System.out.println("duplicate detected -> " + args[i]);
                System.out.println(s.size() + " detected -> " + s);
            }
        }
    }
}