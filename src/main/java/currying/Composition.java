package currying;
import static currying.Functions.fib;
import static currying.Operators.*;

public class Composition {

    static Function<Integer, Boolean> even = n -> not.apply(odd.apply(n));

    static Function<Integer, Boolean> evenFib = n -> even.apply(fib.apply(n));




}
