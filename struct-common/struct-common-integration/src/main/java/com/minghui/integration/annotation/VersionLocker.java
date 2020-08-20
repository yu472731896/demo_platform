package com.ropeok.integration.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:chenql
 * @Description:控制乐观锁
 * @Date:Created in 10:51 2018/5/8
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface VersionLocker {

    /**
     * @Author:chenql
     * @Description:插件默认对所有的update进行拦截生效，如果不希望有乐观锁控制，在方法上面加上@VersionLocker(false)
     * @Date: 10:52 2018/5/8
     */
    boolean value() default true;
}
