package hello;

import java.util.List;
import java.util.ArrayList;

public class Client {
  private String firstName;
  private String lastName;
  private int id;
  

  public Client() {}

  public Client(int id, String lastName,String firstName) {
      this.lastName = lastName;
      this.firstName = firstName;
      this.id = id;
  }

  public String getFirstName() {
      
      return this.firstName ;
  }

  public String getLastName() {
      
      return this.lastName ;
  }

  public int getId() {
    return this.id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}