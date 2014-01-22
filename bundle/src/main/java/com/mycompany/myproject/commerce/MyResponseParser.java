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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.adobe.cq.commerce.hybris.importer.DefaultResponseParser;
import com.adobe.cq.commerce.hybris.importer.XMLEventReaderUtil;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

/**
 * Customized Hybris response parser.
 */
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

    @Override
    protected void parseUnknownProductAttribute(XMLEventReader xml, Map<String, Object> values, String tagName) throws XMLStreamException {
        if ("productReferences".equals(tagName)) {
            final List<String> references = new ArrayList<String>();
            while (!XMLEventReaderUtil.isNextEndElement(xml, "productReferences")) {
                final XMLEvent referenceEvent = XMLEventReaderUtil.nextTag(xml);
                if (!referenceEvent.isStartElement()) continue;
                final StartElement referenceTag = referenceEvent.asStartElement();
                final String referenceTagName = referenceTag.getName().getLocalPart();
                if ("target".equals(referenceTagName)) {
                    while (!XMLEventReaderUtil.isNextEndElement(xml, "target")) {
                        final XMLEvent targetEvent = XMLEventReaderUtil.nextTag(xml);
                        if (!targetEvent.isStartElement()) continue;
                        final StartElement targetTag = targetEvent.asStartElement();
                        final String targetTagName = targetTag.getName().getLocalPart();
                        if ("url".equals(targetTagName)) {
                            references.add(xml.getElementText());
                        }
                    }
                }
            }
            values.put("references", references);
            XMLEventReaderUtil.skipElement(xml, "productReferences");
        } else {
            XMLEventReaderUtil.skipElement(xml, tagName);
        }
    }

}
