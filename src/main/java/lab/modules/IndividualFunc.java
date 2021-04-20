package lab.modules;
import lab.interfaces.IFunc;

public class IndividualFunc implements IFunc {
    private String xyz;

    public IndividualFunc(String xyz) {
        this.xyz = xyz;
    }

    public Double solve(double x) {
        CalcModule calcModule = new CalcModule(xyz);
        return calcModule.execute(x);
    }

    public void setXyz(String xyz) {
        this.xyz = xyz;
    }
}
