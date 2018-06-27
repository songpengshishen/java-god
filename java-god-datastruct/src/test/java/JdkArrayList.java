import java.util.ArrayList;

/**
 * Jdk中的arraylist测试
 */
public class JdkArrayList extends BaseTest{

    public static void main(String args[]){
        ArrayList<String> tarr = new ArrayList<String>();
        tarr.add("peng");
        tarr.add("no");
        tarr.add("peng");
        System.out.printf(tarr.indexOf("peng")+"");
        System.out.printf(tarr.lastIndexOf("peng")+"");
    }

}
