package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Slf4j
@Api(tags = "用户端-店铺相关接口")
public class ShopController {
    public static final String KEY = "SHOP_STATUS";
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/status")
    @ApiOperation("查询营业状态")
    public Result<Integer> getStatus() {
        log.info("查询营业状态");
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        return Result.success(status == null ? 0 : status);
    }
}
