package edu.wctc.wholesale.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Order {
    //customerName
    private String customerName;

    //purchaseDate
    private LocalDate purchaseDate;

    //purchaseOrderNumber
    private String purchaseOrderNumber;

    //productName
    private String productName;

    //terms
    private String terms;

    //shippedDate
    private LocalDate shippedDate;

    //productCost
    private Double productCost;
}
