package com.fatsnake.designPattern.created.prototype.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Auther: fatsnake
 * @Description": 深拷贝2：先将对象序列化，然后再反序列化成新的对象
 * @Date:2020-02-23 15:42
 * Copyright (c) 2020, zaodao All Rights Reserved.
 */
public class DeepCopyDemo2 {


    public Object deepCopy(Object object) throws Exception {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(object);
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
