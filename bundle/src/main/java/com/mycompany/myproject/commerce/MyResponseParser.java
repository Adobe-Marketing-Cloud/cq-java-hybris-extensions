package com.mycompany.myproject.commerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.adobe.cq.commerce.api.PriceInfo;
import com.adobe.cq.commerce.common.PriceFilter;
import com.adobe.cq.commerce.hybris.importer.DefaultResponseParser;
import com.adobe.cq.commerce.hybris.importer.XMLEventReaderUtil;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

@Component(metatype = true, label = "My Hybris Response Parser")
@Service
@Properties({@Property(name = "sling.filter.scope", value = "request"),
        @Property(name = "service.ranking", intValue = 1000)})
public class MyResponseParser extends DefaultResponseParser{

    @Override
    public Map<String, Object> parseProductData(XMLEventReader xml, boolean variant) throws Exception {
        Map<String, Object> values = new HashMap<String, Object>();

        if (XMLEventReaderUtil.isNextStartElement(xml, "product")) {
            XMLEventReaderUtil.nextTag(xml);
            while (!XMLEventReaderUtil.isNextEndElement(xml, "product")) {
                final XMLEvent event = xml.peek();
                if (!event.isStartElement()) {
                    XMLEventReaderUtil.nextTag(xml);
                    continue;
                }
                final StartElement tag = event.asStartElement();
                final String tagName = tag.getName().getLocalPart();

                if ("code".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    values.put("code", xml.getElementText());
                } else if ("name".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    values.put("name", xml.getElementText());
                } else if ("url".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    values.put("url", xml.getElementText().replaceFirst("/v1", ""));
                } else if ("description".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    values.put("description", xml.getElementText());
                } else if ("purchasable".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    values.put("purchasable", Boolean.parseBoolean(xml.getElementText()));
                } else if ("summary".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    values.put("summary", xml.getElementText());
                } else if ("price".equals(tagName)) {
                    final List<PriceInfo> prices = new ArrayList<PriceInfo>();
                    final PriceInfo pi = parsePrice(xml, "price");
                    pi.put(PriceFilter.PN_TYPES, new HashSet<String>(Arrays.asList("UNIT", "POST_TAX", pi.getCurrency().getCurrencyCode())));
                    prices.add(pi);
                    values.put("prices", prices);
                } else if ("images".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    final List<Map<String, Object>> images = new ArrayList<Map<String, Object>>();
                    while (!XMLEventReaderUtil.isNextEndElement(xml, "images")) {
                        XMLEventReaderUtil.findFirstTag(xml, "image");
                        final Map<String, Object> image = new HashMap<String, Object>();
                        while (!XMLEventReaderUtil.isNextEndElement(xml, "image")) {
                            final XMLEvent imageEvent = XMLEventReaderUtil.nextTag(xml);
                            if (!imageEvent.isStartElement()) continue;

                            image.put(imageEvent.asStartElement().getName().getLocalPart(), xml.getElementText());
                        }
                        images.add(image);
                        XMLEventReaderUtil.skipElement(xml, "image");
                    }
                    values.put("images", images);
                    XMLEventReaderUtil.skipElement(xml, "images");
                } else if("categories".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    final List<String> categories = new ArrayList<String>();
                    while (!XMLEventReaderUtil.isNextEndElement(xml, "categories")) {
                        XMLEventReaderUtil.findFirstTag(xml, "category");
                        while (!XMLEventReaderUtil.isNextEndElement(xml, "category")) {
                            final XMLEvent categoryEvent = XMLEventReaderUtil.nextTag(xml);
                            if (!categoryEvent.isStartElement()) continue;

                            if ("code".equals(categoryEvent.asStartElement().getName().getLocalPart())) {
                                categories.add(xml.getElementText());
                                break;
                            }
                        }
                        XMLEventReaderUtil.skipElement(xml, "category");
                    }
                    values.put("categories", categories);
                    XMLEventReaderUtil.skipElement(xml, "categories");
                } else if ("variantOptions".equals(tagName)) {
                    XMLEventReaderUtil.nextTag(xml);
                    final List<String> variants = new ArrayList<String>();
                    while (!XMLEventReaderUtil.isNextEndElement(xml, "variantOptions")) {
                        String variantCode = null, variantURL = null;
                        XMLEventReaderUtil.findFirstTag(xml,
                                "de.hybris.platform.commercefacades.product.data.VariantOptionData");
                        while (!XMLEventReaderUtil.isNextEndElement(xml,
                                "de.hybris.platform.commercefacades.product.data.VariantOptionData")) {
                            final XMLEvent variantEvent = XMLEventReaderUtil.nextTag(xml);
                            if (!variantEvent.isStartElement()) continue;
                            final StartElement variantTag = variantEvent.asStartElement();
                            final String variantTagName = variantTag.getName().getLocalPart();

                            if ("code".equals(variantTagName)) {
                                variantCode = xml.getElementText();
                                break;
                            } else if ("url".equals(variantTagName)) {
                                variantURL = xml.getElementText();
                            } else {
                                XMLEventReaderUtil.skipElement(xml, variantTagName);
                            }
                        }

                        if (variantCode == null && variantURL != null) {
                            variantCode = variantURL.substring(variantURL.lastIndexOf('/') + 1);
                        }

                        if (variantCode != null) {
                            variants.add(variantCode);
                        }

                        XMLEventReaderUtil.skipElement(xml, "de.hybris.platform.commercefacades.product.data.VariantOptionData");
                    }
                    values.put("variants", variants);
                    XMLEventReaderUtil.skipElement(xml, "variantOptions");
                } else if ("baseOptions".equals(tagName)) {
                    while (!XMLEventReaderUtil.isNextEndElement(xml, "baseOptions")) {
                        final XMLEvent baseOptionEvent = XMLEventReaderUtil.nextTag(xml);
                        if (!baseOptionEvent.isStartElement()) continue;
                        final StartElement baseOptionTag = baseOptionEvent.asStartElement();
                        final String baseOptionTagName = baseOptionTag.getName().getLocalPart();

                        if ("baseProductCode".equals(baseOptionTagName)) {
                            values.put("baseProductCode", xml.getElementText());
                        }
                        else if ("selected".equals(baseOptionTagName)) {
                            final XMLEvent variantsEvent = XMLEventReaderUtil.findFirstTag(xml,
                                    "variantOptionQualifiers",
                                    "selected");
                            if(variantsEvent != null) {
                                while(!XMLEventReaderUtil.isNextEndElement(xml, "variantOptionQualifiers")) {
                                    final XMLEvent variantEvent = XMLEventReaderUtil.nextTag(xml);
                                    if (!variantEvent.isStartElement()) continue;
                                    final StartElement variantTag = variantEvent.asStartElement();
                                    final String variantTagName = variantTag.getName().getLocalPart();

                                    if ("qualifier".equals(variantTagName)) {
                                        putValue(values, "variantAttribute.name", xml.getElementText());
                                    } else if ("name".equals(variantTagName)) {
                                        putValue(values, "variantAttribute.title", xml.getElementText());
                                    } else if ("value".equals(variantTagName)) {
                                        putValue(values, "variantAttribute.value", xml.getElementText());
                                    }
                                }
                                XMLEventReaderUtil.skipElement(xml, "selected");
                            }
                        }
                    }
                    XMLEventReaderUtil.skipElement(xml, "baseOptions");
                } else {
                    XMLEventReaderUtil.skipElement(xml, tagName);
                }
            }
            XMLEventReaderUtil.skipElement(xml, "product");
        }

        return mapValues(values, additionalAttributeMapping, true);
    }

}
