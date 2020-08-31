package com.sammidev.designpattern.inheritance;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setId("1A");
        product1.setCode("1A");
        product1.setName("laptop");
        product1.setPrice(new BigDecimal("45000000"));

        PurchaseDetails purchaseDetails = new PurchaseDetails();
        purchaseDetails.setProduct(product1);
        purchaseDetails.setAmount(2);

        Discount discount = new Discount();
        discount.getShoppingList().add(purchaseDetails);

        System.out.println("total shopping : " + discount.total());
        System.out.println("discount : " + discount.discount());
        System.out.println("pay : " + discount.total().subtract(discount.discount()));
    }
}

class Purchase {
    private String id;
    private LocalDateTime timeTransaction = LocalDateTime.now();
    private String customer;

    Set<PurchaseDetails> shoppingList = new HashSet<>();

    public BigDecimal total() {
        BigDecimal result = BigDecimal.ZERO;
        for (PurchaseDetails pd : shoppingList) {
            result = result.add(pd.subTotal());
        }
        return result;
    }

    public Purchase(String id, LocalDateTime timeTransaction, String customer, Set<PurchaseDetails> shoppingList) {
        this.id = id;
        this.timeTransaction = timeTransaction;
        this.customer = customer;
        this.shoppingList = shoppingList;
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

    public Set<PurchaseDetails> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(Set<PurchaseDetails> shoppingList) {
        this.shoppingList = shoppingList;
    }
}

class PurchaseDetails {
    private String id;
    private Purchase purchase;
    private Product product;
    private Integer amount;

    public BigDecimal subTotal() {
        return product.getPrice().multiply(new BigDecimal(amount));
    }

    public PurchaseDetails(String id, Purchase purchase, Product product, Integer amount) {
        this.id = id;
        this.purchase = purchase;
        this.product = product;
        this.amount = amount;
    }

    public PurchaseDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

class Product {
    private String id;
    private String code;
    private String name;
    private BigDecimal price;

    public Product(String id, String code, String name, BigDecimal price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

class Discount extends Purchase {
    private String nameDisc;
    private String voucher;

    public BigDecimal discount() {
        return total().multiply(new BigDecimal("0.5"));
    }

    public Discount(String nameDisc, String voucher) {
        this.nameDisc = nameDisc;
        this.voucher = voucher;
    }

    public Discount() {
    }

    public String getNameDisc() {
        return nameDisc;
    }

    public void setNameDisc(String nameDisc) {
        this.nameDisc = nameDisc;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}