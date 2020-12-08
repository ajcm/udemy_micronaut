package com.example;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static BigDecimal getRandom(){
        return BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(1,100));
    }
}
