package cn.iocoder.yudao.module.yuanshen.util.gensin;


import java.util.Map;

/**
 * &#064;Author  Light rain
 * &#064;Date  2022/5/20 12:08
 */
public interface Sign {
    //签到
    Object sign();

    //请求头
    Map<String,String> getHeaders();
}
