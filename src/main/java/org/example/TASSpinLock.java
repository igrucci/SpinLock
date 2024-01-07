package org.example;

import java.util.concurrent.atomic.AtomicBoolean;


//Test and Set SpinLock
public class TASSpinLock {

    private AtomicBoolean locked = new AtomicBoolean(false);

    // locked: false -> true
    public void lock() {
        while(locked.getAndSet(true)) { // spin if true
        }
        System.out.println("in the critical section");
    }

    public void unlock(){
        System.out.println("leave the critical section");
        locked.set(false);
    }




}