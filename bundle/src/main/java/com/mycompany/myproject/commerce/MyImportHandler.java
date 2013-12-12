/*************************************************************************
 *
 * ADOBE CONFIDENTIAL
 * __________________
 *
 *  Copyright 2013 Adobe Systems Incorporated
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 **************************************************************************/
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
        @Property(name="service.ranking", intValue = 5000, propertyPrivate = true)
})
public class MyImportHandler extends DefaultImportHandler implements ImportHandler {

    private static final Logger log = LoggerFactory.getLogger(MyImportHandler.class);

    // overriding an existing method to extend its behaviour
    @Override
    public void updateAsset(Node imageNode, ImporterContext ctx, ValueMap values) throws Exception {
        // put your code here
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
