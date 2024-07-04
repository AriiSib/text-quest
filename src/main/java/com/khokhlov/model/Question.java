package com.khokhlov.model;

import lombok.Data;

import java.util.List;

@Data
public class Question{
    public int id;
    public String question;
    public List<Integer> answer;
    public boolean failed;
    public boolean success;
}