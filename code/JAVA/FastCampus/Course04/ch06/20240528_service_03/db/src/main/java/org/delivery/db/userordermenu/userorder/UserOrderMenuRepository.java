package org.delivery.db.userordermenu.userorder;

import org.delivery.db.userordermenu.userorder.enums.UserOrderMenuStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOrderMenuRepository extends JpaRepository<UserOrderMenuEntity, Long> {
    //select * from user_order_menu where user_order_id = ? and status = ?
    List<UserOrderMenuEntity> findAllByUserOrderIdAndStatus(Long userOrderId, UserOrderMenuStatus status);

}

// select * from user_order where user_id = 1; // user1 이 주문을 수행
// select * from user_order_menu where user_order_id = 1; // user1 이 주문한 주문 목록
// select * from store_menu where id in (1,2); // user1 번이 주문한 목록의 구체적 내용
/*
select
u.name,
sm.name,
uo.amount
from user as u
join user_order as uo on u.id = uo.user_id
join user_order_menu as uom on uom.user_order_id = uo.id
join store_menu as sm on sm.id = uom.store_menu_id
where u.id=1
* */