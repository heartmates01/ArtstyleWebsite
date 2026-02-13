package nl.heartmates01.ArtstyleWebsite.artstyle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artstyle {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String style;

  protected Artstyle() {

  }

  public Artstyle(String style) {
    this.style = style;
  }

  @Override
  public String toString() {
    return String.format(
        "Artstyle[id=%d], style='%s']",
        id, style);
  }

  public long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }
}
