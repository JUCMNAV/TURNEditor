package org.xtext.project.turn.tcolab.ide;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Iterator;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * Contains a collection of extension methods for {@link Iterable iterable}s.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class IterableExtensions2 {
  /**
   * Returns a multimap where each key is the result of invoking the supplied function {@code computeKeys}
   * on its corresponding value. If the function produces the same key for different values, multiple
   * values will be available for that particular key.
   * 
   * @param values the values to use when constructing the {@code Multimap}. Must not be {@code null}.
   * @param computeKeys the function used to produce the key for each value. Must not be {@code null}.
   */
  public static <K extends Object, V extends Object> Multimap<K, V> toMultimap(final Iterable<? extends V> values, final Function1<? super V, K> computeKeys) {
    final ArrayListMultimap<K, V> map = ArrayListMultimap.<K, V>create();
    final Consumer<V> _function = (V it) -> {
      map.put(computeKeys.apply(it), it);
    };
    values.forEach(_function);
    return map;
  }
  
  /**
   * Returns with the string representation of the iterable argument after calling the {@link Object#toString()} method
   * on each elements. The elements are separated by a comma (,) while the very last element is with the {@code andOrNor}
   * argument.
   */
  public static String toPrettyString(final Iterable<?> any, final String andOrNor) {
    final StringBuilder sb = new StringBuilder();
    final Iterator<?> itr = any.iterator();
    while (itr.hasNext()) {
      {
        final Object next = itr.next();
        int _length = sb.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          boolean _hasNext = itr.hasNext();
          if (_hasNext) {
            sb.append(", ");
          } else {
            CharSequence _xifexpression = null;
            if ((andOrNor == null)) {
              _xifexpression = ", ";
            } else {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append(" ");
              _builder.append(andOrNor, " ");
              _builder.append(" ");
              _xifexpression = _builder;
            }
            sb.append(_xifexpression);
          }
        }
        sb.append(next);
      }
    }
    return sb.toString();
  }
  
  /**
   * Returns with an empty, unmodifiable iterable if the argument is {@code null}, otherwise returns with the argument.
   */
  public static <E extends Object> Iterable<? extends E> nullToEmpty(final Iterable<? extends E> iterable) {
    Iterable<? extends E> _xifexpression = null;
    if ((iterable == null)) {
      _xifexpression = CollectionLiterals.emptyList();
    } else {
      _xifexpression = iterable;
    }
    return _xifexpression;
  }
}
