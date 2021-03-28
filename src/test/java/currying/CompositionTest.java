package currying;

import static currying.Composition.even;
import static currying.Functions.*;
import static currying.Composition.evenFib;
import static currying.Operators.not;
import net.jqwik.api.*;

import net.jqwik.api.constraints.IntRange;

public class CompositionTest {

    @Property
    boolean test1(@ForAll @IntRange(min = 1, max = 50) int n) {
        return n % 3 == 0 ? evenFib.apply(n): not.apply(evenFib.apply(n));

    }


}
