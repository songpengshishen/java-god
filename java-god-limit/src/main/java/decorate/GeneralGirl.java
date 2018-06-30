package decorate;

/**
 * 一般的女孩
 * @author wsp
 */
public class GeneralGirl  implements  Girl{
    @Override
    public void dressing() {
        System.out.println("我是一个普通女孩在化妆!");
    }
}
