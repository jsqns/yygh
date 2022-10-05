package com.atguigu.hospital.controller.DTO;

import lombok.Data;

/**
 * @version 1.0
 * @ClassName SaveScheduleDTO
 * @Author q.s.j
 * @Date 2022/10/4 17:30
 * @Decription
 **/
@Data
public class SaveScheduleDTO {
//{"hoscode":"1000_0","depcode":"200040878","title":"医师","docname":"邵迎红","skill":"内分泌科常见病。","workDate":"2020-12-13","workTime":0,
// "reservedNumber":33,"availableNumber":22,"amount":"100","status":1,"hosScheduleId":"1"}
    private String hoscode;
    private String depcode;
    private String title;
    private String docname;
    private String skill;
    private String workDate;
    private String workTime;
    private String reservedNumber;
    private String availableNumber;
    private String amount;
    private String hosScheduleId;
    private Integer status;
}
