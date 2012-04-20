/*
 *   Copyright 2012 Glencoe Software, Inc. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 *
 */

package omero.cmdexample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import ome.system.OmeroContext;

/**
 * SPI type picked up from the Spring configuration and given a chance to
 * register all its {@link Ice.ObjectFactory} instances with the
 * {@link Ice.Communicator}.
 *
 * @see ticket:6340
 */
public class RequestObjectFactoryRegistry extends
        omero.util.ObjectFactoryRegistry implements ApplicationContextAware {

    private/* final */OmeroContext ctx;

    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {
        this.ctx = (OmeroContext) ctx;
    }

    public Map<String, ObjectFactory> createFactories() {
        Map<String, ObjectFactory> factories = new HashMap<String, ObjectFactory>();
        factories.put(MyRequestI.ice_staticId(), new ObjectFactory(
                MyRequestI.ice_staticId()) {
            @Override
            public Ice.Object create(String name) {
                return new MyRequestI(ctx);
            }

        });
        return factories;
    }

}
