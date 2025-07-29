package com.learning.poc.sequences;

import lombok.Data;

@Data
public class SequenceBlock {
    private long start;
    private long end;

    public SequenceBlock(long start, long end) {
        this.start = start;
        this.end = end;
    }

    // getters
}
