package com.budget.budget.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

// Счет пользователя
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "account")
@Entity
public class Account {

    @NotBlank
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;
    @NotNull
    private String accountName;
    private String description;
    @NotNull
    private BigDecimal amountMoney;
    @NotNull
    private String currency;
    @NotNull
    @CreationTimestamp
    private LocalDateTime created;
    @NotNull
    @UpdateTimestamp
    private LocalDateTime changed;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_transaction")
    private List<Transaction> transactionList;
//    TODO привязать транзакции к счетам
    @NotNull
    private LocalDateTime dataTransaction;

}
