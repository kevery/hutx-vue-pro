package cn.iocoder.yudao.module.yuanshen.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class YuanServiceImpl implements YuanService {


    @Override
    public String qiandao(String token) {

        return "签到成功";
    }
}
