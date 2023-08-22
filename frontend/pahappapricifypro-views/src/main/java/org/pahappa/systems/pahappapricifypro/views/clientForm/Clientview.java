package org.pahappa.systems.pahappapricifypro.views.clientForm;

import com.googlecode.genericdao.search.Search;
import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.pahappapricifypro.core.services.ClientService;
import org.pahappa.systems.pahappapricifypro.models.client.Client;
import org.pahappa.systems.pahappapricifypro.models.constants.Gender;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;

import org.sers.webutils.model.RecordStatus;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@ManagedBean(name="clientview")
@Getter
@Setter
@SessionScoped
public class Clientview extends PaginatedTableView<Client,Clientview,Clientview> {
    private ClientService clientservice;
    private int total;
    private int noMale;
    private int noFemale;
    private String searchTerm;
    private Search search;
    private Date createdFrom, createdTo;
    private List<Gender> genders = new ArrayList<>();
    private Gender selectedGender;

    @PostConstruct
    public void init(){
        clientservice= ApplicationContextProvider.getBean(ClientService.class);
        this.genders = Arrays.asList(Gender.values());
        this.reloadFilterReset();
    }
    @Override
    public void reloadFromDB(int offset, int limit, Map<String, Object> map) throws Exception {
        super.setDataModels(clientservice.getInstances(new Search().addFilterEqual("recordStatus", RecordStatus.ACTIVE).addFilterEqual("dateCreated",createdFrom),offset,limit));

    }

    @Override
    public List<ExcelReport> getExcelReportModels() {
        return Collections.emptyList();
    }

    @Override
    public String getFileName() {
        return null;
    }
    @Override
    public void reloadFilterReset(){
//this.searchFields = Arrays.asList(new Search())
        this.total = super.getTotalRecords();
        this.noMale = clientservice.countInstances(new Search().addFilterEqual("gender", Gender.MALE));
        this.noFemale = clientservice.countInstances(new Search().addFilterEqual("gender", Gender.FEMALE));
        super.setTotalRecords(clientservice.countInstances(new Search().addFilterEqual("recordStatus", RecordStatus.ACTIVE)));
        try {
            super.reloadFilterReset();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return getDataModels();
    }
    public void deleteClient(Client client){

        try {
            clientservice.deleteInstance(client);

        } catch (OperationFailedException e) {
//            UiUtils.ComposeFailure("Operation Failed",e.getLocalizedMessage());
//            Logger.getLogger(Clientview.class.getName()).log(Level.SEVERE,null,e);
//        }
            e.printStackTrace();
        }
    }
}
