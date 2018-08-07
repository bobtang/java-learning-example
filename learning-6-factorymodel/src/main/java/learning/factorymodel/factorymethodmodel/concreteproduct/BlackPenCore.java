package learning.factorymodel.factorymethodmodel.concreteproduct;

import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * 具体产品（ConcreteProduct）_3
 */
public class BlackPenCore extends PenCore {
    public BlackPenCore() {
        color = "黑色";
    }

    public void writeWord(String s) {
        System.out.println("写出" +color + "的字:" + "\u001b[1;30m" + s +"\u001b[0m");
    }
}
