package com.oskarro.interview.gateway

import org.springframework.stereotype.Service
import kotlin.streams.asSequence

@Service
class CodingService {

    fun leavePositiveNumbersAndSortCollectionsFromShortestToLongest(entries: Collection<Collection<Int?>?>?): Collection<Collection<Int>> {

        entries
            ?.stream()
            ?.asSequence()
            ?.filter { it > 0 }

    }

    public Collection<Collection<Integer>> leavePositiveNumbersAndSortCollectionsFromShortestToLongest(Collection<Collection<Integer>> entries) {

    }
}