package nl.heartmates01.ArtstyleWebsite.palette;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Palette {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String paletteName;
  private String color1;
  private String color2;
  private String color3;
  private String color4;
  private String color5;

  protected Palette() {
  }

  public Palette(String paletteName, String color1, String color2, String color3, String color4,
      String color5) {
    this.paletteName = paletteName;
    this.color1 = color1;
    this.color2 = color2;
    this.color3 = color3;
    this.color4 = color4;
    this.color5 = color5;
  }

  @Override
  public String toString() {
    return String.format(
        "Palette[id=%d, paletteName='%s' color1='%s', color2='%s', color3='%s', color4='%s', color5'%s']",
        id, paletteName, color1, color2, color3, color4, color5);
  }

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPaletteName() {
    return paletteName;
  }

  public void setPaletteName(String paletteName) {
    this.paletteName = paletteName;
  }

  public String getColor1() {
    return color1;
  }

  public void setColor1(String color1) {
    this.color1 = color1;
  }

  public String getColor2() {
    return color2;
  }

  public void setColor2(String color2) {
    this.color2 = color2;
  }

  public String getColor3() {
    return color3;
  }

  public void setColor3(String color3) {
    this.color3 = color3;
  }

  public String getColor4() {
    return color4;
  }

  public void setColor4(String color4) {
    this.color4 = color4;
  }

  public String getColor5() {
    return color5;
  }

  public void setColor5(String color5) {
    this.color5 = color5;
  }

  public String getAllColors() {
    return getPaletteName() + getColor1() + getColor2() + getColor3() + getColor4() + getColor5();
  }
}
