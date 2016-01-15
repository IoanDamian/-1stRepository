package hello;

import java.util.List;
import java.util.ArrayList;

public class Bon {
  
  private int id, total;
  private String ora;
  

  public Bon() {}

  public Bon(int id, int total, String ora) {
      this.total = total;
      this.ora = ora;
      this.id = id;
  }

  public String getOra() {
      return  this.ora;
  }

  public int getTotal() {
      return  this.total;
  }

  public int getId() {
    return this.id;
  }

  public void setOra(String ora) {
    this.ora = ora;
  }

  public void setTotal(int total) {
    this.total = total;
  }
}