package com.mycompany.myproject.commerce;

import com.adobe.cq.commerce.api.CommerceServiceFactory;
import com.adobe.cq.commerce.hybris.HybrisSession;
import com.adobe.cq.commerce.hybris.SessionInfo;
import com.adobe.cq.commerce.hybris.api.HybrisService;
import com.adobe.cq.commerce.hybris.common.DefaultHybrisFactory;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCommerceServiceFactory extends DefaultHybrisFactory implements CommerceServiceFactory{

    private static final Logger log = LoggerFactory.getLogger(MyCommerceServiceFactory.class);

    @Override
    public HybrisService getCommerceService(Resource resource) {
        return super.getCommerceService(resource);
    }

    @Override
    public HybrisSession getSession(HybrisService service, SlingHttpServletRequest request, SessionInfo sessionInfo) {
        return super.getSession(service, request, sessionInfo);
    }

}
