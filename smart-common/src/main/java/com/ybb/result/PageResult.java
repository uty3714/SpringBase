package com.ybb.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    private long total; //总记录数

    private List<T> records; //当前页数据集合
}
