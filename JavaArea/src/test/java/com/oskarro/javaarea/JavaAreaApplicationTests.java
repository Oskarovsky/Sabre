package com.oskarro.javaarea;

import com.oskarro.javaarea.gateway.CodingJavaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JavaAreaApplicationTests {

    @Autowired
    CodingJavaService codingJavaService;


    @Test
    public void test_checkNumberOfCollections() {
        // GIVEN
        Collection<Collection<Integer>> collection = Arrays.asList(
                Arrays.asList(1, 4, 2, 5, 6),
                Arrays.asList(0, -2, 666, 9, 6),
                Arrays.asList(-6, -99, 3, 1, 5),
                Arrays.asList(41, 6, 2, 3, 33),
                Arrays.asList(0, -2, -9, -5, -66)
        );

        // WHEN
        Collection<Collection<Integer>> result = codingJavaService.leavePositiveNumbersAndSortCollectionsFromShortestToLongest(collection);

        // THEN
        assertEquals(5, result.size());
    }

    @Test
    public void test_checkForNegativeNumbers() {
        // GIVEN
        Collection<Collection<Integer>> collection = Arrays.asList(
                Arrays.asList(10041, 31141, -5, -491591, 1),
                Arrays.asList(66, -6, 101, 7, 44),
                Arrays.asList(-16, -99, 1, 23, -65),
                Arrays.asList(4111, -451, -0, 2, 33),
                Arrays.asList(0, 0, -900, 0, -116)
        );

        // WHEN
        Collection<Collection<Integer>> result = codingJavaService.leavePositiveNumbersAndSortCollectionsFromShortestToLongest(collection);

        // THEN
        assertThat(result).hasSize(5);
        assertEquals(0, result.stream().flatMap(c -> c.stream().filter(t -> t < 0)).collect(Collectors.toCollection(ArrayList::new)).size());
    }


}
