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

@Component(metatype = true, label = "My Import Handler")
@Service(HybrisImporter.class)
@Properties({
        @Property(name = "commerceProvider", value = "trainingCommerce", propertyPrivate = true)
})
public class MyImporter extends DefaultHybrisImporter implements HybrisImporter, ProductImporter {

    private static final Logger log = LoggerFactory.getLogger(MyImporter.class);

    @Override
    public void importCatalog(Resource base, String baseStore, String catalog, String language, PrintWriter writer) {
        log.info("My importer is at work: importCatalog");
        super.importCatalog(base, baseStore, catalog, language, writer);   
    }

    @Override
    public void importCatalog(Resource base, String baseStore, String catalog, String language, PrintWriter writer, boolean incremental) {
        log.info("My importer is at work: importCatalog 2");
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
