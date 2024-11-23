package ast;

public class QIntVal extends QVal {

    final long value;

    public QIntVal(long value) {
        this.value=value;
    }

    @Override
    public String toString() {
        return value+"";
    }

    Object val() {
        return value;
    }
}
