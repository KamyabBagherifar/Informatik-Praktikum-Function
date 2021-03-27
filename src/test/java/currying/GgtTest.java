package currying;
import static currying.Functions.*;
import net.jqwik.api.*;

import net.jqwik.api.constraints.IntRange;


public class GgtTest {
    @Example
    boolean exampleTest() {
        return ggt.apply(12).apply(6) == 6 && ggt.apply(1).apply(0) == 1;

    }

    @Data
    Iterable<? extends Tuple.Tuple3<Integer, Integer, Integer>> preStored() {
        return Table.of(
                Tuple.of(0, 1, 1), Tuple.of(12, 6, 6), Tuple.of(2, 2, 2), Tuple.of(12, 4, 4),
                Tuple.of(8, 6, 2), Tuple.of(18, 6, 6)
        );
    }

    @Property
    @FromData("preStored")
    boolean dataTest(@ForAll int a, @ForAll int b, @ForAll int result) {
        return (ggt.apply(a).apply(b)) == (result);
    }

    @Property(tries = 1000)
    boolean idempotenzgesetz(@ForAll @IntRange(min = 0, max = 100000) int a){
        return ggt.apply(a).apply(a) == a;
    }
    @Property(tries = 1000)
    boolean neutralesElement(@ForAll @IntRange(min = 0, max = 100000) int a){
        return ggt.apply(a).apply(0) == a;
    }
    @Property(tries = 1000)
    boolean absorbierendesElement(@ForAll @IntRange(min = 0, max = 100000) int a){
        return ggt.apply(a).apply(1) == 1;
    }
    @Property(tries = 1000)
    boolean kommutattivgesetz(@ForAll @IntRange(min = 0, max = 100000) int a,
                              @ForAll @IntRange(min = 0, max = 100000) int b){
        return ggt.apply(a).apply(b).equals(ggt.apply(b).apply(a));
    }
    @Property(tries = 1000)
    boolean assoziativgesetz(@ForAll @IntRange(min = 0, max = 100000) int a,
                             @ForAll @IntRange(min = 0, max = 100000) int b,
                             @ForAll @IntRange(min = 0, max = 100000) int c){
        return ggt.apply(a).apply(ggt.apply(b).apply(c)).equals(ggt.apply(ggt.apply(a).apply(b)).apply(c));
    }
    @Property(tries = 1000)
    boolean disitributibgesetz(@ForAll @IntRange(min = 0, max = 10000) int a,
                               @ForAll @IntRange(min = 0, max = 10000) int b,
                               @ForAll @IntRange(min = 0, max = 10000) int m){
        return ggt.apply(m*a).apply(m*b) == m*ggt.apply(b).apply(a);
    }
    @Property(tries = 2000)
    boolean lastTest(@ForAll @IntRange(min = 0, max = 10000) int a, @ForAll @IntRange(min = 0, max = 10000) int b){
        if(a > b){
            return ggt.apply(a).apply(b).equals(ggt.apply(a - b).apply(b));
        }else{
            return ggt.apply(a).apply(b).equals(ggt.apply(a).apply(b - a));
        }
    }


}
