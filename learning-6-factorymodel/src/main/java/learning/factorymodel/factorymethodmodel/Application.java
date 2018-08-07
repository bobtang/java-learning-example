package learning.factorymodel.factorymethodmodel;

import learning.factorymodel.factorymethodmodel.concretecreator.BlackBallPen;
import learning.factorymodel.factorymethodmodel.concretecreator.BlueBallPen;
import learning.factorymodel.factorymethodmodel.concretecreator.RedBallPen;
import learning.factorymodel.factorymethodmodel.creator.BallPen;
import learning.factorymodel.factorymethodmodel.product.PenCore;

/**
 * 应用
 */
public class Application{
    public static void main(String args[]){
       PenCore penCore;
       BallPen ballPen=new BlueBallPen();
       penCore=ballPen.getPenCore();
       penCore.writeWord("你好,很高兴认识你");
       ballPen=new RedBallPen();
       penCore=ballPen.getPenCore();
       penCore.writeWord("How are you");
       ballPen=new BlackBallPen();
       penCore=ballPen.getPenCore();
       penCore.writeWord("nice to meet you");
    }
}
