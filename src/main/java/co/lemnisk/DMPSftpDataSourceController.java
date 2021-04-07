package co.lemnisk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
  public DMPSftpDataSource get(@PathVariable Integer Id) {
    return service.get(Id);
  }
  
  @PostMapping("/datasource")
  public void add(@Validated @RequestBody DMPSftpDataSource dmpSftpDataSource) {
    System.out.println("DEBUG cid:" + dmpSftpDataSource.getCampaignId());
    System.out.println("DEBUG host:" + dmpSftpDataSource.getHost());
    service.save(dmpSftpDataSource);
  }
  
  @PutMapping("/datasource/{Id}")
  public void update(@RequestBody DMPSftpDataSource dmpSftpDataSource, @PathVariable Integer Id) {
    service.save(dmpSftpDataSource);
  }
  
  @DeleteMapping("/datasource/{Id}")
  public void delete(@PathVariable Integer Id) {
    service.delete(Id);
  }
}
