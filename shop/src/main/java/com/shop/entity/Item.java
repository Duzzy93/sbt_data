package com.shop.entity;

import com.shop.common.entity.BaseEntity;
import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item extends BaseEntity {

  @Id
  @Column(name = "item_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String itemNm;

  @Column(nullable = false)
  private int price;

  @Column(nullable = false)
  private int stockNumber;

  @Lob
  @Column(nullable = false)
  private String itemDetail;

  @Enumerated(EnumType.STRING)
  private ItemSellStatus itemSellStatus;

  public void updateItem(ItemFormDto itemFormDto) {
    this.itemNm = itemFormDto.getItemNm();
    this.price = itemFormDto.getPrice();
    this.stockNumber = itemFormDto.getStockNumber();
    this.itemDetail = itemFormDto.getItemDetail();
    this.itemSellStatus = itemFormDto.getItemSellStatus();
  }

}
