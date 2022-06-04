package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("table_user")
public class Account implements Serializable {

    private Integer id;
    private String name;
    private Double money;

}
