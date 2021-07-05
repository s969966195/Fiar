package org.sy.fiar.pub.constants;

/**
 * @Description 用户常量
 * @Author sy
 * @Date 2021/7/4 20:02
 * @Version 1.0
 */
public interface UserConstant {

    /**
     * 注册结果
     */
    public static class RegisterResult {

        public static final int SUCCESS = 0;

        public static final int DUPLICATE_USERNAME = 1;

        public static final int FAILED = 2;

    }

}
