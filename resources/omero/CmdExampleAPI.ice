/*
 *   Copyright 2012 Glencoe Software, Inc. All rights reserved.
 *   Use is subject to license terms supplied in LICENSE.txt
 */

#ifndef CMD_EXAMPLE_ICE
#define CMD_EXAMPLE_ICE

#include <omero/cmd/API.ice>

module omero {

    module cmdexample {

        /**
         * Command object which can be passed to [omero::cmd::Session::submit].
         **/
        class MyRequest extends omero::cmd::Request{};

        class MyRequestRsp extends omero::cmd::Response{};

    };

};

#endif
