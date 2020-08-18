package com.test.vo;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
public class Test01VO {
    public int seq;
    public String title;
    public String content;
    public Date regDt;
}
