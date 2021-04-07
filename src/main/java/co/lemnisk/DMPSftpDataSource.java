package co.lemnisk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "DMPSftpDataSource", schema = "ADT_3950")
@Entity
public class DMPSftpDataSource {
  private Integer Id;
  private Integer CampaignId;
  private String Host;
  
  public DMPSftpDataSource() {
    
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return Id;
  }
  public void setId(Integer id) {
    Id = id;
  }
  public Integer getCampaignId() {
    return CampaignId;
  }
  public void setCampaignId(Integer campaignId) {
    CampaignId = campaignId;
  }
  public String getHost() {
    return Host;
  }
  public void setHost(String host) {
    Host = host;
  }
}
