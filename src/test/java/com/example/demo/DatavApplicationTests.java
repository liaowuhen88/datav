package com.example.demo;

import com.example.demo.service.StatisticsService;
import com.example.demo.utils.MathUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatavApplicationTests {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StatisticsService statisticsService;

	/**
	 * 系统中用户数
	 */
	@Test
	public void contextLoads() {

		Long groupAndPersonal = statisticsService.groupAndPersonalCount();
		Long personnu = statisticsService.selectPersonnu();
		Long automobile = statisticsService.automobile();

		logger.info("系统中（团险+个险）人数:[{}] -----系统中无人员信息保单人数:[{}]----车险合同数:[{}]",groupAndPersonal,personnu,automobile);

	}


	/**
	 * 系统中企业数
	 */
	@Test
	public void enterpriseUserCount() {

		Long enterpriseUserCount = statisticsService.enterpriseUserCount();

		logger.info("系统中企业数:[{}]",enterpriseUserCount);

	}

	/**
	 * 累计服务金额
	 */
	@Test
	public void totalServeMoney() {

		String personalPremium = statisticsService.personalPremium();
		String groupPremium = statisticsService.groupPremium();
		String automobilePremium = statisticsService.automobilePremium();
		String cardPremium = statisticsService.cardPremium();
		String total = MathUtils.add(personalPremium,groupPremium,automobilePremium,cardPremium);

		logger.info("系统中个单保费:[{}]----团报单费:[{}]---车险保费:[{}]---卡单保费:[{}]",personalPremium,groupPremium,automobilePremium,cardPremium);
        logger.info(total);
	}


	/**
	 * 理赔受理件数
	 * 系统中微信报案案件数+系统中内部报案案件数
	 */
	@Test
	public void settlementCount() {

		Long settlementCount = statisticsService.settlementCount();

		logger.info("系统中微信报案案件数+系统中内部报案案件数:[{}]",settlementCount);

	}

	/**
	 * 系统中投保人次
	 */
	@Test
	public void personalNum() {

		Long groupPersonalNum = statisticsService.groupPersonalNum();
		Long personalNum = statisticsService.personalNum();
		Long cardNum = statisticsService.cardNum();
		Long automobile = statisticsService.automobile();

		logger.info("系统中团单载明人数合计:[{}]----个单:[{}]---卡单:[{}]----车险合同数:[{}]",groupPersonalNum,personalNum,cardNum,automobile);

	}

}
