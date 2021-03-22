package com.telia.utills.direction.reduction.service;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author shahbazhussain on 22/03/2021
 */
class TeliaChallengeTest {


    @Test
    void givenEmptyDirectionSet_whenEvaluateDirectionReduction_thenReturnEmptyReduceResult() {

        // given empty direction list
        final var inputDirections = new ArrayList<String>();

        //when evaluating reduce direction
        final var reduceDir = TeliaChallenge.dirReduc( inputDirections );

        //verify the resultant array is also empty
        Assertions.assertEquals( Collections.emptyList(), reduceDir );

    }

    @Test
    void givenNullDirectionSet_whenEvaluateDirectionReduction_thenReturnIllegalArgumentException() {

        // given empty direction list
        final List<String> inputDirections = null;

        //when evaluating reduce direction
        var exception = assertThrows( IllegalArgumentException.class,
                () -> TeliaChallenge.dirReduc( inputDirections ) );

        //verify the exception message
        Assertions.assertEquals( "The given direct array mustn't be null.", exception.getMessage() );

    }

    @Test
    void givenSingleDirection_whenEvaluateDirectionReduction_thenReturnSameDirection() {

        // given direction list containing only one direction
        final var inputDirections = Collections.singletonList( "WEST" );

        //when evaluating reduce direction
        final var reduceDir = TeliaChallenge.dirReduc( inputDirections );

        //verify the resultant array is also same given single element
        Assertions.assertEquals( 1, reduceDir.size() );
        Assertions.assertEquals( Collections.singletonList( "WEST" ), reduceDir );

    }

    @Test
    void givenDirection_whenEvaluateDirectionReduction_thenCheckResultOrderMatter() {

        // given direction list
        final var inputDirections = Arrays.asList( "SOUTH", "EAST", "EAST" );

        //when evaluating reduce direction
        final var reduceDir = TeliaChallenge.dirReduc( inputDirections );

        //verify the resultant array order is same ["SOUTH", "EAST", "WEST"]
        // expecting ["WEST","SOUTH","EAST"] will fail or false
        Assertions.assertEquals( 3, reduceDir.size() );
        // expectation with wrong order not equal
        Assertions.assertNotEquals( Arrays.asList( "EAST", "SOUTH", "EAST" ), reduceDir );
        // expectation with right order equal
        Assertions.assertEquals( Arrays.asList(  "SOUTH", "EAST", "EAST"), reduceDir );


    }


    @Test
    void givenDifferentDirectionSets_whenEvaluateDirectionReduction_thenReturnReduceResult() {

        // given various direction set possibilities
        final var inputDirections1 = Arrays.asList( "NORTH", "SOUTH", "EAST", "WEST" );
        final var inputDirections2 = Arrays.asList( "NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST" );
        final var inputDirections3 = Arrays.asList( "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" );
        final var inputDirections4 = Arrays.asList( "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH" );

        //when evaluating reduce direction on each direction set
        final List<String> reduceDir1 = TeliaChallenge.dirReduc( inputDirections1 );
        final List<String> reduceDir2 = TeliaChallenge.dirReduc( inputDirections2 );
        final List<String> reduceDir3 = TeliaChallenge.dirReduc( inputDirections3 );
        final List<String> reduceDir4 = TeliaChallenge.dirReduc( inputDirections4 );

        //verify the output corresponding
        Assertions.assertEquals( Collections.emptyList(), reduceDir1 );
        Assertions.assertEquals( Arrays.asList( "WEST", "WEST" ), reduceDir2 );
        Assertions.assertEquals( Collections.singletonList( "WEST" ), reduceDir3 );
        Assertions.assertEquals( Collections.emptyList(), reduceDir4 );
    }

    @Test
    void givenDirectionSet_whenEvaluateDirectionReduction_thenReturnReduceResult() {

        // given direction list, which practical come to same point
        // from req perspective, cannot reduce
        final var inputDirections = Arrays.asList( "NORTH", "WEST", "SOUTH", "EAST" );

        //when evaluating reduce direction
        final var reduceDir = TeliaChallenge.dirReduc( inputDirections );

        //verify the resultant array is also same given single element
        Assertions.assertEquals( 4, reduceDir.size() );
        Assertions.assertEquals( Arrays.asList( "NORTH", "WEST", "SOUTH", "EAST" ), reduceDir );

    }

}