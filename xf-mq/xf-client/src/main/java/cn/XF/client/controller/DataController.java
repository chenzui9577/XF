package cn.XF.client.controller;

import cn.XF.client.dto.request.CollectDataRequest;
import cn.XF.client.service.AmqpSendService;
import cn.XF.common.controller.BaseController;
import cn.XF.common.protocol.Result;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

import static cn.XF.client.constant.MqConstant.COLLECT_DATA_EXCHANGE;

/**
 * <p>信息采集数据接口</p>
 * 接口必须指定路径：/CollectorManage/interface/batchAddData
 *
 * @author cz
 **/
@Validated
@RestController
@Api(tags = "信息采集数据接口")
@RequestMapping(value = "/interface")
public class DataController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Resource
    private AmqpSendService amqpSendService;

    @ApiOperation(value = "采集器任务及心跳接口", notes = "用于采集器的心跳验证", httpMethod = "POST")
    @RequestMapping(value = "/getaction", method = RequestMethod.POST)
    public String heartbeat(
            @ApiParam(value = "设备串号") @RequestParam(value = "code", required = false) String code,
            @ApiParam(value = "固件版本") @RequestParam(value = "ver", required = false) String ver,
            @ApiParam(value = "轮询时间（最大255）") @RequestParam(value = "csm", required = false) String csm,
            @ApiParam(value = "数据卡imsi号") @RequestParam(value = "imsi", required = false) String imsi,
            @ApiParam(value = "接口位置（无需关注）") @RequestParam(value = "nipaddr", required = false) String nipaddr,
            @ApiParam(value = "硬件版本") @RequestParam(value = "hardVar", required = false) String hardVar,
            @ApiParam(value = "硬件日期") @RequestParam(value = "hardDate", required = false) String hardDate,
            @ApiParam(value = "boot版本") @RequestParam(value = "bootVar", required = false) String bootVar,
            @ApiParam(value = "通信状态 1 正常 0故障") @RequestParam(value = "state", required = false) String state
    ) {
        logger.info("心跳数据--" +
                "设备串号：" + code +
                "固件版本：" + ver +
                "轮询时间：" + csm +
                "数据卡imsi号：" + imsi +
                "接口位置：" + nipaddr +
                "硬件版本：" + hardVar +
                "硬件日期：" + hardDate +
                "boot版本：" + bootVar +
                "通信状态（1-正常,0-故障）：" + state
        );
        return "@0#";
    }


    @ApiOperation(value = "批量数据信息采集", notes = "用于消防数据的采集器信息上传", httpMethod = "POST")
    @RequestMapping(value = "/batchAddData", method = RequestMethod.POST)
    public Result collectData(
            @ApiParam(value = "设备串号", required = true) @NotBlank(message = "设备串号不允许为空!") @RequestParam(value = "sn") String sn,
            @ApiParam(value = "采集数据", required = true) @NotBlank(message = "采集数据不允许为空!") @RequestParam(value = "data") String data
    ) {
        CollectDataRequest dataRequest = new CollectDataRequest();
        dataRequest.setSn(sn);
        dataRequest.setData(data);
        dataRequest.setCreatTime(System.currentTimeMillis());
        logger.info("消防数据信息采集记录：{}", JSON.toJSONString(dataRequest));
        amqpSendService.convertAndSend(COLLECT_DATA_EXCHANGE, "", JSONUtil.toJsonStr(dataRequest));
        return this.success();
    }
}


