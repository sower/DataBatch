package me.ylem.task;

import javax.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 批处理任务
 *
 * @date 2023/03/04
 **/
@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchJob {

  private JobBuilderFactory jobBuilderFactory;

  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job multiStepJob() {
    return jobBuilderFactory.get("multiStepJob")
        .start(step1())
        .next(step2())
        .build();
  }

  private Step step1() {
    return stepBuilderFactory.get("step1")
        .tasklet((stepContribution, chunkContext) -> {
          System.out.println("=== step one ===");
          return RepeatStatus.FINISHED;
        }).build();
  }

  private Step step2() {
    return stepBuilderFactory.get("step2")
        .tasklet((stepContribution, chunkContext) -> {
          System.out.println("----- step two -----");
          return RepeatStatus.FINISHED;
        }).build();
  }
}
