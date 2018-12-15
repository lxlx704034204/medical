package com.bben.common.entity.form;

import com.bben.common.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

@ApiModel
//@Slf4j
@Data
public class BaseForm<T extends BasePo> {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private String username;

    /**
     * From转化为Po，进行后续业务处理
     *
     * @param clazz
     * @return
     */
    public T toPo(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Po NewInstance Error");
        }
        BeanUtils.copyProperties(this, t);
        return t;
    }
}
