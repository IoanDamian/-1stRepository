package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class ClientController {
  private List<Client> clienti = new ArrayList<Client>();

  ClientController() {
    Client c1 = new Client(100, "John","Traian");
    Client c2 = new Client(101, "Steve","Caraman");
    Client c3 = new Client(102, "Larry","Gheorghe");

    clienti.add(c1);
    clienti.add(c2);
    clienti.add(c3);
  }

  @RequestMapping(value="/client", method = RequestMethod.GET)
  public List<Client> index() {
    return this.clienti;
  }

  @RequestMapping(value="/client/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Client c : this.clienti) {
      if(c.getId() == id) {
        return new ResponseEntity<Client>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/client/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Client c : this.clienti) {
      if(c.getId() == id) {
        this.clienti.remove(c);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


@RequestMapping(value="/client", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Client c) {

      clienti.add(c);
      return new ResponseEntity<Client>(c, new HttpHeaders(), HttpStatus.OK);
      }

@RequestMapping(value="/client/{id}/{firstName}/{lastName}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("id") int id  , @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName ) {
    for(Client c : this.clienti) {
      if(c.getId() == id) {
        c.setFirstName(firstName);
        c.setLastName(lastName);
        return new ResponseEntity<Client>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
    