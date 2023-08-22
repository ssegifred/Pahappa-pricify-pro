package org.pahappa.systems.pahappapricifypro.views.clientForm;


import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.pahappapricifypro.core.services.ClientService;
import org.pahappa.systems.pahappapricifypro.models.client.Client;
import org.pahappa.systems.pahappapricifypro.security.HyperLinks;
import org.pahappa.systems.pahappapricifypro.views.dialogs.DialogForm;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;
import org.pahappa.systems.pahappapricifypro.models.constants.Gender;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name="clientDialog")
@SessionScoped
@Getter
@Setter
public class ClientDialog extends DialogForm<Client> {
  private ClientService clientService;
  private List<Gender> listOfGenders;

  @PostConstruct
  public void init(){
      this.clientService= ApplicationContextProvider.getBean(ClientService.class);
      this.listOfGenders = Arrays.asList(Gender.values());
  }
    public ClientDialog() {
        super(HyperLinks.NAME_DIALOG, 700, 300);
    }


    @Override
    public void persist() throws Exception {
        this.clientService.saveInstance(super.model);

    }
    @Override
    public void resetModal(){
      super.resetModal();
      super.model=new Client();
    }
}
