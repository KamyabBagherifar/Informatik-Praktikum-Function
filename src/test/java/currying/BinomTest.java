package currying;

import static currying.Functions.binom;
import net.jqwik.api.*;

import net.jqwik.api.constraints.IntRange;



public class BinomTest {

    @Example
    boolean exampleTest() {
        return binom.apply(12).apply(6) == 924 && binom.apply(4).apply(3) == 4;


    }

    @Data
    Iterable<? extends Tuple.Tuple3<Integer, Integer, Integer>> preStored() {
        return Table.of(
                Tuple.of(12, 6, 924), Tuple.of(4, 3, 4), Tuple.of(2, 1, 2), Tuple.of(2, 2, 1), Tuple.of(12, 4, 495),
                Tuple.of(8, 6, 28), Tuple.of(10, 6, 210)
        );
    }

    @Property
    @FromData("preStored")
    boolean dataTest(@ForAll int n, @ForAll int k, @ForAll int result) {
        return (binom.apply(n).apply(k)) == (result);
    }

    @Property(tries = 1000)
    boolean test1(@ForAll @IntRange(min = 0, max = 100000) int n){
        return binom.apply(n).apply(0) == 1;
    }
    @Property(tries = 1000)
    boolean test2(@ForAll @IntRange(min = 0, max = 1000) int n){
        return binom.apply(n).apply(n) == 1;
    }
    @Property(tries = 1000)
    boolean test3(@ForAll @IntRange(min = 0, max = 100000) int n){
        return binom.apply(n).apply(1) == n;
    }
    @Property(tries = 676)
    boolean test4(@ForAll @IntRange(min = 0, max = 25) int n, @ForAll @IntRange(min = 0, max = 25) int k ){
        if( n >= k){
            return binom.apply(n).apply(k).equals(binom.apply(n).apply(n - k));

        }else{
            return binom.apply(k).apply(n).equals(binom.apply(k).apply(k - n));
        }

    }

    @Property(tries = 1000)
    boolean test5(@ForAll @IntRange(min = 1, max = 30) int n, @ForAll @IntRange(min = 1, max = 30) int k) {
        return Functions.binom.apply(n).apply(k) ==
                (int) ((double)(Functions.binom.apply(n-1).apply(k-1)) * (double)n / k);
    }


    @Property(tries = 2000)
    boolean test6(@ForAll @IntRange(min = 1, max = 30) int n, @ForAll @IntRange(min = 1, max = 30) int k,
                  @ForAll @IntRange(min = 1, max = 30) int h){
        if( n-k > h && n-h > k){
            return binom.apply(n).apply(h) * binom.apply(n-h).apply(k) == binom.apply(n).apply(k) * binom.apply(n-k).apply(h);
        }else {
            return true;
        }


    }




}
