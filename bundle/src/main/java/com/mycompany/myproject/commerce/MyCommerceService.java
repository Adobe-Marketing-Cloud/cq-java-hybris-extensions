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
