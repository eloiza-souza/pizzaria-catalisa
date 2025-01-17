package com.zup.pizzaria.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private static String padraoDeData = "dd/MM/yyyy HH:mm:ss";

    public static String converteInstantParaString(Instant instante) {
        return criaFormatodorParaData(padraoDeData).format(instante);
    }

    private static DateTimeFormatter criaFormatodorParaData(String pattern) {
        return DateTimeFormatter.ofPattern(pattern)
                .withZone(ZoneId.systemDefault());
    }
}

