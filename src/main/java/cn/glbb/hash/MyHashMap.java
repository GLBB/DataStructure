package cn.glbb.hash;

import java.util.LinkedList;
import java.util.Set;


// 放弃
public class MyHashMap<K, V> implements MyMap<K, V> {

    private static int DEFAULT_INITIAL_CAPACITY = 4;

    private static int MAXIMUM_CAPCITY = 1 << 30;

    private int capcity;

    private static float DEFAULT_MAX_LOAD_FACTORY = 0.75f;

    private float loadFactorThreshold;

    private int size = 0;

    LinkedList<MyMap.Entry<K,V>>[] table;

    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_MAX_LOAD_FACTORY);
    }

    public MyHashMap(int initialCapcity){
        this(initialCapcity,DEFAULT_MAX_LOAD_FACTORY);
    }

    public MyHashMap(int initialCapcity, float loadFactorThreshold){
        if (initialCapcity>MAXIMUM_CAPCITY){
            this.capcity = MAXIMUM_CAPCITY;
        }else {
            this.capcity = trimToPowerOf2(initialCapcity);
        }
    }

    private int trimToPowerOf2(int initialCapcity) {
        int capcity = 1;
        while (capcity < initialCapcity){
            capcity = capcity << 1;
        }
        return capcity;
    }

    private static int supplementalHash (int h){
        h ^= (h>>>20) ^ (h>>>12);
        return h ^ (h>>>7) ^ (h>>>4);
    }

    private int hash(int hashCode) {
        return  supplementalHash(hashCode) & (capcity-1);
    }

    private void removeEntries() {
        for (int i = 0; i < capcity; i++){
            if (table[i]!=null){
                table[i].clear();
            }
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<V> values() {
        return null;
    }
}
