/*
 *   Copyright 2012 Glencoe Software, Inc. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */

package omero.cmdexample;

import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import ome.system.OmeroContext;
import ome.util.SqlAction;

import omero.cmd.IRequest;
import omero.cmd.Response;
import omero.cmd.Status;

/**
 * Example request that doesn't do much of anything.
 * @author Josh Moore, josh at glencoesoftware.com
 * @since 4.4.0
 */
public class MyRequestI extends MyRequest implements IRequest {

    private static final long serialVersionUID = 1L;

    private static final Log log = LogFactory.getLog(MyRequestI.class);

    // TODO: move to Helper instance.
    private final AtomicReference<Response> rsp = new AtomicReference<Response>();

    private final OmeroContext ctx;

    public MyRequestI(OmeroContext ctx) {
        this.ctx = ctx;
    }

    public void init(Status status, SqlAction sql, Session session, ome.system.ServiceFactory sf) {
        status.steps = 10;
    }

    public void step(int i) {
        try {
            Thread.sleep(100); // simulat work
        } catch (InterruptedException e) {
            // ignore
        }
        return;
    }

    public void finish() {
        final MyRequestRsp rsp = new MyRequestRsp();
        this.rsp.set(rsp);
    }

    public Response getResponse() {
        return rsp.get();
    }
}
