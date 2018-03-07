package com.link.util.xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.Date;

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
        //如果是时间,则转化为时间戳格式
        if (o instanceof Date){
            trans = prefix + ((Date) o).getTime() + suffix;
        }
        writer.setValue(trans);
    }

    //xml转换成JAVA对象
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
        return null;
    }

    public boolean canConvert(Class aClass) {
        //String和Integer
        return String.class.isAssignableFrom(aClass) || Integer.class.isAssignableFrom(aClass)|| Date.class.isAssignableFrom(aClass);
    }
}
