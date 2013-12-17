package com.mycompany.myproject.commerce;

import com.adobe.cq.commerce.api.CommerceServiceFactory;
import com.adobe.cq.commerce.hybris.HybrisSession;
import com.adobe.cq.commerce.hybris.SessionInfo;
import com.adobe.cq.commerce.hybris.api.HybrisFactory;
import com.adobe.cq.commerce.hybris.api.HybrisService;
import com.adobe.cq.commerce.hybris.common.DefaultHybrisFactory;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;

/**
 * Specific {@link CommerceServiceFactory} for hybris, mainly responsible for creating
 * {@link MyCommerceService} instances.
 */
@Component(metatype = true, label = "My Hybris Factory")
@Service(value = { HybrisFactory.class, CommerceServiceFactory.class })
@Properties(value = {
        @Property(name = "service.description", value = "My specific hybris commerce service factory"),
        @Property(name = "commerceProvider", value = "my-hybris")
})
public class MyCommerceServiceFactory extends DefaultHybrisFactory {

    @Override
    public HybrisService getCommerceService(Resource res) {
        return new MyCommerceService(res, getServiceContext());
    }

    @Override
    public HybrisSession getSession(HybrisService service, SlingHttpServletRequest request, SlingHttpServletResponse response, SessionInfo sessionInfo) {
        HybrisSession defaultSession = super.getSession(service, request, response, sessionInfo);
        return new MyCommerceSession(defaultSession);
    }

}
