package org.jboss.errai.bus.client.framework;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.enterprise.event.Event;
import org.dashbuilder.dataprovider.DataSetProviderType;
import org.dashbuilder.dataset.DataSet;
import org.dashbuilder.dataset.DataSetLookup;
import org.dashbuilder.dataset.DataSetMetadata;
import org.dashbuilder.dataset.backend.EditDataSetDef;
import org.dashbuilder.dataset.def.DataSetDef;
import org.dashbuilder.dataset.service.DataSetDefServices;
import org.dashbuilder.dataset.service.DataSetDefVfsServices;
import org.dashbuilder.dataset.service.DataSetExportServices;
import org.dashbuilder.dataset.service.DataSetLookupServices;
import org.drools.workbench.models.datamodel.imports.Imports;
import org.drools.workbench.models.datamodel.rule.RuleModel;
import org.drools.workbench.models.guided.dtable.shared.conversion.ConversionResult;
import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52;
import org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree;
import org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel;
import org.drools.workbench.models.guided.template.shared.TemplateModel;
import org.drools.workbench.models.testscenarios.shared.Scenario;
import org.drools.workbench.screens.drltext.model.DrlModelContent;
import org.drools.workbench.screens.drltext.service.DRLTextEditorService;
import org.drools.workbench.screens.dsltext.model.DSLTextEditorContent;
import org.drools.workbench.screens.dsltext.service.DSLTextEditorService;
import org.drools.workbench.screens.dtablexls.service.DecisionTableXLSContent;
import org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService;
import org.drools.workbench.screens.enums.model.EnumModelContent;
import org.drools.workbench.screens.enums.service.EnumService;
import org.drools.workbench.screens.globals.model.GlobalsEditorContent;
import org.drools.workbench.screens.globals.model.GlobalsModel;
import org.drools.workbench.screens.globals.service.GlobalsEditorService;
import org.drools.workbench.screens.guided.dtable.model.GuidedDecisionTableEditorContent;
import org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService;
import org.drools.workbench.screens.guided.dtree.model.GuidedDecisionTreeEditorContent;
import org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService;
import org.drools.workbench.screens.guided.rule.model.GuidedEditorContent;
import org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService;
import org.drools.workbench.screens.guided.scorecard.model.ScoreCardModelContent;
import org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService;
import org.drools.workbench.screens.guided.template.model.GuidedTemplateEditorContent;
import org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService;
import org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSContent;
import org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService;
import org.drools.workbench.screens.testscenario.model.TestScenarioModelContent;
import org.drools.workbench.screens.testscenario.model.TestScenarioResult;
import org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService;
import org.drools.workbench.screens.workitems.model.WorkItemDefinitionElements;
import org.drools.workbench.screens.workitems.model.WorkItemsModelContent;
import org.drools.workbench.screens.workitems.service.WorkItemsEditorService;
import org.guvnor.asset.management.model.RepositoryStructureModel;
import org.guvnor.asset.management.service.AssetManagementService;
import org.guvnor.asset.management.service.RepositoryStructureService;
import org.guvnor.common.services.project.builder.model.BuildResults;
import org.guvnor.common.services.project.builder.model.IncrementalBuildResults;
import org.guvnor.common.services.project.builder.service.BuildService;
import org.guvnor.common.services.project.model.GAV;
import org.guvnor.common.services.project.model.MavenRepositoryMetadata;
import org.guvnor.common.services.project.model.POM;
import org.guvnor.common.services.project.model.Package;
import org.guvnor.common.services.project.model.Project;
import org.guvnor.common.services.project.model.ProjectImports;
import org.guvnor.common.services.project.model.ProjectRepositories;
import org.guvnor.common.services.project.service.DeploymentMode;
import org.guvnor.common.services.project.service.POMService;
import org.guvnor.common.services.project.service.ProjectRepositoriesService;
import org.guvnor.common.services.project.service.ProjectRepositoryResolver;
import org.guvnor.common.services.project.service.ProjectService;
import org.guvnor.common.services.shared.config.AppConfigService;
import org.guvnor.common.services.shared.config.ResourceConfigService;
import org.guvnor.common.services.shared.metadata.MetadataService;
import org.guvnor.common.services.shared.metadata.model.Metadata;
import org.guvnor.common.services.shared.security.KieWorkbenchSecurityService;
import org.guvnor.common.services.shared.test.TestService;
import org.guvnor.common.services.workingset.client.model.WorkingSetSettings;
import org.guvnor.inbox.model.InboxPageRequest;
import org.guvnor.inbox.service.InboxService;
import org.guvnor.m2repo.model.JarListPageRequest;
import org.guvnor.m2repo.service.M2RepoService;
import org.guvnor.structure.navigator.FileNavigatorService;
import org.guvnor.structure.navigator.NavigatorContent;
import org.guvnor.structure.organizationalunit.OrganizationalUnit;
import org.guvnor.structure.organizationalunit.OrganizationalUnitService;
import org.guvnor.structure.repositories.Repository;
import org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations;
import org.guvnor.structure.repositories.RepositoryInfo;
import org.guvnor.structure.repositories.RepositoryService;
import org.guvnor.structure.repositories.RepositoryServiceEditor;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.builder.RemoteCallSendable;
import org.jboss.errai.bus.client.api.messaging.MessageBus;
import org.jboss.errai.common.client.api.ErrorCallback;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.common.client.api.interceptor.InterceptedCall;
import org.jboss.errai.common.client.api.interceptor.RemoteCallContext;
import org.jboss.errai.common.client.framework.CallContextStatus;
import org.jboss.errai.common.client.framework.ProxyProvider;
import org.jboss.errai.common.client.framework.RemoteServiceProxyFactory;
import org.jboss.errai.common.client.util.AsyncBeanFactory;
import org.jboss.errai.common.client.util.CreationalCallback;
import org.jboss.errai.security.client.local.interceptors.AuthenticationServiceInterceptor;
import org.jboss.errai.security.shared.api.Group;
import org.jboss.errai.security.shared.api.Role;
import org.jboss.errai.security.shared.api.identity.User;
import org.jboss.errai.security.shared.service.AuthenticationService;
import org.jboss.errai.security.shared.service.NonCachingUserService;
import org.jbpm.console.ng.bd.model.DeploymentUnitSummary;
import org.jbpm.console.ng.bd.model.KModuleDeploymentUnitSummary;
import org.jbpm.console.ng.bd.model.KModuleKey;
import org.jbpm.console.ng.bd.service.DataServiceEntryPoint;
import org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint;
import org.jbpm.console.ng.bd.service.KieSessionEntryPoint;
import org.jbpm.console.ng.ga.forms.service.FormServiceEntryPoint;
import org.jbpm.console.ng.ga.forms.service.PlaceManagerActivityService;
import org.jbpm.console.ng.ga.model.QueryFilter;
import org.jbpm.console.ng.ga.service.GenericServiceEntryPoint;
import org.jbpm.console.ng.ga.service.ItemKey;
import org.jbpm.console.ng.ht.model.CommentSummary;
import org.jbpm.console.ng.ht.model.TaskAssignmentSummary;
import org.jbpm.console.ng.ht.model.TaskEventKey;
import org.jbpm.console.ng.ht.model.TaskEventSummary;
import org.jbpm.console.ng.ht.model.TaskKey;
import org.jbpm.console.ng.ht.model.TaskSummary;
import org.jbpm.console.ng.ht.service.TaskAuditService;
import org.jbpm.console.ng.ht.service.TaskCommentsService;
import org.jbpm.console.ng.ht.service.TaskFormManagementService;
import org.jbpm.console.ng.ht.service.TaskLifeCycleService;
import org.jbpm.console.ng.ht.service.TaskOperationsService;
import org.jbpm.console.ng.ht.service.TaskQueryService;
import org.jbpm.console.ng.pr.model.DocumentKey;
import org.jbpm.console.ng.pr.model.DocumentSummary;
import org.jbpm.console.ng.pr.model.ProcessDefinitionKey;
import org.jbpm.console.ng.pr.model.ProcessInstanceKey;
import org.jbpm.console.ng.pr.model.ProcessInstanceSummary;
import org.jbpm.console.ng.pr.model.ProcessSummary;
import org.jbpm.console.ng.pr.model.ProcessVariableKey;
import org.jbpm.console.ng.pr.model.ProcessVariableSummary;
import org.jbpm.console.ng.pr.service.DocumentsService;
import org.jbpm.console.ng.pr.service.ProcessDefinitionService;
import org.jbpm.console.ng.pr.service.ProcessInstanceService;
import org.jbpm.console.ng.pr.service.ProcessVariablesService;
import org.jbpm.designer.service.DesignerAssetService;
import org.jbpm.designer.service.DesignerContent;
import org.jbpm.formModeler.api.client.FormRenderContext;
import org.jbpm.formModeler.api.client.FormRenderContextManager;
import org.jbpm.formModeler.api.client.FormRenderContextTO;
import org.jbpm.formModeler.api.events.FormSubmitFailEvent;
import org.jbpm.formModeler.api.events.FormSubmittedEvent;
import org.jbpm.formModeler.api.events.ResizeFormcontainerEvent;
import org.jbpm.formModeler.api.model.Form;
import org.jbpm.formModeler.renderer.service.FormRendererIncluderService;
import org.jbpm.formModeler.renderer.service.FormRenderingService;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.controller.api.model.runtime.ServerInstanceKey;
import org.kie.server.controller.api.model.spec.Capability;
import org.kie.server.controller.api.model.spec.ContainerConfig;
import org.kie.server.controller.api.model.spec.ContainerSpec;
import org.kie.server.controller.api.model.spec.ContainerSpecKey;
import org.kie.server.controller.api.model.spec.ServerConfig;
import org.kie.server.controller.api.model.spec.ServerTemplate;
import org.kie.uberfire.social.activities.model.PagedSocialQuery;
import org.kie.uberfire.social.activities.model.SocialActivitiesEvent;
import org.kie.uberfire.social.activities.model.SocialEventType;
import org.kie.uberfire.social.activities.model.SocialPaged;
import org.kie.uberfire.social.activities.model.SocialUser;
import org.kie.uberfire.social.activities.service.SocialActivitiesAPI;
import org.kie.uberfire.social.activities.service.SocialAdapter;
import org.kie.uberfire.social.activities.service.SocialEventTypeRepositoryAPI;
import org.kie.uberfire.social.activities.service.SocialPredicate;
import org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI;
import org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI;
import org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI;
import org.kie.uberfire.social.activities.service.SocialUserRepositoryAPI;
import org.kie.uberfire.social.activities.service.SocialUserServiceAPI;
import org.kie.uberfire.social.activities.service.SocialUserTimelinePagedRepositoryAPI;
import org.kie.uberfire.social.activities.service.StressTestAPI;
import org.kie.workbench.common.screens.datamodeller.model.EditorModelContent;
import org.kie.workbench.common.screens.datamodeller.model.GenerationResult;
import org.kie.workbench.common.screens.datamodeller.model.TypeInfoResult;
import org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorEditorContent;
import org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel;
import org.kie.workbench.common.screens.datamodeller.service.DataModelerService;
import org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorEditorService;
import org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService;
import org.kie.workbench.common.screens.defaulteditor.service.DefaultEditorContent;
import org.kie.workbench.common.screens.defaulteditor.service.DefaultEditorService;
import org.kie.workbench.common.screens.explorer.model.FolderItem;
import org.kie.workbench.common.screens.explorer.model.FolderListing;
import org.kie.workbench.common.screens.explorer.model.ProjectExplorerContent;
import org.kie.workbench.common.screens.explorer.model.URIStructureExplorerModel;
import org.kie.workbench.common.screens.explorer.service.ActiveOptions;
import org.kie.workbench.common.screens.explorer.service.ExplorerService;
import org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery;
import org.kie.workbench.common.screens.home.service.HomeService;
import org.kie.workbench.common.screens.projecteditor.model.ProjectScreenModel;
import org.kie.workbench.common.screens.projecteditor.service.PomEditorService;
import org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService;
import org.kie.workbench.common.screens.search.model.QueryMetadataPageRequest;
import org.kie.workbench.common.screens.search.model.SearchTermPageRequest;
import org.kie.workbench.common.screens.search.service.SearchService;
import org.kie.workbench.common.screens.server.management.model.ContainerSpecData;
import org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService;
import org.kie.workbench.common.screens.server.management.service.RuntimeManagementService;
import org.kie.workbench.common.screens.server.management.service.SpecManagementService;
import org.kie.workbench.common.screens.social.hp.config.SocialConfigurationService;
import org.kie.workbench.common.screens.social.hp.service.RepositoryListService;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleBaselinePayload;
import org.kie.workbench.common.services.datamodel.model.PackageDataModelOracleIncrementalPayload;
import org.kie.workbench.common.services.datamodel.service.IncrementalDataModelService;
import org.kie.workbench.common.services.datamodeller.core.DataModel;
import org.kie.workbench.common.services.datamodeller.core.DataObject;
import org.kie.workbench.common.services.datamodeller.core.ElementType;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationDefinitionRequest;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationDefinitionResponse;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseResponse;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceRequest;
import org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceResponse;
import org.kie.workbench.common.services.refactoring.model.query.RefactoringPageRequest;
import org.kie.workbench.common.services.refactoring.service.RefactoringQueryService;
import org.kie.workbench.common.services.shared.dependencies.DependencyService;
import org.kie.workbench.common.services.shared.dependencies.EnhancedDependencies;
import org.kie.workbench.common.services.shared.enums.EnumDropdownService;
import org.kie.workbench.common.services.shared.kmodule.KModuleModel;
import org.kie.workbench.common.services.shared.kmodule.KModuleService;
import org.kie.workbench.common.services.shared.project.KieProject;
import org.kie.workbench.common.services.shared.project.KieProjectService;
import org.kie.workbench.common.services.shared.project.ProjectImportsContent;
import org.kie.workbench.common.services.shared.project.ProjectImportsService;
import org.kie.workbench.common.services.shared.rulename.RuleNamesService;
import org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService;
import org.kie.workbench.common.services.shared.whitelist.WhiteList;
import org.optaplanner.workbench.screens.solver.model.SolverConfigModel;
import org.optaplanner.workbench.screens.solver.model.SolverModelContent;
import org.optaplanner.workbench.screens.solver.service.SolverEditorService;
import org.uberfire.backend.plugin.RuntimePluginsService;
import org.uberfire.backend.vfs.DirectoryStream;
import org.uberfire.backend.vfs.DirectoryStream.Filter;
import org.uberfire.backend.vfs.Path;
import org.uberfire.backend.vfs.VFSLockService;
import org.uberfire.backend.vfs.VFSService;
import org.uberfire.backend.vfs.impl.LockInfo;
import org.uberfire.backend.vfs.impl.LockResult;
import org.uberfire.backend.vfs.impl.VFSCacheInterceptor;
import org.uberfire.ext.apps.api.AppsPersistenceAPI;
import org.uberfire.ext.apps.api.Directory;
import org.uberfire.ext.editor.commons.service.CopyService;
import org.uberfire.ext.editor.commons.service.DeleteService;
import org.uberfire.ext.editor.commons.service.RenameService;
import org.uberfire.ext.editor.commons.service.ValidationService;
import org.uberfire.ext.editor.commons.version.VersionService;
import org.uberfire.ext.layout.editor.api.LayoutServices;
import org.uberfire.ext.layout.editor.api.editor.LayoutTemplate;
import org.uberfire.ext.plugin.model.DynamicMenu;
import org.uberfire.ext.plugin.model.LayoutEditorModel;
import org.uberfire.ext.plugin.model.Media;
import org.uberfire.ext.plugin.model.Plugin;
import org.uberfire.ext.plugin.model.PluginContent;
import org.uberfire.ext.plugin.model.PluginSimpleContent;
import org.uberfire.ext.plugin.model.PluginType;
import org.uberfire.ext.plugin.service.PluginServices;
import org.uberfire.ext.properties.editor.model.PropertyEditorCategory;
import org.uberfire.ext.properties.editor.service.BeanPropertyEditorBuilderService;
import org.uberfire.ext.security.management.api.AbstractEntityManager.SearchRequest;
import org.uberfire.ext.security.management.api.AbstractEntityManager.SearchResponse;
import org.uberfire.ext.security.management.api.GroupManagerSettings;
import org.uberfire.ext.security.management.api.RoleManagerSettings;
import org.uberfire.ext.security.management.api.UserManagerSettings;
import org.uberfire.ext.security.management.api.service.GroupManagerService;
import org.uberfire.ext.security.management.api.service.RoleManagerService;
import org.uberfire.ext.security.management.api.service.UserManagerService;
import org.uberfire.ext.services.shared.preferences.UserPreference;
import org.uberfire.ext.services.shared.preferences.UserPreferencesService;
import org.uberfire.ext.services.shared.preferences.UserPreferencesType;
import org.uberfire.java.nio.base.version.VersionRecord;
import org.uberfire.mvp.PlaceRequest;
import org.uberfire.paging.AbstractPageRow;
import org.uberfire.paging.PageResponse;
import org.uberfire.workbench.model.PerspectiveDefinition;
import org.uberfire.workbench.model.SplashScreenFilter;
import org.uberfire.workbench.services.WorkbenchServices;

public class RpcProxyLoaderImpl implements RpcProxyLoader { public void loadProxies(final MessageBus bus) {
    class org_jbpm_console_ng_ga_service_GenericServiceEntryPointImpl extends AbstractRpcProxy implements GenericServiceEntryPoint { public PageResponse getData(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.service.GenericServiceEntryPoint").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.service.GenericServiceEntryPoint").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ga_service_GenericServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public AbstractPageRow getItem(final ItemKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.service.GenericServiceEntryPoint").endpoint("getItem:org.jbpm.console.ng.ga.service.ItemKey:", qualifiers, new Object[] { a0 }).respondTo(AbstractPageRow.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.service.GenericServiceEntryPoint").endpoint("getItem:org.jbpm.console.ng.ga.service.ItemKey:", qualifiers, new Object[] { a0 }).respondTo(AbstractPageRow.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ga_service_GenericServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAll(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.service.GenericServiceEntryPoint").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.service.GenericServiceEntryPoint").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ga_service_GenericServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GenericServiceEntryPoint.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ga_service_GenericServiceEntryPointImpl();
      }
    });
    class org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl extends AbstractRpcProxy implements DataModelerService { public Path createJavaFile(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("createJavaFile:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("createJavaFile:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createJavaFile(final Path a0, final String a1, final String a2, final Map a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("createJavaFile:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("createJavaFile:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public EditorModelContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(EditorModelContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(EditorModelContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public EditorModelContent loadContent(final Path a0, final boolean a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("loadContent:org.uberfire.backend.vfs.Path:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(EditorModelContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("loadContent:org.uberfire.backend.vfs.Path:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(EditorModelContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DataModel loadModel(final KieProject a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("loadModel:org.kie.workbench.common.services.shared.project.KieProject:", qualifiers, new Object[] { a0 }).respondTo(DataModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("loadModel:org.kie.workbench.common.services.shared.project.KieProject:", qualifiers, new Object[] { a0 }).respondTo(DataModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GenerationResult saveModel(final DataModel a0, final KieProject a1, final boolean a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("saveModel:org.kie.workbench.common.services.datamodeller.core.DataModel:org.kie.workbench.common.services.shared.project.KieProject:boolean:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(GenerationResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("saveModel:org.kie.workbench.common.services.datamodeller.core.DataModel:org.kie.workbench.common.services.shared.project.KieProject:boolean:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(GenerationResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GenerationResult saveModel(final DataModel a0, final KieProject a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("saveModel:org.kie.workbench.common.services.datamodeller.core.DataModel:org.kie.workbench.common.services.shared.project.KieProject:", qualifiers, new Object[] { a0, a1 }).respondTo(GenerationResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("saveModel:org.kie.workbench.common.services.datamodeller.core.DataModel:org.kie.workbench.common.services.shared.project.KieProject:", qualifiers, new Object[] { a0, a1 }).respondTo(GenerationResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GenerationResult saveSource(final String a0, final Path a1, final DataObject a2, final Metadata a3, final String a4) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("saveSource:java.lang.String:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.datamodeller.core.DataObject:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(GenerationResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("saveSource:java.lang.String:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.datamodeller.core.DataObject:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(GenerationResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GenerationResult saveSource(final String a0, final Path a1, final DataObject a2, final Metadata a3, final String a4, final String a5, final String a6) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("saveSource:java.lang.String:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.datamodeller.core.DataObject:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6 }).respondTo(GenerationResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("saveSource:java.lang.String:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.datamodeller.core.DataObject:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6 }).respondTo(GenerationResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GenerationResult updateSource(final String a0, final Path a1, final DataObject a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("updateSource:java.lang.String:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.datamodeller.core.DataObject:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(GenerationResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("updateSource:java.lang.String:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.datamodeller.core.DataObject:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(GenerationResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GenerationResult updateDataObject(final DataObject a0, final String a1, final Path a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("updateDataObject:org.kie.workbench.common.services.datamodeller.core.DataObject:java.lang.String:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(GenerationResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("updateDataObject:org.kie.workbench.common.services.datamodeller.core.DataObject:java.lang.String:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(GenerationResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path copy(final Path a0, final String a1, final String a2, final boolean a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:boolean:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:boolean:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2, final boolean a3, final boolean a4, final String a5, final DataObject a6, final Metadata a7) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:boolean:boolean:java.lang.String:org.kie.workbench.common.services.datamodeller.core.DataObject:org.guvnor.common.services.shared.metadata.model.Metadata:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6, a7 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:boolean:boolean:java.lang.String:org.kie.workbench.common.services.datamodeller.core.DataObject:org.guvnor.common.services.shared.metadata.model.Metadata:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6, a7 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
      }

      public GenerationResult refactorClass(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("refactorClass:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(GenerationResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("refactorClass:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(GenerationResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final String a0, final Path a1, final DataObject a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("validate:java.lang.String:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.datamodeller.core.DataObject:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("validate:java.lang.String:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.datamodeller.core.DataObject:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public TypeInfoResult loadJavaTypeInfo(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("loadJavaTypeInfo:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(TypeInfoResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("loadJavaTypeInfo:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(TypeInfoResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getBasePropertyTypes() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("getBasePropertyTypes:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("getBasePropertyTypes:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map getAnnotationDefinitions() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("getAnnotationDefinitions:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("getAnnotationDefinitions:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List findClassUsages(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("findClassUsages:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("findClassUsages:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List findFieldUsages(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("findFieldUsages:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("findFieldUsages:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List findPersistableClasses(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("findPersistableClasses:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("findPersistableClasses:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Boolean isPersistableClass(final String a0, final Path a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("isPersistableClass:java.lang.String:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("isPersistableClass:java.lang.String:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Boolean exists(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("exists:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("exists:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public AnnotationSourceResponse resolveSourceRequest(final AnnotationSourceRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("resolveSourceRequest:org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceRequest:", qualifiers, new Object[] { a0 }).respondTo(AnnotationSourceResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("resolveSourceRequest:org.kie.workbench.common.services.datamodeller.driver.model.AnnotationSourceRequest:", qualifiers, new Object[] { a0 }).respondTo(AnnotationSourceResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validateValuePair(final String a0, final ElementType a1, final String a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("validateValuePair:java.lang.String:org.kie.workbench.common.services.datamodeller.core.ElementType:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("validateValuePair:java.lang.String:org.kie.workbench.common.services.datamodeller.core.ElementType:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public AnnotationParseResponse resolveParseRequest(final AnnotationParseRequest a0, final KieProject a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("resolveParseRequest:org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest:org.kie.workbench.common.services.shared.project.KieProject:", qualifiers, new Object[] { a0, a1 }).respondTo(AnnotationParseResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("resolveParseRequest:org.kie.workbench.common.services.datamodeller.driver.model.AnnotationParseRequest:org.kie.workbench.common.services.shared.project.KieProject:", qualifiers, new Object[] { a0, a1 }).respondTo(AnnotationParseResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public AnnotationDefinitionResponse resolveDefinitionRequest(final AnnotationDefinitionRequest a0, final KieProject a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("resolveDefinitionRequest:org.kie.workbench.common.services.datamodeller.driver.model.AnnotationDefinitionRequest:org.kie.workbench.common.services.shared.project.KieProject:", qualifiers, new Object[] { a0, a1 }).respondTo(AnnotationDefinitionResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.DataModelerService").endpoint("resolveDefinitionRequest:org.kie.workbench.common.services.datamodeller.driver.model.AnnotationDefinitionRequest:org.kie.workbench.common.services.shared.project.KieProject:", qualifiers, new Object[] { a0, a1 }).respondTo(AnnotationDefinitionResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DataModelerService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_datamodeller_service_DataModelerServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl extends AbstractRpcProxy implements PersistenceDescriptorService { public PersistenceDescriptorModel createProjectDefaultDescriptor(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("createProjectDefaultDescriptor:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PersistenceDescriptorModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("createProjectDefaultDescriptor:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PersistenceDescriptorModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PersistenceDescriptorModel load(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("load:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(PersistenceDescriptorModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("load:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(PersistenceDescriptorModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path calculatePersistenceDescriptorPath(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("calculatePersistenceDescriptorPath:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("calculatePersistenceDescriptorPath:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String toSource(final Path a0, final PersistenceDescriptorModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final PersistenceDescriptorModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PersistenceDescriptorModel load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PersistenceDescriptorModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PersistenceDescriptorModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final PersistenceDescriptorModel a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(PersistenceDescriptorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorServiceImpl();
      }
    });
    class org_uberfire_ext_editor_commons_service_DeleteServiceImpl extends AbstractRpcProxy implements DeleteService { public void deleteIfExists(final Collection a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.DeleteService").endpoint("deleteIfExists:java.util.Collection:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.DeleteService").endpoint("deleteIfExists:java.util.Collection:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_DeleteServiceImpl.this.sendRequest(bus, sendable);
      }

      public boolean hasRestriction(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.DeleteService").endpoint("hasRestriction:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.DeleteService").endpoint("hasRestriction:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_DeleteServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.DeleteService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.DeleteService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_DeleteServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DeleteService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_editor_commons_service_DeleteServiceImpl();
      }
    });
    class org_uberfire_backend_plugin_RuntimePluginsServiceImpl extends AbstractRpcProxy implements RuntimePluginsService { public Collection listFramworksContent() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("listFramworksContent:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("listFramworksContent:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_plugin_RuntimePluginsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection listPluginsContent() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("listPluginsContent:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("listPluginsContent:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_plugin_RuntimePluginsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String getTemplateContent(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("getTemplateContent:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.plugin.RuntimePluginsService").endpoint("getTemplateContent:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_plugin_RuntimePluginsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RuntimePluginsService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_backend_plugin_RuntimePluginsServiceImpl();
      }
    });
    class org_jbpm_console_ng_ht_service_TaskFormManagementServiceImpl extends AbstractRpcProxy implements TaskFormManagementService { public List getAvailableDeployments() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskFormManagementService").endpoint("getAvailableDeployments:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskFormManagementService").endpoint("getAvailableDeployments:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskFormManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getFormsByDeployment(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskFormManagementService").endpoint("getFormsByDeployment:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskFormManagementService").endpoint("getFormsByDeployment:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskFormManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(TaskFormManagementService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ht_service_TaskFormManagementServiceImpl();
      }
    });
    class org_uberfire_ext_editor_commons_version_VersionServiceImpl extends AbstractRpcProxy implements VersionService { public List getVersions(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.version.VersionService").endpoint("getVersions:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.version.VersionService").endpoint("getVersions:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_version_VersionServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path getPathToPreviousVersion(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.version.VersionService").endpoint("getPathToPreviousVersion:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.version.VersionService").endpoint("getPathToPreviousVersion:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_version_VersionServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path restore(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.version.VersionService").endpoint("restore:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.version.VersionService").endpoint("restore:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_version_VersionServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(VersionService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_editor_commons_version_VersionServiceImpl();
      }
    });
    class org_jbpm_console_ng_ga_forms_service_FormServiceEntryPointImpl extends AbstractRpcProxy implements FormServiceEntryPoint { public String getFormDisplayTask(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.forms.service.FormServiceEntryPoint").endpoint("getFormDisplayTask:long:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.forms.service.FormServiceEntryPoint").endpoint("getFormDisplayTask:long:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ga_forms_service_FormServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String getFormDisplayProcess(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.forms.service.FormServiceEntryPoint").endpoint("getFormDisplayProcess:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.forms.service.FormServiceEntryPoint").endpoint("getFormDisplayProcess:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ga_forms_service_FormServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(FormServiceEntryPoint.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ga_forms_service_FormServiceEntryPointImpl();
      }
    });
    class org_guvnor_common_services_project_builder_service_BuildServiceImpl extends AbstractRpcProxy implements BuildService { public BuildResults build(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("build:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(BuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("build:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(BuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public BuildResults buildAndDeploy(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("buildAndDeploy:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(BuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("buildAndDeploy:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(BuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public BuildResults buildAndDeploy(final Project a0, final DeploymentMode a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("buildAndDeploy:org.guvnor.common.services.project.model.Project:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1 }).respondTo(BuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("buildAndDeploy:org.guvnor.common.services.project.model.Project:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1 }).respondTo(BuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public BuildResults buildAndDeploy(final Project a0, final boolean a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("buildAndDeploy:org.guvnor.common.services.project.model.Project:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(BuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("buildAndDeploy:org.guvnor.common.services.project.model.Project:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(BuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public BuildResults buildAndDeploy(final Project a0, final boolean a1, final DeploymentMode a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("buildAndDeploy:org.guvnor.common.services.project.model.Project:boolean:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(BuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("buildAndDeploy:org.guvnor.common.services.project.model.Project:boolean:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(BuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean isBuilt(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("isBuilt:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("isBuilt:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public IncrementalBuildResults addPackageResource(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("addPackageResource:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(IncrementalBuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("addPackageResource:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(IncrementalBuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public IncrementalBuildResults deletePackageResource(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("deletePackageResource:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(IncrementalBuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("deletePackageResource:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(IncrementalBuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public IncrementalBuildResults updatePackageResource(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("updatePackageResource:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(IncrementalBuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("updatePackageResource:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(IncrementalBuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public IncrementalBuildResults applyBatchResourceChanges(final Project a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("applyBatchResourceChanges:org.guvnor.common.services.project.model.Project:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(IncrementalBuildResults.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.builder.service.BuildService").endpoint("applyBatchResourceChanges:org.guvnor.common.services.project.model.Project:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(IncrementalBuildResults.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_builder_service_BuildServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(BuildService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_project_builder_service_BuildServiceImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl extends AbstractRpcProxy implements SocialTimeLineRepositoryAPI { public List getLastEventTimeline(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastEventTimeline:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastEventTimeline:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getLastEventTimeline(final String a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastEventTimeline:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastEventTimeline:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getLastEventTimeline(final SocialAdapter a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastEventTimeline:org.kie.uberfire.social.activities.service.SocialAdapter:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastEventTimeline:org.kie.uberfire.social.activities.service.SocialAdapter:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void saveTypeEvent(final SocialActivitiesEvent a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("saveTypeEvent:org.kie.uberfire.social.activities.model.SocialActivitiesEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("saveTypeEvent:org.kie.uberfire.social.activities.model.SocialActivitiesEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
      }

      public void saveUserEvent(final SocialActivitiesEvent a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("saveUserEvent:org.kie.uberfire.social.activities.model.SocialActivitiesEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("saveUserEvent:org.kie.uberfire.social.activities.model.SocialActivitiesEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
      }

      public List getLastUserTimeline(final SocialUser a0, final SocialPredicate a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getLastUserTimeline(final SocialUser a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getLastUserTimeline(final SocialUser a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("getLastUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Integer numberOfPages(final SocialEventType a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("numberOfPages:org.kie.uberfire.social.activities.model.SocialEventType:", qualifiers, new Object[] { a0 }).respondTo(Integer.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimeLineRepositoryAPI").endpoint("numberOfPages:org.kie.uberfire.social.activities.model.SocialEventType:", qualifiers, new Object[] { a0 }).respondTo(Integer.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return 0;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialTimeLineRepositoryAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_SocialTimeLineRepositoryAPIImpl();
      }
    });
    class org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl extends AbstractRpcProxy implements OrganizationalUnitService { public OrganizationalUnit getOrganizationalUnit(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("getOrganizationalUnit:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(OrganizationalUnit.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("getOrganizationalUnit:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(OrganizationalUnit.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getOrganizationalUnits() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("getOrganizationalUnits:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("getOrganizationalUnits:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public OrganizationalUnit createOrganizationalUnit(final String a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("createOrganizationalUnit:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(OrganizationalUnit.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("createOrganizationalUnit:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(OrganizationalUnit.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public OrganizationalUnit createOrganizationalUnit(final String a0, final String a1, final String a2, final Collection a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("createOrganizationalUnit:java.lang.String:java.lang.String:java.lang.String:java.util.Collection:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(OrganizationalUnit.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("createOrganizationalUnit:java.lang.String:java.lang.String:java.lang.String:java.util.Collection:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(OrganizationalUnit.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public OrganizationalUnit updateOrganizationalUnit(final String a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("updateOrganizationalUnit:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(OrganizationalUnit.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("updateOrganizationalUnit:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(OrganizationalUnit.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void addRepository(final OrganizationalUnit a0, final Repository a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("addRepository:org.guvnor.structure.organizationalunit.OrganizationalUnit:org.guvnor.structure.repositories.Repository:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("addRepository:org.guvnor.structure.organizationalunit.OrganizationalUnit:org.guvnor.structure.repositories.Repository:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
      }

      public void removeRepository(final OrganizationalUnit a0, final Repository a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("removeRepository:org.guvnor.structure.organizationalunit.OrganizationalUnit:org.guvnor.structure.repositories.Repository:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("removeRepository:org.guvnor.structure.organizationalunit.OrganizationalUnit:org.guvnor.structure.repositories.Repository:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
      }

      public void addGroup(final OrganizationalUnit a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("addGroup:org.guvnor.structure.organizationalunit.OrganizationalUnit:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("addGroup:org.guvnor.structure.organizationalunit.OrganizationalUnit:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
      }

      public void removeGroup(final OrganizationalUnit a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("removeGroup:org.guvnor.structure.organizationalunit.OrganizationalUnit:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("removeGroup:org.guvnor.structure.organizationalunit.OrganizationalUnit:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
      }

      public void removeOrganizationalUnit(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("removeOrganizationalUnit:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("removeOrganizationalUnit:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
      }

      public OrganizationalUnit getParentOrganizationalUnit(final Repository a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("getParentOrganizationalUnit:org.guvnor.structure.repositories.Repository:", qualifiers, new Object[] { a0 }).respondTo(OrganizationalUnit.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("getParentOrganizationalUnit:org.guvnor.structure.repositories.Repository:", qualifiers, new Object[] { a0 }).respondTo(OrganizationalUnit.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String getSanitizedDefaultGroupId(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("getSanitizedDefaultGroupId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("getSanitizedDefaultGroupId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Boolean isValidGroupId(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("isValidGroupId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.organizationalunit.OrganizationalUnitService").endpoint("isValidGroupId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(OrganizationalUnitService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_structure_organizationalunit_OrganizationalUnitServiceImpl();
      }
    });
    class org_guvnor_common_services_shared_metadata_MetadataServiceImpl extends AbstractRpcProxy implements MetadataService { public Metadata getMetadata(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.metadata.MetadataService").endpoint("getMetadata:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Metadata.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.metadata.MetadataService").endpoint("getMetadata:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Metadata.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_metadata_MetadataServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getTags(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.metadata.MetadataService").endpoint("getTags:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.metadata.MetadataService").endpoint("getTags:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_metadata_MetadataServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map configAttrs(final Map a0, final Metadata a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.metadata.MetadataService").endpoint("configAttrs:java.util.Map:org.guvnor.common.services.shared.metadata.model.Metadata:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.metadata.MetadataService").endpoint("configAttrs:java.util.Map:org.guvnor.common.services.shared.metadata.model.Metadata:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_metadata_MetadataServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map setUpAttributes(final Path a0, final Metadata a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.metadata.MetadataService").endpoint("setUpAttributes:org.uberfire.backend.vfs.Path:org.guvnor.common.services.shared.metadata.model.Metadata:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.metadata.MetadataService").endpoint("setUpAttributes:org.uberfire.backend.vfs.Path:org.guvnor.common.services.shared.metadata.model.Metadata:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_metadata_MetadataServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(MetadataService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_shared_metadata_MetadataServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_social_hp_service_RepositoryListServiceImpl extends AbstractRpcProxy implements RepositoryListService { public List getRepositories() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.social.hp.service.RepositoryListService").endpoint("getRepositories:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.social.hp.service.RepositoryListService").endpoint("getRepositories:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_social_hp_service_RepositoryListServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RepositoryListService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_social_hp_service_RepositoryListServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_defaulteditor_service_DefaultEditorServiceImpl extends AbstractRpcProxy implements DefaultEditorService { public DefaultEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.defaulteditor.service.DefaultEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DefaultEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.defaulteditor.service.DefaultEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DefaultEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_defaulteditor_service_DefaultEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final String a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.defaulteditor.service.DefaultEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.defaulteditor.service.DefaultEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_defaulteditor_service_DefaultEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DefaultEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_defaulteditor_service_DefaultEditorServiceImpl();
      }
    });
    class org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl extends AbstractRpcProxy implements GuidedDecisionTableEditorService { public GuidedDecisionTableEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedDecisionTableEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedDecisionTableEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PackageDataModelOracleBaselinePayload loadDataModel(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("loadDataModel:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PackageDataModelOracleBaselinePayload.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("loadDataModel:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PackageDataModelOracleBaselinePayload.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String toSource(final Path a0, final GuidedDecisionTable52 a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final GuidedDecisionTable52 a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final GuidedDecisionTable52 a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GuidedDecisionTable52 load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedDecisionTable52.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedDecisionTable52.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final GuidedDecisionTable52 a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtable.service.GuidedDecisionTableEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GuidedDecisionTableEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_guided_dtable_service_GuidedDecisionTableEditorServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_projecteditor_service_PomEditorServiceImpl extends AbstractRpcProxy implements PomEditorService { public DefaultEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.PomEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DefaultEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.PomEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DefaultEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_projecteditor_service_PomEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final String a1, final Metadata a2, final String a3, final DeploymentMode a4) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.PomEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.PomEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_projecteditor_service_PomEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(PomEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_projecteditor_service_PomEditorServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_server_management_service_RuntimeManagementServiceImpl extends AbstractRpcProxy implements RuntimeManagementService { public Collection getServerInstances(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuntimeManagementService").endpoint("getServerInstances:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuntimeManagementService").endpoint("getServerInstances:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_RuntimeManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getContainersByServerInstance(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuntimeManagementService").endpoint("getContainersByServerInstance:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuntimeManagementService").endpoint("getContainersByServerInstance:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_RuntimeManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ContainerSpecData getContainersByContainerSpec(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuntimeManagementService").endpoint("getContainersByContainerSpec:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(ContainerSpecData.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuntimeManagementService").endpoint("getContainersByContainerSpec:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(ContainerSpecData.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_RuntimeManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RuntimeManagementService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_server_management_service_RuntimeManagementServiceImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_SocialUserTimelinePagedRepositoryAPIImpl extends AbstractRpcProxy implements SocialUserTimelinePagedRepositoryAPI { public PagedSocialQuery getUserTimeline(final SocialUser a0, final SocialPaged a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserTimelinePagedRepositoryAPI").endpoint("getUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:org.kie.uberfire.social.activities.model.SocialPaged:", qualifiers, new Object[] { a0, a1 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserTimelinePagedRepositoryAPI").endpoint("getUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:org.kie.uberfire.social.activities.model.SocialPaged:", qualifiers, new Object[] { a0, a1 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialUserTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PagedSocialQuery getUserTimeline(final SocialUser a0, final SocialPaged a1, final SocialPredicate a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserTimelinePagedRepositoryAPI").endpoint("getUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:org.kie.uberfire.social.activities.model.SocialPaged:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserTimelinePagedRepositoryAPI").endpoint("getUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:org.kie.uberfire.social.activities.model.SocialPaged:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialUserTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PagedSocialQuery getUserTimeline(final SocialUser a0, final SocialPaged a1, final Map a2, final SocialPredicate a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserTimelinePagedRepositoryAPI").endpoint("getUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:org.kie.uberfire.social.activities.model.SocialPaged:java.util.Map:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserTimelinePagedRepositoryAPI").endpoint("getUserTimeline:org.kie.uberfire.social.activities.model.SocialUser:org.kie.uberfire.social.activities.model.SocialPaged:java.util.Map:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialUserTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialUserTimelinePagedRepositoryAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_SocialUserTimelinePagedRepositoryAPIImpl();
      }
    });
    class org_kie_workbench_common_screens_projecteditor_service_ProjectScreenServiceImpl extends AbstractRpcProxy implements ProjectScreenService { public ProjectScreenModel load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectScreenModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectScreenModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_projecteditor_service_ProjectScreenServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void save(final Path a0, final ProjectScreenModel a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.projecteditor.model.ProjectScreenModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.projecteditor.model.ProjectScreenModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_projecteditor_service_ProjectScreenServiceImpl.this.sendRequest(bus, sendable);
      }

      public void save(final Path a0, final ProjectScreenModel a1, final String a2, final DeploymentMode a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.projecteditor.model.ProjectScreenModel:java.lang.String:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.projecteditor.model.ProjectScreenModel:java.lang.String:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_projecteditor_service_ProjectScreenServiceImpl.this.sendRequest(bus, sendable);
      }

      public ProjectScreenModel rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(ProjectScreenModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(ProjectScreenModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_projecteditor_service_ProjectScreenServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_projecteditor_service_ProjectScreenServiceImpl.this.sendRequest(bus, sendable);
      }

      public void copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.projecteditor.service.ProjectScreenService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_projecteditor_service_ProjectScreenServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ProjectScreenService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_projecteditor_service_ProjectScreenServiceImpl();
      }
    });
    class org_jbpm_console_ng_ga_forms_service_PlaceManagerActivityServiceImpl extends AbstractRpcProxy implements PlaceManagerActivityService { public void initActivities(final List a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.forms.service.PlaceManagerActivityService").endpoint("initActivities:java.util.List:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.forms.service.PlaceManagerActivityService").endpoint("initActivities:java.util.List:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ga_forms_service_PlaceManagerActivityServiceImpl.this.sendRequest(bus, sendable);
      }

      public List getAllActivities() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.forms.service.PlaceManagerActivityService").endpoint("getAllActivities:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ga.forms.service.PlaceManagerActivityService").endpoint("getAllActivities:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ga_forms_service_PlaceManagerActivityServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(PlaceManagerActivityService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ga_forms_service_PlaceManagerActivityServiceImpl();
      }
    });
    class org_uberfire_ext_services_shared_preferences_UserPreferencesServiceImpl extends AbstractRpcProxy implements UserPreferencesService { public void saveUserPreferences(final UserPreference a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.services.shared.preferences.UserPreferencesService").endpoint("saveUserPreferences:org.uberfire.ext.services.shared.preferences.UserPreference:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.services.shared.preferences.UserPreferencesService").endpoint("saveUserPreferences:org.uberfire.ext.services.shared.preferences.UserPreference:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_services_shared_preferences_UserPreferencesServiceImpl.this.sendRequest(bus, sendable);
      }

      public UserPreference loadUserPreferences(final String a0, final UserPreferencesType a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.services.shared.preferences.UserPreferencesService").endpoint("loadUserPreferences:java.lang.String:org.uberfire.ext.services.shared.preferences.UserPreferencesType:", qualifiers, new Object[] { a0, a1 }).respondTo(UserPreference.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.services.shared.preferences.UserPreferencesService").endpoint("loadUserPreferences:java.lang.String:org.uberfire.ext.services.shared.preferences.UserPreferencesType:", qualifiers, new Object[] { a0, a1 }).respondTo(UserPreference.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_services_shared_preferences_UserPreferencesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public UserPreference loadUserPreferences(final UserPreference a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.services.shared.preferences.UserPreferencesService").endpoint("loadUserPreferences:org.uberfire.ext.services.shared.preferences.UserPreference:", qualifiers, new Object[] { a0 }).respondTo(UserPreference.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.services.shared.preferences.UserPreferencesService").endpoint("loadUserPreferences:org.uberfire.ext.services.shared.preferences.UserPreference:", qualifiers, new Object[] { a0 }).respondTo(UserPreference.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_services_shared_preferences_UserPreferencesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(UserPreferencesService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_services_shared_preferences_UserPreferencesServiceImpl();
      }
    });
    class org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl extends AbstractRpcProxy implements DRLTextEditorService { public DrlModelContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DrlModelContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DrlModelContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List loadClassFields(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("loadClassFields:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("loadClassFields:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String assertPackageName(final String a0, final Path a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("assertPackageName:java.lang.String:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("assertPackageName:java.lang.String:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final String a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final String a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.drltext.service.DRLTextEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DRLTextEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_drltext_service_DRLTextEditorServiceImpl();
      }
    });
    class org_guvnor_common_services_project_service_ProjectRepositoryResolverImpl extends AbstractRpcProxy implements ProjectRepositoryResolver { public Set getRemoteRepositoriesMetaData() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRemoteRepositoriesMetaData:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRemoteRepositoriesMetaData:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectRepositoryResolverImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set getRemoteRepositoriesMetaData(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRemoteRepositoriesMetaData:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRemoteRepositoriesMetaData:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectRepositoryResolverImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set getRepositoriesResolvingArtifact(final GAV a0, final MavenRepositoryMetadata[] a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRepositoriesResolvingArtifact:org.guvnor.common.services.project.model.GAV:org.guvnor.common.services.project.model.MavenRepositoryMetadata[]:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRepositoriesResolvingArtifact:org.guvnor.common.services.project.model.GAV:org.guvnor.common.services.project.model.MavenRepositoryMetadata[]:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectRepositoryResolverImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set getRepositoriesResolvingArtifact(final GAV a0, final Project a1, final MavenRepositoryMetadata[] a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRepositoriesResolvingArtifact:org.guvnor.common.services.project.model.GAV:org.guvnor.common.services.project.model.Project:org.guvnor.common.services.project.model.MavenRepositoryMetadata[]:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRepositoriesResolvingArtifact:org.guvnor.common.services.project.model.GAV:org.guvnor.common.services.project.model.Project:org.guvnor.common.services.project.model.MavenRepositoryMetadata[]:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectRepositoryResolverImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set getRepositoriesResolvingArtifact(final String a0, final MavenRepositoryMetadata[] a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRepositoriesResolvingArtifact:java.lang.String:org.guvnor.common.services.project.model.MavenRepositoryMetadata[]:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoryResolver").endpoint("getRepositoriesResolvingArtifact:java.lang.String:org.guvnor.common.services.project.model.MavenRepositoryMetadata[]:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectRepositoryResolverImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ProjectRepositoryResolver.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_project_service_ProjectRepositoryResolverImpl();
      }
    });
    class org_guvnor_asset_management_service_AssetManagementServiceImpl extends AbstractRpcProxy implements AssetManagementService { public void configureRepository(final String a0, final String a1, final String a2, final String a3, final String a4) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("configureRepository:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("configureRepository:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_AssetManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void buildProject(final String a0, final String a1, final String a2, final String a3, final String a4, final String a5, final Boolean a6) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("buildProject:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.Boolean:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("buildProject:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.Boolean:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_AssetManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void promoteChanges(final String a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("promoteChanges:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("promoteChanges:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_AssetManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void releaseProject(final String a0, final String a1, final String a2, final String a3, final String a4, final Boolean a5, final String a6) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("releaseProject:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.Boolean:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("releaseProject:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.String:java.lang.Boolean:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_AssetManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public boolean supportRuntimeDeployment() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("supportRuntimeDeployment:", qualifiers, new Object[] { }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("supportRuntimeDeployment:", qualifiers, new Object[] { }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_AssetManagementServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Set getProjects(final Repository a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("getProjects:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.AssetManagementService").endpoint("getProjects:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_AssetManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(AssetManagementService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_asset_management_service_AssetManagementServiceImpl();
      }
    });
    class org_guvnor_common_services_project_service_ProjectServiceImpl extends AbstractRpcProxy implements ProjectService { public Project resolveProject(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Project resolveParentProject(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveParentProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveParentProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Project resolveToParentProject(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveToParentProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveToParentProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set resolvePackages(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolvePackages:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolvePackages:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set resolvePackages(final Package a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolvePackages:org.guvnor.common.services.project.model.Package:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolvePackages:org.guvnor.common.services.project.model.Package:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Package resolveDefaultPackage(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveDefaultPackage:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveDefaultPackage:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Package resolveParentPackage(final Package a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveParentPackage:org.guvnor.common.services.project.model.Package:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolveParentPackage:org.guvnor.common.services.project.model.Package:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean isPom(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("isPom:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("isPom:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Package resolvePackage(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolvePackage:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("resolvePackage:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public WorkingSetSettings loadWorkingSetConfig(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("loadWorkingSetConfig:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(WorkingSetSettings.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("loadWorkingSetConfig:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(WorkingSetSettings.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set getProjects(final Repository a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("getProjects:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("getProjects:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Project newProject(final Path a0, final POM a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("newProject:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Project.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("newProject:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Project.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Project newProject(final Path a0, final POM a1, final String a2, final DeploymentMode a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("newProject:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:java.lang.String:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Project.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("newProject:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:java.lang.String:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Project.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Package newPackage(final Package a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("newPackage:org.guvnor.common.services.project.model.Package:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("newPackage:org.guvnor.common.services.project.model.Package:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void addGroup(final Project a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("addGroup:org.guvnor.common.services.project.model.Project:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("addGroup:org.guvnor.common.services.project.model.Project:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
      }

      public void removeGroup(final Project a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("removeGroup:org.guvnor.common.services.project.model.Project:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("removeGroup:org.guvnor.common.services.project.model.Project:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
      }

      public void copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ProjectService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_project_service_ProjectServiceImpl();
      }
    });
    class org_guvnor_common_services_project_service_ProjectRepositoriesServiceImpl extends AbstractRpcProxy implements ProjectRepositoriesService { public ProjectRepositories create(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoriesService").endpoint("create:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectRepositories.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoriesService").endpoint("create:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectRepositories.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectRepositoriesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final ProjectRepositories a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoriesService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.ProjectRepositories:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoriesService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.ProjectRepositories:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectRepositoriesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ProjectRepositories load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoriesService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectRepositories.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.ProjectRepositoriesService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectRepositories.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_ProjectRepositoriesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ProjectRepositoriesService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_project_service_ProjectRepositoriesServiceImpl();
      }
    });
    class org_guvnor_common_services_shared_security_KieWorkbenchSecurityServiceImpl extends AbstractRpcProxy implements KieWorkbenchSecurityService { public String loadPolicy() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.security.KieWorkbenchSecurityService").endpoint("loadPolicy:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.security.KieWorkbenchSecurityService").endpoint("loadPolicy:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_security_KieWorkbenchSecurityServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(KieWorkbenchSecurityService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_shared_security_KieWorkbenchSecurityServiceImpl();
      }
    });
    class org_jbpm_formModeler_renderer_service_FormRendererIncluderServiceImpl extends AbstractRpcProxy implements FormRendererIncluderService { public FormRenderContextTO launchTest() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRendererIncluderService").endpoint("launchTest:", qualifiers, new Object[] { }).respondTo(FormRenderContextTO.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRendererIncluderService").endpoint("launchTest:", qualifiers, new Object[] { }).respondTo(FormRenderContextTO.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_renderer_service_FormRendererIncluderServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Boolean persistContext(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRendererIncluderService").endpoint("persistContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRendererIncluderService").endpoint("persistContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_renderer_service_FormRendererIncluderServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Boolean clearContext(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRendererIncluderService").endpoint("clearContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRendererIncluderService").endpoint("clearContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_renderer_service_FormRendererIncluderServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(FormRendererIncluderService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_formModeler_renderer_service_FormRendererIncluderServiceImpl();
      }
    });
    class org_kie_workbench_common_services_shared_dependencies_DependencyServiceImpl extends AbstractRpcProxy implements DependencyService { public Collection loadDependencies(final Collection a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.dependencies.DependencyService").endpoint("loadDependencies:java.util.Collection:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.dependencies.DependencyService").endpoint("loadDependencies:java.util.Collection:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_dependencies_DependencyServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection loadDependencies(final GAV a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.dependencies.DependencyService").endpoint("loadDependencies:org.guvnor.common.services.project.model.GAV:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.dependencies.DependencyService").endpoint("loadDependencies:org.guvnor.common.services.project.model.GAV:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_dependencies_DependencyServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set loadPackageNames(final GAV a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.dependencies.DependencyService").endpoint("loadPackageNames:org.guvnor.common.services.project.model.GAV:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.dependencies.DependencyService").endpoint("loadPackageNames:org.guvnor.common.services.project.model.GAV:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_dependencies_DependencyServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public EnhancedDependencies loadEnhancedDependencies(final Collection a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.dependencies.DependencyService").endpoint("loadEnhancedDependencies:java.util.Collection:", qualifiers, new Object[] { a0 }).respondTo(EnhancedDependencies.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.dependencies.DependencyService").endpoint("loadEnhancedDependencies:java.util.Collection:", qualifiers, new Object[] { a0 }).respondTo(EnhancedDependencies.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_dependencies_DependencyServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DependencyService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_dependencies_DependencyServiceImpl();
      }
    });
    class org_jbpm_console_ng_pr_service_ProcessVariablesServiceImpl extends AbstractRpcProxy implements ProcessVariablesService { public PageResponse getData(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessVariablesService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessVariablesService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessVariablesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ProcessVariableSummary getItem(final ProcessVariableKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessVariablesService").endpoint("getItem:org.jbpm.console.ng.pr.model.ProcessVariableKey:", qualifiers, new Object[] { a0 }).respondTo(ProcessVariableSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessVariablesService").endpoint("getItem:org.jbpm.console.ng.pr.model.ProcessVariableKey:", qualifiers, new Object[] { a0 }).respondTo(ProcessVariableSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessVariablesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAll(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessVariablesService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessVariablesService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessVariablesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ProcessVariablesService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_pr_service_ProcessVariablesServiceImpl();
      }
    });
    class org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl extends AbstractRpcProxy implements DataServiceEntryPoint { public Map getServiceTasks(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getServiceTasks:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getServiceTasks:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstances() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstances:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstances:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstances(final List a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstances:java.util.List:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstances:java.util.List:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstancesByDeploymentId(final String a0, final List a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstancesByDeploymentId:java.lang.String:java.util.List:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstancesByDeploymentId:java.lang.String:java.util.List:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessesByFilter(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessesByFilter:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessesByFilter:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ProcessInstanceSummary getProcessInstanceById(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceById:long:", qualifiers, new Object[] { a0 }).respondTo(ProcessInstanceSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceById:long:", qualifiers, new Object[] { a0 }).respondTo(ProcessInstanceSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ProcessSummary getProcessById(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessById:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(ProcessSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessById:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(ProcessSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstancesByProcessDefinition(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstancesByProcessDefinition:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstancesByProcessDefinition:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstanceHistory(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceHistory:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceHistory:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstanceHistory(final long a0, final boolean a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceHistory:long:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceHistory:long:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstanceFullHistory(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceFullHistory:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceFullHistory:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstanceActiveNodes(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceActiveNodes:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceActiveNodes:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getProcessInstanceCompletedNodes(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceCompletedNodes:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessInstanceCompletedNodes:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getVariableHistory(final long a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getVariableHistory:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getVariableHistory:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getReusableSubProcesses(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getReusableSubProcesses:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getReusableSubProcesses:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map getRequiredInputData(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getRequiredInputData:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getRequiredInputData:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getAllTasksDef(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getAllTasksDef:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getAllTasksDef:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map getAssociatedEntities(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getAssociatedEntities:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getAssociatedEntities:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ProcessSummary getProcessDesc(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessDesc:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(ProcessSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getProcessDesc:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(ProcessSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getVariablesCurrentState(final long a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getVariablesCurrentState:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getVariablesCurrentState:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map getTaskInputMappings(final String a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getTaskInputMappings:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getTaskInputMappings:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map getTaskOutputMappings(final String a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getTaskOutputMappings:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getTaskOutputMappings:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getAllRuntimeLogs(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getAllRuntimeLogs:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getAllRuntimeLogs:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getBusinessLogs(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getBusinessLogs:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DataServiceEntryPoint").endpoint("getBusinessLogs:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DataServiceEntryPoint.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_bd_service_DataServiceEntryPointImpl();
      }
    });
    class org_dashbuilder_dataset_service_DataSetLookupServicesImpl extends AbstractRpcProxy implements DataSetLookupServices { public DataSet lookupDataSet(final DataSetLookup a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetLookupServices").endpoint("lookupDataSet:org.dashbuilder.dataset.DataSetLookup:", qualifiers, new Object[] { a0 }).respondTo(DataSet.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetLookupServices").endpoint("lookupDataSet:org.dashbuilder.dataset.DataSetLookup:", qualifiers, new Object[] { a0 }).respondTo(DataSet.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetLookupServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DataSet lookupDataSet(final DataSetDef a0, final DataSetLookup a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetLookupServices").endpoint("lookupDataSet:org.dashbuilder.dataset.def.DataSetDef:org.dashbuilder.dataset.DataSetLookup:", qualifiers, new Object[] { a0, a1 }).respondTo(DataSet.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetLookupServices").endpoint("lookupDataSet:org.dashbuilder.dataset.def.DataSetDef:org.dashbuilder.dataset.DataSetLookup:", qualifiers, new Object[] { a0, a1 }).respondTo(DataSet.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetLookupServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DataSetMetadata lookupDataSetMetadata(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetLookupServices").endpoint("lookupDataSetMetadata:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(DataSetMetadata.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetLookupServices").endpoint("lookupDataSetMetadata:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(DataSetMetadata.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetLookupServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DataSetLookupServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_dashbuilder_dataset_service_DataSetLookupServicesImpl();
      }
    });
    class org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl extends AbstractRpcProxy implements SolverEditorService { public SolverModelContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(SolverModelContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(SolverModelContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final SolverConfigModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.optaplanner.workbench.screens.solver.model.SolverConfigModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.optaplanner.workbench.screens.solver.model.SolverConfigModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String toSource(final Path a0, final SolverConfigModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.optaplanner.workbench.screens.solver.model.SolverConfigModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.optaplanner.workbench.screens.solver.model.SolverConfigModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final SolverConfigModel a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.optaplanner.workbench.screens.solver.model.SolverConfigModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.optaplanner.workbench.screens.solver.model.SolverConfigModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public SolverConfigModel load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(SolverConfigModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(SolverConfigModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final SolverConfigModel a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.optaplanner.workbench.screens.solver.model.SolverConfigModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.optaplanner.workbench.screens.solver.model.SolverConfigModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.optaplanner.workbench.screens.solver.service.SolverEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SolverEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_optaplanner_workbench_screens_solver_service_SolverEditorServiceImpl();
      }
    });
    class org_guvnor_common_services_shared_test_TestServiceImpl extends AbstractRpcProxy implements TestService { public void runAllTests(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.test.TestService").endpoint("runAllTests:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.test.TestService").endpoint("runAllTests:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_test_TestServiceImpl.this.sendRequest(bus, sendable);
      }

      public void runAllTests(final Path a0, final Event a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.test.TestService").endpoint("runAllTests:org.uberfire.backend.vfs.Path:javax.enterprise.event.Event:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.test.TestService").endpoint("runAllTests:org.uberfire.backend.vfs.Path:javax.enterprise.event.Event:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_test_TestServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(TestService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_shared_test_TestServiceImpl();
      }
    });
    class org_jbpm_designer_service_DesignerAssetServiceImpl extends AbstractRpcProxy implements DesignerAssetService { public DesignerContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DesignerContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DesignerContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_designer_service_DesignerAssetServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void updateMetadata(final Path a0, final Metadata a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("updateMetadata:org.uberfire.backend.vfs.Path:org.guvnor.common.services.shared.metadata.model.Metadata:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("updateMetadata:org.uberfire.backend.vfs.Path:org.guvnor.common.services.shared.metadata.model.Metadata:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_designer_service_DesignerAssetServiceImpl.this.sendRequest(bus, sendable);
      }

      public Map getEditorParameters(final Path a0, final String a1, final String a2, final PlaceRequest a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("getEditorParameters:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:org.uberfire.mvp.PlaceRequest:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("getEditorParameters:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:org.uberfire.mvp.PlaceRequest:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_designer_service_DesignerAssetServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String getEditorID() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("getEditorID:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("getEditorID:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_designer_service_DesignerAssetServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createProcess(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("createProcess:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.designer.service.DesignerAssetService").endpoint("createProcess:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_designer_service_DesignerAssetServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DesignerAssetService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_designer_service_DesignerAssetServiceImpl();
      }
    });
    class org_dashbuilder_dataset_service_DataSetExportServicesImpl extends AbstractRpcProxy implements DataSetExportServices { public Path exportDataSetCSV(final DataSetLookup a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetExportServices").endpoint("exportDataSetCSV:org.dashbuilder.dataset.DataSetLookup:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetExportServices").endpoint("exportDataSetCSV:org.dashbuilder.dataset.DataSetLookup:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetExportServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path exportDataSetCSV(final DataSet a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetExportServices").endpoint("exportDataSetCSV:org.dashbuilder.dataset.DataSet:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetExportServices").endpoint("exportDataSetCSV:org.dashbuilder.dataset.DataSet:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetExportServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path exportDataSetExcel(final DataSetLookup a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetExportServices").endpoint("exportDataSetExcel:org.dashbuilder.dataset.DataSetLookup:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetExportServices").endpoint("exportDataSetExcel:org.dashbuilder.dataset.DataSetLookup:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetExportServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path exportDataSetExcel(final DataSet a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetExportServices").endpoint("exportDataSetExcel:org.dashbuilder.dataset.DataSet:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetExportServices").endpoint("exportDataSetExcel:org.dashbuilder.dataset.DataSet:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetExportServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DataSetExportServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_dashbuilder_dataset_service_DataSetExportServicesImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_SocialUserServiceAPIImpl extends AbstractRpcProxy implements SocialUserServiceAPI { public void userFollowAnotherUser(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserServiceAPI").endpoint("userFollowAnotherUser:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserServiceAPI").endpoint("userFollowAnotherUser:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialUserServiceAPIImpl.this.sendRequest(bus, sendable);
      }

      public void userUnfollowAnotherUser(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserServiceAPI").endpoint("userUnfollowAnotherUser:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserServiceAPI").endpoint("userUnfollowAnotherUser:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialUserServiceAPIImpl.this.sendRequest(bus, sendable);
      }

      public void update(final SocialUser[] a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserServiceAPI").endpoint("update:org.kie.uberfire.social.activities.model.SocialUser[]:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserServiceAPI").endpoint("update:org.kie.uberfire.social.activities.model.SocialUser[]:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialUserServiceAPIImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialUserServiceAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_SocialUserServiceAPIImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_SocialTimelineRulesQueryAPIImpl extends AbstractRpcProxy implements SocialTimelineRulesQueryAPI { public List executeAllRules() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("executeAllRules:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("executeAllRules:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimelineRulesQueryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List executeSpecificRule(final Map a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("executeSpecificRule:java.util.Map:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("executeSpecificRule:java.util.Map:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimelineRulesQueryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAllCached() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("getAllCached:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("getAllCached:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimelineRulesQueryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getTypeCached(final String[] a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("getTypeCached:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("getTypeCached:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimelineRulesQueryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getNEventsFromEachType(final int a0, final String[] a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("getNEventsFromEachType:int:java.lang.String[]:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTimelineRulesQueryAPI").endpoint("getNEventsFromEachType:int:java.lang.String[]:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTimelineRulesQueryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialTimelineRulesQueryAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_SocialTimelineRulesQueryAPIImpl();
      }
    });
    class org_guvnor_structure_navigator_FileNavigatorServiceImpl extends AbstractRpcProxy implements FileNavigatorService { public NavigatorContent listContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.navigator.FileNavigatorService").endpoint("listContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(NavigatorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.navigator.FileNavigatorService").endpoint("listContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(NavigatorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_navigator_FileNavigatorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List listRepositories() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.navigator.FileNavigatorService").endpoint("listRepositories:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.navigator.FileNavigatorService").endpoint("listRepositories:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_navigator_FileNavigatorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(FileNavigatorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_structure_navigator_FileNavigatorServiceImpl();
      }
    });
    class org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl extends AbstractRpcProxy implements GlobalsEditorService { public GlobalsEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GlobalsEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GlobalsEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String toSource(final Path a0, final GlobalsModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.screens.globals.model.GlobalsModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.screens.globals.model.GlobalsModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final GlobalsModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.screens.globals.model.GlobalsModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.screens.globals.model.GlobalsModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final GlobalsModel a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.screens.globals.model.GlobalsModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.screens.globals.model.GlobalsModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GlobalsModel load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GlobalsModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GlobalsModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final GlobalsModel a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.screens.globals.model.GlobalsModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.screens.globals.model.GlobalsModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.globals.service.GlobalsEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GlobalsEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_globals_service_GlobalsEditorServiceImpl();
      }
    });
    class org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl extends AbstractRpcProxy implements GuidedDecisionTreeEditorService { public GuidedDecisionTreeEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedDecisionTreeEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedDecisionTreeEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PackageDataModelOracleBaselinePayload loadDataModel(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("loadDataModel:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PackageDataModelOracleBaselinePayload.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("loadDataModel:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PackageDataModelOracleBaselinePayload.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String toSource(final Path a0, final GuidedDecisionTree a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final GuidedDecisionTree a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final GuidedDecisionTree a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GuidedDecisionTree load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedDecisionTree.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedDecisionTree.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final GuidedDecisionTree a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.dtree.shared.model.GuidedDecisionTree:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.dtree.service.GuidedDecisionTreeEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GuidedDecisionTreeEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_guided_dtree_service_GuidedDecisionTreeEditorServiceImpl();
      }
    });
    class org_uberfire_ext_security_management_api_service_RoleManagerServiceImpl extends AbstractRpcProxy implements RoleManagerService { public SearchResponse search(final SearchRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("search:org.uberfire.ext.security.management.api.AbstractEntityManager.SearchRequest:", qualifiers, new Object[] { a0 }).respondTo(SearchResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("search:org.uberfire.ext.security.management.api.AbstractEntityManager.SearchRequest:", qualifiers, new Object[] { a0 }).respondTo(SearchResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_RoleManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Role get(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Role.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Role.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_RoleManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Role create(final Role a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("create:org.jboss.errai.security.shared.api.Role:", qualifiers, new Object[] { a0 }).respondTo(Role.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("create:org.jboss.errai.security.shared.api.Role:", qualifiers, new Object[] { a0 }).respondTo(Role.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_RoleManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Role update(final Role a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("update:org.jboss.errai.security.shared.api.Role:", qualifiers, new Object[] { a0 }).respondTo(Role.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("update:org.jboss.errai.security.shared.api.Role:", qualifiers, new Object[] { a0 }).respondTo(Role.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_RoleManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final String[] a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("delete:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("delete:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_RoleManagerServiceImpl.this.sendRequest(bus, sendable);
      }

      public RoleManagerSettings getSettings() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("getSettings:", qualifiers, new Object[] { }).respondTo(RoleManagerSettings.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.RoleManagerService").endpoint("getSettings:", qualifiers, new Object[] { }).respondTo(RoleManagerSettings.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_RoleManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RoleManagerService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_security_management_api_service_RoleManagerServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorEditorServiceImpl extends AbstractRpcProxy implements PersistenceDescriptorEditorService { public PersistenceDescriptorEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PersistenceDescriptorEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PersistenceDescriptorEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PersistenceDescriptorEditorContent loadContent(final Path a0, final boolean a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(PersistenceDescriptorEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(PersistenceDescriptorEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final PersistenceDescriptorEditorContent a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorEditorContent:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.datamodeller.service.PersistenceDescriptorEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.screens.datamodeller.model.persistence.PersistenceDescriptorEditorContent:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(PersistenceDescriptorEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_datamodeller_service_PersistenceDescriptorEditorServiceImpl();
      }
    });
    class org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl extends AbstractRpcProxy implements GuidedRuleEditorService { public GuidedEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String toSource(final Path a0, final RuleModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.datamodel.rule.RuleModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.datamodel.rule.RuleModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final RuleModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.datamodel.rule.RuleModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.datamodel.rule.RuleModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final RuleModel a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.datamodel.rule.RuleModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.datamodel.rule.RuleModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public RuleModel load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(RuleModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(RuleModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final RuleModel a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.datamodel.rule.RuleModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.datamodel.rule.RuleModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.rule.service.GuidedRuleEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GuidedRuleEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_guided_rule_service_GuidedRuleEditorServiceImpl();
      }
    });
    class org_kie_workbench_common_services_shared_security_KieWorkbenchSecurityServiceImpl extends AbstractRpcProxy implements org.kie.workbench.common.services.shared.security.KieWorkbenchSecurityService { public String loadPolicy() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.security.KieWorkbenchSecurityService").endpoint("loadPolicy:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.security.KieWorkbenchSecurityService").endpoint("loadPolicy:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_security_KieWorkbenchSecurityServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(org.kie.workbench.common.services.shared.security.KieWorkbenchSecurityService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_security_KieWorkbenchSecurityServiceImpl();
      }
    });
    class org_drools_workbench_screens_enums_service_EnumServiceImpl extends AbstractRpcProxy implements EnumService { public EnumModelContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(EnumModelContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(EnumModelContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean accepts(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("accepts:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("accepts:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public List validate(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("validate:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("validate:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("validate:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("validate:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final String a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final String a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.enums.service.EnumService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_enums_service_EnumServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(EnumService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_enums_service_EnumServiceImpl();
      }
    });
    class org_jboss_errai_security_shared_service_AuthenticationServiceImpl extends AbstractRpcProxy implements AuthenticationService { public User login(final String a0, final String a1) {
        try {
          final CallContextStatus status = new CallContextStatus(AuthenticationServiceInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "login";
            }
            public Class getReturnType() {
              return User.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("login:java.lang.String:java.lang.String:", qualifiers, getParameters()).respondTo(User.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("login:java.lang.String:java.lang.String:", qualifiers, getParameters()).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == AuthenticationServiceInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((AuthenticationServiceInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (AuthenticationServiceInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                org.jboss.errai.ioc.client.container.IOC.getAsyncBeanManager().lookupBeans(AuthenticationServiceInterceptor.class).iterator().next().getInstance(icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { a0, a1 });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
        return null;
      }

      public boolean isLoggedIn() {
        try {
          final CallContextStatus status = new CallContextStatus(AuthenticationServiceInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "isLoggedIn";
            }
            public Class getReturnType() {
              return boolean.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("isLoggedIn:", qualifiers, getParameters()).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("isLoggedIn:", qualifiers, getParameters()).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == AuthenticationServiceInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((AuthenticationServiceInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (AuthenticationServiceInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                org.jboss.errai.ioc.client.container.IOC.getAsyncBeanManager().lookupBeans(AuthenticationServiceInterceptor.class).iterator().next().getInstance(icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
        return false;
      }

      public void logout() {
        try {
          final CallContextStatus status = new CallContextStatus(AuthenticationServiceInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "logout";
            }
            public Class getReturnType() {
              return void.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("logout:", qualifiers, getParameters()).respondTo(void.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("logout:", qualifiers, getParameters()).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == AuthenticationServiceInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((AuthenticationServiceInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (AuthenticationServiceInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                org.jboss.errai.ioc.client.container.IOC.getAsyncBeanManager().lookupBeans(AuthenticationServiceInterceptor.class).iterator().next().getInstance(icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
      }

      public User getUser() {
        try {
          final CallContextStatus status = new CallContextStatus(AuthenticationServiceInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "getUser";
            }
            public Class getReturnType() {
              return User.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("getUser:", qualifiers, getParameters()).respondTo(User.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.AuthenticationService").endpoint("getUser:", qualifiers, getParameters()).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == AuthenticationServiceInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((AuthenticationServiceInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (AuthenticationServiceInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                org.jboss.errai.ioc.client.container.IOC.getAsyncBeanManager().lookupBeans(AuthenticationServiceInterceptor.class).iterator().next().getInstance(icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_jboss_errai_security_shared_service_AuthenticationServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(AuthenticationService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jboss_errai_security_shared_service_AuthenticationServiceImpl();
      }
    });
    class org_kie_workbench_common_services_shared_rulename_RuleNamesServiceImpl extends AbstractRpcProxy implements RuleNamesService { public Collection getRuleNames(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.rulename.RuleNamesService").endpoint("getRuleNames:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.rulename.RuleNamesService").endpoint("getRuleNames:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_rulename_RuleNamesServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RuleNamesService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_rulename_RuleNamesServiceImpl();
      }
    });
    class org_guvnor_inbox_service_InboxServiceImpl extends AbstractRpcProxy implements InboxService { public PageResponse loadInbox(final InboxPageRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.inbox.service.InboxService").endpoint("loadInbox:org.guvnor.inbox.model.InboxPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.inbox.service.InboxService").endpoint("loadInbox:org.guvnor.inbox.model.InboxPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_inbox_service_InboxServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(InboxService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_inbox_service_InboxServiceImpl();
      }
    });
    class org_dashbuilder_dataset_service_DataSetDefServicesImpl extends AbstractRpcProxy implements DataSetDefServices { public List getPublicDataSetDefs() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefServices").endpoint("getPublicDataSetDefs:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefServices").endpoint("getPublicDataSetDefs:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DataSetDef createDataSetDef(final DataSetProviderType a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefServices").endpoint("createDataSetDef:org.dashbuilder.dataprovider.DataSetProviderType:", qualifiers, new Object[] { a0 }).respondTo(DataSetDef.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefServices").endpoint("createDataSetDef:org.dashbuilder.dataprovider.DataSetProviderType:", qualifiers, new Object[] { a0 }).respondTo(DataSetDef.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String registerDataSetDef(final DataSetDef a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefServices").endpoint("registerDataSetDef:org.dashbuilder.dataset.def.DataSetDef:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefServices").endpoint("registerDataSetDef:org.dashbuilder.dataset.def.DataSetDef:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void removeDataSetDef(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefServices").endpoint("removeDataSetDef:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefServices").endpoint("removeDataSetDef:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefServicesImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DataSetDefServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_dashbuilder_dataset_service_DataSetDefServicesImpl();
      }
    });
    class org_uberfire_ext_editor_commons_service_RenameServiceImpl extends AbstractRpcProxy implements RenameService { public void renameIfExists(final Collection a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.RenameService").endpoint("renameIfExists:java.util.Collection:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.RenameService").endpoint("renameIfExists:java.util.Collection:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_RenameServiceImpl.this.sendRequest(bus, sendable);
      }

      public boolean hasRestriction(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.RenameService").endpoint("hasRestriction:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.RenameService").endpoint("hasRestriction:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_RenameServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.RenameService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.RenameService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_RenameServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RenameService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_editor_commons_service_RenameServiceImpl();
      }
    });
    class org_guvnor_common_services_project_service_POMServiceImpl extends AbstractRpcProxy implements POMService { public Path create(final Path a0, final String a1, final POM a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.POMService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.project.model.POM:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.POMService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.project.model.POM:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_POMServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final POM a1, final Metadata a2, final String a3, final boolean a4) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.POMService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:boolean:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.POMService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:boolean:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_POMServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public POM load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.POMService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(POM.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.POMService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(POM.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_POMServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final POM a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.POMService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.project.service.POMService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_project_service_POMServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(POMService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_project_service_POMServiceImpl();
      }
    });
    class org_uberfire_ext_layout_editor_api_LayoutServicesImpl extends AbstractRpcProxy implements LayoutServices { public String convertLayoutToString(final LayoutTemplate a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.layout.editor.api.LayoutServices").endpoint("convertLayoutToString:org.uberfire.ext.layout.editor.api.editor.LayoutTemplate:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.layout.editor.api.LayoutServices").endpoint("convertLayoutToString:org.uberfire.ext.layout.editor.api.editor.LayoutTemplate:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_layout_editor_api_LayoutServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public LayoutTemplate convertLayoutFromString(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.layout.editor.api.LayoutServices").endpoint("convertLayoutFromString:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(LayoutTemplate.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.layout.editor.api.LayoutServices").endpoint("convertLayoutFromString:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(LayoutTemplate.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_layout_editor_api_LayoutServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(LayoutServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_layout_editor_api_LayoutServicesImpl();
      }
    });
    class org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl extends AbstractRpcProxy implements GroupManagerService { public void assignUsers(final String a0, final Collection a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("assignUsers:java.lang.String:java.util.Collection:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("assignUsers:java.lang.String:java.util.Collection:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl.this.sendRequest(bus, sendable);
      }

      public SearchResponse search(final SearchRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("search:org.uberfire.ext.security.management.api.AbstractEntityManager.SearchRequest:", qualifiers, new Object[] { a0 }).respondTo(SearchResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("search:org.uberfire.ext.security.management.api.AbstractEntityManager.SearchRequest:", qualifiers, new Object[] { a0 }).respondTo(SearchResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Group get(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Group.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Group.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Group create(final Group a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("create:org.jboss.errai.security.shared.api.Group:", qualifiers, new Object[] { a0 }).respondTo(Group.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("create:org.jboss.errai.security.shared.api.Group:", qualifiers, new Object[] { a0 }).respondTo(Group.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Group update(final Group a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("update:org.jboss.errai.security.shared.api.Group:", qualifiers, new Object[] { a0 }).respondTo(Group.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("update:org.jboss.errai.security.shared.api.Group:", qualifiers, new Object[] { a0 }).respondTo(Group.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final String[] a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("delete:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("delete:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl.this.sendRequest(bus, sendable);
      }

      public GroupManagerSettings getSettings() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("getSettings:", qualifiers, new Object[] { }).respondTo(GroupManagerSettings.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.GroupManagerService").endpoint("getSettings:", qualifiers, new Object[] { }).respondTo(GroupManagerSettings.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GroupManagerService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_security_management_api_service_GroupManagerServiceImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_StressTestAPIImpl extends AbstractRpcProxy implements StressTestAPI { public int stress(final int a0, final int a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.StressTestAPI").endpoint("stress:int:int:", qualifiers, new Object[] { a0, a1 }).respondTo(Integer.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.StressTestAPI").endpoint("stress:int:int:", qualifiers, new Object[] { a0, a1 }).respondTo(Integer.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_StressTestAPIImpl.this.sendRequest(bus, sendable);
        return 0;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(StressTestAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_StressTestAPIImpl();
      }
    });
    class org_uberfire_backend_vfs_VFSServiceImpl extends AbstractRpcProxy implements VFSService { public Path get(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DirectoryStream newDirectoryStream(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DirectoryStream.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DirectoryStream.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DirectoryStream newDirectoryStream(final Path a0, final Filter a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.DirectoryStream.Filter:", qualifiers, new Object[] { a0, a1 }).respondTo(DirectoryStream.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("newDirectoryStream:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.DirectoryStream.Filter:", qualifiers, new Object[] { a0, a1 }).respondTo(DirectoryStream.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createDirectory(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createDirectory(final Path a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectory:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createDirectories(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path createDirectories(final Path a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("createDirectories:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map readAttributes(final Path a0) {
        try {
          final CallContextStatus status = new CallContextStatus(VFSCacheInterceptor.class);
          final RemoteCallContext callContext = new RemoteCallContext() {
            public String getMethodName() {
              return "readAttributes";
            }
            public Class getReturnType() {
              return Map.class;
            }
            public Annotation[] getAnnotations() {
              return new Annotation[] { new InterceptedCall() {
                  public Class annotationType() {
                    return InterceptedCall.class;
                  }
                  public String toString() {
                    return "@org.jboss.errai.common.client.api.interceptor.InterceptedCall(value=[class org.uberfire.backend.vfs.impl.VFSCacheInterceptor])";
                  }
                  public Class[] value() {
                    return new Class[] { VFSCacheInterceptor.class };
                  }
              } };
            }
            public Annotation[] getTypeAnnotations() {
              return new Annotation[] { };
            }
            public Object proceed() {
              status.proceed();
              if (status.getNextInterceptor() == null) {
                RemoteCallSendable sendable = null;
                if (errorCallback == null) {
                  sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAttributes:org.uberfire.backend.vfs.Path:", qualifiers, getParameters()).respondTo(Map.class, remoteCallback).defaultErrorHandling();
                } else {
                  sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAttributes:org.uberfire.backend.vfs.Path:", qualifiers, getParameters()).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
                }
                org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
              } else if (status.getNextInterceptor() == VFSCacheInterceptor.class) {
                final RemoteCallContext ctx = this;
                final CreationalCallback icc = new CreationalCallback() {
                  public void callback(final Object beanInstance) {
                    status.setProceeding(false);
                    ((VFSCacheInterceptor) beanInstance).aroundInvoke(ctx);
                    if ((!status.isProceeding()) && (VFSCacheInterceptor.class == status.getNextInterceptor())) {
                      remoteCallback.callback(ctx.getResult());
                    }
                  }
                };
                AsyncBeanFactory.createBean(new VFSCacheInterceptor(), icc);
              }
              return null;
            }
            public void proceed(final RemoteCallback interceptorCallback) {
              final RemoteCallback providedCallback = org_uberfire_backend_vfs_VFSServiceImpl.this.remoteCallback;
              remoteCallback = new RemoteCallback() {
                public void callback(Object response) {
                  RemoteCallback intCallback = interceptorCallback;
                  setResult(response);
                  intCallback.callback(getResult());
                  providedCallback.callback(getResult());
                }
              };
              proceed();
            }
            public void proceed(RemoteCallback interceptorCallback, final ErrorCallback interceptorErrorCallback) {
              final ErrorCallback providedErrorCallback = org_uberfire_backend_vfs_VFSServiceImpl.this.errorCallback;
              errorCallback = new ErrorCallback() {
                public boolean error(Object message, Throwable throwable) {
                  interceptorErrorCallback.error(message, throwable);
                  if (getResult() != null) {
                    remoteCallback.callback(getResult());
                    return false;
                  } else if (providedErrorCallback != null) {
                    return providedErrorCallback.error(message, throwable);
                  }
                  return true;
                }
              };
              proceed(interceptorCallback);
            }
          };
          callContext.setParameters(new Object[] { a0 });
          callContext.proceed();
        } catch (Throwable throwable) {
          if (errorCallback != null) {
            errorCallback.error(null, throwable);
          } else {
            invokeDefaultErrorHandlers(throwable);
          }
        }
        return null;
      }

      public void setAttributes(final Path a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("setAttributes:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("setAttributes:org.uberfire.backend.vfs.Path:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
      }

      public void delete(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("delete:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("delete:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
      }

      public boolean deleteIfExists(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("deleteIfExists:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("deleteIfExists:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Path copy(final Path a0, final Path a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("copy:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("copy:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path move(final Path a0, final Path a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("move:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("move:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String readAllString(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAllString:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("readAllString:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path write(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path write(final Path a0, final String a1, final Map a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("write:org.uberfire.backend.vfs.Path:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean isRegularFile(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isRegularFile:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isRegularFile:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isRegularFile(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isRegularFile:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isRegularFile:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isDirectory(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isDirectory:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isDirectory:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isDirectory(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSService").endpoint("isDirectory:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(VFSService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_backend_vfs_VFSServiceImpl();
      }
    });
    class org_kie_workbench_common_services_shared_project_ProjectImportsServiceImpl extends AbstractRpcProxy implements ProjectImportsService { public ProjectImportsContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.ProjectImportsService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectImportsContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.ProjectImportsService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectImportsContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_ProjectImportsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void saveProjectImports(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.ProjectImportsService").endpoint("saveProjectImports:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.ProjectImportsService").endpoint("saveProjectImports:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_ProjectImportsServiceImpl.this.sendRequest(bus, sendable);
      }

      public ProjectImports load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.ProjectImportsService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectImports.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.ProjectImportsService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ProjectImports.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_ProjectImportsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final ProjectImports a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.ProjectImportsService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.ProjectImports:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.ProjectImportsService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.ProjectImports:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_ProjectImportsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ProjectImportsService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_project_ProjectImportsServiceImpl();
      }
    });
    class org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl extends AbstractRpcProxy implements DecisionTableXLSService { public ConversionResult convert(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("convert:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ConversionResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("convert:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ConversionResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DecisionTableXLSContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DecisionTableXLSContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DecisionTableXLSContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String getSource(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("getSource:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("getSource:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final Path a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("validate:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("validate:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dtablexls.service.DecisionTableXLSService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DecisionTableXLSService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_dtablexls_service_DecisionTableXLSServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_search_service_SearchServiceImpl extends AbstractRpcProxy implements SearchService { public PageResponse fullTextSearch(final SearchTermPageRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.search.service.SearchService").endpoint("fullTextSearch:org.kie.workbench.common.screens.search.model.SearchTermPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.search.service.SearchService").endpoint("fullTextSearch:org.kie.workbench.common.screens.search.model.SearchTermPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_search_service_SearchServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PageResponse queryMetadata(final QueryMetadataPageRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.search.service.SearchService").endpoint("queryMetadata:org.kie.workbench.common.screens.search.model.QueryMetadataPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.search.service.SearchService").endpoint("queryMetadata:org.kie.workbench.common.screens.search.model.QueryMetadataPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_search_service_SearchServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SearchService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_search_service_SearchServiceImpl();
      }
    });
    class org_jbpm_console_ng_pr_service_ProcessDefinitionServiceImpl extends AbstractRpcProxy implements ProcessDefinitionService { public PageResponse getData(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessDefinitionService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessDefinitionService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessDefinitionServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ProcessSummary getItem(final ProcessDefinitionKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessDefinitionService").endpoint("getItem:org.jbpm.console.ng.pr.model.ProcessDefinitionKey:", qualifiers, new Object[] { a0 }).respondTo(ProcessSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessDefinitionService").endpoint("getItem:org.jbpm.console.ng.pr.model.ProcessDefinitionKey:", qualifiers, new Object[] { a0 }).respondTo(ProcessSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessDefinitionServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAll(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessDefinitionService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessDefinitionService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessDefinitionServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ProcessDefinitionService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_pr_service_ProcessDefinitionServiceImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_SocialUserRepositoryAPIImpl extends AbstractRpcProxy implements SocialUserRepositoryAPI { public SocialUser findSocialUser(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserRepositoryAPI").endpoint("findSocialUser:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(SocialUser.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserRepositoryAPI").endpoint("findSocialUser:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(SocialUser.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialUserRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List findAllUsers() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserRepositoryAPI").endpoint("findAllUsers:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialUserRepositoryAPI").endpoint("findAllUsers:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialUserRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialUserRepositoryAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_SocialUserRepositoryAPIImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_SocialActivitiesAPIImpl extends AbstractRpcProxy implements SocialActivitiesAPI { public void register(final SocialActivitiesEvent a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialActivitiesAPI").endpoint("register:org.kie.uberfire.social.activities.model.SocialActivitiesEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialActivitiesAPI").endpoint("register:org.kie.uberfire.social.activities.model.SocialActivitiesEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialActivitiesAPIImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialActivitiesAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_SocialActivitiesAPIImpl();
      }
    });
    class org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl extends AbstractRpcProxy implements TaskOperationsService { public long addQuickTask(final String a0, final int a1, final Date a2, final List a3, final List a4, final String a5, final boolean a6, final boolean a7, final String a8, final String a9, final Long a10) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("addQuickTask:java.lang.String:int:java.util.Date:java.util.List:java.util.List:java.lang.String:boolean:boolean:java.lang.String:java.lang.String:java.lang.Long:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10 }).respondTo(Long.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("addQuickTask:java.lang.String:int:java.util.Date:java.util.List:java.util.List:java.lang.String:boolean:boolean:java.lang.String:java.lang.String:java.lang.Long:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10 }).respondTo(Long.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl.this.sendRequest(bus, sendable);
        return 0L;
      }

      public void updateTask(final long a0, final int a1, final List a2, final Date a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("updateTask:long:int:java.util.List:java.util.Date:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("updateTask:long:int:java.util.List:java.util.Date:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl.this.sendRequest(bus, sendable);
      }

      public TaskSummary getTaskDetails(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("getTaskDetails:long:", qualifiers, new Object[] { a0 }).respondTo(TaskSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("getTaskDetails:long:", qualifiers, new Object[] { a0 }).respondTo(TaskSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public long saveContent(final long a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("saveContent:long:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Long.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("saveContent:long:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(Long.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl.this.sendRequest(bus, sendable);
        return 0L;
      }

      public boolean existInDatabase(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("existInDatabase:long:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("existInDatabase:long:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public TaskAssignmentSummary getTaskAssignmentDetails(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("getTaskAssignmentDetails:long:", qualifiers, new Object[] { a0 }).respondTo(TaskAssignmentSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("getTaskAssignmentDetails:long:", qualifiers, new Object[] { a0 }).respondTo(TaskAssignmentSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void executeReminderForTask(final long a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("executeReminderForTask:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskOperationsService").endpoint("executeReminderForTask:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(TaskOperationsService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ht_service_TaskOperationsServiceImpl();
      }
    });
    class org_jbpm_console_ng_ht_service_TaskQueryServiceImpl extends AbstractRpcProxy implements TaskQueryService { public PageResponse getData(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskQueryService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskQueryService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskQueryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public TaskSummary getItem(final TaskKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskQueryService").endpoint("getItem:org.jbpm.console.ng.ht.model.TaskKey:", qualifiers, new Object[] { a0 }).respondTo(TaskSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskQueryService").endpoint("getItem:org.jbpm.console.ng.ht.model.TaskKey:", qualifiers, new Object[] { a0 }).respondTo(TaskSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskQueryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAll(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskQueryService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskQueryService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskQueryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(TaskQueryService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ht_service_TaskQueryServiceImpl();
      }
    });
    class org_dashbuilder_dataset_service_DataSetDefVfsServicesImpl extends AbstractRpcProxy implements DataSetDefVfsServices { public Path resolve(final DataSetDef a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("resolve:org.dashbuilder.dataset.def.DataSetDef:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("resolve:org.dashbuilder.dataset.def.DataSetDef:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefVfsServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DataSetDef get(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("get:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DataSetDef.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("get:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DataSetDef.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefVfsServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public EditDataSetDef load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(EditDataSetDef.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(EditDataSetDef.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefVfsServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final DataSetDef a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("save:org.dashbuilder.dataset.def.DataSetDef:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("save:org.dashbuilder.dataset.def.DataSetDef:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefVfsServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefVfsServicesImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.dashbuilder.dataset.service.DataSetDefVfsServices").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_dashbuilder_dataset_service_DataSetDefVfsServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DataSetDefVfsServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_dashbuilder_dataset_service_DataSetDefVfsServicesImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_SocialTypeTimelinePagedRepositoryAPIImpl extends AbstractRpcProxy implements SocialTypeTimelinePagedRepositoryAPI { public PagedSocialQuery getEventTimeline(final String a0, final SocialPaged a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:java.lang.String:org.kie.uberfire.social.activities.model.SocialPaged:", qualifiers, new Object[] { a0, a1 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:java.lang.String:org.kie.uberfire.social.activities.model.SocialPaged:", qualifiers, new Object[] { a0, a1 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTypeTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PagedSocialQuery getEventTimeline(final SocialAdapter a0, final SocialPaged a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:org.kie.uberfire.social.activities.service.SocialAdapter:org.kie.uberfire.social.activities.model.SocialPaged:", qualifiers, new Object[] { a0, a1 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:org.kie.uberfire.social.activities.service.SocialAdapter:org.kie.uberfire.social.activities.model.SocialPaged:", qualifiers, new Object[] { a0, a1 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTypeTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PagedSocialQuery getEventTimeline(final String a0, final SocialPaged a1, final SocialPredicate a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:java.lang.String:org.kie.uberfire.social.activities.model.SocialPaged:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:java.lang.String:org.kie.uberfire.social.activities.model.SocialPaged:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTypeTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PagedSocialQuery getEventTimeline(final String a0, final SocialPaged a1, final Map a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:java.lang.String:org.kie.uberfire.social.activities.model.SocialPaged:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:java.lang.String:org.kie.uberfire.social.activities.model.SocialPaged:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTypeTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PagedSocialQuery getEventTimeline(final String a0, final SocialPaged a1, final Map a2, final SocialPredicate a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:java.lang.String:org.kie.uberfire.social.activities.model.SocialPaged:java.util.Map:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:java.lang.String:org.kie.uberfire.social.activities.model.SocialPaged:java.util.Map:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTypeTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PagedSocialQuery getEventTimeline(final SocialAdapter a0, final SocialPaged a1, final Map a2, final SocialPredicate a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:org.kie.uberfire.social.activities.service.SocialAdapter:org.kie.uberfire.social.activities.model.SocialPaged:java.util.Map:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(PagedSocialQuery.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialTypeTimelinePagedRepositoryAPI").endpoint("getEventTimeline:org.kie.uberfire.social.activities.service.SocialAdapter:org.kie.uberfire.social.activities.model.SocialPaged:java.util.Map:org.kie.uberfire.social.activities.service.SocialPredicate:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(PagedSocialQuery.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialTypeTimelinePagedRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialTypeTimelinePagedRepositoryAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_SocialTypeTimelinePagedRepositoryAPIImpl();
      }
    });
    class org_kie_workbench_common_services_shared_project_KieProjectServiceImpl extends AbstractRpcProxy implements KieProjectService { public KieProject resolveProject(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(KieProject.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(KieProject.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Project resolveParentProject(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveParentProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveParentProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Project resolveToParentProject(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveToParentProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveToParentProject:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Project.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set resolvePackages(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolvePackages:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolvePackages:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set resolvePackages(final Package a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolvePackages:org.guvnor.common.services.project.model.Package:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolvePackages:org.guvnor.common.services.project.model.Package:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Package resolveDefaultPackage(final Project a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveDefaultPackage:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveDefaultPackage:org.guvnor.common.services.project.model.Project:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Package resolveParentPackage(final Package a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveParentPackage:org.guvnor.common.services.project.model.Package:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolveParentPackage:org.guvnor.common.services.project.model.Package:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean isPom(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("isPom:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("isPom:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Package resolvePackage(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolvePackage:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("resolvePackage:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public WorkingSetSettings loadWorkingSetConfig(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("loadWorkingSetConfig:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(WorkingSetSettings.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("loadWorkingSetConfig:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(WorkingSetSettings.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set getProjects(final Repository a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("getProjects:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("getProjects:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public KieProject newProject(final Path a0, final POM a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("newProject:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(KieProject.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("newProject:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(KieProject.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public KieProject newProject(final Path a0, final POM a1, final String a2, final DeploymentMode a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("newProject:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:java.lang.String:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(KieProject.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("newProject:org.uberfire.backend.vfs.Path:org.guvnor.common.services.project.model.POM:java.lang.String:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(KieProject.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Package newPackage(final Package a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("newPackage:org.guvnor.common.services.project.model.Package:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("newPackage:org.guvnor.common.services.project.model.Package:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void addGroup(final Project a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("addGroup:org.guvnor.common.services.project.model.Project:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("addGroup:org.guvnor.common.services.project.model.Project:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
      }

      public void removeGroup(final Project a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("removeGroup:org.guvnor.common.services.project.model.Project:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("removeGroup:org.guvnor.common.services.project.model.Project:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
      }

      public void copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.project.KieProjectService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_project_KieProjectServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(KieProjectService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_project_KieProjectServiceImpl();
      }
    });
    class org_uberfire_backend_vfs_VFSLockServiceImpl extends AbstractRpcProxy implements VFSLockService { public LockResult acquireLock(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("acquireLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("acquireLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public LockResult releaseLock(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("releaseLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("releaseLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public LockResult forceReleaseLock(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("forceReleaseLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("forceReleaseLock:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public LockInfo retrieveLockInfo(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("retrieveLockInfo:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockInfo.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("retrieveLockInfo:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(LockInfo.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List retrieveLockInfos(final Path a0, final boolean a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("retrieveLockInfos:org.uberfire.backend.vfs.Path:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.backend.vfs.VFSLockService").endpoint("retrieveLockInfos:org.uberfire.backend.vfs.Path:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_backend_vfs_VFSLockServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(VFSLockService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_backend_vfs_VFSLockServiceImpl();
      }
    });
    class org_uberfire_ext_apps_api_AppsPersistenceAPIImpl extends AbstractRpcProxy implements AppsPersistenceAPI { public Directory getRootDirectory() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.apps.api.AppsPersistenceAPI").endpoint("getRootDirectory:", qualifiers, new Object[] { }).respondTo(Directory.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.apps.api.AppsPersistenceAPI").endpoint("getRootDirectory:", qualifiers, new Object[] { }).respondTo(Directory.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_apps_api_AppsPersistenceAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Directory createDirectory(final Directory a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.apps.api.AppsPersistenceAPI").endpoint("createDirectory:org.uberfire.ext.apps.api.Directory:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Directory.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.apps.api.AppsPersistenceAPI").endpoint("createDirectory:org.uberfire.ext.apps.api.Directory:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Directory.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_apps_api_AppsPersistenceAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Boolean deleteDirectory(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.apps.api.AppsPersistenceAPI").endpoint("deleteDirectory:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.apps.api.AppsPersistenceAPI").endpoint("deleteDirectory:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_apps_api_AppsPersistenceAPIImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(AppsPersistenceAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_apps_api_AppsPersistenceAPIImpl();
      }
    });
    class org_jbpm_console_ng_ht_service_TaskAuditServiceImpl extends AbstractRpcProxy implements TaskAuditService { public List getAllTaskEventsByProcessInstanceId(final long a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskAuditService").endpoint("getAllTaskEventsByProcessInstanceId:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskAuditService").endpoint("getAllTaskEventsByProcessInstanceId:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskAuditServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PageResponse getData(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskAuditService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskAuditService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskAuditServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public TaskEventSummary getItem(final TaskEventKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskAuditService").endpoint("getItem:org.jbpm.console.ng.ht.model.TaskEventKey:", qualifiers, new Object[] { a0 }).respondTo(TaskEventSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskAuditService").endpoint("getItem:org.jbpm.console.ng.ht.model.TaskEventKey:", qualifiers, new Object[] { a0 }).respondTo(TaskEventSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskAuditServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAll(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskAuditService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskAuditService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskAuditServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(TaskAuditService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ht_service_TaskAuditServiceImpl();
      }
    });
    class org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl extends AbstractRpcProxy implements ScenarioTestEditorService { public TestScenarioModelContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(TestScenarioModelContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(TestScenarioModelContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public TestScenarioResult runScenario(final Path a0, final Scenario a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("runScenario:org.uberfire.backend.vfs.Path:org.drools.workbench.models.testscenarios.shared.Scenario:", qualifiers, new Object[] { a0, a1 }).respondTo(TestScenarioResult.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("runScenario:org.uberfire.backend.vfs.Path:org.drools.workbench.models.testscenarios.shared.Scenario:", qualifiers, new Object[] { a0, a1 }).respondTo(TestScenarioResult.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final Scenario a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.testscenarios.shared.Scenario:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.testscenarios.shared.Scenario:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Scenario load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Scenario.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Scenario.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final Scenario a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.testscenarios.shared.Scenario:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.testscenarios.shared.Scenario:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.testscenario.service.ScenarioTestEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ScenarioTestEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_testscenario_service_ScenarioTestEditorServiceImpl();
      }
    });
    class org_uberfire_ext_editor_commons_service_ValidationServiceImpl extends AbstractRpcProxy implements ValidationService { public boolean isFileNameValid(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.ValidationService").endpoint("isFileNameValid:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.ValidationService").endpoint("isFileNameValid:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isFileNameValid(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.ValidationService").endpoint("isFileNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.ValidationService").endpoint("isFileNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ValidationService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_editor_commons_service_ValidationServiceImpl();
      }
    });
    class org_guvnor_common_services_shared_config_AppConfigServiceImpl extends AbstractRpcProxy implements AppConfigService { public Map loadPreferences() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.config.AppConfigService").endpoint("loadPreferences:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.config.AppConfigService").endpoint("loadPreferences:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_config_AppConfigServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public long getTimestamp() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.config.AppConfigService").endpoint("getTimestamp:", qualifiers, new Object[] { }).respondTo(Long.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.config.AppConfigService").endpoint("getTimestamp:", qualifiers, new Object[] { }).respondTo(Long.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_config_AppConfigServiceImpl.this.sendRequest(bus, sendable);
        return 0L;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(AppConfigService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_shared_config_AppConfigServiceImpl();
      }
    });
    class org_guvnor_m2repo_service_M2RepoServiceImpl extends AbstractRpcProxy implements M2RepoService { public String getPomText(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.m2repo.service.M2RepoService").endpoint("getPomText:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.m2repo.service.M2RepoService").endpoint("getPomText:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_m2repo_service_M2RepoServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public GAV loadGAVFromJar(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.m2repo.service.M2RepoService").endpoint("loadGAVFromJar:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(GAV.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.m2repo.service.M2RepoService").endpoint("loadGAVFromJar:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(GAV.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_m2repo_service_M2RepoServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PageResponse listArtifacts(final JarListPageRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.m2repo.service.M2RepoService").endpoint("listArtifacts:org.guvnor.m2repo.model.JarListPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.m2repo.service.M2RepoService").endpoint("listArtifacts:org.guvnor.m2repo.model.JarListPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_m2repo_service_M2RepoServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String getRepositoryURL(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.m2repo.service.M2RepoService").endpoint("getRepositoryURL:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.m2repo.service.M2RepoService").endpoint("getRepositoryURL:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_m2repo_service_M2RepoServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(M2RepoService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_m2repo_service_M2RepoServiceImpl();
      }
    });
    class org_uberfire_workbench_services_WorkbenchServicesImpl extends AbstractRpcProxy implements WorkbenchServices { public void save(final String a0, final PerspectiveDefinition a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("save:java.lang.String:org.uberfire.workbench.model.PerspectiveDefinition:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("save:java.lang.String:org.uberfire.workbench.model.PerspectiveDefinition:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }

      public void save(final SplashScreenFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("save:org.uberfire.workbench.model.SplashScreenFilter:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("save:org.uberfire.workbench.model.SplashScreenFilter:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }

      public Set loadPerspectives() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadPerspectives:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadPerspectives:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PerspectiveDefinition loadPerspective(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadPerspective:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(PerspectiveDefinition.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadPerspective:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(PerspectiveDefinition.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void removePerspectiveState(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("removePerspectiveState:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("removePerspectiveState:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }

      public void removePerspectiveStates() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("removePerspectiveStates:", qualifiers, new Object[] { }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("removePerspectiveStates:", qualifiers, new Object[] { }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }

      public SplashScreenFilter loadSplashScreenFilter(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadSplashScreenFilter:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(SplashScreenFilter.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadSplashScreenFilter:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(SplashScreenFilter.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map loadDefaultEditorsMap() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadDefaultEditorsMap:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("loadDefaultEditorsMap:", qualifiers, new Object[] { }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void saveDefaultEditors(final Map a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("saveDefaultEditors:java.util.Map:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.workbench.services.WorkbenchServices").endpoint("saveDefaultEditors:java.util.Map:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_workbench_services_WorkbenchServicesImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(WorkbenchServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_workbench_services_WorkbenchServicesImpl();
      }
    });
    class org_guvnor_asset_management_service_RepositoryStructureServiceImpl extends AbstractRpcProxy implements RepositoryStructureService { public Path initRepositoryStructure(final GAV a0, final Repository a1, final DeploymentMode a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("initRepositoryStructure:org.guvnor.common.services.project.model.GAV:org.guvnor.structure.repositories.Repository:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("initRepositoryStructure:org.guvnor.common.services.project.model.GAV:org.guvnor.structure.repositories.Repository:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path initRepositoryStructure(final POM a0, final String a1, final Repository a2, final boolean a3, final DeploymentMode a4) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("initRepositoryStructure:org.guvnor.common.services.project.model.POM:java.lang.String:org.guvnor.structure.repositories.Repository:boolean:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("initRepositoryStructure:org.guvnor.common.services.project.model.POM:java.lang.String:org.guvnor.structure.repositories.Repository:boolean:org.guvnor.common.services.project.service.DeploymentMode:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Repository initRepository(final Repository a0, final boolean a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("initRepository:org.guvnor.structure.repositories.Repository:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(Repository.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("initRepository:org.guvnor.structure.repositories.Repository:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(Repository.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path convertToMultiProjectStructure(final List a0, final GAV a1, final Repository a2, final boolean a3, final String a4) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("convertToMultiProjectStructure:java.util.List:org.guvnor.common.services.project.model.GAV:org.guvnor.structure.repositories.Repository:boolean:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("convertToMultiProjectStructure:java.util.List:org.guvnor.common.services.project.model.GAV:org.guvnor.structure.repositories.Repository:boolean:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public RepositoryStructureModel load(final Repository a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("load:org.guvnor.structure.repositories.Repository:", qualifiers, new Object[] { a0 }).respondTo(RepositoryStructureModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("load:org.guvnor.structure.repositories.Repository:", qualifiers, new Object[] { a0 }).respondTo(RepositoryStructureModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public RepositoryStructureModel load(final Repository a0, final boolean a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("load:org.guvnor.structure.repositories.Repository:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(RepositoryStructureModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("load:org.guvnor.structure.repositories.Repository:boolean:", qualifiers, new Object[] { a0, a1 }).respondTo(RepositoryStructureModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void save(final Path a0, final RepositoryStructureModel a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.asset.management.model.RepositoryStructureModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("save:org.uberfire.backend.vfs.Path:org.guvnor.asset.management.model.RepositoryStructureModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
      }

      public boolean isValidProjectName(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("isValidProjectName:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("isValidProjectName:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isValidGroupId(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("isValidGroupId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("isValidGroupId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isValidArtifactId(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("isValidArtifactId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("isValidArtifactId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isValidVersion(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("isValidVersion:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("isValidVersion:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.asset.management.service.RepositoryStructureService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_asset_management_service_RepositoryStructureServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RepositoryStructureService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_asset_management_service_RepositoryStructureServiceImpl();
      }
    });
    class org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl extends AbstractRpcProxy implements GuidedRuleTemplateEditorService { public GuidedTemplateEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedTemplateEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(GuidedTemplateEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean accepts(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("accepts:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("accepts:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public List validate(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String toSource(final Path a0, final TemplateModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.template.shared.TemplateModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.template.shared.TemplateModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final TemplateModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.template.shared.TemplateModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.template.shared.TemplateModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final TemplateModel a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.guided.template.shared.TemplateModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.guided.template.shared.TemplateModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public TemplateModel load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(TemplateModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(TemplateModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final TemplateModel a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.template.shared.TemplateModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.template.shared.TemplateModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.template.service.GuidedRuleTemplateEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GuidedRuleTemplateEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_guided_template_service_GuidedRuleTemplateEditorServiceImpl();
      }
    });
    class org_drools_workbench_screens_scorecardxls_service_ScoreCardXLSServiceImpl extends AbstractRpcProxy implements ScoreCardXLSService { public ScoreCardXLSContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ScoreCardXLSContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ScoreCardXLSContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_scorecardxls_service_ScoreCardXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final Path a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("validate:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("validate:org.uberfire.backend.vfs.Path:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_scorecardxls_service_ScoreCardXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_scorecardxls_service_ScoreCardXLSServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_scorecardxls_service_ScoreCardXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.scorecardxls.service.ScoreCardXLSService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_scorecardxls_service_ScoreCardXLSServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ScoreCardXLSService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_scorecardxls_service_ScoreCardXLSServiceImpl();
      }
    });
    class org_kie_workbench_common_services_shared_kmodule_KModuleServiceImpl extends AbstractRpcProxy implements KModuleService { public boolean isKModule(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.kmodule.KModuleService").endpoint("isKModule:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.kmodule.KModuleService").endpoint("isKModule:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_kmodule_KModuleServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Path setUpKModule(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.kmodule.KModuleService").endpoint("setUpKModule:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.kmodule.KModuleService").endpoint("setUpKModule:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_kmodule_KModuleServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public KModuleModel load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.kmodule.KModuleService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(KModuleModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.kmodule.KModuleService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(KModuleModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_kmodule_KModuleServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final KModuleModel a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.kmodule.KModuleService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.shared.kmodule.KModuleModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.kmodule.KModuleService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.shared.kmodule.KModuleModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_kmodule_KModuleServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(KModuleService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_kmodule_KModuleServiceImpl();
      }
    });
    class org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl extends AbstractRpcProxy implements DSLTextEditorService { public DSLTextEditorContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DSLTextEditorContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DSLTextEditorContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean accepts(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("accepts:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("accepts:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public List validate(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final String a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final String a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.dsltext.service.DSLTextEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DSLTextEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_dsltext_service_DSLTextEditorServiceImpl();
      }
    });
    class org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl extends AbstractRpcProxy implements WorkItemsEditorService { public WorkItemsModelContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(WorkItemsModelContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(WorkItemsModelContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public WorkItemDefinitionElements loadDefinitionElements() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("loadDefinitionElements:", qualifiers, new Object[] { }).respondTo(WorkItemDefinitionElements.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("loadDefinitionElements:", qualifiers, new Object[] { }).respondTo(WorkItemDefinitionElements.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set loadWorkItemDefinitions(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("loadWorkItemDefinitions:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("loadWorkItemDefinitions:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean accepts(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("accepts:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("accepts:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public List validate(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final String a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final String a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("save:org.uberfire.backend.vfs.Path:java.lang.String:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.workitems.service.WorkItemsEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(WorkItemsEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_workitems_service_WorkItemsEditorServiceImpl();
      }
    });
    class org_kie_workbench_common_services_shared_validation_ValidationServiceImpl extends AbstractRpcProxy implements org.kie.workbench.common.services.shared.validation.ValidationService { public boolean isProjectNameValid(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isProjectNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isProjectNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isPackageNameValid(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isPackageNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isPackageNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isFileNameValid(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isFileNameValid:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isFileNameValid:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isFileNameValid(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isFileNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isFileNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isJavaFileNameValid(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isJavaFileNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isJavaFileNameValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Map evaluateJavaIdentifiers(final String[] a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("evaluateJavaIdentifiers:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("evaluateJavaIdentifiers:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Map evaluateMavenIdentifiers(final String[] a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("evaluateMavenIdentifiers:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("evaluateMavenIdentifiers:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean isTimerIntervalValid(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isTimerIntervalValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("isTimerIntervalValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean validate(final POM a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("validate:org.guvnor.common.services.project.model.POM:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("validate:org.guvnor.common.services.project.model.POM:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean validateGroupId(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("validateGroupId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("validateGroupId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean validateArtifactId(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("validateArtifactId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("validateArtifactId:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean validateGAVVersion(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("validateGAVVersion:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.validation.ValidationService").endpoint("validateGAVVersion:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_validation_ValidationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(org.kie.workbench.common.services.shared.validation.ValidationService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_validation_ValidationServiceImpl();
      }
    });
    class org_jbpm_console_ng_ht_service_TaskCommentsServiceImpl extends AbstractRpcProxy implements TaskCommentsService { public long addComment(final long a0, final String a1, final String a2, final Date a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskCommentsService").endpoint("addComment:long:java.lang.String:java.lang.String:java.util.Date:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Long.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskCommentsService").endpoint("addComment:long:java.lang.String:java.lang.String:java.util.Date:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Long.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskCommentsServiceImpl.this.sendRequest(bus, sendable);
        return 0L;
      }

      public void deleteComment(final long a0, final long a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskCommentsService").endpoint("deleteComment:long:long:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskCommentsService").endpoint("deleteComment:long:long:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskCommentsServiceImpl.this.sendRequest(bus, sendable);
      }

      public List getAllCommentsByTaskId(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskCommentsService").endpoint("getAllCommentsByTaskId:long:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskCommentsService").endpoint("getAllCommentsByTaskId:long:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskCommentsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public CommentSummary getCommentById(final long a0, final long a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskCommentsService").endpoint("getCommentById:long:long:", qualifiers, new Object[] { a0, a1 }).respondTo(CommentSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskCommentsService").endpoint("getCommentById:long:long:", qualifiers, new Object[] { a0, a1 }).respondTo(CommentSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskCommentsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(TaskCommentsService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ht_service_TaskCommentsServiceImpl();
      }
    });
    class org_jboss_errai_security_shared_service_NonCachingUserServiceImpl extends AbstractRpcProxy implements NonCachingUserService { public User getUser() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.NonCachingUserService").endpoint("getUser:", qualifiers, new Object[] { }).respondTo(User.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jboss.errai.security.shared.service.NonCachingUserService").endpoint("getUser:", qualifiers, new Object[] { }).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jboss_errai_security_shared_service_NonCachingUserServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(NonCachingUserService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jboss_errai_security_shared_service_NonCachingUserServiceImpl();
      }
    });
    class org_jbpm_formModeler_renderer_service_FormRenderingServiceImpl extends AbstractRpcProxy implements FormRenderingService { public FormRenderContextTO startRendering(final Form a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRenderingService").endpoint("startRendering:org.jbpm.formModeler.api.model.Form:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(FormRenderContextTO.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRenderingService").endpoint("startRendering:org.jbpm.formModeler.api.model.Form:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(FormRenderContextTO.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_renderer_service_FormRenderingServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public FormRenderContextTO startRendering(final Long a0, final Map a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRenderingService").endpoint("startRendering:java.lang.Long:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(FormRenderContextTO.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.renderer.service.FormRenderingService").endpoint("startRendering:java.lang.Long:java.util.Map:", qualifiers, new Object[] { a0, a1 }).respondTo(FormRenderContextTO.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_renderer_service_FormRenderingServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(FormRenderingService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_formModeler_renderer_service_FormRenderingServiceImpl();
      }
    });
    class org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl extends AbstractRpcProxy implements DeploymentManagerEntryPoint { public void redeploy() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("redeploy:", qualifiers, new Object[] { }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("redeploy:", qualifiers, new Object[] { }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void deploy(final DeploymentUnitSummary a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("deploy:org.jbpm.console.ng.bd.model.DeploymentUnitSummary:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("deploy:org.jbpm.console.ng.bd.model.DeploymentUnitSummary:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void undeploy(final DeploymentUnitSummary a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("undeploy:org.jbpm.console.ng.bd.model.DeploymentUnitSummary:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("undeploy:org.jbpm.console.ng.bd.model.DeploymentUnitSummary:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void activate(final DeploymentUnitSummary a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("activate:org.jbpm.console.ng.bd.model.DeploymentUnitSummary:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("activate:org.jbpm.console.ng.bd.model.DeploymentUnitSummary:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void deactivate(final DeploymentUnitSummary a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("deactivate:org.jbpm.console.ng.bd.model.DeploymentUnitSummary:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("deactivate:org.jbpm.console.ng.bd.model.DeploymentUnitSummary:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public PageResponse getData(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public KModuleDeploymentUnitSummary getItem(final KModuleKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("getItem:org.jbpm.console.ng.bd.model.KModuleKey:", qualifiers, new Object[] { a0 }).respondTo(KModuleDeploymentUnitSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("getItem:org.jbpm.console.ng.bd.model.KModuleKey:", qualifiers, new Object[] { a0 }).respondTo(KModuleDeploymentUnitSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAll(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.DeploymentManagerEntryPoint").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DeploymentManagerEntryPoint.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_bd_service_DeploymentManagerEntryPointImpl();
      }
    });
    class org_jbpm_console_ng_pr_service_DocumentsServiceImpl extends AbstractRpcProxy implements DocumentsService { public PageResponse getData(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.DocumentsService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.DocumentsService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_DocumentsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public DocumentSummary getItem(final DocumentKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.DocumentsService").endpoint("getItem:org.jbpm.console.ng.pr.model.DocumentKey:", qualifiers, new Object[] { a0 }).respondTo(DocumentSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.DocumentsService").endpoint("getItem:org.jbpm.console.ng.pr.model.DocumentKey:", qualifiers, new Object[] { a0 }).respondTo(DocumentSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_DocumentsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAll(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.DocumentsService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.DocumentsService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_DocumentsServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(DocumentsService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_pr_service_DocumentsServiceImpl();
      }
    });
    class org_guvnor_structure_repositories_RepositoryServiceImpl extends AbstractRpcProxy implements RepositoryService { public RepositoryInfo getRepositoryInfo(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositoryInfo:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(RepositoryInfo.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositoryInfo:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(RepositoryInfo.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getRepositoryHistory(final String a0, final int a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositoryHistory:java.lang.String:int:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositoryHistory:java.lang.String:int:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getRepositoryHistory(final String a0, final int a1, final int a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositoryHistory:java.lang.String:int:int:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositoryHistory:java.lang.String:int:int:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getRepositoryHistoryAll(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositoryHistoryAll:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositoryHistoryAll:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Repository getRepository(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepository:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Repository.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepository:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Repository.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Repository getRepository(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepository:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Repository.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepository:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Repository.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection getRepositories() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositories:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("getRepositories:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Repository createRepository(final OrganizationalUnit a0, final String a1, final String a2, final RepositoryEnvironmentConfigurations a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("createRepository:org.guvnor.structure.organizationalunit.OrganizationalUnit:java.lang.String:java.lang.String:org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Repository.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("createRepository:org.guvnor.structure.organizationalunit.OrganizationalUnit:java.lang.String:java.lang.String:org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Repository.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Repository createRepository(final String a0, final String a1, final RepositoryEnvironmentConfigurations a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("createRepository:java.lang.String:java.lang.String:org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Repository.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("createRepository:java.lang.String:java.lang.String:org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Repository.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String normalizeRepositoryName(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("normalizeRepositoryName:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("normalizeRepositoryName:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public boolean validateRepositoryName(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("validateRepositoryName:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("validateRepositoryName:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public void addGroup(final Repository a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("addGroup:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("addGroup:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
      }

      public void removeGroup(final Repository a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("removeGroup:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("removeGroup:org.guvnor.structure.repositories.Repository:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
      }

      public void removeRepository(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("removeRepository:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("removeRepository:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
      }

      public Repository updateRepositoryConfiguration(final Repository a0, final RepositoryEnvironmentConfigurations a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("updateRepositoryConfiguration:org.guvnor.structure.repositories.Repository:org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations:", qualifiers, new Object[] { a0, a1 }).respondTo(Repository.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryService").endpoint("updateRepositoryConfiguration:org.guvnor.structure.repositories.Repository:org.guvnor.structure.repositories.RepositoryEnvironmentConfigurations:", qualifiers, new Object[] { a0, a1 }).respondTo(Repository.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RepositoryService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_structure_repositories_RepositoryServiceImpl();
      }
    });
    class org_kie_workbench_common_services_shared_enums_EnumDropdownServiceImpl extends AbstractRpcProxy implements EnumDropdownService { public String[] loadDropDownExpression(final Path a0, final String[] a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.enums.EnumDropdownService").endpoint("loadDropDownExpression:org.uberfire.backend.vfs.Path:java.lang.String[]:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(String[].class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.enums.EnumDropdownService").endpoint("loadDropDownExpression:org.uberfire.backend.vfs.Path:java.lang.String[]:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(String[].class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_enums_EnumDropdownServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(EnumDropdownService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_enums_EnumDropdownServiceImpl();
      }
    });
    class org_uberfire_ext_properties_editor_service_BeanPropertyEditorBuilderServiceImpl extends AbstractRpcProxy implements BeanPropertyEditorBuilderService { public PropertyEditorCategory extract(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.properties.editor.service.BeanPropertyEditorBuilderService").endpoint("extract:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(PropertyEditorCategory.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.properties.editor.service.BeanPropertyEditorBuilderService").endpoint("extract:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(PropertyEditorCategory.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_properties_editor_service_BeanPropertyEditorBuilderServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PropertyEditorCategory extract(final String a0, final Object a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.properties.editor.service.BeanPropertyEditorBuilderService").endpoint("extract:java.lang.String:java.lang.Object:", qualifiers, new Object[] { a0, a1 }).respondTo(PropertyEditorCategory.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.properties.editor.service.BeanPropertyEditorBuilderService").endpoint("extract:java.lang.String:java.lang.Object:", qualifiers, new Object[] { a0, a1 }).respondTo(PropertyEditorCategory.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_properties_editor_service_BeanPropertyEditorBuilderServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(BeanPropertyEditorBuilderService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_properties_editor_service_BeanPropertyEditorBuilderServiceImpl();
      }
    });
    class org_guvnor_structure_repositories_RepositoryServiceEditorImpl extends AbstractRpcProxy implements RepositoryServiceEditor { public List revertHistory(final String a0, final Path a1, final String a2, final VersionRecord a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryServiceEditor").endpoint("revertHistory:java.lang.String:org.uberfire.backend.vfs.Path:java.lang.String:org.uberfire.java.nio.base.version.VersionRecord:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.structure.repositories.RepositoryServiceEditor").endpoint("revertHistory:java.lang.String:org.uberfire.backend.vfs.Path:java.lang.String:org.uberfire.java.nio.base.version.VersionRecord:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_structure_repositories_RepositoryServiceEditorImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RepositoryServiceEditor.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_structure_repositories_RepositoryServiceEditorImpl();
      }
    });
    class org_uberfire_ext_security_management_api_service_UserManagerServiceImpl extends AbstractRpcProxy implements UserManagerService { public void assignGroups(final String a0, final Collection a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("assignGroups:java.lang.String:java.util.Collection:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("assignGroups:java.lang.String:java.util.Collection:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
      }

      public void assignRoles(final String a0, final Collection a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("assignRoles:java.lang.String:java.util.Collection:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("assignRoles:java.lang.String:java.util.Collection:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
      }

      public void changePassword(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("changePassword:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("changePassword:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
      }

      public SearchResponse search(final SearchRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("search:org.uberfire.ext.security.management.api.AbstractEntityManager.SearchRequest:", qualifiers, new Object[] { a0 }).respondTo(SearchResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("search:org.uberfire.ext.security.management.api.AbstractEntityManager.SearchRequest:", qualifiers, new Object[] { a0 }).respondTo(SearchResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public User get(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(User.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("get:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public User create(final User a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("create:org.jboss.errai.security.shared.api.identity.User:", qualifiers, new Object[] { a0 }).respondTo(User.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("create:org.jboss.errai.security.shared.api.identity.User:", qualifiers, new Object[] { a0 }).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public User update(final User a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("update:org.jboss.errai.security.shared.api.identity.User:", qualifiers, new Object[] { a0 }).respondTo(User.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("update:org.jboss.errai.security.shared.api.identity.User:", qualifiers, new Object[] { a0 }).respondTo(User.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final String[] a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("delete:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("delete:java.lang.String[]:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
      }

      public UserManagerSettings getSettings() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("getSettings:", qualifiers, new Object[] { }).respondTo(UserManagerSettings.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.security.management.api.service.UserManagerService").endpoint("getSettings:", qualifiers, new Object[] { }).respondTo(UserManagerSettings.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_security_management_api_service_UserManagerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(UserManagerService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_security_management_api_service_UserManagerServiceImpl();
      }
    });
    class org_jbpm_console_ng_ht_service_TaskLifeCycleServiceImpl extends AbstractRpcProxy implements TaskLifeCycleService { public void complete(final long a0, final String a1, final Map a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("complete:long:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("complete:long:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskLifeCycleServiceImpl.this.sendRequest(bus, sendable);
      }

      public void claim(final long a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("claim:long:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("claim:long:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskLifeCycleServiceImpl.this.sendRequest(bus, sendable);
      }

      public void start(final long a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("start:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("start:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskLifeCycleServiceImpl.this.sendRequest(bus, sendable);
      }

      public void release(final long a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("release:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("release:long:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskLifeCycleServiceImpl.this.sendRequest(bus, sendable);
      }

      public void delegate(final long a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("delegate:long:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.ht.service.TaskLifeCycleService").endpoint("delegate:long:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_ht_service_TaskLifeCycleServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(TaskLifeCycleService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_ht_service_TaskLifeCycleServiceImpl();
      }
    });
    class org_jbpm_console_ng_pr_service_ProcessInstanceServiceImpl extends AbstractRpcProxy implements ProcessInstanceService { public PageResponse getData(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessInstanceService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessInstanceService").endpoint("getData:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessInstanceServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ProcessInstanceSummary getItem(final ProcessInstanceKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessInstanceService").endpoint("getItem:org.jbpm.console.ng.pr.model.ProcessInstanceKey:", qualifiers, new Object[] { a0 }).respondTo(ProcessInstanceSummary.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessInstanceService").endpoint("getItem:org.jbpm.console.ng.pr.model.ProcessInstanceKey:", qualifiers, new Object[] { a0 }).respondTo(ProcessInstanceSummary.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessInstanceServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List getAll(final QueryFilter a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessInstanceService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.pr.service.ProcessInstanceService").endpoint("getAll:org.jbpm.console.ng.ga.model.QueryFilter:", qualifiers, new Object[] { a0 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_pr_service_ProcessInstanceServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ProcessInstanceService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_pr_service_ProcessInstanceServiceImpl();
      }
    });
    class org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl extends AbstractRpcProxy implements GuidedScoreCardEditorService { public ScoreCardModelContent loadContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ScoreCardModelContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("loadContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ScoreCardModelContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public String toSource(final Path a0, final ScoreCardModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("toSource:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel:", qualifiers, new Object[] { a0, a1 }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List validate(final Path a0, final ScoreCardModel a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("validate:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel:", qualifiers, new Object[] { a0, a1 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path create(final Path a0, final String a1, final ScoreCardModel a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("create:org.uberfire.backend.vfs.Path:java.lang.String:org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ScoreCardModel load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ScoreCardModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(ScoreCardModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final ScoreCardModel a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("save:org.uberfire.backend.vfs.Path:org.drools.workbench.models.guided.scorecard.shared.ScoreCardModel:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.drools.workbench.screens.guided.scorecard.service.GuidedScoreCardEditorService").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(GuidedScoreCardEditorService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_drools_workbench_screens_guided_scorecard_service_GuidedScoreCardEditorServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_server_management_service_RuleCapabilitiesServiceImpl extends AbstractRpcProxy implements RuleCapabilitiesService { public void scanNow(final ContainerSpecKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService").endpoint("scanNow:org.kie.server.controller.api.model.spec.ContainerSpecKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService").endpoint("scanNow:org.kie.server.controller.api.model.spec.ContainerSpecKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_RuleCapabilitiesServiceImpl.this.sendRequest(bus, sendable);
      }

      public void startScanner(final ContainerSpecKey a0, final long a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService").endpoint("startScanner:org.kie.server.controller.api.model.spec.ContainerSpecKey:long:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService").endpoint("startScanner:org.kie.server.controller.api.model.spec.ContainerSpecKey:long:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_RuleCapabilitiesServiceImpl.this.sendRequest(bus, sendable);
      }

      public void stopScanner(final ContainerSpecKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService").endpoint("stopScanner:org.kie.server.controller.api.model.spec.ContainerSpecKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService").endpoint("stopScanner:org.kie.server.controller.api.model.spec.ContainerSpecKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_RuleCapabilitiesServiceImpl.this.sendRequest(bus, sendable);
      }

      public void upgradeContainer(final ContainerSpecKey a0, final ReleaseId a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService").endpoint("upgradeContainer:org.kie.server.controller.api.model.spec.ContainerSpecKey:org.kie.server.api.model.ReleaseId:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.RuleCapabilitiesService").endpoint("upgradeContainer:org.kie.server.controller.api.model.spec.ContainerSpecKey:org.kie.server.api.model.ReleaseId:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_RuleCapabilitiesServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RuleCapabilitiesService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_server_management_service_RuleCapabilitiesServiceImpl();
      }
    });
    class org_uberfire_ext_plugin_service_PluginServicesImpl extends AbstractRpcProxy implements PluginServices { public String getMediaServletURI() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("getMediaServletURI:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("getMediaServletURI:", qualifiers, new Object[] { }).respondTo(String.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection listRuntimePlugins() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("listRuntimePlugins:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("listRuntimePlugins:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection listPlugins() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("listPlugins:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("listPlugins:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Plugin createNewPlugin(final String a0, final PluginType a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("createNewPlugin:java.lang.String:org.uberfire.ext.plugin.model.PluginType:", qualifiers, new Object[] { a0, a1 }).respondTo(Plugin.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("createNewPlugin:java.lang.String:org.uberfire.ext.plugin.model.PluginType:", qualifiers, new Object[] { a0, a1 }).respondTo(Plugin.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PluginContent getPluginContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("getPluginContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PluginContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("getPluginContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(PluginContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void deleteMedia(final Media a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("deleteMedia:org.uberfire.ext.plugin.model.Media:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("deleteMedia:org.uberfire.ext.plugin.model.Media:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
      }

      public DynamicMenu getDynamicMenuContent(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("getDynamicMenuContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DynamicMenu.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("getDynamicMenuContent:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(DynamicMenu.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final PluginSimpleContent a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("save:org.uberfire.ext.plugin.model.PluginSimpleContent:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("save:org.uberfire.ext.plugin.model.PluginSimpleContent:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public LayoutEditorModel getLayoutEditor(final Path a0, final PluginType a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("getLayoutEditor:org.uberfire.backend.vfs.Path:org.uberfire.ext.plugin.model.PluginType:", qualifiers, new Object[] { a0, a1 }).respondTo(LayoutEditorModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("getLayoutEditor:org.uberfire.backend.vfs.Path:org.uberfire.ext.plugin.model.PluginType:", qualifiers, new Object[] { a0, a1 }).respondTo(LayoutEditorModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path saveMenu(final DynamicMenu a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("saveMenu:org.uberfire.ext.plugin.model.DynamicMenu:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("saveMenu:org.uberfire.ext.plugin.model.DynamicMenu:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path saveLayout(final LayoutEditorModel a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("saveLayout:org.uberfire.ext.plugin.model.LayoutEditorModel:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("saveLayout:org.uberfire.ext.plugin.model.LayoutEditorModel:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection listDynamicMenus() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("listDynamicMenus:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("listDynamicMenus:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection listLayoutEditor(final PluginType a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("listLayoutEditor:org.uberfire.ext.plugin.model.PluginType:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("listLayoutEditor:org.uberfire.ext.plugin.model.PluginType:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void delete(final Path a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("delete:org.uberfire.backend.vfs.Path:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path rename(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.plugin.service.PluginServices").endpoint("rename:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_plugin_service_PluginServicesImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(PluginServices.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_plugin_service_PluginServicesImpl();
      }
    });
    class org_kie_workbench_common_screens_social_hp_config_SocialConfigurationServiceImpl extends AbstractRpcProxy implements SocialConfigurationService { public Boolean isSocialEnable() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.social.hp.config.SocialConfigurationService").endpoint("isSocialEnable:", qualifiers, new Object[] { }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.social.hp.config.SocialConfigurationService").endpoint("isSocialEnable:", qualifiers, new Object[] { }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_social_hp_config_SocialConfigurationServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialConfigurationService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_social_hp_config_SocialConfigurationServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_home_service_HomeServiceImpl extends AbstractRpcProxy implements HomeService { public Collection getOrganizationalUnits() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.home.service.HomeService").endpoint("getOrganizationalUnits:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.home.service.HomeService").endpoint("getOrganizationalUnits:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_home_service_HomeServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(HomeService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_home_service_HomeServiceImpl();
      }
    });
    class org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl extends AbstractRpcProxy implements KieSessionEntryPoint { public long startProcess(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("startProcess:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Long.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("startProcess:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Long.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
        return 0L;
      }

      public long startProcess(final String a0, final String a1, final Map a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("startProcess:java.lang.String:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Long.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("startProcess:java.lang.String:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Long.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
        return 0L;
      }

      public long startProcess(final String a0, final String a1, final String a2, final Map a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("startProcess:java.lang.String:java.lang.String:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Long.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("startProcess:java.lang.String:java.lang.String:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Long.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
        return 0L;
      }

      public long startProcess(final String a0, final String a1, final String a2, final Map a3, final Long a4) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("startProcess:java.lang.String:java.lang.String:java.lang.String:java.util.Map:java.lang.Long:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Long.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("startProcess:java.lang.String:java.lang.String:java.lang.String:java.util.Map:java.lang.Long:", qualifiers, new Object[] { a0, a1, a2, a3, a4 }).respondTo(Long.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
        return 0L;
      }

      public void abortProcessInstance(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("abortProcessInstance:long:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("abortProcessInstance:long:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void abortProcessInstances(final List a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("abortProcessInstances:java.util.List:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("abortProcessInstances:java.util.List:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void suspendProcessInstance(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("suspendProcessInstance:long:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("suspendProcessInstance:long:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void signalProcessInstance(final long a0, final String a1, final Object a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("signalProcessInstance:long:java.lang.String:java.lang.Object:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("signalProcessInstance:long:java.lang.String:java.lang.Object:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void signalProcessInstances(final List a0, final String a1, final Object a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("signalProcessInstances:java.util.List:java.lang.String:java.lang.Object:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("signalProcessInstances:java.util.List:java.lang.String:java.lang.Object:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public void setProcessVariable(final long a0, final String a1, final Object a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("setProcessVariable:long:java.lang.String:java.lang.Object:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("setProcessVariable:long:java.lang.String:java.lang.Object:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
      }

      public Collection getAvailableSignals(final long a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("getAvailableSignals:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.console.ng.bd.service.KieSessionEntryPoint").endpoint("getAvailableSignals:long:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(KieSessionEntryPoint.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_console_ng_bd_service_KieSessionEntryPointImpl();
      }
    });
    class org_guvnor_common_services_shared_config_ResourceConfigServiceImpl extends AbstractRpcProxy implements ResourceConfigService { public Map configAttrs(final Map a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.config.ResourceConfigService").endpoint("configAttrs:java.util.Map:", qualifiers, new Object[] { a0 }).respondTo(Map.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.guvnor.common.services.shared.config.ResourceConfigService").endpoint("configAttrs:java.util.Map:", qualifiers, new Object[] { a0 }).respondTo(Map.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_guvnor_common_services_shared_config_ResourceConfigServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ResourceConfigService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_guvnor_common_services_shared_config_ResourceConfigServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl extends AbstractRpcProxy implements SpecManagementService { public void saveContainerSpec(final String a0, final ContainerSpec a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("saveContainerSpec:java.lang.String:org.kie.server.controller.api.model.spec.ContainerSpec:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("saveContainerSpec:java.lang.String:org.kie.server.controller.api.model.spec.ContainerSpec:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void saveServerTemplate(final ServerTemplate a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("saveServerTemplate:org.kie.server.controller.api.model.spec.ServerTemplate:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("saveServerTemplate:org.kie.server.controller.api.model.spec.ServerTemplate:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public ServerTemplate getServerTemplate(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("getServerTemplate:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(ServerTemplate.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("getServerTemplate:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(ServerTemplate.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void deleteServerInstance(final ServerInstanceKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("deleteServerInstance:org.kie.server.controller.api.model.runtime.ServerInstanceKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("deleteServerInstance:org.kie.server.controller.api.model.runtime.ServerInstanceKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public Collection listServerTemplateKeys() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("listServerTemplateKeys:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("listServerTemplateKeys:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection listServerTemplates() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("listServerTemplates:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("listServerTemplates:", qualifiers, new Object[] { }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Collection listContainerSpec(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("listContainerSpec:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("listContainerSpec:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Collection.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void deleteContainerSpec(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("deleteContainerSpec:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("deleteContainerSpec:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void deleteServerTemplate(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("deleteServerTemplate:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("deleteServerTemplate:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void copyServerTemplate(final String a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("copyServerTemplate:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("copyServerTemplate:java.lang.String:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void updateContainerConfig(final String a0, final String a1, final Capability a2, final ContainerConfig a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("updateContainerConfig:java.lang.String:java.lang.String:org.kie.server.controller.api.model.spec.Capability:org.kie.server.controller.api.model.spec.ContainerConfig:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("updateContainerConfig:java.lang.String:java.lang.String:org.kie.server.controller.api.model.spec.Capability:org.kie.server.controller.api.model.spec.ContainerConfig:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void updateServerTemplateConfig(final String a0, final Capability a1, final ServerConfig a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("updateServerTemplateConfig:java.lang.String:org.kie.server.controller.api.model.spec.Capability:org.kie.server.controller.api.model.spec.ServerConfig:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("updateServerTemplateConfig:java.lang.String:org.kie.server.controller.api.model.spec.Capability:org.kie.server.controller.api.model.spec.ServerConfig:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void startContainer(final ContainerSpecKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("startContainer:org.kie.server.controller.api.model.spec.ContainerSpecKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("startContainer:org.kie.server.controller.api.model.spec.ContainerSpecKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public void stopContainer(final ContainerSpecKey a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("stopContainer:org.kie.server.controller.api.model.spec.ContainerSpecKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("stopContainer:org.kie.server.controller.api.model.spec.ContainerSpecKey:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
      }

      public boolean isContainerIdValid(final String a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("isContainerIdValid:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("isContainerIdValid:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public boolean isNewServerTemplateIdValid(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("isNewServerTemplateIdValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.server.management.service.SpecManagementService").endpoint("isNewServerTemplateIdValid:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SpecManagementService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_server_management_service_SpecManagementServiceImpl();
      }
    });
    class org_kie_workbench_common_services_shared_whitelist_PackageNameWhiteListServiceImpl extends AbstractRpcProxy implements PackageNameWhiteListService { public WhiteList filterPackageNames(final Project a0, final Collection a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService").endpoint("filterPackageNames:org.guvnor.common.services.project.model.Project:java.util.Collection:", qualifiers, new Object[] { a0, a1 }).respondTo(WhiteList.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService").endpoint("filterPackageNames:org.guvnor.common.services.project.model.Project:java.util.Collection:", qualifiers, new Object[] { a0, a1 }).respondTo(WhiteList.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_whitelist_PackageNameWhiteListServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void createProjectWhiteList(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService").endpoint("createProjectWhiteList:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService").endpoint("createProjectWhiteList:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_whitelist_PackageNameWhiteListServiceImpl.this.sendRequest(bus, sendable);
      }

      public WhiteList load(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(WhiteList.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService").endpoint("load:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(WhiteList.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_whitelist_PackageNameWhiteListServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Path save(final Path a0, final WhiteList a1, final Metadata a2, final String a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.shared.whitelist.WhiteList:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.shared.whitelist.PackageNameWhiteListService").endpoint("save:org.uberfire.backend.vfs.Path:org.kie.workbench.common.services.shared.whitelist.WhiteList:org.guvnor.common.services.shared.metadata.model.Metadata:java.lang.String:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_shared_whitelist_PackageNameWhiteListServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(PackageNameWhiteListService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_shared_whitelist_PackageNameWhiteListServiceImpl();
      }
    });
    class org_kie_workbench_common_services_refactoring_service_RefactoringQueryServiceImpl extends AbstractRpcProxy implements RefactoringQueryService { public Set getQueries() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.refactoring.service.RefactoringQueryService").endpoint("getQueries:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.refactoring.service.RefactoringQueryService").endpoint("getQueries:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_refactoring_service_RefactoringQueryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set getTerms(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.refactoring.service.RefactoringQueryService").endpoint("getTerms:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.refactoring.service.RefactoringQueryService").endpoint("getTerms:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_refactoring_service_RefactoringQueryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public PageResponse query(final RefactoringPageRequest a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.refactoring.service.RefactoringQueryService").endpoint("query:org.kie.workbench.common.services.refactoring.model.query.RefactoringPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.refactoring.service.RefactoringQueryService").endpoint("query:org.kie.workbench.common.services.refactoring.model.query.RefactoringPageRequest:", qualifiers, new Object[] { a0 }).respondTo(PageResponse.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_refactoring_service_RefactoringQueryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public List query(final String a0, final Set a1, final boolean a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.refactoring.service.RefactoringQueryService").endpoint("query:java.lang.String:java.util.Set:boolean:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.refactoring.service.RefactoringQueryService").endpoint("query:java.lang.String:java.util.Set:boolean:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_refactoring_service_RefactoringQueryServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(RefactoringQueryService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_refactoring_service_RefactoringQueryServiceImpl();
      }
    });
    class org_uberfire_ext_editor_commons_service_CopyServiceImpl extends AbstractRpcProxy implements CopyService { public void copyIfExists(final Collection a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.CopyService").endpoint("copyIfExists:java.util.Collection:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.CopyService").endpoint("copyIfExists:java.util.Collection:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_CopyServiceImpl.this.sendRequest(bus, sendable);
      }

      public boolean hasRestriction(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.CopyService").endpoint("hasRestriction:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.CopyService").endpoint("hasRestriction:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(Boolean.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_CopyServiceImpl.this.sendRequest(bus, sendable);
        return false;
      }

      public Path copy(final Path a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.CopyService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.uberfire.ext.editor.commons.service.CopyService").endpoint("copy:org.uberfire.backend.vfs.Path:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(Path.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_uberfire_ext_editor_commons_service_CopyServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(CopyService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_uberfire_ext_editor_commons_service_CopyServiceImpl();
      }
    });
    class org_kie_workbench_common_services_datamodel_service_IncrementalDataModelServiceImpl extends AbstractRpcProxy implements IncrementalDataModelService { public PackageDataModelOracleIncrementalPayload getUpdates(final Path a0, final Imports a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.datamodel.service.IncrementalDataModelService").endpoint("getUpdates:org.uberfire.backend.vfs.Path:org.drools.workbench.models.datamodel.imports.Imports:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(PackageDataModelOracleIncrementalPayload.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.services.datamodel.service.IncrementalDataModelService").endpoint("getUpdates:org.uberfire.backend.vfs.Path:org.drools.workbench.models.datamodel.imports.Imports:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(PackageDataModelOracleIncrementalPayload.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_services_datamodel_service_IncrementalDataModelServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(IncrementalDataModelService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_services_datamodel_service_IncrementalDataModelServiceImpl();
      }
    });
    class org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl extends AbstractRpcProxy implements ExplorerService { public ProjectExplorerContent getContent(final String a0, final ActiveOptions a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getContent:java.lang.String:org.kie.workbench.common.screens.explorer.service.ActiveOptions:", qualifiers, new Object[] { a0, a1 }).respondTo(ProjectExplorerContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getContent:java.lang.String:org.kie.workbench.common.screens.explorer.service.ActiveOptions:", qualifiers, new Object[] { a0, a1 }).respondTo(ProjectExplorerContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public ProjectExplorerContent getContent(final ProjectExplorerContentQuery a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getContent:org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery:", qualifiers, new Object[] { a0 }).respondTo(ProjectExplorerContent.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getContent:org.kie.workbench.common.screens.explorer.service.ProjectExplorerContentQuery:", qualifiers, new Object[] { a0 }).respondTo(ProjectExplorerContent.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public URIStructureExplorerModel getURIStructureExplorerModel(final Path a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getURIStructureExplorerModel:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(URIStructureExplorerModel.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getURIStructureExplorerModel:org.uberfire.backend.vfs.Path:", qualifiers, new Object[] { a0 }).respondTo(URIStructureExplorerModel.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public FolderListing getFolderListing(final OrganizationalUnit a0, final Repository a1, final String a2, final Project a3, final FolderItem a4, final ActiveOptions a5) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getFolderListing:org.guvnor.structure.organizationalunit.OrganizationalUnit:org.guvnor.structure.repositories.Repository:java.lang.String:org.guvnor.common.services.project.model.Project:org.kie.workbench.common.screens.explorer.model.FolderItem:org.kie.workbench.common.screens.explorer.service.ActiveOptions:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5 }).respondTo(FolderListing.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getFolderListing:org.guvnor.structure.organizationalunit.OrganizationalUnit:org.guvnor.structure.repositories.Repository:java.lang.String:org.guvnor.common.services.project.model.Project:org.kie.workbench.common.screens.explorer.model.FolderItem:org.kie.workbench.common.screens.explorer.service.ActiveOptions:", qualifiers, new Object[] { a0, a1, a2, a3, a4, a5 }).respondTo(FolderListing.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Package resolvePackage(final FolderItem a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("resolvePackage:org.kie.workbench.common.screens.explorer.model.FolderItem:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("resolvePackage:org.kie.workbench.common.screens.explorer.model.FolderItem:", qualifiers, new Object[] { a0 }).respondTo(Package.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public Set getLastUserOptions() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getLastUserOptions:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("getLastUserOptions:", qualifiers, new Object[] { }).respondTo(Set.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void deleteItem(final FolderItem a0, final String a1) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("deleteItem:org.kie.workbench.common.screens.explorer.model.FolderItem:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("deleteItem:org.kie.workbench.common.screens.explorer.model.FolderItem:java.lang.String:", qualifiers, new Object[] { a0, a1 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
      }

      public void renameItem(final FolderItem a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("renameItem:org.kie.workbench.common.screens.explorer.model.FolderItem:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("renameItem:org.kie.workbench.common.screens.explorer.model.FolderItem:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
      }

      public void copyItem(final FolderItem a0, final String a1, final String a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("copyItem:org.kie.workbench.common.screens.explorer.model.FolderItem:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.workbench.common.screens.explorer.service.ExplorerService").endpoint("copyItem:org.kie.workbench.common.screens.explorer.model.FolderItem:java.lang.String:java.lang.String:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(ExplorerService.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_workbench_common_screens_explorer_service_ExplorerServiceImpl();
      }
    });
    class org_jbpm_formModeler_api_client_FormRenderContextManagerImpl extends AbstractRpcProxy implements FormRenderContextManager { public FormRenderContext newContext(final Form a0, final String a1, final Map a2) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("newContext:org.jbpm.formModeler.api.model.Form:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(FormRenderContext.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("newContext:org.jbpm.formModeler.api.model.Form:java.lang.String:java.util.Map:", qualifiers, new Object[] { a0, a1, a2 }).respondTo(FormRenderContext.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public FormRenderContext newContext(final Form a0, final String a1, final Map a2, final Map a3) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("newContext:org.jbpm.formModeler.api.model.Form:java.lang.String:java.util.Map:java.util.Map:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(FormRenderContext.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("newContext:org.jbpm.formModeler.api.model.Form:java.lang.String:java.util.Map:java.util.Map:", qualifiers, new Object[] { a0, a1, a2, a3 }).respondTo(FormRenderContext.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public FormRenderContext getFormRenderContext(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("getFormRenderContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(FormRenderContext.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("getFormRenderContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(FormRenderContext.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public FormRenderContext getRootContext(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("getRootContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(FormRenderContext.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("getRootContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(FormRenderContext.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public void removeContext(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("removeContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("removeContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
      }

      public void removeContext(final FormRenderContext a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("removeContext:org.jbpm.formModeler.api.client.FormRenderContext:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("removeContext:org.jbpm.formModeler.api.client.FormRenderContext:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
      }

      public void fireContextSubmitError(final FormSubmitFailEvent a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("fireContextSubmitError:org.jbpm.formModeler.api.events.FormSubmitFailEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("fireContextSubmitError:org.jbpm.formModeler.api.events.FormSubmitFailEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
      }

      public void fireContextSubmit(final FormSubmittedEvent a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("fireContextSubmit:org.jbpm.formModeler.api.events.FormSubmittedEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("fireContextSubmit:org.jbpm.formModeler.api.events.FormSubmittedEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
      }

      public void fireContextFormResize(final ResizeFormcontainerEvent a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("fireContextFormResize:org.jbpm.formModeler.api.events.ResizeFormcontainerEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("fireContextFormResize:org.jbpm.formModeler.api.events.ResizeFormcontainerEvent:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
      }

      public void persistContext(final FormRenderContext a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("persistContext:org.jbpm.formModeler.api.client.FormRenderContext:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("persistContext:org.jbpm.formModeler.api.client.FormRenderContext:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
      }

      public void persistContext(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("persistContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.jbpm.formModeler.api.client.FormRenderContextManager").endpoint("persistContext:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(void.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_jbpm_formModeler_api_client_FormRenderContextManagerImpl.this.sendRequest(bus, sendable);
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(FormRenderContextManager.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_jbpm_formModeler_api_client_FormRenderContextManagerImpl();
      }
    });
    class org_kie_uberfire_social_activities_service_SocialEventTypeRepositoryAPIImpl extends AbstractRpcProxy implements SocialEventTypeRepositoryAPI { public List findAll() {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialEventTypeRepositoryAPI").endpoint("findAll:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialEventTypeRepositoryAPI").endpoint("findAll:", qualifiers, new Object[] { }).respondTo(List.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialEventTypeRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }

      public SocialEventType findType(final String a0) {
        RemoteCallSendable sendable = null;
        if (errorCallback == null) {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialEventTypeRepositoryAPI").endpoint("findType:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(SocialEventType.class, remoteCallback).defaultErrorHandling();
        } else {
          sendable = MessageBuilder.createCall().call("org.kie.uberfire.social.activities.service.SocialEventTypeRepositoryAPI").endpoint("findType:java.lang.String:", qualifiers, new Object[] { a0 }).respondTo(SocialEventType.class, remoteCallback).errorsHandledBy(errorCallback);
        }
        org_kie_uberfire_social_activities_service_SocialEventTypeRepositoryAPIImpl.this.sendRequest(bus, sendable);
        return null;
      }
    }
    RemoteServiceProxyFactory.addRemoteProxy(SocialEventTypeRepositoryAPI.class, new ProxyProvider() {
      public Object getProxy() {
        return new org_kie_uberfire_social_activities_service_SocialEventTypeRepositoryAPIImpl();
      }
    });
  }
}