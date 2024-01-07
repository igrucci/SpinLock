package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketSpinLock {

    //give tickets
    private AtomicInteger nextFreeTicket = new AtomicInteger(0);

    //current. that owns lock
    private AtomicInteger ownerTicket = new AtomicInteger(0);

    public void lock(){
        int myTicket = nextFreeTicket.getAndIncrement();
        while(ownerTicket.get() != myTicket){ // wait
            Thread.onSpinWait();
        }
        System.out.println("in the critical section");
    }


    public void unlock(){
        System.out.println("leave the critical section");
        ownerTicket.getAndIncrement();
    }



}
