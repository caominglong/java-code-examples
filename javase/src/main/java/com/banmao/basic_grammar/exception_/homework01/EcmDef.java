package com.banmao.basic_grammar.exception_.homework01;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午9:50
 * @description
 */
public class EcmDef {

    public static void main(String[] args) {

        // 先验证输入的参数个数不正确
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("数组个数不对！");
            }
            Integer n1 = Integer.parseInt(args[0]);
            Integer n2 = Integer.parseInt(args[1]);

            double n3 = new EcmDef().cal(n1 , n2);
            System.out.println("计算结果是：" + n3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式转换错误");
        } catch (ArithmeticException e) {
            System.out.println("出现了除0的异常");
        }

    }

    public double cal(int n1, int n2) {
        return n1 / n2;
    }
}