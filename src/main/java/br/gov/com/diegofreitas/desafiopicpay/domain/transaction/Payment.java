package br.gov.com.diegofreitas.desafiopicpay.domain.transaction;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PAYMENTS")
public class Payment implements Serializable {

    @Id
    private Long transactionID;

    @Column
    private Double value;

}
