package com.test.DesignMode.FacadeModel;

/**
 * @describe:外观模式
 *
 * @author:xzj
 * @createDate:2021/4/19 10:58
 * @param:
 * @return:
 */

/**
* 优点： 减少系统之前的相互依赖 提供灵活性 提高安全性
* 缺点： 不符合开闭原则 如果要改东西比较麻烦 继承重写都不合适
* 使用场景：
*        1 为复杂的模块或子系统提供外界访问的模块
*        2 子系统相对独立
*        3 预防低水平人员带来的风险
* 注意事项：在层次化结构中，可以使用外观模式定义系统中的每一层入口
* */
public class FacadePatternDemo {
   public static void main(String[] args) {
      ShapeMaker shapeMaker = new ShapeMaker();
 
      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();      
   }
}