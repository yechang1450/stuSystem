package com.heaboy.common.common.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BaseEntity implements Serializable {
    private long id;
}
