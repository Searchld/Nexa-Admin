package com.ruoyi.sq.domain;

import java.io.Serializable;

public interface SqTableEntity extends Serializable
{
    Object getPkValue();
    void setPkValue(Object value);
}
