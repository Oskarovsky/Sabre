package com.oskarro.kotlinarea.gateway

import org.springframework.stereotype.Service
import java.util.function.Supplier
import java.util.stream.Collectors
import java.util.stream.Stream

@Service
class CodingKotlinService {

    fun leavePositiveNumbersAndSortCollectionsFromShortestToLongest(entries: Collection<Collection<Int>>): Collection<Collection<Int>>? {
        return entries.stream()
            .map { t -> t.stream().filter { x: Int -> x > 0 } }
            .map { x -> x.sorted().collect(Collectors.toCollection { ArrayList() }) }
            .collect(Collectors.toCollection { ArrayList() })
    }

}