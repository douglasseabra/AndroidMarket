package br.com.market.androidmarket.helpers;

import java.util.Random;

import br.com.market.androidmarket.R;

/**
 * Created by Douglas on 14/07/2016.
 */
public class ColorHelper {

    public static int getRandomColor() {
        int[] colors = { R.color.orage_e7ad45,
                R.color.red_d04f2a,
                R.color.purple_5f498c,
                R.color.green_a3c74b,
                R.color.pink_ce4251,
                R.color.blue_4982c5,
                R.color.gray_919191 };

        int index = getRandomNumberFrom(0, 6);

        return colors[index];
    }


    private static int getRandomNumberFrom(int min, int max) {
        Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;

        return randomNumber;
    }
}
