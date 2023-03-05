package me.ylem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;
import me.ylem.base.BaseEntity;

/**
 * website实体
 *
 * @date 2022/09/26
 */
@Data
@Entity
@Table(name = "website")
public class WebSite extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  private String name;

  private String url;

  @Lob
  private String description;
}
