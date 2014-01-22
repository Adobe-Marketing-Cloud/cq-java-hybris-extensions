/*
* Copyright 2013 Adobe
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.mycompany.myproject.commerce;

import java.io.PrintWriter;

import com.adobe.cq.commerce.hybris.importer.DefaultHybrisImporter;
import com.adobe.cq.commerce.hybris.importer.HybrisImporter;
import com.adobe.cq.commerce.pim.api.ProductImporter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

/**
 * Customized Hybris importer.
 */
@Component(metatype = true, label = "My Import Handler")
@Service(HybrisImporter.class)
@Properties({
        @Property(name = "commerceProvider", value = "my-hybris", propertyPrivate = true)
})
public class MyImporter extends DefaultHybrisImporter implements HybrisImporter, ProductImporter {

    private static final Logger log = LoggerFactory.getLogger(MyImporter.class);

    @Override
    public void importCatalog(Resource base, String baseStore, String catalog, String language, PrintWriter writer) {
        importCatalog(base, baseStore, catalog, language, writer, false);
    }

    @Override
    public void importCatalog(Resource base, String baseStore, String catalog, String language, PrintWriter writer, boolean incremental) {
        log.info("My importer is at work: importCatalog");
        super.importCatalog(base, baseStore, catalog, language, writer, incremental);   
    }

    @Override
    public void updateCatalog(Resource base) {
        log.info("My importer is at work: updateCatalog");
        super.updateCatalog(base);   
    }

    @Override
    public void importGroups(String path, String baseStore, PrintWriter writer, ResourceResolver resolver) {
        log.info("My importer is at work: importGroups");
        super.importGroups(path, baseStore, writer, resolver);   
    }
}
