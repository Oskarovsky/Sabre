package com.oskarro.javaarea;

import com.oskarro.javaarea.gateway.CodingJavaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JavaAreaApplicationTests {

    @Autowired
    CodingJavaService codingJavaService;


    @Test
    public void test_leavePositiveNumbersAndSortCollectionsFromShortestToLongest() {
        // GIVEN
        Collection<Collection<Integer>> collection = Arrays.asList(
                Arrays.asList(1, 4, 2, 5, 6),
                Arrays.asList(0, -2, 666, 9, 6),
                Arrays.asList(-6, -99, 3, 1, 5),
                Arrays.asList(41, 6, 2, 3, 33),
                Arrays.asList(0, -2, -9, -5, -66)
        );

        // WHEN
        Collection<Collection<Integer>> collections = codingJavaService.leavePositiveNumbersAndSortCollectionsFromShortestToLongest(collection);

        // THEN
        assertEquals(5, collections.size());

    }


}
