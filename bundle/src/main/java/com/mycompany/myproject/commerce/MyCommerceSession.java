package com.mycompany.myproject.commerce;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.adobe.cq.commerce.api.CommerceException;
import com.adobe.cq.commerce.api.CommerceService;
import com.adobe.cq.commerce.api.PlacedOrder;
import com.adobe.cq.commerce.api.PlacedOrderResult;
import com.adobe.cq.commerce.api.PriceInfo;
import com.adobe.cq.commerce.api.Product;
import com.adobe.cq.commerce.api.promotion.PromotionInfo;
import com.adobe.cq.commerce.api.promotion.Voucher;
import com.adobe.cq.commerce.api.promotion.VoucherInfo;
import com.adobe.cq.commerce.hybris.HybrisSession;
import com.adobe.cq.commerce.hybris.SessionInfo;
import org.apache.commons.collections.Predicate;


public class MyCommerceSession implements HybrisSession {

    HybrisSession defaultSession = null;

    public MyCommerceSession(HybrisSession defaultSession) {
         this.defaultSession = defaultSession;
    }

    @Override
    public SessionInfo getSessionInfo() {
        return this.defaultSession.getSessionInfo();
    }

    @Override
    public CommerceService getCommerceService() {
        return this.defaultSession.getCommerceService();
    }

    @Override
    public String getBaseStore() {
        return this.defaultSession.getBaseStore();
    }

    @Override
    public void logout() throws CommerceException {
        this.defaultSession.logout();
    }

    @Override
    public void setUserLocale(Locale locale) {
        this.defaultSession.setUserLocale(locale);
    }

    @Override
    public Locale getUserLocale() {
        return this.defaultSession.getUserLocale();
    }

    @Override
    public String getPriceInfo(Product product) throws CommerceException {
        return this.defaultSession.getPriceInfo(product);
    }

    @Override
    public List<PriceInfo> getProductPriceInfo(Product product) throws CommerceException {
        return this.defaultSession.getProductPriceInfo( product);
    }

    @Override
    public List<PriceInfo> getProductPriceInfo(Product product, Predicate predicate) throws CommerceException {
        return this.defaultSession.getProductPriceInfo( product,  predicate);
    }

    @Override
    public String getProductPrice(Product product) throws CommerceException {
        return this.defaultSession.getProductPrice( product);
    }

    @Override
    public String getProductPrice(Product product, Predicate predicate) throws CommerceException {
        return this.defaultSession.getProductPrice( product,  predicate);
    }

    @Override
    public int getCartEntryCount() throws CommerceException {
        return this.defaultSession.getCartEntryCount();
    }

    @Override
    public List<CartEntry> getCartEntries() throws CommerceException {
        return this.defaultSession.getCartEntries();
    }

    @Override
    public String getCartPreTaxPrice() throws CommerceException {
        return this.defaultSession.getCartPreTaxPrice();
    }

    @Override
    public String getCartTax() throws CommerceException {
        return this.defaultSession.getCartTax();
    }

    @Override
    public String getCartTotalPrice() throws CommerceException {
        return this.defaultSession.getCartTotalPrice();
    }

    @Override
    public String getOrderShipping() throws CommerceException {
        return this.defaultSession.getOrderShipping();
    }

    @Override
    public String getOrderTotalTax() throws CommerceException {
        return this.defaultSession.getOrderTotalTax();
    }

    @Override
    public String getOrderTotalPrice() throws CommerceException {
        return this.defaultSession.getOrderTotalPrice();
    }

    @Override
    public List<PriceInfo> getCartPriceInfo(Predicate predicate) throws CommerceException {
        return this.defaultSession.getCartPriceInfo(predicate);
    }

    @Override
    public String getCartPrice(Predicate predicate) throws CommerceException {
        return this.defaultSession.getCartPrice( predicate);
    }

    @Override
    public void addCartEntry(Product product, int i) throws CommerceException {
        this.defaultSession.addCartEntry( product,  i);
    }

    @Override
    public void modifyCartEntry(int i, int i2) throws CommerceException {
        this.defaultSession.modifyCartEntry( i,  i2);
    }

    @Override
    public void deleteCartEntry(int i) throws CommerceException {
        this.defaultSession.deleteCartEntry(i);
    }

    @Override
    public void addVoucher(String s) throws CommerceException {
        this.defaultSession.addVoucher(s);
    }

    @Override
    public void removeVoucher(String s) throws CommerceException {
        this.defaultSession.removeVoucher(s);
    }

    @Override
    public List<VoucherInfo> getVoucherInfos() throws CommerceException {
        return this.defaultSession.getVoucherInfos();
    }

    @Override
    public List<Voucher> getVouchers() throws CommerceException {
        return this.defaultSession.getVouchers();
    }

    @Override
    public boolean supportsClientsidePromotionResolution() {
        return this.defaultSession.supportsClientsidePromotionResolution();
    }

    @Override
    public void addPromotion(String s) throws CommerceException {
        this.defaultSession.addPromotion(s);
    }

    @Override
    public void removePromotion(String s) throws CommerceException {
        this.defaultSession.removePromotion(s);
    }

    @Override
    public List<PromotionInfo> getPromotions() throws CommerceException {
        return this.defaultSession.getPromotions();
    }

    @Override
    public String getOrderId() throws CommerceException {
        return this.defaultSession.getOrderId();
    }

    @Override
    public void updateOrderDetails(Map<String, String> stringStringMap) throws CommerceException {
        this.defaultSession.updateOrderDetails(stringStringMap);
    }

    @Override
    public void updateOrder(Map<String, Object> stringObjectMap) throws CommerceException {
        this.defaultSession.updateOrder(stringObjectMap);
    }

    @Override
    public Map<String, String> getOrderDetails() throws CommerceException {
        return this.defaultSession.getOrderDetails();
    }

    @Override
    public Map<String, Object> getOrder() throws CommerceException {
        return this.defaultSession.getOrder();
    }

    @Override
    public void submitOrder(Map<String, String> stringStringMap) throws CommerceException {
        this.defaultSession.submitOrder(stringStringMap);
    }

    @Override
    public void placeOrder(Map<String, Object> stringObjectMap) throws CommerceException {
        this.defaultSession.placeOrder(stringObjectMap);
    }

    @Override
    public PlacedOrderResult getPlacedOrders(String s, int i, int i2, String s2) throws CommerceException {
        return this.defaultSession.getPlacedOrders(s, i, i2, s2);
    }

    @Override
    public PlacedOrder getPlacedOrder(String s) throws CommerceException {
        return this.defaultSession.getPlacedOrder(s);
    }
}
