package example;


/**
 * exampleOne
 *
 * @author Huai_Shuo
 * @date 15/12/8
 * example接口在拥有dongHuang方法之外同时还定义了yiXiu方法，实现了Formula接口的子类只需要实现一个calculate方法，默认方法sqrt将在子类上可以直接使用。
 */
public class exampleOne implements example {


    @Override
    public double dongHuang(int a) {
        return yiXiu(a * 100);
    }


}
