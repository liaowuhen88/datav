package com.example.demo.controller;

import com.example.demo.bean.DataViewResp;
import com.example.demo.service.StatisticsService;
import com.example.demo.utils.MathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaowuhen on 2018/1/4.
 */
@RestController
public class DataVController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping(value = "index")
    @ResponseBody
    public String index()
    {
        return "hello word datav";
    }


    @RequestMapping(value = "userCount")
    @ResponseBody
    public List<DataViewResp>  userCount()
    {
        Long groupAndPersonal = statisticsService.groupAndPersonalCount();
        Long personnu = statisticsService.selectPersonnu();
        Long automobile = statisticsService.automobile();

        Long total = groupAndPersonal+personnu+automobile;

        logger.info("系统中（团险+个险）人数:[{}] -----系统中无人员信息保单人数:[{}]----车险合同数:[{}]",groupAndPersonal,personnu,automobile);

        return responseToDataView("", total.toString());

    }

   @RequestMapping(value = "enterpriseUserCount")
    @ResponseBody
    public List<DataViewResp> enterpriseUserCount()
    {
        Long enterpriseUserCount = statisticsService.enterpriseUserCount();

        logger.info("系统中企业数:[{}]",enterpriseUserCount);

        return responseToDataView("", enterpriseUserCount.toString());

    }


    @RequestMapping(value = "totalServeMoney")
    @ResponseBody
    public List<DataViewResp> totalServeMoney()
    {
        String personalPremium = statisticsService.personalPremium();
        String groupPremium = statisticsService.groupPremium();
        String automobilePremium = statisticsService.automobilePremium();
        String cardPremium = statisticsService.cardPremium();
        String total = MathUtils.add(personalPremium,groupPremium,automobilePremium,cardPremium);

        logger.info("系统中个单保费:[{}]----团报单费:[{}]---车险保费:[{}]---卡单保费:[{}]",personalPremium,groupPremium,automobilePremium,cardPremium);

        return responseToDataView("", total);

    }

    @RequestMapping(value = "settlementCount")
    @ResponseBody
    public List<DataViewResp> settlementCount()
    {
        Long settlementCount = statisticsService.settlementCount();

        logger.info("系统中微信报案案件数+系统中内部报案案件数:[{}]",settlementCount);
        return responseToDataView("", settlementCount.toString());

    }

    @RequestMapping(value = "personalNum")
    @ResponseBody
    public List<DataViewResp> personalNum()
    {
        Long groupPersonalNum = statisticsService.groupPersonalNum();
        Long personalNum = statisticsService.personalNum();
        Long cardNum = statisticsService.cardNum();
        Long automobile = statisticsService.automobile();
        Long total = groupPersonalNum+personalNum+cardNum+automobile;

        logger.info("系统中团单载明人数合计:[{}]----个单:[{}]---卡单:[{}]----车险合同数:[{}]",groupPersonalNum,personalNum,cardNum,automobile);

        return responseToDataView("", total.toString());
    }


    private List<DataViewResp> responseToDataView(String name, Double value) {
        return responseToDataView(name,MathUtils.getString(value));
    }

    private List<DataViewResp> responseToDataView(String name, String value) {
        List<DataViewResp> resps = new ArrayList<DataViewResp>();
        DataViewResp dataViewResp = new DataViewResp();
        dataViewResp.setName(name);
        dataViewResp.setValue(value);
        resps.add(dataViewResp);
        return resps;
    }
}
