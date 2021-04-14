package lab.models;

import lab.interfaces.IFunc;

public class Func {
    IFunc func;
    IFunc dfunc;

    public Func(IFunc func, IFunc dfunc) {
        this.func = func;
        this.dfunc = dfunc;
    }

    public IFunc getFunc() {
        return func;
    }

    public void setFunc(IFunc func) {
        this.func = func;
    }

    public IFunc getDfunc() {
        return dfunc;
    }

    public void setDfunc(IFunc dfunc) {
        this.dfunc = dfunc;
    }
}
