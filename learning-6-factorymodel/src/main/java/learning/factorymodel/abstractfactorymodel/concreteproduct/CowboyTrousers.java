package learning.factorymodel.abstractfactorymodel.concreteproduct;

import learning.factorymodel.abstractfactorymodel.product.Trousers;

/**
 * 具体产品（ConcreteProduct)_4 牛仔裤
 */
public class CowboyTrousers extends Trousers {
    private int waistSize;
    private int height;
    private String name;

    CowboyTrousers(String name, int waistSize, int height) {
        this.name = name;
        this.waistSize = waistSize;
        this.height = height;
    }

    public int getWaistSize() {
        return waistSize;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }
}
