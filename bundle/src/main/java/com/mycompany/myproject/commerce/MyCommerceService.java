package com.mycompany.myproject.commerce;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import com.adobe.cq.commerce.api.CommerceException;
import com.adobe.cq.commerce.api.CommerceQuery;
import com.adobe.cq.commerce.api.CommerceResult;
import com.adobe.cq.commerce.api.CommerceSession;
import com.adobe.cq.commerce.api.Product;
import com.adobe.cq.commerce.hybris.common.DefaultHybrisService;
import com.adobe.cq.commerce.hybris.common.HybrisConfiguration;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCommerceService extends DefaultHybrisService {

    private static final Logger log = LoggerFactory.getLogger(MyCommerceService.class);


    public MyCommerceService(Resource res, HybrisConfiguration config) {
        super(res, config);
    }

    public CommerceResult search(CommerceQuery commerceQuery) throws CommerceException {
        return null;
    }

    @Override
    public void productRolloutHook(Product productData, Page productPage, Product productReference) throws CommerceException {
        super.productRolloutHook(productData, productPage, productReference);
            try {
                Node productReferenceNode=productReference.adaptTo(Node.class);
                //Node pageContentNode = productPage.getContentResource().adaptTo(Node.class);
                //set custom properties here
                productReferenceNode.getSession().save();
            } catch (RepositoryException e) {
                log.error("An exception occurred: "+e, e);
            }
    }

    @Override
    public CommerceSession login(SlingHttpServletRequest request, SlingHttpServletResponse response) throws CommerceException {
        return super.login(request,response);
    }

    @Override
    public void catalogRolloutHook(Page blueprint, Page catalog) throws CommerceException {
        super.catalogRolloutHook(blueprint, catalog);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
