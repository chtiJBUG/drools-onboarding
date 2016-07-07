/*
 * Copyright 2014 Red Hat, Inc. and/or its affiliates.
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
package org.chtijbug.workbench.drools.backend.server;

import org.apache.lucene.analysis.Analyzer;
import org.kie.workbench.common.screens.datamodeller.model.index.terms.*;
import org.kie.workbench.common.services.refactoring.backend.server.indexing.FullyQualifiedClassNameAnalyzer;
import org.kie.workbench.common.services.refactoring.backend.server.indexing.RuleAttributeNameAnalyzer;
import org.kie.workbench.common.services.refactoring.model.index.terms.*;
import org.uberfire.ext.metadata.backend.lucene.LuceneConfig;
import org.uberfire.ext.metadata.backend.lucene.LuceneConfigBuilder;
import org.uberfire.ext.metadata.backend.lucene.analyzer.FilenameAnalyzer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

import static org.apache.lucene.util.Version.LUCENE_40;

@ApplicationScoped
public class LuceneConfigProducer {

    private LuceneConfig config;

    @PostConstruct
    public void setup() {
        final Map<String, Analyzer> analyzers = getAnalyzers();
        this.config = new LuceneConfigBuilder().withInMemoryMetaModelStore()
                .usingAnalyzers(analyzers)
                .useDirectoryBasedIndex()
                .useNIODirectory()
                .build();
    }

    @Produces
    @Named("luceneConfig")
    public LuceneConfig configProducer() {
        return this.config;
    }

    private Map<String, Analyzer> getAnalyzers() {
        return new HashMap<String, Analyzer>() {{
            put(RuleIndexTerm.TERM,
                    new RuleAttributeNameAnalyzer(LUCENE_40));
            put(RuleAttributeIndexTerm.TERM,
                    new RuleAttributeNameAnalyzer(LUCENE_40));
            put(RuleAttributeValueIndexTerm.TERM,
                    new RuleAttributeNameAnalyzer(LUCENE_40));

            put(ProjectRootPathIndexTerm.TERM,
                    new FilenameAnalyzer(LUCENE_40));

            put(PackageNameIndexTerm.TERM,
                    new FullyQualifiedClassNameAnalyzer(LUCENE_40));
            put(FieldTypeIndexTerm.TERM,
                    new FullyQualifiedClassNameAnalyzer(LUCENE_40));
            put(JavaTypeIndexTerm.TERM,
                    new FullyQualifiedClassNameAnalyzer(LUCENE_40));
            put(JavaTypeInterfaceIndexTerm.TERM,
                    new FullyQualifiedClassNameAnalyzer(LUCENE_40));
            put(JavaTypeNameIndexTerm.TERM,
                    new FullyQualifiedClassNameAnalyzer(LUCENE_40));
            put(JavaTypeParentIndexTerm.TERM,
                    new FullyQualifiedClassNameAnalyzer(LUCENE_40));
            put(TypeIndexTerm.TERM,
                    new FullyQualifiedClassNameAnalyzer(LUCENE_40));
        }};
    }

}
