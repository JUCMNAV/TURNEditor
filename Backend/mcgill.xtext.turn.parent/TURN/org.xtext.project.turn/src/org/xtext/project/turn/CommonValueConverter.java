package org.xtext.project.turn;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class CommonValueConverter extends DefaultTerminalConverters {
	private List <Integer> uniqueList=new ArrayList<Integer>();
	
    private IValueConverter<Integer> intValueConverter = new IValueConverter<Integer>() {
        @Override
        public Integer toValue(String string, INode node) throws ValueConverterException {
            if (Strings.isEmpty(string)) {
                throw new ValueConverterException("Cannot be empty", node, null);
            }
            if(Integer.parseInt(string) > 100){
            	throw new ValueConverterException("Quantitative value cannot be greater than 100", node, null);
            }
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException e) {
                throw new ValueConverterException("'"+string+"' is not a valid integer", node, e);
            }
        }
        @Override
        public String toString(Integer value) throws ValueConverterException {
            return Integer.toString(value);
        }
    };
    
    private IValueConverter<Integer> positiveValueConverter = new IValueConverter<Integer>() {
        @Override
        public Integer toValue(String string, INode node) throws ValueConverterException {
            if (Strings.isEmpty(string)) {
                throw new ValueConverterException("Cannot be empty", node, null);
            }
            if(Integer.parseInt(string) <= 0){
            	throw new ValueConverterException("value cannot be less than 0", node, null);
            }
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException e) {
                throw new ValueConverterException("'"+string+"' is not a valid integer", node, e);
            }
        }
        @Override
        public String toString(Integer value) throws ValueConverterException {
            return Integer.toString(value);
        }
    };
    
    private IValueConverter<Integer> uniqueValueConverter = new IValueConverter<Integer>() {
        @Override
        public Integer toValue(String string, INode node) throws ValueConverterException {
            if (Strings.isEmpty(string)) {
                throw new ValueConverterException("Cannot be empty", node, null);
            }
            if(Integer.parseInt(string) <= 0){
            	throw new ValueConverterException("ID cannot be less than 0", node, null);
            }
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException e) {
                throw new ValueConverterException("'"+string+"' is not a valid integer", node, e);
            }
        }
        @Override
        public String toString(Integer value) throws ValueConverterException {
            return Integer.toString(value);
        }
    };

    @ValueConverter(rule = "QuantitativeValue")
    public IValueConverter<Integer> AnyIntegerLiteral() {
        return intValueConverter;
    }
    
    @ValueConverter(rule = "PositiveInteger")
    public IValueConverter<Integer> positiveIntegerLiteral() {
        return positiveValueConverter;
    }
    
    @ValueConverter(rule = "IDNumber")
    public IValueConverter<Integer> uniqueIntegerLiteral() {
        return uniqueValueConverter;
    }
}