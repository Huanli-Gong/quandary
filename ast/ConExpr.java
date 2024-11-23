package ast;

import java.util.HashMap;

public class ConExpr extends Expr {

    final BinaryExpr binaryExpr;

    public ConExpr(BinaryExpr binaryExpr, Location loc) {
        super(loc);
        this.binaryExpr = binaryExpr;
    }

    @Override
    public String toString() {        
        return "[" + binaryExpr + "]";
    }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        MyThread t1 = new MyThread(binaryExpr.expr1,env);
        MyThread t2 = new MyThread(binaryExpr.expr2,env);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        switch (binaryExpr.operator) {
            case BinaryExpr.PLUS:  return new QIntVal((long)t1.value.val() + (long)t2.value.val());
            case BinaryExpr.MINUS: return new QIntVal((long)t1.value.val() - (long)t2.value.val());
            case BinaryExpr.TIMES: return new QIntVal((long)t1.value.val() * (long)t2.value.val());
            case BinaryExpr.DOT:   return new QRefVal(new QObj(t1.value, t2.value));
        }
        throw new RuntimeException("Unexpected in BinaryExpr.doOperation");
    }
}
class MyThread extends Thread {
    final Expr expr;
    HashMap<String, QVal> env;
    QVal value;
    MyThread(Expr expr, HashMap<String, QVal> env) { 
        this.expr = expr; 
        this.env = env; 
    }
    @Override
    public void run() {
        value=expr.eval(env);
    }
}