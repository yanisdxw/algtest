package com.study.thread.book;

import java.math.BigInteger;

public class VolitatleCachedFactorizer {

    private volatile  OneValueCache cache = new OneValueCache(null,null);

    public BigInteger[] getFactors(BigInteger i){
        BigInteger[] factors = cache.getFactors(i);
        if(factors==null){
            factors = factor(i);
            cache = new OneValueCache(i,factors);
        }
        return factors;
    }

    private BigInteger[] factor(BigInteger i){
        return new BigInteger[]{};
    }
}
