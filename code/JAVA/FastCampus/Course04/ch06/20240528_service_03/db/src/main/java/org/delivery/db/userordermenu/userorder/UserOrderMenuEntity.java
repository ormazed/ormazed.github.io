package org.delivery.db.userordermenu.userorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;
import org.delivery.db.userordermenu.userorder.enums.UserOrderMenuStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "user_order_menu")
public class UserOrderMenuEntity extends BaseEntity {

    @Column(nullable = false)
    private Long userOrderId;  // 1: n

    @Column(nullable = false)
    private Long storeMenuId; // 1: n

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length=50)
    private UserOrderMenuStatus status;

}
