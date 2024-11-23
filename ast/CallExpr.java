package ast;

import java.util.HashMap;

public class CallExpr extends Expr {

    final String funcName;
    final ExprList args;

    public CallExpr(String funcName,ExprList args,Location loc) {
        super(loc);
        this.funcName = funcName;
        this.args = args;
    }

    // @Override
    // public String toString() {
    //     return value.toString();
    // }

    @Override
    QVal eval(HashMap<String, QVal> env) {
        HashMap<String, QVal> newEnv= new HashMap<>();
        if(Program.funcDefMap.containsKey(funcName)){
            FuncDef function=Program.funcDefMap.get(funcName);
            buildEnv(env,function.params,args,newEnv);
            return function.execBody(newEnv); 
        }  
        QVal arg = args.first.eval(env);
        switch(funcName){
            case "left" : return ((QObj)arg.val()).left; 
            case "right" : return ((QObj)arg.val()).right;
            case "isAtom" : 
                if(arg.val() ==null|| arg instanceof QIntVal){
                    return new QIntVal(1);
                }
                return new QIntVal(0);
            case "isNil" : 
                if(arg.val() ==null){
                    return new QIntVal(1);
                }
                return new QIntVal(0);
            case "setLeft" : 
                ((QObj)arg.val()).left=args.rest.first.eval(env);
                return new QIntVal(1); 
            case "setRight" : 
                ((QObj)arg.val()).right=args.rest.first.eval(env);
                return new QIntVal(1);
            case "acq" : 
                while (!((QRefVal)arg).lock.compareAndSet(false, true)){}
                return new QIntVal(1); 
            case "rel" : 
                ((QRefVal)arg).lock.compareAndSet(true, false);
                return new QIntVal(1);                                    
            case "randomInt" : return new QIntVal((long)(java.lang.Math.random()*(long)arg.val())); 
        }
        return null;
    }

    void buildEnv(HashMap<String, QVal> env,FormalDeclList params,ExprList args,HashMap<String, QVal> newEnv) {        
        if(params!=null){
            newEnv.put(params.first, args.first.eval(env));
            buildEnv(env, params.rest,args.rest,newEnv);
        }
    }
}
