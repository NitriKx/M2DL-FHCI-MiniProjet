package com.lifo.upspoi.model.converters;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.lifo.upspoi.model.PointTag;
import com.lifo.upspoi.model.PointTag_Table;
import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benoît Sauvère on 25/01/16.
 */
@com.raizlabs.android.dbflow.annotation.TypeConverter
public class ListPointTagTypeConverter extends TypeConverter<String,List> {

    private static final String separator = ",";

    @Override
    public String getDBValue(List model) {
        List<PointTag> modelPointTag = (List<PointTag>) model;
        if (modelPointTag == null || modelPointTag.size() == 0) {
            return "";
        }
        return Joiner.on(separator).join(modelPointTag);
    }

    @Override
    public List getModelValue(String data) {
        if (data == null || data.length() == 0) {
            return new ArrayList<>();
        }
        return Lists.transform(Lists.newArrayList(Splitter.on(separator).split(data)), new Function<String, PointTag>() {
            @Override
            public PointTag apply(String pointTagAsString) {

                // Pour chaque tag, on va aller chercher l'élément qui lui est lié dans la base de données
                PointTag pointTagFromDB = SQLite.select().from(PointTag.class).where(PointTag_Table.nomTag.eq(pointTagAsString)).querySingle();
                return pointTagFromDB;
            }
        });
    }
}
