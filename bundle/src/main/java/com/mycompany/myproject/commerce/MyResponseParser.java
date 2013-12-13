package com.mycompany.myproject.commerce;

import java.util.Map;

import javax.xml.stream.XMLEventReader;

import com.adobe.cq.commerce.hybris.importer.DefaultResponseParser;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

/*
@Component(metatype = true, label = "My Hybris Response Parser")
@Service
@Properties({@Property(name = "service.ranking", intValue = 1000)})
*/
public class MyResponseParser extends DefaultResponseParser {

    @Override
    public Map<String, Object> parseProductData(XMLEventReader xml, boolean variant) throws Exception {
        return super.parseProductData(xml, variant);
   }

}
