package currying;

public class Functions {


    static Function<Integer, Integer> fact = n -> n == 0 || n == 1 ? 1 : n * Functions.fact.apply(n - 1);


    static Function<Integer, Function<Integer, Integer>> ggt = a -> b -> a.equals(b) || b == 0 ? a :
            Functions.ggt.apply(b).apply(a % b);

    static Function<Integer, Function<Integer, Integer>> binom = n -> k -> n.equals(k) || k == 0 ? 1 : k == 1 ? n
            : k > n || k < 0 ? 0 :
            Functions.binom.apply(n - 1).apply(k) + Functions.binom.apply(n - 1).apply(k - 1);


    static Function<Integer, Integer> fib = n -> n == 0 || n == 1 ? n :
            Functions.fib.apply(n - 1) + Functions.fib.apply(n - 2);


    static Function<Integer, Function<Integer, Function<Integer, Integer>>> loop = n -> i -> res ->
            n.equals(i) ? fib.apply(i) + res :
            Functions.loop.apply(n).apply(i + 1).apply(fib.apply(i) + res);


}

