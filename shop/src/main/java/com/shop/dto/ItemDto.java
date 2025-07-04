package com.shop.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ItemDto {
  private Long id;

  private String itemNm;

  private Integer price;

  private String itemDetail;

  private String sellStatCd;

  private LocalDateTime regTime;

  private LocalDateTime updateTime;
}
