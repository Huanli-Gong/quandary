package ast;

import java.util.HashMap;

public class CompCond extends Cond {

    public static final int LessEqual = 1;
    public static final int GreaterEqual = 2;
    public static final int Equal = 3;
    public static final int NotEqual = 4;
    public static final int Less = 5;
    public static final int Greater = 6;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public CompCond(Expr expr1, int operator, Expr expr2, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;
    }

    @Override
    public String toString() {        
        String s = null;
        switch (operator) {
            case LessEqual:  s = "<="; break;
            case GreaterEqual: s = ">="; break;
            case Equal: s = "=="; break;
            case NotEqual:  s = "!="; break;
            case Less: s = "<"; break;
            case Greater: s = ">"; break;
        }
        return "(" + expr1 + " " + s + " " + expr2 + ")";
    }

    @Override
    boolean eval(HashMap<String, QVal> env) {
        switch (operator) {
            case LessEqual:  return (long)expr1.eval(env).val() <= (long)expr2.eval(env).val();
            case GreaterEqual: return (long)expr1.eval(env).val() >= (long)expr2.eval(env).val();
            case Equal: return (long)expr1.eval(env).val() == (long)expr2.eval(env).val();
            case NotEqual:  return (long)expr1.eval(env).val() != (long)expr2.eval(env).val();
            case Less: return (long)expr1.eval(env).val() < (long)expr2.eval(env).val();
            case Greater: return (long)expr1.eval(env).val() > (long)expr2.eval(env).val();
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }
}
