# Set

This implementation of `Set<E>` interface is an improvement to the standard list backed set.

Our intention was to improve the time complexity of `contains` -- a method we figured would be called most often -- even at the expense of `add` and `remove`. We did so by ordering the backing array, making searching it logarithmic time. However, we did not want to place a constraint on the generic type argument `E` that would restrict our implementation to objects that are `Comparable`. Therefore, we ordered the element based on the natural ordering of their hash codes.

Although, the proper implementation of a hash based data structure is one in which elements are put into buckets based on their hash code. And, in a properly implemented hash based data structure `contains`, `add`, and `remove` are all constant time operations. That was not our goal.

We were most concerned with showing how a list backed set could be optimized for a particular operation, in our case `contains`.

Type of Set     | `contains` | `add`      | `remove`
:-------------- | :--------- | :--------- | :---------
List Backed Set | O(n)       | O(n)       | O(n)
Our Set         | O(log n)   | O(n log n) | O(n log n)
