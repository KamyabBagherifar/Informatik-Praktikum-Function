package recursion;

import net.jqwik.api.*;

import static recursion.Methods.add;

class AddTest {

  @Property
  boolean testAdd(@ForAll int a, @ForAll int b) {
    return add(a, b) == a +b;
  }
}