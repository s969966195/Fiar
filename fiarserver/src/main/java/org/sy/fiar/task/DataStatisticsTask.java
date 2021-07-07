package org.sy.fiar.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.sy.fiar.service.ArticleService;

/**
 * 数据统计定时任务
 *
 * @author SY
 * @since 2021/7/7 23:30
 */
@Component
public class DataStatisticsTask {

    @Autowired
    ArticleService articleService;

    //每天执行一次，统计PV
    @Scheduled(cron = "1 0 0 * * ?")
    public void pvStatisticsPerDay() {
        articleService.pvStatisticsPerDay();
    }

}
