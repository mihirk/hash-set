package org.egov.bootcamp;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BinarySearch {
    public Integer search(List elements, Integer element) {
        Object[] copyElements = elements.toArray();
        Arrays.sort(copyElements);
        if (Arrays.equals(copyElements, elements.toArray())) {
            return search(elements, element, 0, elements.size() - 1);
        }
        return -1;
    }

    private Integer search(List<Integer> elements, Integer element, Integer start, Integer end) {
        if (Objects.equals(start, end) && !elements.get(end).equals(element)) return -1;
        int midPos = (start + end) / 2;
        switch (Integer.compare(elements.get(midPos), element)) {
            case 0:
                return midPos;
            case 1:
                return search(elements, element, start, midPos);
            case -1:
                return search(elements, element, midPos, end);
            default:
                return -1;
        }
    }
}
