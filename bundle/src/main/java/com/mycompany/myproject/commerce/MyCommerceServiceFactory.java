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
