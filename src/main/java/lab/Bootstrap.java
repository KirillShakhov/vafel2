package lab;

import lab.interfaces.IFunc;
import lab.models.Func;
import lab.modules.MathModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Нелинейное уравнение\n2. Системы нелинейных уравнений.");
        String str = scanner.nextLine();
        if(str.equals("1")){
            Map<String, Func> funcs = new HashMap<>();
            // Можно добавить нелинейное уравнение

            // 1
            funcs.put("y=x^2+x+2", new Func(x->(Math.pow(x, 2) + x + 2), x -> 2*x+1));
            //

            // Не трогать
            int i = 1;
            ArrayList<Func> tmp = new ArrayList<>();
            for(Map.Entry<String, Func> entry : funcs.entrySet()) {
                System.out.println(i++ + ". "+entry.getKey());
                tmp.add(entry.getValue());
            }
            str = scanner.nextLine();
            try{
                IFunc func1 = tmp.get(Integer.parseInt(str)-1).getFunc();
                IFunc dfunc1 = tmp.get(Integer.parseInt(str)-1).getDfunc();
                MathModule.execute(func1, dfunc1);
            }catch (Exception e){
                System.out.println("Нет такого уравнения");
            }
        }else if(str.equals("2")){

        }
    }
}
