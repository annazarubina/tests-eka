package org.eka.tests.other.heapsort;

import java.util.Arrays;

class Output {
    public int[] res;

    public Output(int[] res) {
        this.res = res;
    }

    public Output() {
    }

    @Override
    public String toString() {
        return Arrays.toString(res);
    }
}
