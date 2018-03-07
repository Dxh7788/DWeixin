package com.link.util;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 处理JAVA对象转换成XML时添加<!CDATA[ ]]>标签
 * @author  kongxiaoqian
 * @version 1.0
 */
public class CDATAConverter implements Converter {

    //java对象转换为xml
    public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
        String prefix = "<![CDATA[";
        String suffix = "]]>";
        String trans = prefix + o + suffix;
        writer.setValue(trans);
    }

    //xml转换成JAVA对象
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return null;
    }

    public boolean canConvert(Class aClass) {
        //String和Integer
        return String.class.isAssignableFrom(aClass) || Integer.class.isAssignableFrom(aClass);
    }
}
