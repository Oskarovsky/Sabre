package com.oskarro.kotlinarea

import com.oskarro.kotlinarea.gateway.CodingKotlinService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import java.util.function.Supplier
import java.util.stream.Collectors

@SpringBootTest
class KotlinAreaApplicationTests(@Autowired val service: CodingKotlinService) {


    @Test
    fun test_test_checkNumberOfCollections() {
        // GIVEN
        val collection: Collection<Collection<Int>> = listOf<Collection<Int>>(
            listOf(1, 4, 2, 5, 6),
            listOf(0, -2, 666, 9, 6),
            listOf(-6, -99, 3, 1, 5),
            listOf(41, 6, 2, 3, 33),
            listOf(0, -2, -9, -5, -66)
        )

        // WHEN
        val collections: Collection<Collection<Int>>? = service.leavePositiveNumbersAndSortCollectionsFromShortestToLongest(collection)

        // THEN
        Assertions.assertEquals(5, collections!!.size)
    }

    @Test
    fun test_checkForNegativeNumbers() {
        // GIVEN
        val collection: Collection<Collection<Int>> = listOf<Collection<Int>>(
            listOf(10041, 31141, -5, -491591, 1),
            listOf(66, -6, 101, 7, 44),
            listOf(-16, -99, 1, 23, -65),
            listOf(4111, -451, -0, 2, 33),
            listOf(0, 0, -900, 0, -116)
        )

        // WHEN
        val result: Collection<Collection<Int>>? = service.leavePositiveNumbersAndSortCollectionsFromShortestToLongest(collection)

        // THEN
        org.assertj.core.api.Assertions.assertThat(result).hasSize(5)
        Assertions.assertEquals(
            0,
            result!!.stream()
                .flatMap { c: Collection<Int> -> c.stream().filter { t: Int -> t < 0 } }
                .collect(Collectors.toCollection { ArrayList() }).size
        )
    }
}
