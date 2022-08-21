package org.sy.fiar.pub.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解
 *
 * @author SY
 * @since 2022/8/21 22:33
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLogSys {
    /** 日志描述 */
    String desc() default "";

    /** 日志操作类型 */
    OperationType operationType() default OperationType.SYSTEM;
}
