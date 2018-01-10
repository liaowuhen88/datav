package com.example.demo.service;

/**
 * Created by liaowuhen on 2018/1/4.
 */
public interface StatisticsService {

    /**
     * (团险+个险）人数
     * Group insurance
     * Personal insurance
     */
    Long groupAndPersonalCount();

    /**
     * 系统中无人员信息保单人数（例如建工险）
     */
    Long selectPersonnu();

    /**
     * 车险合同用户
     */
    Long automobileUser();

    /**
     * 车险合同用户
     */
    Long automobileInsure();

    /**
     * 系统中企业用户数量
     */
    Long enterpriseUserCount();

    /**
     * 系统中个单保费
     */
    String personalPremium();

    /**
     * 系统中团单保费
     */
    String groupPremium();

    /**
     * 车险保费
     */
    String automobilePremium();

    /**
     * 卡单保费
     */
    String cardPremium();

    /**
     * 理赔受理件数=系统中微信报案案件数+系统中内部报案案件数
     */
    Long settlementCount();

    /**
     * 系统中团单载明人数合计
     */

    Long groupPersonalNum();

    /**
     * 系统中个单数
     */

    Long personalNum();

    /**
     * 系统中卡单数
     */

    Long cardNum();
}
