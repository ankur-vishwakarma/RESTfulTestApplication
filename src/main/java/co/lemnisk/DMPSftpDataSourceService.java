package co.lemnisk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DMPSftpDataSourceService {
  
  @Autowired
  private DMPSftpDataSourceRepo repo;
  
  public List<DMPSftpDataSource> listAll(){
    return repo.findAll();
  }
  
  public DMPSftpDataSource get(Integer Id) {
    return repo.findById(Id).get();
  }
  
  public void save(DMPSftpDataSource dataSource) {
    repo.save(dataSource);
  }
  
  public void delete(Integer Id) {
    repo.deleteById(Id);
  }
}
