package com.bben.common.entity.form;

import com.bben.common.entity.param.BaseParam;
import io.swagger.annotations.ApiModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

@ApiModel
public class BaseQueryForm<P extends BaseParam> extends BaseForm {
    private final Logger log = LoggerFactory.getLogger(getClass());
    /**
     * Form转化为Param
     *
     * @param clazz
     * @return
     */
    public P toParam(Class<P> clazz) {
        P p = null;
        try {
            p = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Param NewInstance Error");
        }
        BeanUtils.copyProperties(this, p);
        return p;
    }

}
