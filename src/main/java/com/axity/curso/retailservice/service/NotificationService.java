package com.axity.curso.retailservice.service;

public interface NotificationService {
    void enviarConfirmacionCompraAsync(Long orderId, String cliente);
    void enviarAlertaStockMinimoAsync(String sku, int stockActual);
}