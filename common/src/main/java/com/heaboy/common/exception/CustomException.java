package com.heaboy.common.exception;

import com.heaboy.common.common.entity.ResultJson;
import lombok.Getter;


/**
 * @author Wangzhen
 * createAt: 2020/5/29
 */
@Getter
public class CustomException extends RuntimeException{
    private ResultJson resultJson;

    public CustomException(ResultJson resultJson) {
        this.resultJson = resultJson;
    }
}
