package com.example.spring_boot_rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public enum OrderStatus {
    placed,
    approved,
    delivered;
}
