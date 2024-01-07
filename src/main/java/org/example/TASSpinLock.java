package org.example;


import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

//Test and Set SpinLock
public abstract class TASSpinLock implements Lock {

    private AtomicBoolean locked = new AtomicBoolean(false);

    public void Unlock(){
      locked.set(false);
    }
    // locked: false -> true
    @Override
    public void lock() {
        while(locked.getAndSet(true)) { // spin if true
            //backoff
        }
    }


    @Override
    public void unlock() {
        locked.set(false);
    }


}