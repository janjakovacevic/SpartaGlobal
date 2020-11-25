package com.sparta.janja;

public class ContainerGenerics<T, V extends Number> {
                                    // ensuring we don't get anything but a number

    private T contents;
    private V values;

    public ContainerGenerics(T contents, V values) {
        this.contents = contents;
        this.values = values;
    }

    public V getValues() {
        return values;
    }

    public void setValues(V values) {
        this.values = values;
    }

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }
}
