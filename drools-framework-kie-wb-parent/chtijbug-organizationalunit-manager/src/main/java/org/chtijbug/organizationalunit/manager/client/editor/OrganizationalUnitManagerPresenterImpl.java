/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chtijbug.organizationalunit.manager.client.editor;

import com.google.gwt.user.client.Command;
import org.chtijbug.organizationalunit.manager.client.resources.i18n.OrganizationalUnitManagerConstants;
import org.guvnor.structure.config.SystemRepositoryChangedEvent;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.organizationalunit.OrganizationalUnitService;
import org.guvnor.structure.repositories.NewRepositoryEvent;
import org.guvnor.structure.repositories.RepositoryRemovedEvent;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.ErrorCallback;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.security.shared.api.Group;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.mvp.UberView;
import org.uberfire.commons.validation.PortablePreconditions;
import org.uberfire.ext.security.management.api.AbstractEntityManager;
import org.uberfire.ext.security.management.client.ClientUserSystemManager;
import org.uberfire.ext.security.management.impl.SearchRequestImpl;
import org.uberfire.ext.widgets.common.client.callbacks.HasBusyIndicatorDefaultErrorCallback;
import org.uberfire.lifecycle.OnOpen;
import org.uberfire.lifecycle.OnStartup;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
//The identifier has been preserved from kie-wb-common so existing .niogit System repositories are not broken
@WorkbenchScreen(identifier = "org.chtijbug.OrganizationalUnitManager")
public class OrganizationalUnitManagerPresenterImpl implements OrganizationalUnitManagerPresenter {

    private OrganizationalUnitManagerView view;

    private Caller<OrganizationalUnitService> organizationalUnitService;


    private ClientUserSystemManager userSystemManager;


    private Collection<String> allGroups;

    private Collection<OrganizationalUnit> allOrganizationalUnits;


    public OrganizationalUnitManagerPresenterImpl() {
        //For CDI proxying
    }

    @Inject
    public OrganizationalUnitManagerPresenterImpl(final OrganizationalUnitManagerView view,
                                                  final Caller<OrganizationalUnitService> organizationalUnitService,
                                                  final ClientUserSystemManager clientUserSystemManager) {
        this.view = PortablePreconditions.checkNotNull("view",
                view);
        this.organizationalUnitService = PortablePreconditions.checkNotNull("organizationalUnitService",
                organizationalUnitService);

        this.userSystemManager = PortablePreconditions.checkNotNull("clientUserSystemManager",
                clientUserSystemManager);

    }

    @PostConstruct
    public void setup() {
        //  addOrganizationalUnitPopup.init( this );
        //  editOrganizationalUnitPopup.init( this );
    }

    @OnStartup
    public void onStartup() {
        view.reset();
        AbstractEntityManager.SearchRequest request = new SearchRequestImpl("", 1, 50);
        final List<String> listGroups = new ArrayList<String>();//= userSystemManager.groups().search(request);
        OrganizationalUnitManagerPresenterImpl.this.allGroups = listGroups;
        userSystemManager.groups(new RemoteCallback() {
            @Override
            public void callback(Object o) {
                AbstractEntityManager.SearchResponse<Group> searchResponse = (AbstractEntityManager.SearchResponse<Group>) o;
                if (searchResponse != null) {
                    for (Group g : searchResponse.getResults()) {
                        listGroups.add(g.getName());
                    }

                }
            }
        }, new ErrorCallback() {
            @Override
            public boolean error(Object o, Throwable throwable) {
                System.out.println("Error" + o.toString() + "t=" + throwable.toString());
                return false;
            }
        }).search(request);

        loadOrganizationalUnits();

    }


    @OnOpen
    public void onOpen() {
        view.reset();
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return OrganizationalUnitManagerConstants.INSTANCE.OrganizationalUnitManagerTitle();
    }

    @WorkbenchPartView
    public UberView<OrganizationalUnitManagerPresenter> getView() {
        return view;
    }

    @Override
    public void loadOrganizationalUnits() {
        view.showBusyIndicator(OrganizationalUnitManagerConstants.INSTANCE.Wait());
        organizationalUnitService.call(new RemoteCallback<Collection<OrganizationalUnit>>() {
                                           @Override
                                           public void callback(final Collection<OrganizationalUnit> organizationalUnits) {
                                               OrganizationalUnitManagerPresenterImpl.this.allOrganizationalUnits = organizationalUnits;
                                               view.setOrganizationalUnits(organizationalUnits);
                                               view.hideBusyIndicator();
                                           }
                                       },
                new HasBusyIndicatorDefaultErrorCallback(view)).getOrganizationalUnits();
    }

    @Override
    public void organizationalUnitSelected(final OrganizationalUnit organizationalUnit) {
        //Reload rather than using cached Object as it could have been changed server-side (adding/deleting Repositories)
        view.showBusyIndicator(OrganizationalUnitManagerConstants.INSTANCE.Wait());
        organizationalUnitService.call(new RemoteCallback<OrganizationalUnit>() {
                                           @Override
                                           public void callback(final OrganizationalUnit organizationalUnit) {
                                               view.setOrganizationalUnitGroups(organizationalUnit.getGroups(),
                                                       getAvailableGroups());
                                               view.hideBusyIndicator();
                                           }
                                       },
                new HasBusyIndicatorDefaultErrorCallback(view)).getOrganizationalUnit(organizationalUnit.getName());
    }

    private Collection<String> getAvailableGroups() {
        final Collection<String> availableGroups = new ArrayList<String>();
        if (allGroups != null) {
            availableGroups.addAll(allGroups);
        }
        for (OrganizationalUnit ou : allOrganizationalUnits) {
            availableGroups.removeAll(ou.getRepositories());
        }
        return availableGroups;
    }


    @Override
    public void checkIfOrganizationalUnitExists(final String organizationalUnitName,
                                                final Command onSuccessCommand,
                                                final Command onFailureCommand) {
        //Check the Organizational Unit doesn't already exist
        organizationalUnitService.call(new RemoteCallback<OrganizationalUnit>() {

            @Override
            public void callback(final OrganizationalUnit organizationalUnit) {
                if (organizationalUnit == null) {
                    onSuccessCommand.execute();
                } else {
                    onFailureCommand.execute();
                }
            }
        }).getOrganizationalUnit(organizationalUnitName);
    }


    @Override
    public void saveOrganizationalUnit(final String organizationalUnitName,
                                       final String organizationalUnitOwner,
                                       final String defaultGroupId) {
        view.showBusyIndicator(OrganizationalUnitManagerConstants.INSTANCE.Wait());
        organizationalUnitService.call(new RemoteCallback<OrganizationalUnit>() {

                                           @Override
                                           public void callback(final OrganizationalUnit response) {
                                               loadOrganizationalUnits();
                                           }
                                       },
                new HasBusyIndicatorDefaultErrorCallback(view)).updateOrganizationalUnit(organizationalUnitName,
                organizationalUnitOwner,
                defaultGroupId);
    }


    @Override
    public void addOrganizationalUnitGroup(final OrganizationalUnit organizationalUnit,
                                           final String group) {
        view.showBusyIndicator(OrganizationalUnitManagerConstants.INSTANCE.Wait());
        organizationalUnit.getGroups().add(group);
        organizationalUnitService.call(new RemoteCallback<Void>() {
                                           @Override
                                           public void callback(final Void v) {
                                               view.setOrganizationalUnitGroups(organizationalUnit.getGroups(),
                                                       getAvailableGroups());
                                               view.hideBusyIndicator();
                                           }
                                       },
                new HasBusyIndicatorDefaultErrorCallback(view)).addGroup(organizationalUnit,
                group);
    }

    @Override
    public void removeOrganizationalUnitGroup(final OrganizationalUnit organizationalUnit,
                                              final String group) {
        view.showBusyIndicator(OrganizationalUnitManagerConstants.INSTANCE.Wait());
        organizationalUnit.getGroups().remove(group);
        organizationalUnitService.call(new RemoteCallback<Void>() {
                                           @Override
                                           public void callback(final Void v) {
                                               view.setOrganizationalUnitGroups(organizationalUnit.getGroups(),
                                                       getAvailableGroups());
                                               view.hideBusyIndicator();
                                           }
                                       },
                new HasBusyIndicatorDefaultErrorCallback(view)).removeGroup(organizationalUnit,
                group);
    }

    @Override
    public void checkValidGroupId(final String proposedGroupId,
                                  RemoteCallback<Boolean> callback) {
        organizationalUnitService.call(callback,
                new HasBusyIndicatorDefaultErrorCallback(view)).isValidGroupId(proposedGroupId);
    }

    @Override
    public void getSanitizedGroupId(String proposedGroupId,
                                    RemoteCallback<String> callback) {
        organizationalUnitService.call(callback,
                new HasBusyIndicatorDefaultErrorCallback(view)).getSanitizedDefaultGroupId(proposedGroupId);
    }

    public void onRepositoryAddedEvent(@Observes NewRepositoryEvent event) {
        onStartup();
    }

    public void onRepositoryRemovedEvent(@Observes RepositoryRemovedEvent event) {
        onStartup();
    }

    public void onSystemRepositoryChanged(@Observes SystemRepositoryChangedEvent event) {
        onStartup();
    }

}
