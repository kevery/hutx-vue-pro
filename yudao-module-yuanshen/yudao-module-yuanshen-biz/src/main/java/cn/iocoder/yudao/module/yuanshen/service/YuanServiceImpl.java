package cn.iocoder.yudao.module.yuanshen.service;

import cn.hutool.crypto.asymmetric.Sign;
import cn.iocoder.yudao.module.yuanshen.service.gensin.GenShinSignMiHoYo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class YuanServiceImpl implements YuanService {




    Sign sign;

    @Override
    public String qiandao(String token) {
        String type = "2";
        String version = "2.28.1";
        String salt = "dWCcD2FsOUXEstC5f9xubswZxEeoBOTc";

        String cookies = "_MHYUUID=d121b06e-c5c6-4dc3-817a-4ffcfdf3be40; UM_distinctid=185a62607f5601-09eee16846d95e-26021051-1bcab9-185a62607f61217; DEVICEFP_SEED_ID=100f650025ffd83b; DEVICEFP_SEED_TIME=1673857482819; DEVICEFP=38d7ecd894ac6; mi18nLang=zh-cn; ltuid=305560629; _ga_CXN1FSHKS4=GS1.1.1675219306.1.0.1675219312.0.0.0; _ga_S2V1JGS2Q4=GS1.1.1675219284.4.1.1675219412.0.0.0; account_mid_v2=0uv3b6lw9b_mhy; account_id_v2=305560629; ltmid_v2=0uv3b6lw9b_mhy; ltuid_v2=305560629; cookie_token=14tOGgxf6mVAQB39ejOtM6XYFuaM4bVyxCyFiDwW; account_id=305560629; _ga_X7QVFGT6ZC=GS1.1.1675730351.1.1.1675731587.0.0.0; stoken=mWVMbFKCzWaZdZ2JSJQtRXiSVeR1IvZ51sC3Pvrg; stuid=305560629; _ga_9TTX3TE5YL=GS1.1.1676853216.8.0.1676853216.0.0.0; _ga_KJ6J9V9VZQ=GS1.1.1676871305.2.1.1676871820.0.0.0; _ga=GA1.2.199385534.1673857484; _gid=GA1.2.1392795029.1676941746; login_uid=305560629; login_ticket=UQbzsJBixx3VunZjptikAXnWg7p6zaFRnq9gSuHb";
        String uid = "305560629";


       GenShinSignMiHoYo  genshin = new GenShinSignMiHoYo(cookies, uid, type, version, salt);

        Object sign1 = genshin.sign();
//
//
////        cookies, signIn.getUid(), type, version, salt
//
//
        return "1";
    }
}
