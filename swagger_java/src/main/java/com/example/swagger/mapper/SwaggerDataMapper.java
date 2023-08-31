package com.example.swagger.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.swagger.entity.SwaggerData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SwaggerDataMapper extends BaseMapper<SwaggerData> {
    @Select("SELECT server_url, api_url, method, tag, summary, input_param, input_param_dec, output_param, create_time, update_time FROM swagger_data WHERE id = #{id}")
    SwaggerData findInputOutputParamsById(Long id);
}
