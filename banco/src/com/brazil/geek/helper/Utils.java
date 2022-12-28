package com.brazil.geek.helper;

import java.text.*;
import java.util.Date;
import java.util.Locale;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Utils {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static NumberFormat numberFormat = new DecimalFormat("R$ #,##0.00",
            new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String dateToString(Date date) {
        return simpleDateFormat.format(date);
    }

    public static String doubleToString(Double value) {
        return numberFormat.format(value);
    }

    public static Double stringToDouble(String value) {
        try {
            return (Double) numberFormat.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void pause(int seconds) {
        try {
            SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("Erro ao pausar por " + seconds + " segundos.");
        }
    }

}
