
import com.wsp.java.god.datastruct.list.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by tangying on 16/12/25.
 */
public class ArraylistTest extends BaseTest {

    public static void main(String args[]){
        MyArrayList<String> arrayList = new MyArrayList<String>();
        System.out.println(arrayList.size());
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(2));
        arrayList.remove(2);
        System.out.println(arrayList.get(2));
        System.out.println(arrayList.size());

        Iterator it =   arrayList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        new ArrayList<>().iterator().hasNext();
    }
}
