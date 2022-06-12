package org.vxinv.java_base.a3_generate_collection.c35_generic;

public class NumberPair<U extends Number, V extends Number> extends Pair<U, V> {

    public NumberPair(U first, V second) {
        super(first, second);
    }

    public double sum(){
        return getFirst().doubleValue()
                +getSecond().doubleValue();
    }

    public static void main(String[] args){
    	NumberPair<Integer, Double> pair = new NumberPair<>(10, 12.34);
    	double sum = pair.sum();
    }
}
