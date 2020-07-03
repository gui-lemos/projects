package br.com.unisinos.prova;

import java.util.Random;

public class GeradorChave {

    public static int gerar() {
        int max = 10000;
        int min = 1;
        return new Random().nextInt((max - min) + 1) + min;
    }
}
