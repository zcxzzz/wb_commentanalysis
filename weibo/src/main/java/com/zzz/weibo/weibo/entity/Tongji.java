package com.zzz.weibo.weibo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzz
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Tongji implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Double getPinglv() {
        return pinglv;
    }

    public void setPinglv(Double pinglv) {
        this.pinglv = pinglv;
    }

    private String word;

    private Double pinglv;


}
