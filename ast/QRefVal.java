package ast;

import java.util.concurrent.atomic.AtomicBoolean;

public class QRefVal extends QVal {

    final QObj referent;
    public AtomicBoolean lock;

    public QRefVal(QObj referent) {
        this.referent=referent;
        this.lock = new AtomicBoolean(false);
    }

    @Override
    public String toString() {
        if(referent==null){
            return "nil";
        }
        return referent.toString();
    }

    Object val() {
        return referent;
    }
}
