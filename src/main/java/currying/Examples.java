package currying;

public class Examples {
// Examples from FPJ-Buch
  public static final Function<Integer, Integer> fact0 = n -> n == 0 ? 1 : n * Examples.fact0.apply(n - 1);

  public static Function<Integer, Integer> fact1;
  static {
    fact1 = n -> n <= 1 ? 1 : n * fact1.apply(n - 1);
  }

  public final Function<Integer, Integer> fact2 = n -> n <= 1 ? 1 : n * this.fact2.apply(n - 1);

  public Function<Integer, Integer> fact3;
  {
    fact3 = n -> n <= 1 ? 1 : n * fact3.apply(n - 1);
  }
    public static final Function<Integer, Integer> fib = f -> f <= 1 ? f : Examples.fib.apply(f-1) + Examples.fib.apply(f-2);

  public static void main(String[] args) {
    System.out.println(fact0.apply(10));
    System.out.println(fact1.apply(0));
    Examples x = new Examples();
    System.out.println(x.fact2.apply(10));
    System.out.println(x.fact3.apply(10));
  }
}
