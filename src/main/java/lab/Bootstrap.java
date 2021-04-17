package lab;

import lab.interfaces.IFunc;
import lab.interfaces.ISysFunc;
import lab.models.FirstSysFunc;
import lab.models.Func;
import lab.models.SecondSysFunc;
import lab.modules.MathModule;

import java.util.ArrayList;
import java.util.Scanner;

public class Bootstrap {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {


            System.out.println("1. Нелинейное уравнение\n2. Системы нелинейных уравнений.");
            String str = scanner.nextLine();


            if (str.equals("1")) {
                ArrayList<Func> funcs = new ArrayList<>();
                // Можно добавить нелинейное уравнение

                // 1
                funcs.add(new Func("y=x^2+x+2", x -> (Math.pow(x, 2) + x + 2), x -> 2 * x + 1));
                // 2
                funcs.add(new Func("3x^2-14x-5", x -> 3 * Math.pow(x, 2) - (14 * x) - 5, x -> 6 * x - 14));
                //


                /*
                 Вывод и обработка ввода
                 */
                int i = 1;
                for (Func f : funcs) {
                    System.out.println((i++) + ". " + f.getName());
                }
                str = scanner.nextLine();
                try {
                    IFunc func1 = funcs.get(Integer.parseInt(str) - 1).getFunc();
                    IFunc dfunc1 = funcs.get(Integer.parseInt(str) - 1).getDfunc();
                    MathModule.execute(func1, dfunc1);
                } catch (Exception e) {
                    System.out.println("Нет такого уравнения");
                }
            }



            else if (str.equals("2")) {
                ArrayList<ISysFunc> sysFuncs = new ArrayList<>();


                sysFuncs.add(new FirstSysFunc());
                sysFuncs.add(new SecondSysFunc());


                 /*
                 Вывод и обработка ввода
                 */
                int i = 1;
                for (ISysFunc f : sysFuncs) {
                    System.out.println((i++) + ". " + f.getMessage());
                }
                str = scanner.nextLine();
                try {
                    ISysFunc func1 = sysFuncs.get(Integer.parseInt(str) - 1);
                    MathModule.execute(func1);
                } catch (Exception e) {
                    System.out.println("Нет такого уравнения");
                }
            }

        }
    }
}
