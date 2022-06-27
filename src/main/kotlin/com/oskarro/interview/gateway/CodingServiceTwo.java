package com.oskarro.interview.gateway;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CodingServiceTwo {

    public Collection<Collection<Integer>> leavePositiveNumbersAndSortCollectionsFromShortestToLongest(Collection<Collection<Integer>> entries) {
        entries
                .stream()
                .map(t -> {
                    List<Integer> collect1 = t.stream().filter(x -> x > 0).collect(Collectors.toList());
                    return collect1;
                })
                .collect(Collectors.toList())
                .sort(Comparator.comparingInt(s -> s.toArray().length))


    }
}

}

