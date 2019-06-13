# HashSet-Implementation

Following interface is implemented:</br>

                      public interface SetI<E> {
                              boolean add(E e);
                              boolean addAll(SetI<? extends E> c);
                              boolean containsAll(SetI<?> c);
                              boolean removeAll(SetI<?> c);
                              void    clear();
                              boolean contains(Object o);
                              boolean equals(Object o);
                              int     hashCode();
                              boolean isEmpty();
                              boolean remove(Object o);
                              int     size();
                              Object[]        toArray();
                      }

The documentation of the above methods can be found here: https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html </br>
This implementation allows to insert the null element.
