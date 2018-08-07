package learning.factorymodel.abstractfactorymodel.concreteproduct;

import learning.factorymodel.abstractfactorymodel.product.Trousers;

/**
 * 具体产品（ConcreteProduct)_3 西裤
 */
public class WesternTrousers extends Trousers {
    private int waistSize;
    private int height;
    private String name;

    public WesternTrousers(String name, int waistSize, int height) {
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
