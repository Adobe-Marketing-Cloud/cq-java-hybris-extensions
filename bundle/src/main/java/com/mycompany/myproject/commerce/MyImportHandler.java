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

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.ValueMap;
import com.adobe.cq.commerce.hybris.importer.DefaultImportHandler;
import com.adobe.cq.commerce.hybris.importer.ImportHandler;
import com.adobe.cq.commerce.hybris.importer.ImporterContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Customized import handler for Hybris product catalogs.
 */
@Component(metatype = true, label = "Customized Commerce Hybris Import Handler")
@Service
@Properties({
        @Property(name="service.ranking", intValue = 1000, propertyPrivate = true)
})
public class MyImportHandler extends DefaultImportHandler implements ImportHandler {

    private static final Logger log = LoggerFactory.getLogger(MyImportHandler.class);

    @Override
    public void updateAsset(Node imageNode, ImporterContext ctx, ValueMap values) throws Exception {
        log.info("MyImportHandler is updating an asset.");
        super.updateAsset(imageNode, ctx, values);
    }

    @Override
    public String createProduct(ImporterContext ctx, ValueMap values, List<String> categories) throws Exception {
        log.info("MyImportHandler is creating a product.");
        return super.createProduct(ctx, values, categories);
    }

    @Override
    public void updateProduct(Node productNode, ImporterContext ctx, ValueMap values, List<String> categories) throws RepositoryException {
        log.info("MyImportHandler is updating a product.");
        super.updateProduct(productNode, ctx, values, categories);
    }

}
