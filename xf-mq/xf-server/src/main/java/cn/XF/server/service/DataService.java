package cn.XF.server.service;

import cn.XF.server.dto.request.CollectDataRequest;
import cn.XF.server.entity.Engistates;

import java.util.List;

/**
 * <p>数据处理的服务接口</p>
 *
 * @author cz
 **/
public interface DataService {

    /**
     * 原始消防数据拆解
     *
     * @param dataRequest 待分析的数据
     * @return 分析后的信息数组
     */
    List<Engistates> analyseData(CollectDataRequest dataRequest);
}
