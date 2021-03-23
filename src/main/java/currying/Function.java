package currying;

public interface Function<T, U> {
    U apply(T arg);

    static Function<Integer, Integer> compose(Function<Integer, Integer> f1,
                                              Function<Integer, Integer> f2) {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return f1.apply(f2.apply(arg));
            }
        };
    }

    static Function<Integer, Integer> compose1(Function<Integer, Integer> f1,
                                              Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }


    Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;

    Function<Integer, Integer> factorial = n ->{
        return n <= 1 ? n : n * Function.factorial.apply(n - 1);
    };

    static Function<Boolean, Boolean> not(){
        return arg -> !arg;
    }






}
