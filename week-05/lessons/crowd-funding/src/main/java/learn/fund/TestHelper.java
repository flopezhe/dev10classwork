package learn.fund;

import learn.fund.models.Campaign;


import java.math.BigDecimal;
import java.time.LocalDate;

public class TestHelper {

    public static Campaign makeCampaign(int campaignId){
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.plusDays(-30);
        LocalDate endDate = now.plusDays(30);

        if (campaignId == 1){
            startDate = now.plusDays(-60);
            endDate = now.plusDays(-30);
        }

        return new Campaign(
                campaignId,
                String.format("Campaign #%s", campaignId),
                String.format("Description #%s", campaignId),
                startDate,
                endDate,
                new BigDecimal("30000.00")
        );
    }
}
