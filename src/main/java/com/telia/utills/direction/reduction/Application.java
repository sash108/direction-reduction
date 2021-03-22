package com.telia.utills.direction.reduction;

import com.telia.utills.direction.reduction.service.TeliaChallenge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        evaluateReduceDir( args );
        SpringApplication.run( Application.class, args );
    }

    public static void evaluateReduceDir(String[] args) {

        System.out.println( "****************** Welcome to Direction Reduction Software ****************" );

        final var argsList = Arrays.asList( args );
        System.out.println( "Input direction set for calculating direction reduction is:" );
        System.out.println( argsList );

        final var reduceDir = TeliaChallenge.dirReduc( argsList );
        System.out.println( "Result after applying algorithm on given input direction set:" );
        System.out.println( reduceDir );

        System.out.println( "******************* End of program, Please come back *************************" );


    }

}
