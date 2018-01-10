package com.example.demo.service.impl;

import com.example.demo.service.StatisticsService;
import com.example.demo.utils.MathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by liaowuhen on 2018/1/4.
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    String groupAndPersonalCount = " select count(*) from personaluseraccount ";
    String selectPersonnu = "SELECT " +
            "        sum(ect.personnum) AS personnu " +
            "        FROM " +
            "        enterprisecontract ect " +
            "        INNER JOIN enterpriseuser enu ON ect.enterpriseid = enu.id " +
            "        WHERE " +
            "        ect.businessType IN (2, 8, 9, 10, 11, 12, 13, 14, 15, 16);";

    String groupPremium = "SELECT sum(p.money) from enterprisecontract p ;";


    String groupPersonalNum = " SELECT sum(p.mianpnum) from enterprisecontract p ;";

    String cardPremium = "SELECT sum(kc_money) from ku_card_user;";

    String cardNum = "SELECT count(1) from ku_card_user;";

    String personalPremium = "SELECT " +
            " sum(w.insuranceFee) " +
            "FROM " +
            " ( " +
            "  SELECT " +
            "   plref.insuranceFee " +
            "  FROM " +
            "   p_contract pc " +
            "  INNER JOIN p_insurancepolicy pp ON pp.pcontractId = pc.id " +
            "  INNER JOIN p_insurancemessage pm ON pm.pInsurancePolicyId = pp.id " +
            "  INNER JOIN ( " +
            "   SELECT " +
            "    pl.pInsurancePolicyId, " +
            "    pl.id AS planid, " +
            "    CASE " +
            "   WHEN pd.principalRisk = 1 THEN " +
            "    pd.productName " +
            "   END AS principalRiskProduct, " +
            "   SUM(IFNULL(pppref.fee, 0)) AS insuranceFee " +
            "  FROM " +
            "   p_insuranceplan pl " +
            "  INNER JOIN p_product_plan_ref pppref ON pppref.planId = pl.id " +
            "  INNER JOIN p_product pd ON pd.id = pppref.productId " +
            "  GROUP BY " +
            "   pl.pInsurancePolicyId " +
            "  ) plref ON plref.pInsurancePolicyId = pp.id " +
            "  GROUP BY " +
            "   pc.id " +
            " ) w";

    String personalNum = "SELECT " +
            " count(1) " +
            "FROM " +
            " ( " +
            "  SELECT " +
            "   pc.id " +
            "  FROM " +
            "   p_contract pc " +
            "  INNER JOIN p_insurancepolicy pp ON pp.pcontractId = pc.id " +
            "  INNER JOIN p_insurancemessage pm ON pm.pInsurancePolicyId = pp.id " +
            "  GROUP BY " +
            "   pc.id " +
            " ) w";

    String settlementCount = "SELECT count(1) from userclaimsapply u";

    //投保
    String automobileInsure = " select count(id) from broker_data ";

    // 用户
    String automobileUser = " select count(id) from broker_data where import_type = '01-天道'";


    String automobilePremium = "select sum(premium) from broker_data";

    String enterpriseUserCount = "SELECT count(1) from enterpriseuser e where e.`name` is not null and e.id != 33;";

    @Override
    public Long groupAndPersonalCount() {
        Long lo = jdbcTemplate.queryForObject(groupAndPersonalCount, Long.class);
        return null == lo ? 0 : lo;
    }

    @Override
    public Long selectPersonnu() {
        Long lo = jdbcTemplate.queryForObject(selectPersonnu, Long.class);
        return null == lo ? 0 : lo;
    }

    @Override
    public Long automobileUser() {
        Long lo = jdbcTemplate.queryForObject(automobileUser, Long.class);
        return null == lo ? 0 : lo;
    }

    @Override
    public Long automobileInsure() {
        Long lo = jdbcTemplate.queryForObject(automobileInsure, Long.class);
        return null == lo ? 0 : lo;
    }

    @Override
    public Long enterpriseUserCount() {
        Long lo = jdbcTemplate.queryForObject(enterpriseUserCount, Long.class);
        return null == lo ? 0 : lo;
    }

    @Override
    public String personalPremium() {
        String lo = jdbcTemplate.queryForObject(personalPremium, String.class);
        return lo;
    }

    @Override
    public String groupPremium() {
        String lo = jdbcTemplate.queryForObject(groupPremium, String.class);
        return lo;
    }

    @Override
    public String automobilePremium() {
        String auto = jdbcTemplate.queryForObject(automobilePremium, String.class);
        return MathUtils.getDivide(auto);
    }

    @Override
    public String cardPremium() {
        String lo = jdbcTemplate.queryForObject(cardPremium, String.class);
        return lo;
    }

    @Override
    public Long settlementCount() {
        Long lo = jdbcTemplate.queryForObject(settlementCount, Long.class);
        return null == lo ? 0 : lo;
    }

    @Override
    public Long groupPersonalNum() {
        Long lo = jdbcTemplate.queryForObject(groupPersonalNum, Long.class);
        return null == lo ? 0 : lo;
    }

    @Override
    public Long personalNum() {
        Long lo = jdbcTemplate.queryForObject(personalNum, Long.class);
        return null == lo ? 0 : lo;
    }

    @Override
    public Long cardNum() {
        Long lo = jdbcTemplate.queryForObject(cardNum, Long.class);
        return null == lo ? 0 : lo;
    }
}
