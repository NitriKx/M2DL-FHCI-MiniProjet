package com.lifo.upspoi.model.converters;

import com.google.android.gms.maps.model.LatLng;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.List;

/**
 * Created by Benoît Sauvère on 25/01/16.
 */
@com.raizlabs.android.dbflow.annotation.TypeConverter
public class ListLatLngTypeConverter extends TypeConverter<String, List> {

    private static final String listSeparator = ";";
    private static final String latlngSeparator = "|";

    @Override
    public String getDBValue(List model) {
        List<LatLng> latlngModel = (List<LatLng>) model;
        List<String> latlngAsStringList = Lists.transform(latlngModel, new Function<LatLng, String>() {
            @Override
            public String apply(LatLng input) {
                return String.format("%f%s%f", input.latitude, latlngSeparator, input.longitude);
            }
        });

        // On aggrège les convertions
        return Joiner.on(listSeparator).join(latlngAsStringList);
    }

    @Override
    public List getModelValue(String data) {
        List<String> latlngAsStringList = Splitter.on(listSeparator).splitToList(data);
        return Lists.transform(latlngAsStringList, new Function<String, LatLng>() {
            @Override
            public LatLng apply(String input) {
                List<String> splittedLatLngListAsString = Splitter.on(latlngSeparator).splitToList(input);
                Double latitude = Double.parseDouble(splittedLatLngListAsString.get(0));
                Double longitude = Double.parseDouble(splittedLatLngListAsString.get(1));
                return new LatLng(latitude, longitude);
            }
        });
    }
}
