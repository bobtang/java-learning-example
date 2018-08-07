package learning.factorymodel.factorymethodmodel.concretecreator;

import learning.factorymodel.factorymethodmodel.concreteproduct.BluePenCore;
import learning.factorymodel.factorymethodmodel.creator.BallPen;
import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * 具体构造者（ConcreteCreator）
 */
public class BlueBallPen extends BallPen {
    public PenCore getPenCore(){
       return new BluePenCore();
    }
}
