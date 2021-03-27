package currying;
import static currying.Functions.*;
import net.jqwik.api.*;

import net.jqwik.api.constraints.IntRange;


public class FibTest {
    @Example
    boolean exampleTest() {
        return fib.apply(8) == 21 && fib.apply(1) == 1;

    }

    @Data
    Iterable<? extends Tuple.Tuple2<Integer, Integer>> preStored() {
        return Table.of(
                Tuple.of(1, 1), Tuple.of(2, 1), Tuple.of(3, 2), Tuple.of(4, 3),
                Tuple.of(5, 5), Tuple.of(6, 8), Tuple.of(7, 13), Tuple.of(8, 21),
                Tuple.of(9, 34), Tuple.of(10, 55), Tuple.of(11, 89), Tuple.of(12, 144),
                Tuple.of(13, 233), Tuple.of(14, 377), Tuple.of(15, 610), Tuple.of(16, 987),
                Tuple.of(17, 1597), Tuple.of(18, 2584), Tuple.of(19, 4181), Tuple.of(20, 6765),
                Tuple.of(21, 10946), Tuple.of(22, 17711), Tuple.of(23, 28657), Tuple.of(24, 46368),
                Tuple.of(25, 75025), Tuple.of(26, 121393), Tuple.of(27, 196418),
                Tuple.of(28, 317811), Tuple.of(29, 514229), Tuple.of(30, 832040)
        );
    }

    @Property
    @FromData("preStored")
    boolean dataTest(@ForAll int n, @ForAll int result) {
        return (fib.apply(n)) == (result);
    }

    @Property(tries = 1000)
    boolean test1(@ForAll @IntRange(min = 1, max = 20) int n, @ForAll @IntRange(min = 1, max = 20) int m) {
        return fib.apply(m+n) == fib.apply(n+1) * fib.apply(m) + fib.apply(n) * fib.apply(m-1);
    }

    @Property(tries = 2000)
    boolean test2(@ForAll @IntRange(min = 1, max = 25) int n, @ForAll @IntRange(min = 1, max = 25) int m) {
        if (m > 0 && n > 0) {
            return ggt.apply(fib.apply(m)).apply(fib.apply(n)).equals(fib.apply(ggt.apply(m).apply(n)));
        } else {
            return true;
        }
    }

    @Property(tries = 2000)
    boolean test3(@ForAll @IntRange(min = 1, max = 20) int n) {

        return ggt.apply(fib.apply(n)).apply(fib.apply(n+1)) == 1;


    }
   /* @Property(tries = 1000)
    boolean test4(@ForAll @IntRange(min = 1, max = 20) int n) {

        return loop(n,0,0) == fib.apply(n+2) -1;

    }
*/

}
