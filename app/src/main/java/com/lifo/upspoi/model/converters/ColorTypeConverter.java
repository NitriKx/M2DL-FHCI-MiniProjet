package com.lifo.upspoi.model.converters;

import com.google.common.base.Splitter;
import com.lifo.upspoi.Utils.Color;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;
/**
 * Created by Benoît Sauvère on 27/01/16.
 */
public class ColorTypeConverter extends TypeConverter<String,Color> {
    @Override
    public String getDBValue(Color model) {
        if (model == null) { return null; }
        return String.format("%d;%d;%d", model.getRouge(), model.getVert(), model.getBleu());
    }

    @Override
    public Color getModelValue(String data) {
        if (data == null) { return null; }
        List<String> splittedData = Splitter.on(";").splitToList(data);
        return new Color(Integer.parseInt(splittedData.get(0)), Integer.parseInt(splittedData.get(1)), Integer.parseInt(splittedData.get(2)));
    }
}
