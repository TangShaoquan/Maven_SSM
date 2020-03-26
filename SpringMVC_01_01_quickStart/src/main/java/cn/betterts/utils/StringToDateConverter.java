package cn.betterts.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {


    /** 
    * @Description: 自定义类型转换器，需要在springmvx.xml里配置
    * @Param: [source]
    * @return: 
    * @Author: 唐绍权 
    * @Date: 10:48.2020/3/22
    */

    @Override
    public Date convert(String source){
        if (source == null) {
            throw new RuntimeException("请传入数据");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
