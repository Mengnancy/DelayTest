package com.qm.concurrent;

public interface LifecycleListener {

    void onEvent(ObservableRunnable.RunnableEvent event);
}
