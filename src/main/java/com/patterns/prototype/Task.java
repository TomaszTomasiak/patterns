package com.patterns.prototype;

import lombok.Data;

public final class Task {

    final private String name;


    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Task [" + name + "]";
    }
}
