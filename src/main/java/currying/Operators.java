package currying;


import java.lang.reflect.Field;

public class Operators {

    static Function<Boolean, Boolean> not = a -> !a;


    static Function<Integer, Function<Integer,Integer>> max = a -> b -> a > b ? a : b;


    static Function<Boolean, Function<Boolean,Boolean>> and = a -> b -> a && b;

    static Function<Boolean, Function<Boolean,Boolean>> or = a -> b -> a || b;

    static Function<Boolean, Function<Boolean, Boolean>> nor = a -> b -> not.apply(or.apply(a).apply(b));

    static Function<Boolean, Function<Boolean, Boolean>> nand = a -> b -> not.apply(and.apply(a).apply(b));

    static Function<Integer, Boolean> odd = a -> a % 2 != 0;












}
