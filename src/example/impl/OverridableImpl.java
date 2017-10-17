package example.impl;


import example.Defaulable2;

/**
 * OverridableImpl
 *
 * @author Huai_Shuo
 * @date 15/12/9
 */
public class OverridableImpl implements Defaulable2 {

    @Override
    public void test() {

    }

    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
