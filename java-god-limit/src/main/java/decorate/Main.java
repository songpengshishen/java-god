package decorate;

/**
 * Created by wangsongpeng on 2018/6/30.
 */
public class Main {
    public static void main(String[] args) {
        Girl girl = new BeautyGirlDecorate(new GeneralGirl());
        girl.dressing();
    }
}
