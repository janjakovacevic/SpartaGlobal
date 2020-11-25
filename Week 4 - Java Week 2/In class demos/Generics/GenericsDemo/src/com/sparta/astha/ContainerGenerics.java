package com.sparta.astha;

public class ContainerGenerics<T, V extends Number> {

    private T contents;
    private V values;




    public ContainerGenerics(){

    }

    public ContainerGenerics(T contents, V values) {
        this.contents = contents;
        this.values = values;
    }

    public V getValues() {
        return values;
    }

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }
}
