package com.samee;

import java.util.Scanner;

import javax.enterprise.context.ApplicationScoped;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;

@ApplicationScoped
public class GreetingRepository {

    
    @Blocking
    public void blocking()
    {

        System.out.println("Program is running.......");

        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        System.out.println(txt);

        System.out.println("Program end.....");

    }

    @NonBlocking
    public void nonblocking()
    {

        System.out.println("Program is running.......");

        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        System.out.println(txt);

        System.out.println("Program end.....");

    }
    
}
