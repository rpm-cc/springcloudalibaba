package com.example.security.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author rpmcc
 * @version 1.0
 * @date 2019/2/26
 * @description 项目中没有二次加密
 */
public class DefaultPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        if (charSequence ==null){
            return  false ;
        }
        if (StringUtils.isEmpty(s)){
            return false;
        }

        return StringUtils.equals(charSequence.toString(),s);
    }
}
