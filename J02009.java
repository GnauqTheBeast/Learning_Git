import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Pair {
    public int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class J02009 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        for(int i = 0; i < n; i++) {
            int x = ip.nextInt();
            int y = ip.nextInt();
            Pair a = new Pair(x, y);
            arrayList.add(a);
        }
        Collections.sort(arrayList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.x < o2.x) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
        int s = arrayList.get(0).x + arrayList.get(0).y;
        for(int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i).x > s) {
                s = arrayList.get(i).x + arrayList.get(i).y;
            }
            else {
                s += arrayList.get(i).y;
            }
        }
        System.out.println(s);
    }
}
