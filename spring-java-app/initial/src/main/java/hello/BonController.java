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
import java.util.ArrayList;


@RestController
public class BonController {
  private List<Bon> bonuri = new ArrayList<Bon>();

  BonController() {
    Bon b1 = new Bon(10, 1500,"10:00");
    Bon b2 = new Bon(11, 100,"16:00");
    Bon b3 = new Bon(12, 400,"18:00");

    bonuri.add(b1);
    bonuri.add(b2);
    bonuri.add(b3);
  }

  @RequestMapping(value="/bon", method = RequestMethod.GET)
  public List<Bon> index() {
    return this.bonuri;
  }

  @RequestMapping(value="/bon/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Bon b : this.bonuri) {
      if(b.getId() == id) {
        return new ResponseEntity<Bon>(b, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/bon/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Bon b : this.bonuri) {
      if(b.getId() == id) {
        this.bonuri.remove(b);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


@RequestMapping(value="/bon/{id}/{total}/{ora}", method = RequestMethod.POST)
  public ResponseEntity create(@PathVariable("id") int id , @PathVariable("total") int total, @PathVariable("ora") String ora) {

    Bon b = new Bon(id,total,ora);
      bonuri.add(b);
      return new ResponseEntity<Bon>(b, new HttpHeaders(), HttpStatus.OK);
      }

@RequestMapping(value="/bon/{id}/{ora}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("id") int id  , @PathVariable("ora") String ora) {
    for(Bon b : this.bonuri) {
      if(b.getId() == id) {
        b.setOra(ora);
        return new ResponseEntity<Bon>(b, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}
    