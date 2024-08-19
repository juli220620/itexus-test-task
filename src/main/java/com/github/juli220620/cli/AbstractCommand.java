package com.github.juli220620.cli;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public abstract class AbstractCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        try {
            process();
            return 0;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 1;
        }
    }

    protected abstract void process() throws Exception;
}
