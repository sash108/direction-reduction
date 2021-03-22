package com.telia.utills.direction.reduction.service;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shahbazhussain on 21/03/2021
 */
public class TeliaChallenge {

    final static Map<String, String> needlessDir = Map.of(
            "NORTH", "SOUTH",
            "SOUTH", "NORTH",
            "EAST", "WEST",
            "WEST", "EAST" );


    public static List<String> dirReduc(List<String> arr) {

        Assert.notNull( arr, "The given direct array mustn't be null." );

        var resultantArr = new ArrayList<String>();
        arr.forEach( direction -> {
            int lastResultElem = resultantArr.size() - 1;
            if (lastResultElem >= 0) {

                var lastAddedDir = resultantArr.get( lastResultElem );
                // Remove from resultantArr if given direction is opposite of last element.
                if (needlessDir.get( direction ).equals( lastAddedDir )) {
                    resultantArr.remove( lastResultElem );
                } else {
                    resultantArr.add( direction );
                }
            } else {
                // add on start
                resultantArr.add( direction );
            }
        } );

        return resultantArr;
    }

}
