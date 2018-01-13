package com.sartur.pocs.xor

class Node {
    Integer layer
    Integer position

    static activation(Double x){
        1.0 / ( 1 + Math.exp( Math.E , -x) )
    }
}
