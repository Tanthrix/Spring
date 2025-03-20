package com.university.uch_university.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.*;

@Entity
public class Payments implements BaseModel {

    @Id
    @GeneratedValue
    UUID id;

    @NotBlank
    String title;

    Double amount;

    @NotBlank
    String date;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @Enumerated(EnumType.STRING)
    PaymentStatus status;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne
    Consuption consuption;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToOne
    PaymentsMethod paymentsMethod;

    @Override
    public ArrayList<String> getColumns() {
        return new ArrayList<>(Arrays.asList("Идентификатор", "Название", "Сумма платежа", "Дата платежа", "Статус", "Метод оплаты"));
    }

    enum PaymentStatus {
        IN_PROGRESS, APPROVED, REJECTED
    }
    @Override
    public LinkedHashMap<String, Object> getNewObject() {
        return new LinkedHashMap<>(){{
           put("title", Map.of("type", "text", "value", ""));
           put("amount", Map.of("type", "double", "value", 0.0));
           put("date", Map.of("type", "date", "value", ""));
           put("status", Map.of("type", "select", "value", List.of(PaymentStatus.values())));
           put("paymentsMethod", Map.of("type", "select-list", "value", new ArrayList<PaymentsMethod>()));
        }};
    }

    @Override
    public ArrayList<Object> getDataAttributes() {
        return new ArrayList<>(Arrays.asList(title, amount, date, status, paymentsMethod));
    }

    @Override
    public String getStr() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }


    public Payments() {
    }

    public Payments(UUID id, String title, Double amount, String date, PaymentStatus status, Consuption consuption, PaymentsMethod paymentsMethod) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.consuption = consuption;
        this.paymentsMethod = paymentsMethod;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Consuption getConsuption() {
        return consuption;
    }

    public void setConsuption(Consuption consuption) {
        this.consuption = consuption;
    }

    public PaymentsMethod getPaymentsMethod() {
        return paymentsMethod;
    }

    public void setPaymentsMethod(PaymentsMethod paymentsMethod) {
        this.paymentsMethod = paymentsMethod;
    }
}
