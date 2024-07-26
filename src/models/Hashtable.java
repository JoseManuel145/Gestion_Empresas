package models;

import java.util.ArrayList;

public class Hashtable<K, v> {
    private int size = 10000;
    private ArrayList<Entry<K, v>>[] table;
    public Hashtable() {
        table = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new ArrayList<>();
        }
    }
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (ArrayList<Entry<K, v>> bucket : table) {
            for (Entry<K, v> entry : bucket) {
                keys.add(entry.key);
            }
        }
        return keys;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i].clear();
        }
    }

    // --> FUNCIONES USANDO UN SIMPLE HASH <--
    public int putFirstHash(K key, v value) {
        int index = getSimpleHash(key);
        ArrayList<Entry<K, v>> bucket = table[index];
        bucket.add(new Entry<>(key, value));
        return index;
    }
    public v getFirstHash(K key) {
        int index = getSimpleHash(key);
        for (Entry<K, v> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    // --> FUNCIONES USANDO EL HASHCODE DE JAVA<--
    public void putSecondHash(K key, v value) {
        int index = getHash(key);
        ArrayList<Entry<K, v>> bucket = table[index];
        bucket.add(new Entry<>(key, value));
    }
    public v getSecondHash(K key) {
        int index = getHash(key);
        for (Entry<K, v> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    // --> METODOS PARA LLAMAR UN TIPO DE HASH <--
    private int getSimpleHash(K key) {
        return Math.abs(simpleHash(String.valueOf(key))) % size;
    }
    private int getHash(K key){
        return Math.abs(hash(key));
    }

    // --> FUNCIONES HASH <--
    private int simpleHash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = hash * 31 + key.charAt(i);
        }
        return Math.abs(hash);
    }
    private int hash(K key) {
        return (key.hashCode() * 31) % size;
    }
}
