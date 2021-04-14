package lab.models;
import lab.interfaces.IFunc;
import lab.interfaces.ISysFunc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstSysFunc implements ISysFunc {
    @Override
    public ArrayList<IFunc> getDraw() {
//        Map<IFunc, IFunc> ar = new HashMap<>();
//        ar.put(x -> (1-2*x)/3, x -> -2.0/3.0);
//        ar.add(x -> (x>=-Math.pow(3, 0.5) && x<=Math.pow(3, 0.5)) ? -Math.abs(Math.pow(3-Math.pow(x,2), 0.5)) : null);
//        ar.add(x -> (x>=-Math.pow(3, 0.5) && x<=Math.pow(3, 0.5)) ? Math.abs(Math.pow(3-Math.pow(x,2), 0.5)) : null);
        return new ArrayList<>();
    }
    @Override
    public String getMessage() {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("x^2+y^2=3");
        ar.add("2x+3y=1");
        return ISysFunc.toString(ar);
    }

    @Override
    public double g_x(double y) { return Math.pow(3-Math.pow(y, 2), 0.5); }
    @Override
    public double g_y(double x) { return (1-2*x)/3; }
    @Override
    public double f1(double x, double y) { return Math.pow(x,2)+Math.pow(y,2)-3; }
    @Override
    public double f2(double x, double y) { return 2*x+3*y-1; }
}