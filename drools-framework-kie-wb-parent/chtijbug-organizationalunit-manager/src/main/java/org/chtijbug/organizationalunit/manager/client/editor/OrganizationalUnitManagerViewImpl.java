/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.chtijbug.organizationalunit.manager.client.editor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.chtijbug.organizationalunit.manager.client.resources.i18n.OrganizationalUnitManagerConstants;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.ListBox;
import org.uberfire.ext.widgets.common.client.common.BusyPopup;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

/**
 * The Organizational Unit Manager View implementation
 */
@ApplicationScoped
public class OrganizationalUnitManagerViewImpl extends Composite implements OrganizationalUnitManagerView {

    interface OrganizationalUnitManagerViewBinder
            extends
            UiBinder<Widget, OrganizationalUnitManagerViewImpl> {

    }

    private static final Comparator<OrganizationalUnit> ORGANIZATIONAL_UNIT_COMPARATOR = new Comparator<OrganizationalUnit>() {
        @Override
        public int compare(final OrganizationalUnit o1,
                           final OrganizationalUnit o2) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
    };

    private static final Comparator<String> GROUP_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(final String o1,
                           final String o2) {
            return o1.toLowerCase().compareTo(o2.toLowerCase());
        }
    };

    private static OrganizationalUnitManagerViewBinder uiBinder = GWT.create(OrganizationalUnitManagerViewBinder.class);

    @UiField
    ListBox lstOrganizationalUnits;

    @UiField
    ListBox lstOrganizationalUnitGroups;

    @UiField
    ListBox lstAvailableGroupsForOrganizationalUnit;


    @UiField
    Button btnAddGroupOrganizationalUnit;

    @UiField
    Button btnRemoveGroupOrganizationalUnit;

    private OrganizationalUnitManagerPresenter presenter;

    private List<OrganizationalUnit> sortedOrganizationalUnits = new ArrayList<OrganizationalUnit>();
    private List<String> sortedOrganizationalUnitGroups = new ArrayList<String>();
    private List<String> sortedAvailableGroups = new ArrayList<String>();

    public OrganizationalUnitManagerViewImpl() {
        initWidget(uiBinder.createAndBindUi(this));

        lstOrganizationalUnits.addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(final ChangeEvent event) {
                final int selectedOrganizationalUnitIndex = lstOrganizationalUnits.getSelectedIndex();
                if (selectedOrganizationalUnitIndex == -1) {
                    return;
                }
                if (sortedOrganizationalUnits.isEmpty()) {
                    return;
                }
                final OrganizationalUnit selectedOrganizationalUnit = sortedOrganizationalUnits.get(selectedOrganizationalUnitIndex);
                presenter.organizationalUnitSelected(selectedOrganizationalUnit);

                btnAddGroupOrganizationalUnit.setEnabled(false);
                btnRemoveGroupOrganizationalUnit.setEnabled(false);
            }
        });

        lstOrganizationalUnitGroups.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(final ChangeEvent event) {
                btnRemoveGroupOrganizationalUnit.setEnabled(true);
            }
        });

        lstOrganizationalUnitGroups.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(final ChangeEvent event) {
                btnAddGroupOrganizationalUnit.setEnabled(true);
            }
        });
    }

    @Override
    public void init(final OrganizationalUnitManagerPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void reset() {
        sortedOrganizationalUnits.clear();
        sortedOrganizationalUnitGroups.clear();
        sortedAvailableGroups.clear();
        lstOrganizationalUnits.clear();
        lstOrganizationalUnitGroups.clear();
        lstAvailableGroupsForOrganizationalUnit.clear();
        btnAddGroupOrganizationalUnit.setEnabled(false);
        btnRemoveGroupOrganizationalUnit.setEnabled(false);

    }

    @Override
    public void setOrganizationalUnits(final Collection<OrganizationalUnit> organizationalUnits) {
        final int selectedOrganizationalUnitIndex = lstOrganizationalUnits.getSelectedIndex();
        final OrganizationalUnit selectedOrganizationalUnit = (selectedOrganizationalUnitIndex < 0 ? null : sortedOrganizationalUnits.get(selectedOrganizationalUnitIndex));

        lstOrganizationalUnits.clear();
        sortedOrganizationalUnits.clear();
        if (!(organizationalUnits == null || organizationalUnits.isEmpty())) {
            lstOrganizationalUnits.setEnabled(true);
            sortedOrganizationalUnits = sortOrganizationalUnits(organizationalUnits);
            for (OrganizationalUnit organizationalUnit : sortedOrganizationalUnits) {
                lstOrganizationalUnits.addItem(getOrganizationalUnitDisplayName(organizationalUnit));
            }


        } else {
            lstOrganizationalUnits.setEnabled(false);
            lstOrganizationalUnits.addItem(OrganizationalUnitManagerConstants.INSTANCE.NoOrganizationalUnitsDefined());
        }

        if (sortedOrganizationalUnits.contains(selectedOrganizationalUnit)) {
            lstOrganizationalUnits.setSelectedIndex(sortedOrganizationalUnits.indexOf(selectedOrganizationalUnit));
            presenter.organizationalUnitSelected(selectedOrganizationalUnit);


        } else {
            lstOrganizationalUnitGroups.clear();
            lstOrganizationalUnitGroups.setEnabled(false);
            lstOrganizationalUnitGroups.addItem(OrganizationalUnitManagerConstants.INSTANCE.NoOrganizationalUnitSelected());
            lstAvailableGroupsForOrganizationalUnit.clear();
            lstAvailableGroupsForOrganizationalUnit.setEnabled(false);
            lstAvailableGroupsForOrganizationalUnit.addItem(OrganizationalUnitManagerConstants.INSTANCE.NoOrganizationalUnitSelected());
        }

    }

    private String getOrganizationalUnitDisplayName(final OrganizationalUnit organizationalUnit) {
        final StringBuilder sb = new StringBuilder(organizationalUnit.getName());
        if (!(organizationalUnit.getOwner() == null || organizationalUnit.getOwner().isEmpty())) {
            sb.append(" : ").append(organizationalUnit.getOwner());
        }
        return sb.toString();
    }

    private List<OrganizationalUnit> sortOrganizationalUnits(final Collection<OrganizationalUnit> organizationalUnits) {
        final List<OrganizationalUnit> sortedOrganizationalUnits = new ArrayList<OrganizationalUnit>();
        sortedOrganizationalUnits.addAll(organizationalUnits);
        Collections.sort(sortedOrganizationalUnits,
                ORGANIZATIONAL_UNIT_COMPARATOR);
        return sortedOrganizationalUnits;
    }

    @Override
    public void setOrganizationalUnitGroups(final Collection<String> groups,
                                            final Collection<String> availableGroups) {
        lstOrganizationalUnitGroups.clear();
        sortedOrganizationalUnitGroups.clear();
        if (!(groups == null || availableGroups.isEmpty())) {
            lstOrganizationalUnitGroups.setEnabled(true);
            sortedOrganizationalUnitGroups = sortGroups(groups);
            for (String group : sortedOrganizationalUnitGroups) {
                lstOrganizationalUnitGroups.addItem(group);
            }
        } else {
            lstOrganizationalUnitGroups.setEnabled(false);
            lstOrganizationalUnitGroups.addItem(OrganizationalUnitManagerConstants.INSTANCE.NoGroupsDefined());
        }

        lstAvailableGroupsForOrganizationalUnit.clear();
        sortedAvailableGroups.clear();
        sortedAvailableGroups.addAll(availableGroups);
        sortedAvailableGroups.removeAll(sortedOrganizationalUnitGroups);
        if (!(sortedAvailableGroups == null || sortedAvailableGroups.isEmpty())) {
            lstAvailableGroupsForOrganizationalUnit.setEnabled(true);
            for (String groupe : sortedAvailableGroups) {
                lstAvailableGroupsForOrganizationalUnit.addItem(groupe);
            }
        } else {
            lstAvailableGroupsForOrganizationalUnit.setEnabled(false);
            lstAvailableGroupsForOrganizationalUnit.addItem(OrganizationalUnitManagerConstants.INSTANCE.NoGroupsAvailable());
        }


    }

    private List<String> sortGroups(final Collection<String> repositories) {
        final List<String> sortedGroups = new ArrayList<String>();
        sortedGroups.addAll(repositories);
        Collections.sort(sortedGroups,
                GROUP_COMPARATOR);
        return sortedGroups;
    }


    @Override
    public void showBusyIndicator(final String message) {
        BusyPopup.showMessage(message);
    }

    @Override
    public void hideBusyIndicator() {
        BusyPopup.close();
    }


    @UiHandler("btnAddGroupOrganizationalUnit")
    public void onClickAddRepositoryButton(final ClickEvent event) {
        final int selectedOrganizationalUnitIndex = lstOrganizationalUnits.getSelectedIndex();
        final OrganizationalUnit selectedOrganizationalUnit = (selectedOrganizationalUnitIndex < 0 ? null : sortedOrganizationalUnits.get(selectedOrganizationalUnitIndex));
        if (selectedOrganizationalUnit == null) {
            return;
        }
        final int selectedGroupIndex = lstAvailableGroupsForOrganizationalUnit.getSelectedIndex();
        final String selectedGroup = (selectedGroupIndex < 0 ? null : sortedAvailableGroups.get(selectedGroupIndex));
        if (selectedGroup == null) {
            return;
        }
        presenter.addOrganizationalUnitGroup(selectedOrganizationalUnit,
                selectedGroup);

    }

    @UiHandler("btnRemoveGroupOrganizationalUnit")
    public void onClickRemoveRepositoryButton(final ClickEvent event) {
        final int selectedOrganizationalUnitIndex = lstOrganizationalUnits.getSelectedIndex();
        final OrganizationalUnit selectedOrganizationalUnit = (selectedOrganizationalUnitIndex < 0 ? null : sortedOrganizationalUnits.get(selectedOrganizationalUnitIndex));
        if (selectedOrganizationalUnit == null) {
            return;
        }
        final int selectedGroupIndex = lstOrganizationalUnitGroups.getSelectedIndex();
        final String selectdGroup = (selectedGroupIndex < 0 ? null : sortedOrganizationalUnitGroups.get(selectedGroupIndex));
        if (selectdGroup == null) {
            return;
        }
        presenter.removeOrganizationalUnitGroup(selectedOrganizationalUnit,
                selectdGroup);
    }

}
