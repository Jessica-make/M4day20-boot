package com.spoto.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobTask {
    /**
     * 每6秒执行一次
     */
   @Scheduled(cron = "*/6 * * * * ?")
   public void jobOne(){

//    System.out.println("=========");
   }

}
