package factory.abstractfactory;

/**
 * 小米PC工厂
 */
public class XiaomiPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new XiaoMiMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new XiaomiKeyBoard();
    }
}
