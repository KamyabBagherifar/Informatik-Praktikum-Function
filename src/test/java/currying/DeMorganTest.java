package currying;

import net.jqwik.api.*;

import static currying.Operators.*;
public class DeMorganTest {

    @Property
    boolean test_1(@ForAll boolean a, @ForAll boolean b) {
        return not.apply(and.apply(a).apply(b)) ==  or.apply(not.apply(b)).apply(not.apply(a));
    }

    @Property
    boolean test_2(@ForAll boolean a, @ForAll boolean b) {
        return not.apply(or.apply(a).apply(b)) ==  and.apply(not.apply(b)).apply(not.apply(a));
    }







}
