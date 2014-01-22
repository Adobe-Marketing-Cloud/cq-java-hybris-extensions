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

import com.adobe.cq.commerce.api.CommerceException;
import com.adobe.cq.commerce.api.Product;
import com.adobe.cq.commerce.hybris.common.DefaultHybrisService;
import com.adobe.cq.commerce.hybris.common.HybrisConfiguration;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Specific extension of {@link DefaultHybrisService}
 */
public class MyCommerceService extends DefaultHybrisService {

    private static final Logger log = LoggerFactory.getLogger(MyImporter.class);

    public MyCommerceService(Resource res, HybrisConfiguration opts) {
        super(res, opts);
    }

    @Override
    public void catalogRolloutHook(Page blueprint, Page catalog)  throws CommerceException {
        log.info("My commerce service is at work: catalogRolloutHook");
        super.catalogRolloutHook(blueprint, catalog);
    }

    @Override
    public void productRolloutHook(Product productData, Page productPage, Product productReference) throws CommerceException {
        log.info("My commerce service is at work: productRolloutHook");
        super.productRolloutHook(productData, productPage, productReference);
    }
}
