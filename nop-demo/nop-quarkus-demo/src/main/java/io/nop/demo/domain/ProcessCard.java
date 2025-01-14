package io.nop.demo.domain;

public class ProcessCard {
    private int flowMode = 1;
    private int quantity = 3;

    private ProductionOrder productionOrder;

    private String materialId;

    public int getFlowMode() {
        return flowMode;
    }

    public void setFlowMode(int flowMode) {
        this.flowMode = flowMode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductionOrder getProductionOrder() {
        return productionOrder;
    }

    public void setProductionOrder(ProductionOrder productionOrder) {
        this.productionOrder = productionOrder;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }
}

