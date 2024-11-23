package ast;

import java.util.HashMap;

public class BinaryExpr extends Expr {

    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;
    public static final int DOT = 4;

    final Expr expr1;
    final int operator;
    final Expr expr2;

    public BinaryExpr(Expr expr1, int operator, Expr expr2, Location loc) {
        super(loc);
        this.expr1 = expr1;
        this.operator = operator;
        this.expr2 = expr2;
    }

    @Override
    public String toString() {        
        String s = null;
        switch (operator) {
            case PLUS:  s = "+"; break;
            case MINUS: s = "-"; break;
            case TIMES: s = "*"; break;
            case DOT:   s = "."; break;
        }
        return "(" + expr1 + " " + s + " " + expr2 + ")";
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        switch (operator) {
            case PLUS:  return new QIntVal((long)expr1.eval(env).val() + (long)expr2.eval(env).val());
            case MINUS: return new QIntVal((long)expr1.eval(env).val() - (long)expr2.eval(env).val());
            case TIMES: return new QIntVal((long)expr1.eval(env).val() * (long)expr2.eval(env).val());
            case DOT:   return new QRefVal(new QObj(expr1.eval(env), expr2.eval(env)));
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }
}
