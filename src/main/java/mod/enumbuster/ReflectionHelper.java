/*
 * <summary></summary>
 * <author>Hankcs</author>
 * <email>me@hankcs.com</email>
 * <create-date>2016-03-26 PM5:36</create-date>
 *
 * <copyright file="ReflectionHelper.java" company="">
 * Copyright (c) 2008-2016, . All Right Reserved, http://www.hankcs.com/
 * This source is subject to Hankcs. Please contact Hankcs to get more information.
 * </copyright>
 */
package mod.enumbuster;

import sun.reflect.FieldAccessor;
import sun.reflect.ReflectionFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * final static
 * @author hankcs
 */
public class ReflectionHelper
{
    private static final String MODIFIERS_FIELD = "modifiers";

    private static final ReflectionFactory reflection =
            ReflectionFactory.getReflectionFactory();

    public static  void setStaticFinalField(
            Field field, Object value)
            throws NoSuchFieldException, IllegalAccessException
    {
        // public
        field.setAccessible(true);
        // modifiers
        Field modifiersField =
                Field.class.getDeclaredField(MODIFIERS_FIELD);
        modifiersField.setAccessible(true);
        int modifiers = modifiersField.getInt(field);
        // final
        modifiers &= ~Modifier.FINAL;
        modifiersField.setInt(field, modifiers);
        FieldAccessor fa = reflection.newFieldAccessor(
                field, false
        );
        fa.set(null, value);
    }
}