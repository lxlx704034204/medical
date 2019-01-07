package com.bben.samiservice.service;

import com.bben.samiservice.model.samiservice.TSickroom;

import java.util.List;

public interface TSickroomService {

    List<TSickroom> selectByCode(String code);

}
