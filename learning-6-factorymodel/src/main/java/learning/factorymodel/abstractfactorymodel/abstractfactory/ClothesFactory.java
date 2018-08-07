package learning.factorymodel.abstractfactorymodel.abstractfactory;

import learning.factorymodel.abstractfactorymodel.product.Trousers;
import learning.factorymodel.abstractfactorymodel.product.UpperClothes;

/**
 * 抽象工厂-衣服工厂
 */
public abstract class ClothesFactory{
    public abstract UpperClothes createUpperClothes(int chestSize, int height);
    public abstract Trousers createTrousers(int waistSize, int height);
}
