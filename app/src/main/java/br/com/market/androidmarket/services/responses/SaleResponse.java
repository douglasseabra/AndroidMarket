package br.com.market.androidmarket.services.responses;

import java.util.List;

import br.com.market.androidmarket.models.Sale;

/**
 * Created by Douglas on 14/07/2016.
 */
public class SaleResponse {

    private List<Sale> listSales;

    public List<Sale> getListSales() {
        return listSales;
    }

    public void setListSales(List<Sale> listSales) {
        this.listSales = listSales;
    }
}
