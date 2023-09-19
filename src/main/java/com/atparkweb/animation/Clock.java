package com.atparkweb.animation;

import javax.swing.Timer;

class Clock {
    interface Callback {
        void tick(Clock clock);
    }

    private Timer timer;

    private Callback callback;

    void setCallback(Callback tick) {
        this.callback = tick;
    }

    void start() {
        if (timer == null) {
            timer = new Timer(5, e -> {
                if (callback != null) {
                    callback.tick(Clock.this);
                }
            });

            timer.start();
        }
    }

    void stop() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }
}

