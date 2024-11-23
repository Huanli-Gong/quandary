package ast;

import java.util.HashMap;

public class UnaryCond extends Cond {

    final Cond cond;


    public UnaryCond(Cond cond, Location loc) {
        super(loc);
        this.cond= cond;
    }

    @Override
    public String toString() {
        return "(" + " ! " + cond+ ")";
    }

    @Override
    boolean eval(HashMap<String, QVal> env) {
        return !cond.eval(env);
    }
}
