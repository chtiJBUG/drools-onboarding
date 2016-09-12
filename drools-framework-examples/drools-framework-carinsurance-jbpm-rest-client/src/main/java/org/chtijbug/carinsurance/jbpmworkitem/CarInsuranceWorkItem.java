package org.chtijbug.carinsurance.jbpmworkitem;

import com.sun.org.apache.xpath.internal.operations.Quo;
import org.chtijbug.drools.carinsurance.model.QuoteRequest;
import org.chtijbug.drools.carinsurance.restclient.CarInsuranceConnexionConfiguration;
import org.chtijbug.drools.carinsurance.restclient.rest.CarInsuranceRestAPI;
import org.drools.core.process.instance.WorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

/**
 * Created by nheron on 09/09/2016.
 */
public class CarInsuranceWorkItem implements WorkItemHandler {


    private String url="http://localhost:8080/kie-server";
    private String username="kieserverloyalty";
    private String password="kieserverloyalty1!";

   private CarInsuranceRestAPI carInsuranceRestAPI;

    public CarInsuranceWorkItem() {

        if (System.getProperty("url.carinsurance.calculate")!=null){
            url=System.getProperty("url.carinsurance.calculate");
        }
        if (System.getProperty("url.carinsurance.calculate.username")!=null){
            username=System.getProperty("url.carinsurance.calculate.username");
        }
        if (System.getProperty("url.carinsurance.calculate.password")!=null){
            password=System.getProperty("url.carinsurance.calculate.password");
        }
        CarInsuranceConnexionConfiguration carInsuranceConnexionConfiguration = new CarInsuranceConnexionConfiguration(url, username, password);

        this.carInsuranceRestAPI= carInsuranceConnexionConfiguration.getInsuranceRestAPI();

    }

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        Object o = workItem.getParameter("quoteRequest");
        if (o instanceof QuoteRequest){
            QuoteRequest quoteRequest = (QuoteRequest)o;


        }
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {

    }
}
