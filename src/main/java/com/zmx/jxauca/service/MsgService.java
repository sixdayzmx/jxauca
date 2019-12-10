package com.zmx.jxauca.service;

import com.zmx.jxauca.entity.Msg;

import java.util.List;

public interface MsgService {
    public List<Msg> showAll();
    public int addComment(Msg msg);
    public List<Msg> showAllR();
}
