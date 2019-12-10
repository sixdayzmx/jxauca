package com.zmx.jxauca.entity;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@Data
public class Msg {
    private int rid;
    private int rtid;
    private int rrid;
    private String rownername;
    private String rtargetname;
    private String rcomments;
    private Timestamp rtime;
}
