package lab.сommands;

import lab.interfaces.ICommand;
import lab.interfaces.IFunc;
import lab.models.Func;
import lab.models.IndividualFunc;
import lab.modules.MathModule;
import lab.modules.MenuModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NonlinearEquationsMenu implements ICommand {
    @Override
    public String getMessage() {
        return "Решение нелинейных уравнений";
    }

    @Override
    public void execute() {
        ArrayList<ICommand> commands = new ArrayList<>();
        HashMap<String, Func> funcHashMap = new HashMap<>();
//        funcHashMap.put("x^2+x+2", x -> Math.pow(x, 2) + x + 2);
//        funcHashMap.put("3x^2-14x-5", x -> 3 * Math.pow(x, 2) - (14 * x) - 5);
//        funcHashMap.put("x^2+2x+1", x -> Math.pow(x, 2) + (2 * x) + 1);
//        funcHashMap.put("e^x-1", x -> Math.pow(Math.E, x) - 1);
        funcHashMap.put("(1-2*x)/3", new Func(x -> (1-2*x)/3, x -> -2.0/3.0));

        for(Map.Entry<String, Func> entry : funcHashMap.entrySet()) {
            commands.add(new ICommand() {
                @Override
                public String getMessage() {
                    return entry.getKey();
                }
                @Override
                public void execute() {
                    MathModule.execute(entry.getValue().getFunc(), entry.getValue().getDfunc());
                }
            });
        }
        commands.add(new IndividualFunc());
        commands.add(new Main());
        MenuModule menu = new MenuModule(commands);
        menu.execute();
    }
}
