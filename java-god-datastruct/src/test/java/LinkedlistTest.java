
import com.wsp.java.god.datastruct.list.MyLinkedList;

import java.util.Iterator;

/**
 * Created by tangying on 16/12/25.
 */
public class LinkedlistTest extends BaseTest {

    static MyLinkedList<String> linked = new MyLinkedList<String>();

    public static void main(String args[]){
        linked.add("aa");
        linked.add("bb");
        linked.add("cc");
        printAll();
        linked.remove(1);
        printAll();
        linked.remove(0);
        printAll();
        iterator();
    }



    private static void printAll(){
        for(int i = 0 ;i< linked.size();i++){
            System.out.println(linked.get(i));
        }
    }

    private static  void iterator(){
        Iterator<String> it = linked.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
