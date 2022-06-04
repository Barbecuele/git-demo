package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class Account {

    private Integer id;
    private String name;
    private Double money;
}
