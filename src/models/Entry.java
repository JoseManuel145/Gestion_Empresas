package models;

public class Entry<K, V> {
    K key;
    V value;
//constructor del valor que guarda el Business
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}