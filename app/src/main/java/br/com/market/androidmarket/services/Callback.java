package br.com.market.androidmarket.services;

/**
 * Created by Douglas on 13/07/2016.
 */
public interface Callback<T> {

    void success(T t);

    void failure();

}
