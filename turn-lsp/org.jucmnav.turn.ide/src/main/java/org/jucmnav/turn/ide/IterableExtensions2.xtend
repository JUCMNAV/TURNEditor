package org.jucmnav.turn.ide;

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import org.eclipse.xtext.xbase.lib.Functions.Function1

class IterableExtensions2 {

	/**
	 * Returns a multimap where each key is the result of invoking the supplied function {@code computeKeys}
	 * on its corresponding value. If the function produces the same key for different values, multiple 
	 * values will be available for that particular key.
	 * 
	 * @param values the values to use when constructing the {@code Multimap}. Must not be {@code null}.
	 * @param computeKeys the function used to produce the key for each value. Must not be {@code null}.
	 */
	static def <K, V> Multimap<K, V> toMultimap(Iterable<? extends V> values, Function1<? super V, K> computeKeys) {
		val map = ArrayListMultimap.create;
		values.forEach[map.put(computeKeys.apply(it), it)];
		return map;
	}

	/**
	 * Returns with the string representation of the iterable argument after calling the {@link Object#toString()} method
	 * on each elements. The elements are separated by a comma (,) while the very last element is with the {@code andOrNor}
	 * argument.
	 */
	static def toPrettyString(Iterable<?> any, String andOrNor) {
		val sb = new StringBuilder();
		val itr = any.iterator;
		while (itr.hasNext) {
			val next = itr.next()
			if (sb.length > 0) {
				if (itr.hasNext) {
					sb.append(', ');
				} else {
					sb.append(if(andOrNor === null) ', ' else ''' «andOrNor» ''');
				}
			}
			sb.append(next);
		}
		return sb.toString;
	}
	
	/**
	 * Returns with an empty, unmodifiable iterable if the argument is {@code null}, otherwise returns with the argument.
	 */
	static def <E> nullToEmpty(Iterable<? extends E> iterable) {
		return if (iterable === null) emptyList else iterable; 
	}
}