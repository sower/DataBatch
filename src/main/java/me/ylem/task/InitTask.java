package me.ylem.task;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ylem.repository.WebSiteDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * 初始化任务
 *
 * @date 2023/02/27
 */
@Slf4j
@Component
@AllArgsConstructor
public class InitTask implements CommandLineRunner {

  private WebSiteDao webSiteDao;

  @Override
  public void run(String... args) {
    log.info("=== Init task done ===");
    ClassPathResource yml = new ClassPathResource("application.yml");
    log.info("Config yml at {}", yml.getPath());
    log.info("Current websites : {}", webSiteDao.findAll());
  }

}
