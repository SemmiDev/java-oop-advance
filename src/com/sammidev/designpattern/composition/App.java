package com.sammidev.designpattern.composition;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setId("a01");
        product1.setKode("a01");
        product1.setName("Mouse");
        product1.setPrice(new BigDecimal("450000"));

        Product product2 = new Product();
        product2.setId("a02");
        product2.setKode("a02");
        product2.setName("Keyboard");
        product2.setPrice(new BigDecimal("900000"));


        PurchaseDetails purchaseDetails1 = new PurchaseDetails();
        purchaseDetails1.setProduct(product1);
        purchaseDetails1.setTotal(5);

        PurchaseDetails purchaseDetails2 = new PurchaseDetails();
        purchaseDetails1.setProduct(product2);
        purchaseDetails1.setTotal(2);

        Purchase purchase = new Purchase();
        purchase.getListPurchases().add(purchaseDetails1);
        purchase.getListPurchases().add(purchaseDetails2);

        ProductDiscount productDiscount1 = new ProductDiscount(purchase);
        productDiscount1.setCode("DISCOUNT-a01");
        productDiscount1.setName("discount product a01 15%");
        productDiscount1.setProduct(product1);
        productDiscount1.setDiscountPercentace(new BigDecimal("0.175"));

        ProductDiscount productDiscount2 = new ProductDiscount(purchase);
        productDiscount1.setCode("DISCOUNT-idulfitri");
        productDiscount1.setName("Diskon semua produk menyambut hari raya idul fitri : 25%");
        productDiscount1.setProduct(product1);
        productDiscount1.setDiscountPercentace(new BigDecimal("0.25"));

        purchase.getListDicount().add(productDiscount1);
        purchase.getListDicount().add(productDiscount2);

        ProductImport productImport = new ProductImport();
        productImport.setId("a03");
        productImport.setKode("a01");
        productImport.setName("Iphone XS MAX");
        productImport.setPrice(new BigDecimal("30000000"));
        productImport.setCountryOrigin("USA");
        productImport.getImportTaxRate().put("USA", new BigDecimal("0.25"));

        PurchaseDetails purchaseDetails = new PurchaseDetails();
        purchaseDetails.setProduct(productImport);
        purchaseDetails.setTotal(2);

        Purchase purchase1 = new Purchase();
        purchase.getListPurchases().add(purchaseDetails);
        purchase.getListTax().add(productImport);
        purchase.getListTax().add(new Others(new BigDecimal("0.20")));

        System.out.println("Total Pajak : "+purchase1.totalTax());
    }
}


class Others implements Tax {
    private BigDecimal percentace;


    @Override
    public BigDecimal countTax(Purchase purchase) {
        return purchase.totalValue().multiply(percentace);
    }

    public Others(BigDecimal percentace) {
        this.percentace = percentace;
    }

    public BigDecimal getPercentace() {
        return percentace;
    }

    public void setPercentace(BigDecimal percentace) {
        this.percentace = percentace;
    }
}

class ProductImport extends Product implements Tax {

    private Map<String, BigDecimal> importTaxRate = new HashMap<>();
    private String countryOrigin;

    @Override
    public BigDecimal countTax(Purchase purchase) {
        return getPrice().multiply(importTaxRate.get(countryOrigin));
    }

    public Map<String, BigDecimal> getImportTaxRate() {
        return importTaxRate;
    }

    public void setImportTaxRate(Map<String, BigDecimal> importTaxRate) {
        this.importTaxRate = importTaxRate;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }
}

class ProductDiscount extends Discount{
    private Product product;
    private BigDecimal discountPercentace;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    public ProductDiscount(Purchase purchase) {
        super(purchase);
    }

    @Override
    public BigDecimal countDiscount() {
        BigDecimal result = BigDecimal.ZERO;
        for (PurchaseDetails pd : getPurchase().getListPurchases()){
            if (product.equals(pd.getProduct())) {
                result = result.add(product.getPrice().multiply(discountPercentace));
            }
        }
        return result;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getDiscountPercentace() {
        return discountPercentace;
    }

    public void setDiscountPercentace(BigDecimal discountPercentace) {
        this.discountPercentace = discountPercentace;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }
}

class PurchaseDetails {
    private String id;
    private Integer total;
    private Purchase purchase;
    private Product product;

    public BigDecimal subtotal() {
        return product.getPrice().multiply(new BigDecimal(total));
    }

    public PurchaseDetails(String id, Integer total, Purchase purchase, Product product) {
        this.id = id;
        this.total = total;
        this.purchase = purchase;
        this.product = product;
    }

    public PurchaseDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

class Purchase {
    private String id;
    private LocalDateTime timeTransaction = LocalDateTime.now();
    private String customer;

    Set<PurchaseDetails> listPurchases = new HashSet<>();
    Set<Discount> listDicount = new HashSet<>();
    Set<Tax> listTax = new HashSet<>();

    public BigDecimal totalValue() {
        BigDecimal result = BigDecimal.ZERO;
        for (PurchaseDetails pd : listPurchases) {
            result = result.add(pd.subtotal());
        }
        return result;
    }

    public BigDecimal totalDiscount() {
        BigDecimal result = BigDecimal.ZERO;
        for (Discount d : listDicount) {
            result = result.add(d.countDiscount());
        }
        return result;
    }

    public BigDecimal totalTax() {
        BigDecimal result = BigDecimal.ZERO;
        for (Tax tax : listTax) {
            result = result.add(tax.countTax(this));
        }
        return result;
    }

    public Purchase(String id, LocalDateTime timeTransaction, String customer, Set<PurchaseDetails> listPurchases, Set<Discount> listDicount, Set<Tax> listTax) {
        this.id = id;
        this.timeTransaction = timeTransaction;
        this.customer = customer;
        this.listPurchases = listPurchases;
        this.listDicount = listDicount;
        this.listTax = listTax;
    }

    public Purchase() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTimeTransaction() {
        return timeTransaction;
    }

    public void setTimeTransaction(LocalDateTime timeTransaction) {
        this.timeTransaction = timeTransaction;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Set<PurchaseDetails> getListPurchases() {
        return listPurchases;
    }

    public void setListPurchases(Set<PurchaseDetails> listPurchases) {
        this.listPurchases = listPurchases;
    }

    public Set<Discount> getListDicount() {
        return listDicount;
    }

    public void setListDicount(Set<Discount> listDicount) {
        this.listDicount = listDicount;
    }

    public Set<Tax> getListTax() {
        return listTax;
    }

    public void setListTax(Set<Tax> listTax) {
        this.listTax = listTax;
    }
}

abstract class Discount {

    private String code;
    private String name;
    private Purchase purchase;

    public Discount(String code, String name, Purchase purchase) {
        this.code = code;
        this.name = name;
        this.purchase = purchase;
    }

    public Discount() {
    }

    public Discount(Purchase p) {
        this.purchase = p;
    }
    public abstract BigDecimal countDiscount();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}

interface Tax {
    BigDecimal countTax(Purchase purchase);
}

class Product {
    public Product() {}

    public Product(String id, String kode, String name, BigDecimal price) {
        this.id = id;
        this.kode = kode;
        this.name = name;
        this.price = price;
    }

    private String id;
    private String kode;
    private String name;
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}