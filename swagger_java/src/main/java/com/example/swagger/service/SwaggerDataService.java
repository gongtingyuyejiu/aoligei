package com.example.swagger.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.swagger.entity.SwaggerData;

import java.util.List;

public interface SwaggerDataService extends IService<SwaggerData> {
    @Autowired

    List<SwaggerData> analyze();
    SwaggerData getInputOutputParamsById(Long id);

}
