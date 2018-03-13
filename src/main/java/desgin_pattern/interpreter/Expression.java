package desgin_pattern.interpreter;

public abstract class Expression {

    public abstract boolean interpret(Context ctx);
    public abstract boolean equals(Object obj);
    public abstract int hashCode();
    public abstract String toString();
}