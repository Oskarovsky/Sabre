package com.oskarro.javaarea.gateway;

import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

@Service
public class CodingJavaService {

    public Collection<Collection<Integer>> leavePositiveNumbersAndSortCollectionsFromShortestToLongest(Collection<Collection<Integer>> entries) {
         return entries.stream()
                 .map(t -> t.stream().filter(x -> x > 0))
                 .map(x -> x.sorted().collect(toCollection(ArrayList::new)))
                 .collect(toCollection(ArrayList::new));
    }

}

