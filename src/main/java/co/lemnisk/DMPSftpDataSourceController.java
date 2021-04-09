package co.lemnisk;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DMPSftpDataSourceController {
  
  @Autowired
  private DMPSftpDataSourceService service;
  
  @GetMapping("/datasource")
  public List<DMPSftpDataSource> list(){
    return service.listAll();
  }
  
  @GetMapping("/datasource/{Id}")
  public ResponseEntity<DMPSftpDataSource> get(@PathVariable Integer Id) {
    try {
      DMPSftpDataSource dmpSftpDataSource = service.get(Id);
      return new ResponseEntity<DMPSftpDataSource>(dmpSftpDataSource, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<DMPSftpDataSource>(HttpStatus.NOT_FOUND);
    }
  }
  
  @PostMapping("/datasource")
  public void add(@Validated @RequestBody DMPSftpDataSource dmpSftpDataSource) {
    System.out.println("DEBUG cid:" + dmpSftpDataSource.getCampaignId());
    System.out.println("DEBUG host:" + dmpSftpDataSource.getHost());
    service.save(dmpSftpDataSource);
  }
  
  @PutMapping("/datasource/{Id}")
  public ResponseEntity<?> update(@RequestBody DMPSftpDataSource dmpSftpDataSource, @PathVariable Integer Id) {
    try {
      DMPSftpDataSource existDmpSftpDataSource = service.get(Id);
      service.save(dmpSftpDataSource);
      
      return new ResponseEntity<>(HttpStatus.OK);
    }catch(NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
  @DeleteMapping("/datasource/{Id}")
  public ResponseEntity<?> delete(@PathVariable Integer Id) {
    try {
      DMPSftpDataSource existDmpSftpDataSource = service.get(Id);
      service.delete(Id);
      
      return new ResponseEntity<>(HttpStatus.OK);
    }catch(NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
