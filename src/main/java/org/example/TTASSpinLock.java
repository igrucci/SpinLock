package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

//Test and Test and Set
public class TTASSpinLock {
    private AtomicBoolean state = new AtomicBoolean(false);

    public void lock(){
        while(true){
            while(state.get()){}

            if(!state.getAndSet(true)){
                //locked
                return;
            }
        }
    }
    public void unlock(){
        state.set(false);
    }
}
