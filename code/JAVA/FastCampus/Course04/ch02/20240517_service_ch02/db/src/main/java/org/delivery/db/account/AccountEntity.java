package org.delivery.db.account;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="account")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Builder
public class AccountEntity extends BaseEntity {
}
