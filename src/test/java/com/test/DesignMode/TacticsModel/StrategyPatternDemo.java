package com.test.DesignMode.TacticsModel;

/**
 * @describe:策略模式
 *
 * @author:xzj
 * @createDate:2021/4/19 11:04
 * @param:
 * @return:
 */

/**
 * 优点：1 算法之前可以随意的切换 2 避免使用多重条件的判断 3 扩展性好
 * 缺点：1 策略类会增多 2 所有策略类都需要对外暴露
 * 注意事项： 如果策略类超过了4个 就需要老流程混合模式 解决策略类膨胀的问题
 *
 */
public class StrategyPatternDemo {
   public static void main(String[] args) {
      Context context = new Context(new OperationAdd());    
      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
 
      context = new Context(new OperationSubtract());      
      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
 
      context = new Context(new OperationMultiply());    
      System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
   }
}