package com.rescue.demo.controller.response;

import com.rescue.demo.model.enums.GunSizeEnum;
import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostGunResponse {
    private Integer id;
    private String name;
    private String weight;
    private String caliber;
    private GunSizeEnum gunSize;
    private boolean automatic;
    private LocalDateTime createdAt;
}