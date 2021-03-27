package currying;

public class Functions {


    static Function<Integer, Integer> fact = n -> n == 0 || n == 1 ? 1 : n * Functions.fact.apply(n - 1);


    static Function<Integer, Function<Integer, Integer>> ggt = a -> b -> a.equals(b) || b == 0 ? a : Functions.ggt.apply(b).apply(a % b);

    static Function<Integer, Function<Integer, Integer>> binom = n -> k -> n.equals(k) || k == 0 ? 1 : k == 1 ? n : k > n || k < 0 ? 0 :
            Functions.binom.apply(n - 1).apply(k) + Functions.binom.apply(n - 1).apply(k - 1);


    static Function<Integer, Integer> fib = n -> n == 0 || n == 1 ? n : Functions.fib.apply(n - 1) + Functions.fib.apply(n - 2);

   /* static int loop(int n, int i, int res){
        if(n == i){
            return res;
        }else{
            i++;
            return loop(n, i, fib(i)+ res);
        }*/





    }

