package org.egov.bootcamp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashSet<T> {
    private HashMap<T, Boolean> map;
    private final Boolean EXISTS = true;

    public HashSet() {
        this.map = new HashMap<T, Boolean>();
    }

    public boolean add(T element) {
        return this.map.put(element, EXISTS) == null;
    }

    public boolean addAll(Collection<T> elements) {
        Map<T, Boolean> elementMap = new HashMap<T, Boolean>();
        for (T element : elements) {
            elementMap.put(element, this.add(element));
        }
        return elementMap.containsValue(true);
    }

    public boolean remove(T element) {
        return this.map.remove(element) == EXISTS;
    }

    public void removeAll() {
        this.map.clear();
    }

    public void clear() {
        this.map.clear();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public HashSet<T> clone() {
        HashSet<T> clonedSet = new HashSet<T>();
        clonedSet.addAll(this.map.keySet());
        return clonedSet;
    }

    public boolean contains(T element) {
        return this.map.containsKey(element);
    }

    public boolean containsAll(Collection<T> elements) {
        Map<T, Boolean> elementMap = new HashMap<T, Boolean>();
        for (T element : elements) {
            elementMap.put(element, this.contains(element));
        }
        return !elementMap.containsValue(false);
    }

    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    public int size() {
        return map.size();
    }

    public T[] toArray() {
        T[] arrayElements = (T[]) new Object[this.size()];
        return this.map.keySet().toArray(arrayElements);
    }

}
