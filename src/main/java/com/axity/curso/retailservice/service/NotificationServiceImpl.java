package com.axity.curso.retailservice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Async
    @Override
    public void enviarConfirmacionCompraAsync(Long orderId, String cliente) {
        try {
            // Simulación de latencia de red de envío de email (2 segundos)
            Thread.sleep(2000);
            System.out.println("[PROCESO ASÍNCRONO] Email de confirmación enviado exitosamente para el Pedido #" 
                    + orderId + " al cliente: " + cliente);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Async
    @Override
    public void enviarAlertaStockMinimoAsync(String sku, int stockActual) {
        try {
            Thread.sleep(1000);
            System.out.println("[ALERTA DE ALMACÉN - ASÍNCRONO] El producto SKU: " 
                    + sku + " ha alcanzado nivel crítico de stock (" + stockActual + " unidades). Se solicita reabastecimiento.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}