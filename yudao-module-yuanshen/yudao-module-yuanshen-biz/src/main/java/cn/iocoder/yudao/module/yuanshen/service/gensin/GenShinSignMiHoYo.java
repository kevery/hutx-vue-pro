package cn.iocoder.yudao.module.yuanshen.service.gensin;


import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.iocoder.yudao.module.yuanshen.util.gensin.MiHoYoConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 原神签到实现类
 * <p>
 * &#064;Author  Light rain
 * &#064;Date  2022/5/20 2:34
 */
public class GenShinSignMiHoYo extends MiHoYoAbstractSign {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GenShinSignMiHoYo.class);
    //</editor-fold>

    public GenShinSignMiHoYo(String cookie, String uid, String type, String version, String salt) {
        //将cookie/uid赋值给父类
        super(cookie, uid);
        //设置类型
        setClientType(type);
        //设置版本号
        setAppVersion(version);
        //设置校验码
        setSalt(salt);
        //设置服务器id
        setRegion(getRegion());
    }


    /**
     * 获取原神服务器id 官服：cn_gf01天空岛/B服：cn_qd01世界树
     *
     * @return String
     */
    public String getRegion() {
        Map<String, String> basicHeaders = getBasicHeaders();
        try {
            String body = HttpRequest
                    .get(MiHoYoConfig.ROLE_URL)
                    .addHeaders(basicHeaders)
                    .execute().body();

            String s = JSONUtil.parseObj(body).getJSONObject("data").getJSONArray("list").getByPath("[0].region").toString();
            return s;

//            return (String) result.getJSONObject("data").getJSONArray("list").getJSONObject(0).get("region");
        } catch (NullPointerException e) {
            log.warn("获取当前原神用户服务器ID失败！");
            return "";
        }
    }

    /**
     * 米游社原神福利签到
     *
     * @return message
     */
    public Object sign() {
        Map<String, Object> data = new HashMap<>();
        data.put("act_id", MiHoYoConfig.ACT_ID);
        data.put("region", this.region);
        data.put("uid", this.uid);
        Map<String, String> headers = getHeaders();
        String body = HttpRequest
                .post(MiHoYoConfig.SIGN_URL)
                .addHeaders(headers)
                .form(data)
                .execute().body();
        JSONObject signResult = JSONUtil.parseObj(body);

        if (signResult.getInt("retcode") == 0){
            log.info("原神签到福利成功：{}", signResult.get("message"));
        }
        else log.info("原神签到福利签到失败：{}", signResult.get("message"));
        return signResult.get("message");
    }


}

