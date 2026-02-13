package nl.heartmates01.ArtstyleWebsite.setting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Setting {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String type;

  protected Setting() {
  }

  public Setting(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return String.format(
        "Setting[id=%d, type='%s']",
        id, type);
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

}
