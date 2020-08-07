package com.forogh.opinionPoll.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum QuestionType {

    @JsonProperty
            ("double_ans") DOUBLE_ANS(1, "double"),
    @JsonProperty
            ("integer_ans") INT_ANS(2, "integer"),
    @JsonProperty
            ("multiChoice_ans") MULTI_CHOICE(3, "multiChoice"),
    @JsonProperty
            ("singleChoice_ans") SINGLE_CHOICE(4, "singleChoice"),
    @JsonProperty
            ("descriptive_ans") DESCRIPTIVE(5, "descriptive");

    private int k;
    private String v;

    QuestionType(int k, String v) {
        this.k = k;
        this.v = v;
    }

    public int getK() {
        return k;
    }

    public String getV() {
        return v;
    }
}
