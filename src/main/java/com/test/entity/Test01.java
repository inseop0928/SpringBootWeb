package com.test.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@Entity(name = "TB_TEST01")
public class Test01 extends BaseTimeEntity{

    @Id
    @SequenceGenerator(name = "SEQ_TEST", sequenceName = "SEQ_TEST", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_TEST")
    public int seq;

    public String title;
    public String content;
    //public Date regDt;

    @Builder
    public Test01(String title,String content){
        this.title = title;
        this.content = content;
    }

}
