package com.epam.university.java.core.task032;

public class Task032Impl implements Task032 {
    @Override
    public CountingProxy createProxyWrapper() {
        return new CountingProxyImpl();
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        return new SomeActionExecutorImpl(proxy);
    }
}