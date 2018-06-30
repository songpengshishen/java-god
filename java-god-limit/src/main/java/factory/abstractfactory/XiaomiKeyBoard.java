package factory.abstractfactory;

/**
 * 小米键盘.
 */
public class XiaomiKeyBoard implements KeyBoard {
    @Override
    public void typing() {
        System.out.println("小米打字");
    }
}
