package superiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;

  public SuperIterable(Iterable<E> self) {
    this.self = self;
  }

//  public void useAll(/*SuperIterable<E> this, */Consumer<E> op) {
  // was useAll, should be forEach, but forEach already exists
//  public void forEach(Consumer<E> op) {
//    for (E s : this.self) {
//      op.accept(s);
//    }
//  }

  // was selectByCriterion
  public SuperIterable<E> filter(Predicate<E> crit) {
    List<E> rv = new ArrayList<>();
    for (E s : this.self) {
      if (crit.test(s)) {
        rv.add(s);
      }
    }
    return new SuperIterable<>(rv);
  }

  public <F> SuperIterable<F> flatMap(Function<E, SuperIterable<F>> op) {
    List<F> rv = new ArrayList<>();
    for (E e : this.self) {
      SuperIterable<F> manyF = op.apply(e);
      for (F f : manyF) {
        rv.add(f);
      }
    }
    return new SuperIterable<>(rv);
  }

  public <F> SuperIterable<F> map(Function<E, F> op) {
    List<F> rv = new ArrayList<>();
    for (E e : this.self) {
      F f = op.apply(e);
      rv.add(f);
    }
    return new SuperIterable<>(rv);
  }

  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }
}
